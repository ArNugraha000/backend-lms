package id.ac.astra.polytechnic.ta_backend_lms.vo;

import id.ac.astra.polytechnic.ta_backend_lms.model.Divisi;


public class DivisiVo {


    public Long divId;
    public String divJudul;
    public String divNama;
    public String divStatus;
    private String divModifBy;


    public DivisiVo(Divisi div) {
        this.divId = div.getDivId();
        this.divJudul = div.getDivJudul();
        this.divNama = div.getDivNama();
        // 🔥 Mapping status
        if ("0".equals(div.getDivStatus())) {
            this.divStatus = "AKTIF";
        } else {
            this.divStatus = "NONAKTIF";
        }

        this.divModifBy = div.getDivModifBy();
    }

    public DivisiVo() {
    }

    public String getDivModifBy() {
        return divModifBy;
    }

    public void setDivModifBy(String divModifBy) {
        this.divModifBy = divModifBy;
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
}
