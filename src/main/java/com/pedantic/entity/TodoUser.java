package com.pedantic.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TODO_USER")
@NamedQuery(name = "findByEmail", query = "SELECT u FROM TodoUser u WHERE u.email = :email")
@NamedQuery(name = "findAll", query= "SELECT u FROM TodoUser u ORDER BY u.fullName")
@NamedQuery(name = "findById", query= "SELECT u FROM TodoUser u WHERE u.id = :id")
@NamedQuery(name = "findByFullName", query= "SELECT u FROM TodoUser u WHERE u.fullName LIKE :name")
public class TodoUser extends BaseEntity {

    @Column(name = "EMAIL", length = 100)
    @NotEmpty(message = "An email must be set")
    @Email(message = "Invalid email format")
    private String email;

    @Column(name = "PASSWORD")
    @NotNull(message = "Password cannot be empty")
    @Size(min = 8, max = 100, message = "Password length should be between {min} and {max}")
    private String password;

    @Column(name = "FULL_NAME")
    @NotEmpty(message = "Name must be set")
    @Size(min = 2, max = 100, message = "Name length should be between {min} and {max}")
    private String fullName;

//    @OneToMany(mappedBy = "todoOwner")
//    private final Collection<Todo> todos = new ArrayList<>();

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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
