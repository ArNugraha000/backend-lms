package id.ac.astra.polytechnic.ta_backend_lms.dao.daoImpl;


import id.ac.astra.polytechnic.ta_backend_lms.dao.QuizSoalDao;
import id.ac.astra.polytechnic.ta_backend_lms.model.QuizPilihan;
import id.ac.astra.polytechnic.ta_backend_lms.model.QuizSoal;
import id.ac.astra.polytechnic.ta_backend_lms.repository.QuizPilihanRepository;
import id.ac.astra.polytechnic.ta_backend_lms.repository.QuizSoalRepository;
import id.ac.astra.polytechnic.ta_backend_lms.vo.QuizPilihanVo;
import id.ac.astra.polytechnic.ta_backend_lms.vo.QuizSoalDetailVo;
import id.ac.astra.polytechnic.ta_backend_lms.vo.QuizSoalVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Transactional
public class QuizSoalDaoImpl implements QuizSoalDao {

    @Autowired
    private QuizSoalRepository quizSoalRepository;

    @Autowired
    private QuizPilihanRepository quizPilihanRepository;

    private QuizSoalVo convertToVO(QuizSoal entity) {
        if (entity == null) return null;
        QuizSoalVo vo = new QuizSoalVo();
        BeanUtils.copyProperties(entity, vo);
        return vo;
    }

    private QuizSoal convertToEntity(QuizSoalVo vo) {
        if (vo == null) return null;
        QuizSoal entity = new QuizSoal();
        BeanUtils.copyProperties(vo, entity);
        return entity;
    }

    @Override
    public QuizSoalVo save(QuizSoalVo quizSoalVO) {
        QuizSoal entity = convertToEntity(quizSoalVO);
        entity.setMqsCreatedDate(new Date());
        entity.setMqsModifDate(new Date());
        QuizSoal savedEntity = quizSoalRepository.save(entity);
        return convertToVO(savedEntity);
    }

    @Override
    public QuizSoalVo update(QuizSoalVo quizSoalVO) {
        Optional<QuizSoal> existingOpt = quizSoalRepository.findById(quizSoalVO.getMqsId());
        if (existingOpt.isPresent()) {
            QuizSoal entity = existingOpt.get();
            BeanUtils.copyProperties(quizSoalVO, entity, "mqsId", "mqsCreatedDate", "mqsCreatedBy");
            entity.setMqsModifDate(new Date());
            QuizSoal updatedEntity = quizSoalRepository.save(entity);
            return convertToVO(updatedEntity);
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        if (quizSoalRepository.existsById(id)) {
            quizSoalRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public QuizSoalVo findById(Long id) {
        Optional<QuizSoal> entity = quizSoalRepository.findById(id);
        return entity.map(this::convertToVO).orElse(null);
    }

    private QuizPilihanVo convertPilihanToVo(QuizPilihan entity) {
        if (entity == null) return null;
        QuizPilihanVo vo = new QuizPilihanVo();
        BeanUtils.copyProperties(entity, vo);
        return vo;
    }

    @Override
    public List<QuizSoalVo> findByMateriId(Long materiId) {
        List<QuizSoal> entities = quizSoalRepository.findByMqsMtrIdOrderByMqsNomorSoalAsc(materiId);
        return entities.stream().map(entity -> {
            QuizSoalVo vo = convertToVO(entity);
            List<QuizPilihan> pilihans = quizPilihanRepository.findByQqpMqsIdOrderByQqpUrutanAsc(entity.getMqsId());
            List<QuizPilihanVo> pilihanVOs = pilihans.stream().map(this::convertPilihanToVo).collect(Collectors.toList());
            vo.setPilihanList(pilihanVOs);
            return vo;
        }).collect(Collectors.toList());
    }

    @Override
    public List<QuizSoalVo> findAll() {
        List<QuizSoal> entities = quizSoalRepository.findAll();
        return entities.stream().map(this::convertToVO).collect(Collectors.toList());
    }

    @Override
    public List<QuizSoalVo> findByMateriIdAndJenis(Long materiId, String jenis) {
        List<QuizSoal> entities = quizSoalRepository.findByMqsMtrIdAndMqsJenisOrderByMqsNomorSoalAsc(materiId, jenis);
        return entities.stream().map(this::convertToVO).collect(Collectors.toList());
    }

    private QuizPilihanVo convertPilihanToVO(QuizPilihan entity) {
        if (entity == null) return null;
        QuizPilihanVo Vo = new QuizPilihanVo();
        BeanUtils.copyProperties(entity, Vo);
        return Vo;
    }

    @Override
    public QuizSoalDetailVo findSoalWithPilihan(Long soalId) {
        Optional<QuizSoal> soalOpt = quizSoalRepository.findById(soalId);
        if (soalOpt.isPresent()) {
            QuizSoal soal = soalOpt.get();
            List<QuizPilihan> pilihanList = quizPilihanRepository.findByQqpMqsIdOrderByQqpUrutanAsc(soalId);

            QuizSoalDetailVo detailVo = new QuizSoalDetailVo();
            detailVo.setSoal(convertToVO(soal));
            detailVo.setPilihanList(pilihanList.stream().map(this::convertPilihanToVO).collect(Collectors.toList()));
            detailVo.setTotalPoin(soal.getMqsPoin());
            return detailVo;
        }
        return null;
    }

    @Override
    public List<QuizSoalDetailVo> findAllSoalWithPilihanByMateri(Long materiId) {
        List<QuizSoal> soalList = quizSoalRepository.findByMqsMtrIdOrderByMqsNomorSoalAsc(materiId);
        List<QuizSoalDetailVo> result = new ArrayList<>();

        for (QuizSoal soal : soalList) {
            List<QuizPilihan> pilihanList = quizPilihanRepository.findByQqpMqsIdOrderByQqpUrutanAsc(soal.getMqsId());
            QuizSoalDetailVo detailVO = new QuizSoalDetailVo();
            detailVO.setSoal(convertToVO(soal));
            detailVO.setPilihanList(pilihanList.stream().map(this::convertPilihanToVO).collect(Collectors.toList()));
            detailVO.setTotalPoin(soal.getMqsPoin());
            result.add(detailVO);
        }
        return result;
    }

    @Override
    public List<QuizSoalDetailVo> findAllSoalWithPilihanByMateriAndJenis(Long materiId, String jenis) {
        List<QuizSoal> soalList = quizSoalRepository.findByMqsMtrIdAndMqsJenisOrderByMqsNomorSoalAsc(materiId, jenis);
        List<QuizSoalDetailVo> result = new ArrayList<>();

        for (QuizSoal soal : soalList) {
            List<QuizPilihan> pilihanList = quizPilihanRepository.findByQqpMqsIdOrderByQqpUrutanAsc(soal.getMqsId());
            QuizSoalDetailVo detailVO = new QuizSoalDetailVo();
            detailVO.setSoal(convertToVO(soal));
            detailVO.setPilihanList(pilihanList.stream().map(this::convertPilihanToVO).collect(Collectors.toList()));
            detailVO.setTotalPoin(soal.getMqsPoin());
            result.add(detailVO);
        }
        return result;
    }

    @Override
    public int countByMateriId(Long materiId) {
        return quizSoalRepository.findByMqsMtrId(materiId).size();
    }


}
      
