package id.ac.astra.polytechnic.ta_backend_lms.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "MS_DIVISI")
public class Divisi {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "divisi_seq")
    @SequenceGenerator(name = "divisi_seq", sequenceName = "MS_DIVISI_SEQ", allocationSize = 1)
    @Column(name = "DIV_ID")
    private Long divId;

    @Column(name = "DIV_JUDUL")
    private String divJudul;
    @Column(name = "DIV_NAMA")
    private String divNama;
    @Column(name = "DIV_STATUS")
    private String divStatus;
    @Column(name = "DIV_CREATE_BY")
    private String divCreateBy;
    @Column(name = "DIV_CREATE_DATE")
    private Date divCreateDate;
    @Column(name = "DIV_MODIF_BY")
    private String divModifBy;
    @Column(name = "DIV_MODIF_DATE")
    private Date divModifDate;

    public Divisi() {
    }

    public Divisi(Long divId, String divJudul, String divNama, String divStatus, String divCreateBy, Date divCreateDate, String divModifBy, Date divModifDate) {
        this.divId = divId;
        this.divJudul = divJudul;
        this.divNama = divNama;
        this.divStatus = divStatus;
        this.divCreateBy = divCreateBy;
        this.divCreateDate = divCreateDate;
        this.divModifBy = divModifBy;
        this.divModifDate = divModifDate;
    }

    public Long getDivId() {
        return divId;
    }

    public void setDivId(Long divId) {
        this.divId = divId;
    }

    public String getDivJudul() {
        return divJudul;
    }

    public void setDivJudul(String divJudul) {
        this.divJudul = divJudul;
    }

    public String getDivNama() {
        return divNama;
    }

    public void setDivNama(String divNama) {
        this.divNama = divNama;
    }

    public String getDivStatus() {
        return divStatus;
    }

    public void setDivStatus(String divStatus) {
        this.divStatus = divStatus;
    }

    public String getDivCreateBy() {
        return divCreateBy;
    }

    public void setDivCreateBy(String divCreateBy) {
        this.divCreateBy = divCreateBy;
    }

    public Date getDivCreateDate() {
        return divCreateDate;
    }

    public void setDivCreateDate(Date divCreateDate) {
        this.divCreateDate = divCreateDate;
    }

    public String getDivModifBy() {
        return divModifBy;
    }

    public void setDivModifBy(String divModifBy) {
        this.divModifBy = divModifBy;
    }

    public Date getDivModifDate() {
        return divModifDate;
    }

    public void setDivModifDate(Date divModifDate) {
        this.divModifDate = divModifDate;
    }
}
