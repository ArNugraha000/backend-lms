package id.ac.astra.polytechnic.ta_backend_lms.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "MS_SEKSIE")
public class Seksie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seksie_seq")
    @SequenceGenerator(name = "seksie_seq", sequenceName = "MS_SEKSIE_SEQ", allocationSize = 1)
    @Column(name = "SEK_ID")
    private Long sekId;
    @Column(name = "SEK_JUDUL")
    private String sekJudul;
    @Column(name = "SEK_NAMA")
    private String sekNama;
    @Column(name = "SEK_STATUS")
    private String sekStatus;
    @Column(name = "SEK_CREATE_BY")
    private String sekCreateBy;
    @Column(name = "SEK_CREATE_DATE")
    private Date sekCreateDate;
    @Column(name = "SEK_MODIF_BY")
    private String sekModifBy;
    @Column(name = "SEK_MODIF_DATE")
    private Date sekModifDate;

    @ManyToOne
    @JoinColumn(name = "DEP_ID")
    private Departemen departemen;

    public Seksie() {
    }

    public Seksie(Long sekId, String sekJudul, String sekNama, String sekStatus, String sekCreateBy, Date sekCreateDate, String sekModifBy, Date sekModifDate, Departemen departemen) {
        this.sekId = sekId;
        this.sekJudul = sekJudul;
        this.sekNama = sekNama;
        this.sekStatus = sekStatus;
        this.sekCreateBy = sekCreateBy;
        this.sekCreateDate = sekCreateDate;
        this.sekModifBy = sekModifBy;
        this.sekModifDate = sekModifDate;
        this.departemen = departemen;
    }

    public Long getSekId() {
        return sekId;
    }

    public void setSekId(Long sekId) {
        this.sekId = sekId;
    }

    public String getSekJudul() {
        return sekJudul;
    }

    public void setSekJudul(String sekJudul) {
        this.sekJudul = sekJudul;
    }

    public String getSekNama() {
        return sekNama;
    }

    public void setSekNama(String sekNama) {
        this.sekNama = sekNama;
    }

    public String getSekStatus() {
        return sekStatus;
    }

    public void setSekStatus(String sekStatus) {
        this.sekStatus = sekStatus;
    }

    public String getSekCreateBy() {
        return sekCreateBy;
    }

    public void setSekCreateBy(String sekCreateBy) {
        this.sekCreateBy = sekCreateBy;
    }

    public Date getSekCreateDate() {
        return sekCreateDate;
    }

    public void setSekCreateDate(Date sekCreateDate) {
        this.sekCreateDate = sekCreateDate;
    }

    public String getSekModifBy() {
        return sekModifBy;
    }

    public void setSekModifBy(String sekModifBy) {
        this.sekModifBy = sekModifBy;
    }

    public Date getSekModifDate() {
        return sekModifDate;
    }

    public void setSekModifDate(Date sekModifDate) {
        this.sekModifDate = sekModifDate;
    }

    public Departemen getDepartemen() {
        return departemen;
    }

    public void setDepartemen(Departemen departemen) {
        this.departemen = departemen;
    }
}