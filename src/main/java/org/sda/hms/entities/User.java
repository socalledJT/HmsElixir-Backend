package org.sda.hms.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.sda.hms.entities.enums.UserRole;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private UserRole role;

    @OneToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department departmentId;
}
