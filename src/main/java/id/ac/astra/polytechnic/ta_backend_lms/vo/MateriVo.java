package id.ac.astra.polytechnic.ta_backend_lms.vo;

import id.ac.astra.polytechnic.ta_backend_lms.model.Departemen;
import id.ac.astra.polytechnic.ta_backend_lms.model.Materi;

public class MateriVo {
    public String jenisMateri;
    public String judulMateri;
    public String isiMateri;
    public String informasiMateri;
    public String fileDokumen;
    public String adaLink;
    public Integer waktuMelihat;
    public Integer waktuQuiz;


    public MateriVo() {
    }

    public MateriVo(Materi mtr) {
        this.jenisMateri = mtr.getJenisMateri();
        this.judulMateri = mtr.getJudulMateri();
        this.isiMateri = mtr.getIsiMateri();
        this.informasiMateri = mtr.getInformasiMateri();
        this.fileDokumen = mtr.getFileDokumen();
        this.adaLink = mtr.getAdaLink();
        this.waktuMelihat = mtr.getWaktuMelihat();  // tambah
        this.waktuQuiz = mtr.getWaktuQuiz();
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

    public Integer getWaktuMelihat() { return waktuMelihat; }
    public void setWaktuMelihat(Integer waktuMelihat) { this.waktuMelihat = waktuMelihat; }

    public Integer getWaktuQuiz() { return waktuQuiz; }
    public void setWaktuQuiz(Integer waktuQuiz) { this.waktuQuiz = waktuQuiz; }
}
