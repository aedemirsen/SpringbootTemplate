package com.example.domain.entity.user;

import com.example.domain.entity.base.BaseDatedEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends BaseDatedEntity {

    @Column(unique = true)
    private String username;
    private String name;
    private String surname;
    private String password;
    private String mailAddress;


    @ManyToMany(
            fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.MERGE
            }
    )
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private List<Role> roles = new ArrayList<>();

    public String getFullName(){
        return name + " " + surname;
    }

}
