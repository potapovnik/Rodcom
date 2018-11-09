package ru.relex.itschool.db.entity;

import javax.persistence.*;

@Entity
@Table(name = "rc_role", schema = "public", catalog = "postgres")
public class RcRole {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="rc_role_seq_gen")
    @SequenceGenerator(name="rc_role_seq_gen", sequenceName="RC_ROLE_SEQ", allocationSize = 1)
    @Column(name = "role_id")
    private int    roleId;

    @Basic
    @Column(name = "role_name")
    private String roleName;

    public RcRole() {
    }

    public RcRole(String name) {
        this.roleName = name;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RcRole rcRole = (RcRole) o;

        if (roleId != rcRole.roleId) return false;
        if (roleName != null ? !roleName.equals(rcRole.roleName) : rcRole.roleName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleId;
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        return result;
    }
}
