package com.huashuohair.app.bean;

public class Permission {
    private Integer id;

    private String permissionName;

    private String url;

    private Integer type;

    private String code;

    private String description;

    private String remarks;

    private Integer parentId;

    private String parentName;

    private String icon;

    private Integer sort;

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

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName == null ? null : parentName.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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

	public Permission() {
		super();
	}

	public Permission(Integer id, String permissionName, String url, Integer type, String code, String description,
			String remarks, Integer parentId, String parentName, String icon, Integer sort, Integer status,
			String createTime, String createUserId, String lastUpdateTime, String lastUpdateUserId) {
		super();
		this.id = id;
		this.permissionName = permissionName;
		this.url = url;
		this.type = type;
		this.code = code;
		this.description = description;
		this.remarks = remarks;
		this.parentId = parentId;
		this.parentName = parentName;
		this.icon = icon;
		this.sort = sort;
		this.status = status;
		this.createTime = createTime;
		this.createUserId = createUserId;
		this.lastUpdateTime = lastUpdateTime;
		this.lastUpdateUserId = lastUpdateUserId;
	}

	@Override
	public String toString() {
		return "Permission [id=" + id + ", permissionName=" + permissionName + ", url=" + url + ", type=" + type
				+ ", code=" + code + ", description=" + description + ", remarks=" + remarks + ", parentId=" + parentId
				+ ", parentName=" + parentName + ", icon=" + icon + ", sort=" + sort + ", status=" + status
				+ ", createTime=" + createTime + ", createUserId=" + createUserId + ", lastUpdateTime=" + lastUpdateTime
				+ ", lastUpdateUserId=" + lastUpdateUserId + "]";
	}
}