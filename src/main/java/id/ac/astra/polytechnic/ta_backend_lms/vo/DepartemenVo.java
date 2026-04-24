package id.ac.astra.polytechnic.ta_backend_lms.vo;

import id.ac.astra.polytechnic.ta_backend_lms.model.Departemen;

import java.util.Date;

public class DepartemenVo {

    public Long depId;
    public String depJudul;
    public String depNama;
    public String depStatus;
    public Long divId;
    public String divNama;
    private String depModifBy;

    public DepartemenVo(Departemen dep) {
        this.depId = dep.getDepId();
        this.depJudul = dep.getDepJudul();
        this.depNama = dep.getDepNama();
        this.depStatus = "0".equals(dep.getDepStatus())
                ? "AKTIF"
                : "NONAKTIF";

        if (dep.getDivisi() != null) {
            this.divId = dep.getDivisi().getDivId();
            this.divNama = dep.getDivisi().getDivNama();
        } else {
            this.divId = null;
            this.divNama = null;
        }
        this.depModifBy = dep.getDepModifBy();
    }

    public DepartemenVo() {
    }

    public String getDivNama() {
        return divNama;
    }

    public void setDivNama(String divNama) {
        this.divNama = divNama;
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

    public String getDepModifBy() {
        return depModifBy;
    }

    public void setDepModifBy(String depModifBy) {
        this.depModifBy = depModifBy;
    }

    public Long getDivId() {
        return divId;
    }

    public void setDivId(Long divId) {
        this.divId = divId;
    }

}
