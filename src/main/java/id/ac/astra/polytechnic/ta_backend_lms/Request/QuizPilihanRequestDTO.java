package id.ac.astra.polytechnic.ta_backend_lms.Request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class QuizPilihanRequestDTO {

    private Long qqpId;

    @NotNull(message = "Kode pilihan tidak boleh kosong")
    @NotBlank(message = "Kode pilihan tidak boleh kosong")
    private String qqpKodePilihan;

    @NotNull(message = "Teks pilihan tidak boleh kosong")
    @NotBlank(message = "Teks pilihan tidak boleh kosong")
    private String qqpTeksPilihan;

    private Integer qqpUrutan = 0;

    private String qqpCreatedBy;

    private String qqpModifBy;

    public QuizPilihanRequestDTO() {

    }

    public QuizPilihanRequestDTO(Long qqpId, @NotNull(message = "Kode pilihan tidak boleh kosong") String qqpKodePilihan, @NotNull(message = "Teks pilihan tidak boleh kosong") String qqpTeksPilihan, Integer qqpUrutan, String qqpCreatedBy, String qqpModifBy) {
        this.qqpId = qqpId;
        this.qqpKodePilihan = qqpKodePilihan;
        this.qqpTeksPilihan = qqpTeksPilihan;
        this.qqpUrutan = qqpUrutan;
        this.qqpCreatedBy = qqpCreatedBy;
        this.qqpModifBy = qqpModifBy;
    }

    public Long getQqpId() {
        return qqpId;
    }

    public void setQqpId(Long qqpId) {
        this.qqpId = qqpId;
    }

    public @NotNull String getQqpKodePilihan() {
        return qqpKodePilihan;
    }

    public void setQqpKodePilihan(@NotNull String qqpKodePilihan) {
        this.qqpKodePilihan = qqpKodePilihan;
    }

    public @NotNull String getQqpTeksPilihan() {
        return qqpTeksPilihan;
    }

    public void setQqpTeksPilihan(@NotNull String qqpTeksPilihan) {
        this.qqpTeksPilihan = qqpTeksPilihan;
    }

    public Integer getQqpUrutan() {
        return qqpUrutan;
    }

    public void setQqpUrutan(Integer qqpUrutan) {
        this.qqpUrutan = qqpUrutan;
    }

    public String getQqpCreatedBy() {
        return qqpCreatedBy;
    }

    public void setQqpCreatedBy(String qqpCreatedBy) {
        this.qqpCreatedBy = qqpCreatedBy;
    }

    public String getQqpModifBy() {
        return qqpModifBy;
    }

    public void setQqpModifBy(String qqpModifBy) {
        this.qqpModifBy = qqpModifBy;
    }
}
