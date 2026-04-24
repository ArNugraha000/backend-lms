package id.ac.astra.polytechnic.ta_backend_lms.vo;


import id.ac.astra.polytechnic.ta_backend_lms.model.Seksie;

import java.util.Date;

public class SeksieVo {

    public Long sekId;
    public String sekJudul;
    public String sekNama;
    public String sekStatus;
    public Long depId;
    public String depNama;
    public Long divId;
    public String divNama;
    private String sekModifBy;

    public SeksieVo() {
    }

    public SeksieVo(Seksie sek) {

        this.sekId = sek.getSekId();
        this.sekJudul = sek.getSekJudul();
        this.sekNama = sek.getSekNama();
        this.sekStatus = "0".equals(sek.getSekStatus()) ? "AKTIF" : "NONAKTIF";
        if (sek.getDepartemen() != null) {
            this.depId = sek.getDepartemen().getDepId();
            this.depNama = sek.getDepartemen().getDepNama();

            if (sek.getDepartemen().getDivisi() != null) {
                this.divId = sek.getDepartemen().getDivisi().getDivId();
                this.divNama = sek.getDepartemen().getDivisi().getDivNama();
            }
        }
        this.sekModifBy = sek.getSekModifBy();
    }



    public String getDepNama() {
        return depNama;
    }

    public void setDepNama(String depNama) {
        this.depNama = depNama;
    }

    public Long getDivId() {
        return divId;
    }

    public void setDivId(Long divId) {
        this.divId = divId;
    }

    public String getDivNama() {
        return divNama;
    }

    public void setDivNama(String divNama) {
        this.divNama = divNama;
    }

    public String getSekModifBy() {
        return sekModifBy;
    }

    public void setSekModifBy(String sekModifBy) {
        this.sekModifBy = sekModifBy;
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

    public Long getDepId() {
        return depId;
    }

    public void setDepId(Long depId) {
        this.depId = depId;
    }
}
