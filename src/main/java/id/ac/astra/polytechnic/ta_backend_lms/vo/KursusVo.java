package id.ac.astra.polytechnic.ta_backend_lms.vo;

import id.ac.astra.polytechnic.ta_backend_lms.model.Kursus;

import java.sql.Timestamp;

public class KursusVo {

    private Long krsId;
    private String krsNama;
    private String krsJenis;
    private String krsDeskripsi;
    private String krsGambar;
    private String krsGambarUrl; // For full URL
    private Integer krsStatus;
    private Integer krsPublishStatus;
    private String krsCreateBy;
    private Timestamp krsCreateDate;
    private String krsModifBy;
    private Timestamp krsModifDate;

    public KursusVo() {}

    public KursusVo(Kursus krs) {
        this.krsId = krs.getKrsId();
        this.krsNama = krs.getKrsNama();
        this.krsJenis = krs.getKrsJenis();
        this.krsDeskripsi = krs.getKrsDeskripsi();
        this.krsGambar = krs.getKrsGambar();
        this.krsStatus = krs.getKrsStatus();
        this.krsPublishStatus = krs.getKrsPublishStatus();
        this.krsCreateBy = krs.getKrsCreateBy();
        this.krsCreateDate = krs.getKrsCreateDate();
        this.krsModifBy = krs.getKrsModifBy();
        this.krsModifDate = krs.getKrsModifDate();
    }

    // Getters and Setters
    public Long getKrsId() { return krsId; }
    public void setKrsId(Long krsId) { this.krsId = krsId; }

    public String getKrsNama() { return krsNama; }
    public void setKrsNama(String krsNama) { this.krsNama = krsNama; }

    public String getKrsJenis() { return krsJenis; }
    public void setKrsJenis(String krsJenis) { this.krsJenis = krsJenis; }

    public String getKrsDeskripsi() { return krsDeskripsi; }
    public void setKrsDeskripsi(String krsDeskripsi) { this.krsDeskripsi = krsDeskripsi; }

    public String getKrsGambar() { return krsGambar; }
    public void setKrsGambar(String krsGambar) { this.krsGambar = krsGambar; }

    public String getKrsGambarUrl() { return krsGambarUrl; }
    public void setKrsGambarUrl(String krsGambarUrl) { this.krsGambarUrl = krsGambarUrl; }

    public Integer getKrsStatus() { return krsStatus; }
    public void setKrsStatus(Integer krsStatus) { this.krsStatus = krsStatus; }

    public Integer getKrsPublishStatus() { return krsPublishStatus; }
    public void setKrsPublishStatus(Integer krsPublishStatus) { this.krsPublishStatus = krsPublishStatus; }

    public String getKrsCreateBy() { return krsCreateBy; }
    public void setKrsCreateBy(String krsCreateBy) { this.krsCreateBy = krsCreateBy; }

    public Timestamp getKrsCreateDate() { return krsCreateDate; }
    public void setKrsCreateDate(Timestamp krsCreateDate) { this.krsCreateDate = krsCreateDate; }

    public String getKrsModifBy() { return krsModifBy; }
    public void setKrsModifBy(String krsModifBy) { this.krsModifBy = krsModifBy; }

    public Timestamp getKrsModifDate() { return krsModifDate; }
    public void setKrsModifDate(Timestamp krsModifDate) { this.krsModifDate = krsModifDate; }
}