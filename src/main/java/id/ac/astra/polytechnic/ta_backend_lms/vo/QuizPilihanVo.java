package id.ac.astra.polytechnic.ta_backend_lms.vo;

import id.ac.astra.polytechnic.ta_backend_lms.model.QuizPilihan;

import java.util.Date;
public class QuizPilihanVo{

    private Long qqpId;
    private Long qqpMqsId;
    private String qqpKodePilihan;
    private String qqpTeksPilihan;
    private Integer qqpUrutan;
    private Date qqpCreatedDate;
    private String qqpCreatedBy;
    private Date qqpModifDate;
    private String qqpModifBy;

    public QuizPilihanVo() {
    }

    public QuizPilihanVo(QuizPilihan qpp) {
        this.qqpId = qpp.getQqpId();
        this.qqpMqsId = qpp.getQqpMqsId();
        this.qqpKodePilihan = qpp.getQqpKodePilihan();
        this.qqpTeksPilihan = qpp.getQqpTeksPilihan();
        this.qqpUrutan = qpp.getQqpUrutan();
        this.qqpCreatedDate = qpp.getQqpCreatedDate();
        this.qqpCreatedBy = qpp.getQqpCreatedBy();
        this.qqpModifDate = qpp.getQqpModifDate();
        this.qqpModifBy = qpp.getQqpModifBy();
    }

    public Long getQqpId() {
        return qqpId;
    }

    public void setQqpId(Long qqpId) {
        this.qqpId = qqpId;
    }

    public Long getQqpMqsId() {
        return qqpMqsId;
    }

    public void setQqpMqsId(Long qqpMqsId) {
        this.qqpMqsId = qqpMqsId;
    }

    public String getQqpKodePilihan() {
        return qqpKodePilihan;
    }

    public void setQqpKodePilihan(String qqpKodePilihan) {
        this.qqpKodePilihan = qqpKodePilihan;
    }

    public String getQqpTeksPilihan() {
        return qqpTeksPilihan;
    }

    public void setQqpTeksPilihan(String qqpTeksPilihan) {
        this.qqpTeksPilihan = qqpTeksPilihan;
    }

    public Integer getQqpUrutan() {
        return qqpUrutan;
    }

    public void setQqpUrutan(Integer qqpUrutan) {
        this.qqpUrutan = qqpUrutan;
    }

    public Date getQqpCreatedDate() {
        return qqpCreatedDate;
    }

    public void setQqpCreatedDate(Date qqpCreatedDate) {
        this.qqpCreatedDate = qqpCreatedDate;
    }

    public String getQqpCreatedBy() {
        return qqpCreatedBy;
    }

    public void setQqpCreatedBy(String qqpCreatedBy) {
        this.qqpCreatedBy = qqpCreatedBy;
    }

    public Date getQqpModifDate() {
        return qqpModifDate;
    }

    public void setQqpModifDate(Date qqpModifDate) {
        this.qqpModifDate = qqpModifDate;
    }

    public String getQqpModifBy() {
        return qqpModifBy;
    }

    public void setQqpModifBy(String qqpModifBy) {
        this.qqpModifBy = qqpModifBy;
    }
}
