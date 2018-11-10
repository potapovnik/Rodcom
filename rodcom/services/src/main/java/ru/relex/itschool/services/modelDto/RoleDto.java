package ru.relex.itschool.services.modelDto;

/**
 * @author Anton
 *
 */

public class RoleDto {
    private int    roleId;


    private String roleName;



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
