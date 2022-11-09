package com.vu.entity;

import com.vu.constant.EntityConstant;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = EntityConstant.USER_TABLE, schema = EntityConstant.PUBLIC_SCHEMA,
        uniqueConstraints = {@UniqueConstraint(name = EntityConstant.USER_UK,
                                                columnNames = {EntityConstant.EMAIL_COLUMN,
                                                                EntityConstant.PHONE_COLUMN})})
public class User extends Audit {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = EntityConstant.ID_COLUMN, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = EntityConstant.ROLE_ID_COLUMN, nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Role role;

    @NotBlank
    @Column(name = EntityConstant.FULLNAME_COLUMN, length = 200, nullable = false)
    private String name;
    
    @NotBlank
    @Column(name = EntityConstant.USERNAME_COLUMN, length = 200, nullable = false)
    private String username;

    @NotBlank
    @Column(name = EntityConstant.EMAIL_COLUMN, length = 50, nullable = false)
    private String email;

    @NotBlank
    @Column(name = EntityConstant.PASSWORD_COLUMN, length = 255, nullable = false)
    private String password;

    @NotBlank
    @Column(name = EntityConstant.ADDRESS_COLUMN, length = 255, nullable = false)
    private String address;

    @NotBlank
    @Column(name = EntityConstant.PHONE_COLUMN, length = 12, nullable = false)
    private String phone;

    @NotBlank
    @Column(name = EntityConstant.AVATAR_COLUMN,
            columnDefinition = EntityConstant.TEXT_COLUMN_DEFINITION, nullable = true)
    private String avatar;
    
    @NotBlank
    @Column(name = EntityConstant.REMEMBER_TOKEN_COLUMN, length = 255, nullable = true)
    private String rememberToken;

    public User() {
    }

    public User(Role role,
                @NotBlank String name,
                @NotBlank String email,
                @NotBlank String password,
                @NotBlank String address,
                @NotBlank String phone,
                @NotBlank String avatar,
                Date createdAt) {
        this.role = role;
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.avatar = avatar;
        super.setCreatedAt(createdAt);
    }

	public User(Role role, @NotBlank String name, @NotBlank String username, @NotBlank String email,
			@NotBlank String password, @NotBlank String address, @NotBlank String phone, @NotBlank String avatar,
			@NotBlank String rememberToken) {
		this.role = role;
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.address = address;
		this.phone = phone;
		this.avatar = avatar;
		this.rememberToken = rememberToken;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getRememberToken() {
        return rememberToken;
    }

    public void setRememberToken(String rememberToken) {
        this.rememberToken = rememberToken;
    }
}
