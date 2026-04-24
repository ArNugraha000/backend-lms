package id.ac.astra.polytechnic.ta_backend_lms.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "MS_KURSUS")
public class Kursus {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kursus_seq")
    @SequenceGenerator(name = "kursus_seq", sequenceName = "MS_KURSUS_SEQ", allocationSize = 1)
    @Column(name = "KRS_ID")
    private Long krsId;

    @Column(name = "KRS_NAMA")
    private String krsNama;

    @Column(name = "KRS_JENIS")
    private String krsJenis;

    @Column(name = "KRS_DESKRIPSI")
    private String krsDeskripsi;

    @Column(name = "KRS_GAMBAR")
    private String krsGambar;

    @Column(name = "KRS_STATUS")
    private Integer krsStatus;

    @Column(name = "KRS_PUBLISH_STATUS")
    private Integer krsPublishStatus;

    @Column(name = "KRS_CREATE_BY")
    private String krsCreateBy;

    @Column(name = "KRS_CREATE_DATE")
    private Timestamp krsCreateDate;

    @Column(name = "KRS_MODIF_BY")
    private String krsModifBy;

    @Column(name = "KRS_MODIF_DATE")
    private Timestamp krsModifDate;

    public Kursus(Long krsId, String krsNama, String krsJenis, String krsDeskripsi, String krsGambar, Integer krsStatus, Integer krsPublishStatus, String krsCreateBy, Timestamp krsCreateDate, String krsModifBy, Timestamp krsModifDate) {
        this.krsId = krsId;
        this.krsNama = krsNama;
        this.krsJenis = krsJenis;
        this.krsDeskripsi = krsDeskripsi;
        this.krsGambar = krsGambar;
        this.krsStatus = krsStatus;
        this.krsPublishStatus = krsPublishStatus;
        this.krsCreateBy = krsCreateBy;
        this.krsCreateDate = krsCreateDate;
        this.krsModifBy = krsModifBy;
        this.krsModifDate = krsModifDate;
    }

    public Kursus() {
    }

    public Long getKrsId() {
        return krsId;
    }

    public void setKrsId(Long krsId) {
        this.krsId = krsId;
    }

    public String getKrsNama() {
        return krsNama;
    }

    public void setKrsNama(String krsNama) {
        this.krsNama = krsNama;
    }

    public String getKrsJenis() {
        return krsJenis;
    }

    public void setKrsJenis(String krsJenis) {
        this.krsJenis = krsJenis;
    }

    public String getKrsDeskripsi() {
        return krsDeskripsi;
    }

    public void setKrsDeskripsi(String krsDeskripsi) {
        this.krsDeskripsi = krsDeskripsi;
    }

    public String getKrsGambar() {
        return krsGambar;
    }

    public void setKrsGambar(String krsGambar) {
        this.krsGambar = krsGambar;
    }

    public Integer getKrsStatus() {
        return krsStatus;
    }

    public void setKrsStatus(Integer krsStatus) {
        this.krsStatus = krsStatus;
    }

    public Integer getKrsPublishStatus() {
        return krsPublishStatus;
    }

    public void setKrsPublishStatus(Integer krsPublishStatus) {
        this.krsPublishStatus = krsPublishStatus;
    }

    public String getKrsCreateBy() {
        return krsCreateBy;
    }

    public void setKrsCreateBy(String krsCreateBy) {
        this.krsCreateBy = krsCreateBy;
    }

    public Timestamp getKrsCreateDate() {
        return krsCreateDate;
    }

    public void setKrsCreateDate(Timestamp krsCreateDate) {
        this.krsCreateDate = krsCreateDate;
    }

    public String getKrsModifBy() {
        return krsModifBy;
    }

    public void setKrsModifBy(String krsModifBy) {
        this.krsModifBy = krsModifBy;
    }

    public Timestamp getKrsModifDate() {
        return krsModifDate;
    }

    public void setKrsModifDate(Timestamp krsModifDate) {
        this.krsModifDate = krsModifDate;
    }
}