package id.ac.astra.polytechnic.ta_backend_lms.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "MS_DEPARTEMEN")
public class Departemen {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "departemen_seq")
    @SequenceGenerator(name = "departemen_seq", sequenceName = "MS_DEPARTEMEN_SEQ", allocationSize = 1)
    @Column(name = "DEP_ID")
    private Long depId;

    @Column(name = "DEP_JUDUL")
    private String depJudul;
    @Column(name = "DEP_NAMA")
    private String depNama;
    @Column(name = "DEP_STATUS")
    private String depStatus;
    @Column(name = "DEP_CREATE_BY")
    private String depCreateBy;
    @Column(name = "DEP_CREATE_DATE")
    private Date depCreateDate;
    @Column(name = "DEP_MODIF_BY")
    private String depModifBy;
    @Column(name = "DEP_MODIF_DATE")
    private Date depModifDate;

    @ManyToOne
    @JoinColumn(name = "DIV_ID")
    private Divisi divisi;

    public Departemen() {
    }

    public Departemen(Long depId, String depJudul, String depNama, String depStatus, String depCreateBy, Date depCreateDate, String depModifBy, Date depModifDate, Divisi divisi) {
        this.depId = depId;
        this.depJudul = depJudul;
        this.depNama = depNama;
        this.depStatus = depStatus;
        this.depCreateBy = depCreateBy;
        this.depCreateDate = depCreateDate;
        this.depModifBy = depModifBy;
        this.depModifDate = depModifDate;
        this.divisi = divisi;
    }

    public Long getDepId() {
        return depId;
    }

    public void setDepId(Long depId) {
        this.depId = depId;
    }

    public String getDepJudul() {
        return depJudul;
    }

    public void setDepJudul(String depJudul) {
        this.depJudul = depJudul;
    }

    public String getDepNama() {
        return depNama;
    }

    public void setDepNama(String depNama) {
        this.depNama = depNama;
    }

    public String getDepStatus() {
        return depStatus;
    }

    public void setDepStatus(String depStatus) {
        this.depStatus = depStatus;
    }

    public String getDepCreateBy() {
        return depCreateBy;
    }

    public void setDepCreateBy(String depCreateBy) {
        this.depCreateBy = depCreateBy;
    }

    public Date getDepCreateDate() {
        return depCreateDate;
    }

    public void setDepCreateDate(Date depCreateDate) {
        this.depCreateDate = depCreateDate;
    }

    public String getDepModifBy() {
        return depModifBy;
    }

    public void setDepModifBy(String depModifBy) {
        this.depModifBy = depModifBy;
    }

    public Date getDepModifDate() {
        return depModifDate;
    }

    public void setDepModifDate(Date depModifDate) {
        this.depModifDate = depModifDate;
    }

    public Divisi getDivisi() {
        return divisi;
    }

    public void setDivisi(Divisi divisi) {
        this.divisi = divisi;
    }
}