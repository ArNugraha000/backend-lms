package id.ac.astra.polytechnic.ta_backend_lms.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class QuizSoalRequestDTO {

    private Long mqsId;

    @NotNull(message = "ID Materi tidak boleh kosong")
    private Long mqsMtrId;

    @NotNull(message = "Nomor soal tidak boleh kosong")
    private Integer mqsNomorSoal;

    @NotBlank(message = "Teks soal tidak boleh kosong")
    private String mqsTeksSoal;

    private String mqsJawabanBenar;

    private Integer mqsPoin = 1;

    private String mqsCreatedBy;

    private String mqsModifBy;

    private List<QuizPilihanRequestDTO> pilihanList;

    public QuizSoalRequestDTO(){

    }

    public QuizSoalRequestDTO(Long mqsId, @NotNull(message = "ID Materi tidak boleh kosong") Long mqsMtrId, @NotNull(message = "Nomor soal tidak boleh kosong") Integer mqsNomorSoal, String mqsTeksSoal, String mqsJawabanBenar, Integer mqsPoin, String mqsCreatedBy, String mqsModifBy, List<QuizPilihanRequestDTO> pilihanList) {
        this.mqsId = mqsId;
        this.mqsMtrId = mqsMtrId;
        this.mqsNomorSoal = mqsNomorSoal;
        this.mqsTeksSoal = mqsTeksSoal;
        this.mqsJawabanBenar = mqsJawabanBenar;
        this.mqsPoin = mqsPoin;
        this.mqsCreatedBy = mqsCreatedBy;
        this.mqsModifBy = mqsModifBy;
        this.pilihanList = pilihanList;
    }

    public Long getMqsId() {
        return mqsId;
    }

    public void setMqsId(Long mqsId) {
        this.mqsId = mqsId;
    }

    public @NotNull Long getMqsMtrId() {
        return mqsMtrId;
    }

    public void setMqsMtrId(@NotNull Long mqsMtrId) {
        this.mqsMtrId = mqsMtrId;
    }

    public @NotNull Integer getMqsNomorSoal() {
        return mqsNomorSoal;
    }

    public void setMqsNomorSoal(@NotNull Integer mqsNomorSoal) {
        this.mqsNomorSoal = mqsNomorSoal;
    }

    public String getMqsTeksSoal() {
        return mqsTeksSoal;
    }

    public void setMqsTeksSoal(String mqsTeksSoal) {
        this.mqsTeksSoal = mqsTeksSoal;
    }

    public String getMqsJawabanBenar() {
        return mqsJawabanBenar;
    }

    public void setMqsJawabanBenar(String mqsJawabanBenar) {
        this.mqsJawabanBenar = mqsJawabanBenar;
    }

    public Integer getMqsPoin() {
        return mqsPoin;
    }

    public void setMqsPoin(Integer mqsPoin) {
        this.mqsPoin = mqsPoin;
    }

    public String getMqsCreatedBy() {
        return mqsCreatedBy;
    }

    public void setMqsCreatedBy(String mqsCreatedBy) {
        this.mqsCreatedBy = mqsCreatedBy;
    }

    public String getMqsModifBy() {
        return mqsModifBy;
    }

    public void setMqsModifBy(String mqsModifBy) {
        this.mqsModifBy = mqsModifBy;
    }

    public List<QuizPilihanRequestDTO> getPilihanList() {
        return pilihanList;
    }

    public void setPilihanList(List<QuizPilihanRequestDTO> pilihanList) {
        this.pilihanList = pilihanList;
    }
}
