package com.huashuohair.app.bean;

public class RolePermission {
    private Integer id;

    private Integer roleId;

    private Integer permissionId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

	public RolePermission() {
		super();
	}

	public RolePermission(Integer id, Integer roleId, Integer permissionId) {
		super();
		this.id = id;
		this.roleId = roleId;
		this.permissionId = permissionId;
	}

	@Override
	public String toString() {
		return "RolePermission [id=" + id + ", roleId=" + roleId + ", permissionId=" + permissionId + "]";
	}
}