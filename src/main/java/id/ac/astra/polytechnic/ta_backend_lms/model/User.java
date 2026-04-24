package id.ac.astra.polytechnic.ta_backend_lms.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "MS_USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "MS_USER_SEQ", allocationSize = 1)
    @Column(name = "USR_ID")
    private Long usrId;

    @Column(name = "USR_NAME")
    private String usrName;
    @Column(name = "USR_PASSWORD")
    private String usrPassword;
    @Column(name = "USR_ROLE")
    private String usrRole;
    @Column(name = "USR_STATUS")
    private Integer usrStatus;
    @Column(name = "USR_CREATED_BY")
    private String usrCreatedBy;
    @Column(name = "USR_CREATED_DATE")
    private java.util.Date usrCreatedDate;
    @Column(name = "USR_MODIF_BY")
    private String usrModifBy;
    @Column(name = "USR_MODIF_DATE")
    private java.util.Date usrModifDate;

    public User() {
    }

    public User(Long usrId, String usrName, String usrPassword, String usrRole, Integer usrStatus, String usrCreatedBy, Date usrCreatedDate, String usrModifBy, Date usrModifDate) {
        this.usrId = usrId;
        this.usrName = usrName;
        this.usrPassword = usrPassword;
        this.usrRole = usrRole;
        this.usrStatus = usrStatus;
        this.usrCreatedBy = usrCreatedBy;
        this.usrCreatedDate = usrCreatedDate;
        this.usrModifBy = usrModifBy;
        this.usrModifDate = usrModifDate;
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
