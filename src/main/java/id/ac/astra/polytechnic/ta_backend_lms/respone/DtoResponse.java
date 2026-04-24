package id.ac.astra.polytechnic.ta_backend_lms.respone;

public class DtoResponse {
    private int status;
    private String message;
    private Object data;

    // Constructor dengan urutan: status, message, data
    public DtoResponse(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public DtoResponse() {}

    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public Object getData() { return data; }
    public void setData(Object data) { this.data = data; }
}