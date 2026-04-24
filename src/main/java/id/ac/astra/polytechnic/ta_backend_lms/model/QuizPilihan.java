package id.ac.astra.polytechnic.ta_backend_lms.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "LMS_QSL_QUIZ_PILIHAN")
public class QuizPilihan {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "quizPilihanSeq")
    @SequenceGenerator(name = "quizPilihanSeq", sequenceName = "SEQ_LMS_QSL_QUIZ_PILIHAN", allocationSize = 1)
    @Column(name = "QQP_ID")
    private Long qqpId;

    @Column(name = "QQP_MQS_ID", nullable = false)
    private Long qqpMqsId;

    @Column(name = "QQP_KODE_PILIHAN", nullable = false, length = 1)
    private String qqpKodePilihan;

    @Column(name = "QQP_TEKS_PILIHAN", nullable = false, length = 1000)
    private String qqpTeksPilihan;

    @Column(name = "QQP_URUTAN")
    private Integer qqpUrutan = 0;

    @Column(name = "QQP_CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date qqpCreatedDate = new Date();

    @Column(name = "QQP_CREATED_BY", length = 100)
    private String qqpCreatedBy;

    @Column(name = "QQP_MODIF_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date qqpModifDate = new Date();

    @Column(name = "QQP_MODIF_BY", length = 100)
    private String qqpModifBy;

    @ManyToOne
    @JoinColumn(name = "QQP_MQS_ID", insertable = false, updatable = false)
    private QuizSoal quizSoal;

    public QuizPilihan() {
    }

    public QuizPilihan(Long qqpId, Long qqpMqsId, String qqpKodePilihan, String qqpTeksPilihan, Integer qqpUrutan, Date qqpCreatedDate, String qqpCreatedBy, Date qqpModifDate, String qqpModifBy, QuizSoal quizSoal) {
        this.qqpId = qqpId;
        this.qqpMqsId = qqpMqsId;
        this.qqpKodePilihan = qqpKodePilihan;
        this.qqpTeksPilihan = qqpTeksPilihan;
        this.qqpUrutan = qqpUrutan;
        this.qqpCreatedDate = qqpCreatedDate;
        this.qqpCreatedBy = qqpCreatedBy;
        this.qqpModifDate = qqpModifDate;
        this.qqpModifBy = qqpModifBy;
        this.quizSoal = quizSoal;
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

    public QuizSoal getQuizSoal() {
        return quizSoal;
    }

    public void setQuizSoal(QuizSoal quizSoal) {
        this.quizSoal = quizSoal;
    }
}