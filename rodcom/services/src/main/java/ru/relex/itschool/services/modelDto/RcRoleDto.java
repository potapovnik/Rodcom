package ru.relex.itschool.services.modelDto;

/**
 * @author Anton
 *
 */

public class RcRoleDto {
    private int roleId;
    private String roleName;

    //constructors
    public RcRoleDto() {
    }

    public RcRoleDto(String name) {
        this.roleName = name;
    }

    public RcRoleDto(int id, String name) {
        this.roleId = id;
        this.roleName = name;
    }

    //roleId
    public int getRoleId() {
        return roleId;
    }
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    //roleName
    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
