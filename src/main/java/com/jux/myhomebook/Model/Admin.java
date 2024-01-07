package com.jux.myhomebook.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "admin")
public class Admin extends User{



    @Column(name ="is_admin")
    private boolean isAdmin;

}
