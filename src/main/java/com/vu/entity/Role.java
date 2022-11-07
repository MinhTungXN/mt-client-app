package com.vu.entity;

import com.vu.constant.EntityConstant;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Collection;

@Entity
@Table(name = EntityConstant.ROLE_TABLE, schema = EntityConstant.PUBLIC_SCHEMA)
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = EntityConstant.ID_COLUMN, nullable = false)
    private Long id;

    @NotBlank
    @Column(name = EntityConstant.NAME_COLUMN, length = 50, nullable = false)
    private String name;

    @NotBlank
    @Column(name = EntityConstant.DESCRIPTION_COLUMN, length = 100, nullable = false)
    private String description;

    @OneToMany(mappedBy = "role")
    Collection<User> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }
}
