package id.ac.astra.polytechnic.ta_backend_lms.vo;

import java.util.List;

public class QuizSoalDetailVo {
        private QuizSoalVo soal;
        private List<QuizPilihanVo> pilihanList;
        private Integer totalPoin;

    public QuizSoalDetailVo(){
    }

    public QuizSoalDetailVo(QuizSoalVo soal, List<QuizPilihanVo> pilihanList, Integer totalPoin) {
        this.soal = soal;
        this.pilihanList = pilihanList;
        this.totalPoin = totalPoin;
    }

    public QuizSoalVo getSoal() {
        return soal;
    }

    public void setSoal(QuizSoalVo soal) {
        this.soal = soal;
    }

    public List<QuizPilihanVo> getPilihanList() {
        return pilihanList;
    }

    public void setPilihanList(List<QuizPilihanVo> pilihanList) {
        this.pilihanList = pilihanList;
    }

    public Integer getTotalPoin() {
        return totalPoin;
    }

    public void setTotalPoin(Integer totalPoin) {
        this.totalPoin = totalPoin;
    }
}
