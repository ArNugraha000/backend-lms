package id.ac.astra.polytechnic.ta_backend_lms.vo;


import id.ac.astra.polytechnic.ta_backend_lms.model.QuizSoal;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class QuizSoalVo {


        private Long mqsId;
        private Long mqsMtrId;
        private String mqsJenis;
        private Integer mqsNomorSoal;
        private String mqsTeksSoal;
        private String mqsJawabanBenar;
        private Integer mqsPoin;
        private Date mqsCreatedDate;
        private String mqsCreatedBy;
        private Date mqsModifDate;
        private String mqsModifBy;
        private List<QuizPilihanVo> pilihanList;


    public QuizSoalVo() {

    }

    public QuizSoalVo(QuizSoal mqs) {
        this.mqsId = mqs.getMqsId();
        this.mqsMtrId = mqs.getMqsMtrId();
        this.mqsJenis = mqs.getMqsJenis();
        this.mqsNomorSoal = mqs.getMqsNomorSoal();
        this.mqsTeksSoal = mqs.getMqsTeksSoal();
        this.mqsJawabanBenar = mqs.getMqsJawabanBenar();
        this.mqsPoin = mqs.getMqsPoin();
        this.mqsCreatedDate = mqs.getMqsCreatedDate();
        this.mqsCreatedBy = mqs.getMqsCreatedBy();
        this.mqsModifDate = mqs.getMqsModifDate();
        this.mqsModifBy = mqs.getMqsModifBy();
        this.pilihanList = mqs.getPilihanList() != null
                ? mqs.getPilihanList()
                .stream()
                .map(QuizPilihanVo::new)
                .collect(Collectors.toList())
                : List.of();
    }

    public Long getMqsId() {
        return mqsId;
    }

    public void setMqsId(Long mqsId) {
        this.mqsId = mqsId;
    }

    public Long getMqsMtrId() {
        return mqsMtrId;
    }

    public void setMqsMtrId(Long mqsMtrId) {
        this.mqsMtrId = mqsMtrId;
    }

    public String getMqsJenis() {
        return mqsJenis;
    }

    public void setMqsJenis(String mqsJenis) {
        this.mqsJenis = mqsJenis;
    }

    public Integer getMqsNomorSoal() {
        return mqsNomorSoal;
    }

    public void setMqsNomorSoal(Integer mqsNomorSoal) {
        this.mqsNomorSoal = mqsNomorSoal;
    }

    public String getMqsTeksSoal() {
        return mqsTeksSoal;
    }

    public void setMqsTeksSoal(String mqsTeksSoal) {
        this.mqsTeksSoal = mqsTeksSoal;
    }

    public String getMqsJawabanBenar() {
        return mqsJawabanBenar;
    }

    public void setMqsJawabanBenar(String mqsJawabanBenar) {
        this.mqsJawabanBenar = mqsJawabanBenar;
    }

    public Integer getMqsPoin() {
        return mqsPoin;
    }

    public void setMqsPoin(Integer mqsPoin) {
        this.mqsPoin = mqsPoin;
    }

    public Date getMqsCreatedDate() {
        return mqsCreatedDate;
    }

    public void setMqsCreatedDate(Date mqsCreatedDate) {
        this.mqsCreatedDate = mqsCreatedDate;
    }

    public String getMqsCreatedBy() {
        return mqsCreatedBy;
    }

    public void setMqsCreatedBy(String mqsCreatedBy) {
        this.mqsCreatedBy = mqsCreatedBy;
    }

    public Date getMqsModifDate() {
        return mqsModifDate;
    }

    public void setMqsModifDate(Date mqsModifDate) {
        this.mqsModifDate = mqsModifDate;
    }

    public String getMqsModifBy() {
        return mqsModifBy;
    }

    public void setMqsModifBy(String mqsModifBy) {
        this.mqsModifBy = mqsModifBy;
    }

    public List<QuizPilihanVo> getPilihanList() {
        return pilihanList;
    }

    public void setPilihanList(List<QuizPilihanVo> pilihanList) {
        this.pilihanList = pilihanList;
    }
}
