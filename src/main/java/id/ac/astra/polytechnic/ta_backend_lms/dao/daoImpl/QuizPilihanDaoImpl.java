package id.ac.astra.polytechnic.ta_backend_lms.dao.daoImpl;

import id.ac.astra.polytechnic.ta_backend_lms.dao.QuizPilihanDao;
import id.ac.astra.polytechnic.ta_backend_lms.model.QuizPilihan;
import id.ac.astra.polytechnic.ta_backend_lms.repository.QuizPilihanRepository;
import id.ac.astra.polytechnic.ta_backend_lms.vo.QuizPilihanVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Transactional
public class QuizPilihanDaoImpl implements QuizPilihanDao {

    @Autowired
    private QuizPilihanRepository quizPilihanRepository;

    private QuizPilihanVo convertToVO(QuizPilihan entity) {
        if (entity == null) return null;
        QuizPilihanVo vo = new QuizPilihanVo();
        BeanUtils.copyProperties(entity, vo);
        return vo;
    }

    private QuizPilihan convertToEntity(QuizPilihanVo vo) {
        if (vo == null) return null;
        QuizPilihan entity = new QuizPilihan();
        BeanUtils.copyProperties(vo, entity);
        return entity;
    }

    @Override
    public QuizPilihanVo save(QuizPilihanVo quizPilihanVO) {
        QuizPilihan entity = convertToEntity(quizPilihanVO);
        entity.setQqpCreatedDate(new Date());
        entity.setQqpModifDate(new Date());
        QuizPilihan savedEntity = quizPilihanRepository.save(entity);
        return convertToVO(savedEntity);
    }

    @Override
    public QuizPilihanVo update(QuizPilihanVo quizPilihanVO) {
        Optional<QuizPilihan> existingOpt = quizPilihanRepository.findById(quizPilihanVO.getQqpId());
        if (existingOpt.isPresent()) {
            QuizPilihan entity = existingOpt.get();
            BeanUtils.copyProperties(quizPilihanVO, entity, "qqpId", "qqpCreatedDate", "qqpCreatedBy");
            entity.setQqpModifDate(new Date());
            QuizPilihan updatedEntity = quizPilihanRepository.save(entity);
            return convertToVO(updatedEntity);
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        if (quizPilihanRepository.existsById(id)) {
            quizPilihanRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public QuizPilihanVo findById(Long id) {
        Optional<QuizPilihan> entity = quizPilihanRepository.findById(id);
        return entity.map(this::convertToVO).orElse(null);
    }

    @Override
    public List<QuizPilihanVo> findBySoalId(Long soalId) {
        List<QuizPilihan> entities = quizPilihanRepository.findByQqpMqsIdOrderByQqpUrutanAsc(soalId);
        return entities.stream().map(this::convertToVO).collect(Collectors.toList());
    }

    @Override
    public List<QuizPilihanVo> findAll() {
        List<QuizPilihan> entities = quizPilihanRepository.findAll();
        return entities.stream().map(this::convertToVO).collect(Collectors.toList());
    }

    @Override
    public void deleteBySoalId(Long soalId) {
        try {
            quizPilihanRepository.deleteByQqpMqsId(soalId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Gagal hapus pilihan lama: " + e.getMessage());
        }
    }

    @Override
    public void saveAll(List<QuizPilihanVo> pilihanList) {
        List<QuizPilihan> entities = pilihanList.stream().map(this::convertToEntity).collect(Collectors.toList());
        entities.forEach(e -> {
            e.setQqpCreatedDate(new Date());
            e.setQqpModifDate(new Date());
        });
        quizPilihanRepository.saveAll(entities);
    }


}