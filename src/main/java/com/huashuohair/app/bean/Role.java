package com.huashuohair.app.bean;

public class Role {
    private Integer id;

    private String roleName;

    private String code;

    private String description;

    private String remarks;

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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
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

	public Role() {
		super();
	}

	public Role(Integer id, String roleName, String code, String description, String remarks, String createTime,
			String createUserId, String lastUpdateTime, String lastUpdateUserId) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.code = code;
		this.description = description;
		this.remarks = remarks;
		this.createTime = createTime;
		this.createUserId = createUserId;
		this.lastUpdateTime = lastUpdateTime;
		this.lastUpdateUserId = lastUpdateUserId;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + ", code=" + code + ", description=" + description
				+ ", remarks=" + remarks + ", createTime=" + createTime + ", createUserId=" + createUserId
				+ ", lastUpdateTime=" + lastUpdateTime + ", lastUpdateUserId=" + lastUpdateUserId + "]";
	}
}