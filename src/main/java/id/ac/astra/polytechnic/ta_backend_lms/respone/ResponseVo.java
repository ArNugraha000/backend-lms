package id.ac.astra.polytechnic.ta_backend_lms.respone;

public class ResponseVo<T>
{
        private boolean success;
        private String message;
        private T data;
        private String errorCode;

        public ResponseVo(boolean success, String message, T data) {
            this.success = success;
            this.message = message;
            this.data = data;
        }

        public ResponseVo(boolean success, String message, T data, String errorCode) {
            this.success = success;
            this.message = message;
            this.data = data;
            this.errorCode = errorCode;
        }

        public static <T> ResponseVo<T> success(T data) {
            return new ResponseVo<>(true, "Success", data);
        }

        public static <T> ResponseVo<T> success(String message, T data) {
            return new ResponseVo<>(true, message, data);
        }

        public static <T> ResponseVo<T> error(String message) {
            return new ResponseVo<>(false, message, null);
        }

        public static <T> ResponseVo<T> error(String message, String errorCode) {
            return new ResponseVo<>(false, message, null, errorCode);
        }

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public String getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(String errorCode) {
            this.errorCode = errorCode;
        }

    }
