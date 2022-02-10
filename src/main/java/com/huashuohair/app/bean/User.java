package com.huashuohair.app.bean;

public class User {
    private Integer id;

    private String account;

    private String password;

    private String orginalPassword;

    private String salt;

    private String realName;

    private String sex;

    private String telephone;

    private String email;

    private String birthday;

    private String address;

    private Integer departmentId;

    private String depaetmentName;

    private String remarks;

    private Integer status;

    private String createTime;

    private String createUserId;

    private String lastUpdateTime;

    private String lastUpdateUserId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getOrginalPassword() {
        return orginalPassword;
    }

    public void setOrginalPassword(String orginalPassword) {
        this.orginalPassword = orginalPassword == null ? null : orginalPassword.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepaetmentName() {
        return depaetmentName;
    }

    public void setDepaetmentName(String depaetmentName) {
        this.depaetmentName = depaetmentName == null ? null : depaetmentName.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId == null ? null : createUserId.trim();
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime == null ? null : lastUpdateTime.trim();
    }

    public String getLastUpdateUserId() {
        return lastUpdateUserId;
    }

    public void setLastUpdateUserId(String lastUpdateUserId) {
        this.lastUpdateUserId = lastUpdateUserId == null ? null : lastUpdateUserId.trim();
    }

	public User() {
		super();
	}

	public User(Integer id, String account, String password, String orginalPassword, String salt, String realName,
			String sex, String telephone, String email, String birthday, String address, Integer departmentId,
			String depaetmentName, String remarks, Integer status, String createTime, String createUserId,
			String lastUpdateTime, String lastUpdateUserId) {
		super();
		this.id = id;
		this.account = account;
		this.password = password;
		this.orginalPassword = orginalPassword;
		this.salt = salt;
		this.realName = realName;
		this.sex = sex;
		this.telephone = telephone;
		this.email = email;
		this.birthday = birthday;
		this.address = address;
		this.departmentId = departmentId;
		this.depaetmentName = depaetmentName;
		this.remarks = remarks;
		this.status = status;
		this.createTime = createTime;
		this.createUserId = createUserId;
		this.lastUpdateTime = lastUpdateTime;
		this.lastUpdateUserId = lastUpdateUserId;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", account=" + account + ", password=" + password + ", orginalPassword="
				+ orginalPassword + ", salt=" + salt + ", realName=" + realName + ", sex=" + sex + ", telephone="
				+ telephone + ", email=" + email + ", birthday=" + birthday + ", address=" + address + ", departmentId="
				+ departmentId + ", depaetmentName=" + depaetmentName + ", remarks=" + remarks + ", status=" + status
				+ ", createTime=" + createTime + ", createUserId=" + createUserId + ", lastUpdateTime=" + lastUpdateTime
				+ ", lastUpdateUserId=" + lastUpdateUserId + "]";
	}
}