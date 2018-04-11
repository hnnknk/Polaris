package xyz.hnnknk.polaris.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table
public class Author {

    @Id
    @GeneratedValue
    private long id;

    @NotBlank
    @Column
    private String name;

    @NotBlank
    @Column
    private String secondName;

    @Email
    @Column
    private String email;

    @OneToMany(targetEntity = Test.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Test> tests;

    public Author() {
    }

    public Author(@NotBlank String name, @NotBlank String secondName, @Email String email) {
        this.name = name;
        this.secondName = secondName;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;
        Author author = (Author) o;
        return getId() == author.getId();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());
    }
}
