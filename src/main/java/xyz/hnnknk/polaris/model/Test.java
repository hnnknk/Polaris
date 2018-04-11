package xyz.hnnknk.polaris.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table
public class Test {

    @Id
    @GeneratedValue
    private long id;

    @NotBlank
    @Column
    private String name;

    @ManyToOne(targetEntity = Author.class, fetch = FetchType.LAZY)
    private Author author;

    @OneToMany(targetEntity = Question.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Question> questions;

    public Test() {
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Test)) return false;
        Test test = (Test) o;
        return getId() == test.getId();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());
    }
}
