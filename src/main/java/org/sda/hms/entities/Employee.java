package org.sda.hms.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="employee")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User userId;

    @ManyToOne
    @JoinColumn(name="department_id", referencedColumnName = "id")
    private Department departmentId;


}
