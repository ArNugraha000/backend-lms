package id.ac.astra.polytechnic.ta_backend_lms.model;

import jakarta.persistence.*;
import java.util.Date;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "LMS_MTR_QUIZ_SOAL")
public class QuizSoal {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "quizSoalSeq")
    @SequenceGenerator(name = "quizSoalSeq", sequenceName = "SEQ_LMS_MTR_QUIZ_SOAL", allocationSize = 1)
    @Column(name = "MQS_ID")
    private Long mqsId;

    @Column(name = "MQS_MTR_ID", nullable = false)
    private Long mqsMtrId;

    @Column(name = "MQS_JENIS", length = 20)
    private String mqsJenis;

    @Column(name = "MQS_NOMOR_SOAL", nullable = false)
    private Integer mqsNomorSoal;

    @Lob
    @Column(name = "MQS_TEKS_SOAL", nullable = false)
    private String mqsTeksSoal;

    @Column(name = "MQS_JAWABAN_BENAR", length = 10)
    private String mqsJawabanBenar;

    @Column(name = "MQS_POIN")
    private Integer mqsPoin = 1;

    @Column(name = "MQS_CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mqsCreatedDate = new Date();

    @Column(name = "MQS_CREATED_BY", length = 100)
    private String mqsCreatedBy;

    @Column(name = "MQS_MODIF_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mqsModifDate = new Date();

    @Column(name = "MQS_MODIF_BY", length = 100)
    private String mqsModifBy;

    @OneToMany(mappedBy = "quizSoal", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<QuizPilihan> pilihanList;

    public QuizSoal() {
    }

    public QuizSoal(Long mqsId, Long mqsMtrId, String mqsJenis,Integer mqsNomorSoal, String mqsTeksSoal, String mqsJawabanBenar, Integer mqsPoin, Date mqsCreatedDate, String mqsCreatedBy, Date mqsModifDate, String mqsModifBy, List<QuizPilihan> pilihanList) {
        this.mqsId = mqsId;
        this.mqsMtrId = mqsMtrId;
        this.mqsJenis = mqsJenis;
        this.mqsNomorSoal = mqsNomorSoal;
        this.mqsTeksSoal = mqsTeksSoal;
        this.mqsJawabanBenar = mqsJawabanBenar;
        this.mqsPoin = mqsPoin;
        this.mqsCreatedDate = mqsCreatedDate;
        this.mqsCreatedBy = mqsCreatedBy;
        this.mqsModifDate = mqsModifDate;
        this.mqsModifBy = mqsModifBy;
        this.pilihanList = pilihanList;

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

    public List<QuizPilihan> getPilihanList() {
        return pilihanList;
    }

    public void setPilihanList(List<QuizPilihan> pilihanList) {
        this.pilihanList = pilihanList;
    }
}