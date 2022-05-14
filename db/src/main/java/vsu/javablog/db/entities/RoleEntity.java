package vsu.javablog.db.entities;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "roles", schema = "tp_twitter")
//@Validated
@Getter
@Setter
public class RoleEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Integer roleId;

    @Column(name = "role_name")
    @NotBlank
    @NotEmpty
    private String roleName;

//    public RoleEntity() {
//    }
//
//    public Long getRoleId() {
//        return roleId;
//    }
//
//    public void setRoleId(Long role_id) {
//        this.roleId = role_id;
//    }
//
//    public String getRoleName() {
//        return roleName;
//    }
//
//    public void setRoleName(String role_name) {
//        this.roleName = role_name;
//    }
}
