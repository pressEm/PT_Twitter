package vsu.javablog.db.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users", schema = "tp_twitter")
@Validated
@Getter
@Setter
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    @Column(name = "login")
    @NotEmpty(message = "Username can not be empty")
    @Size(min = 4, max = 20, message = "Username length should be between 4 an 20 characters")
    private String username;

    @Column(name = "email")
    @NotEmpty(message = "Email can not be empty")
    @Email(message = "Email is not valid")
    private String email;

    @Column(name = "password")
    @NotEmpty(message = "Password can not be empty")
    private String password;

//    @Column(name = "profile_picture")
//    private String profilePicture;

    @ManyToOne()
    @JoinColumn(name = "role")
    @NotEmpty(message = "Roles can not be null")
    private RoleEntity role;

    @OneToMany(mappedBy="userId")
    private Set<CommentEntity> comments;

//    public UserEntity() {
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
////    public String getProfilePicture() {
////        return profilePicture;
////    }
//
//    public RoleEntity getRoles() {
//        return role;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
////    public void setProfilePicture(String profilePicture) {
////        this.profilePicture = profilePicture;
////    }
//
//    public void setRoles(RoleEntity role) {
//        this.role = role;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
////
////    @Override
////    public boolean equals(Object o) {
////        if (this == o) return true;
////        if (!(o instanceof UserEntity)) return false;
////        UserEntity that = (UserEntity) o;
////        return Objects.equals(getId(), that.getId()) && Objects.equals(getUsername(), that.getUsername()) && Objects.equals(getPassword(), that.getPassword()) && Objects.equals(getProfilePicture(), that.getProfilePicture()) && Objects.equals(getRoles(), that.getRoles()) && Objects.equals(getEmail(), that.getEmail());
////    }
//
////    @Override
////    public int hashCode() {
////        return Objects.hash(getId(),  getUsername(), getPassword(), getProfilePicture(), getRoles(), getEmail());
////    }
//
////    @Override
////    public String toString() {
////        return "UserEntity{" +
////                "id=" + id +
////                ", username='" + username + '\'' +
////                ", profilePicture='" + profilePicture + '\'' +
////                ", roles=" + roles +
////                ", email='" + email + '\'' +
////                '}';
////    }
}
