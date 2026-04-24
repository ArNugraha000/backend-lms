package id.ac.astra.polytechnic.ta_backend_lms.vo;

import id.ac.astra.polytechnic.ta_backend_lms.model.User;



import java.util.Date;

public class UserVo {



    private Long usrId;


    private String usrName;

    private String usrPassword;

    private String usrRole;

    private Integer usrStatus;

    private String usrCreatedBy;

    private java.util.Date usrCreatedDate;

    private String usrModifBy;

    private java.util.Date usrModifDate;

    public UserVo(User usr) {
        this.usrId = usr.getUsrId();
        this.usrName = usr.getUsrName();
        this.usrPassword = usr.getUsrPassword();
        this.usrRole = usr.getUsrRole();
        this.usrStatus = usr.getUsrStatus();
        this.usrCreatedBy = usr.getUsrCreatedBy();
        this.usrCreatedDate = usr.getUsrCreatedDate();
        this.usrModifBy = usr.getUsrModifBy();
        this.usrModifDate = usr.getUsrModifDate();
    }

    public Long getUsrId() {
        return usrId;
    }

    public void setUsrId(Long usrId) {
        this.usrId = usrId;
    }

    public String getUsrName() {
        return usrName;
    }

    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }

    public String getUsrPassword() {
        return usrPassword;
    }

    public void setUsrPassword(String usrPassword) {
        this.usrPassword = usrPassword;
    }

    public String getUsrRole() {
        return usrRole;
    }

    public void setUsrRole(String usrRole) {
        this.usrRole = usrRole;
    }

    public Integer getUsrStatus() {
        return usrStatus;
    }

    public void setUsrStatus(Integer usrStatus) {
        this.usrStatus = usrStatus;
    }

    public String getUsrCreatedBy() {
        return usrCreatedBy;
    }

    public void setUsrCreatedBy(String usrCreatedBy) {
        this.usrCreatedBy = usrCreatedBy;
    }

    public Date getUsrCreatedDate() {
        return usrCreatedDate;
    }

    public void setUsrCreatedDate(Date usrCreatedDate) {
        this.usrCreatedDate = usrCreatedDate;
    }

    public String getUsrModifBy() {
        return usrModifBy;
    }

    public void setUsrModifBy(String usrModifBy) {
        this.usrModifBy = usrModifBy;
    }

    public Date getUsrModifDate() {
        return usrModifDate;
    }

    public void setUsrModifDate(Date usrModifDate) {
        this.usrModifDate = usrModifDate;
    }
}
