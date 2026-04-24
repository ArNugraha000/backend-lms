package id.ac.astra.polytechnic.ta_backend_lms.model;


import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "LMS_MATERI")
public class Materi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MTR_ID")
    private Long id;

    @Column(name = "MTR_JENIS_MATERI")
    private String jenisMateri;

    @Column(name = "MTR_JUDUL_MATERI")
    private String judulMateri;

    @Lob
    @Column(name = "MTR_ISI_MATERI")
    private String isiMateri;

    @Lob
    @Column(name = "MTR_INFORMASI_MATERI")
    private String informasiMateri;

    @Column(name = "MTR_FILE_DOKUMEN")
    private String fileDokumen;

    @Column(name = "MTR_ADA_LINK")
    private String adaLink;

    @Column(name = "MTR_WAKTU_MELIHAT")
    private Integer waktuMelihat;

    @Column(name = "MTR_WAKTU_QUIZ")
    private Integer waktuQuiz;

    @Column(name = "MTR_STATUS")
    private Integer status;

    @Column(name = "MTR_CREATE_BY")
    private String createBy;

    @Column(name = "MTR_CREATE_DATE")
    private Date createDate;

    @Column(name = "MTR_MODIF_BY")
    private String modifBy;

    @Column(name = "MTR_MODIF_DATE")
    private Date modifDate;

    public Materi() {
    }

    public Materi(Long id, String jenisMateri, String judulMateri, String isiMateri, String informasiMateri, String fileDokumen, String adaLink, Integer waktuMelihat, Integer waktuQuiz, Integer status, String createBy, Date createDate, String modifBy, Date modifDate) {
        this.id = id;
        this.jenisMateri = jenisMateri;
        this.judulMateri = judulMateri;
        this.isiMateri = isiMateri;
        this.informasiMateri = informasiMateri;
        this.fileDokumen = fileDokumen;
        this.adaLink = adaLink;
        this.waktuMelihat = waktuMelihat;
        this.waktuQuiz = waktuQuiz;
        this.status = status;
        this.createBy = createBy;
        this.createDate = createDate;
        this.modifBy = modifBy;
        this.modifDate = modifDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJenisMateri() {
        return jenisMateri;
    }

    public void setJenisMateri(String jenisMateri) {
        this.jenisMateri = jenisMateri;
    }

    public String getJudulMateri() {
        return judulMateri;
    }

    public void setJudulMateri(String judulMateri) {
        this.judulMateri = judulMateri;
    }

    public String getIsiMateri() {
        return isiMateri;
    }

    public void setIsiMateri(String isiMateri) {
        this.isiMateri = isiMateri;
    }

    public String getInformasiMateri() {
        return informasiMateri;
    }

    public void setInformasiMateri(String informasiMateri) {
        this.informasiMateri = informasiMateri;
    }

    public String getFileDokumen() {
        return fileDokumen;
    }

    public void setFileDokumen(String fileDokumen) {
        this.fileDokumen = fileDokumen;
    }

    public String getAdaLink() {
        return adaLink;
    }

    public void setAdaLink(String adaLink) {
        this.adaLink = adaLink;
    }

    public Integer getWaktuMelihat() {
        return waktuMelihat;
    }

    public void setWaktuMelihat(Integer waktuMelihat) {
        this.waktuMelihat = waktuMelihat;
    }

    public Integer getWaktuQuiz() {
        return waktuQuiz;
    }

    public void setWaktuQuiz(Integer waktuQuiz) {
        this.waktuQuiz = waktuQuiz;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getModifBy() {
        return modifBy;
    }

    public void setModifBy(String modifBy) {
        this.modifBy = modifBy;
    }

    public Date getModifDate() {
        return modifDate;
    }

    public void setModifDate(Date modifDate) {
        this.modifDate = modifDate;
    }
}


