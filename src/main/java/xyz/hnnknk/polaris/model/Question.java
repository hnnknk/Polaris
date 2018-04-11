package xyz.hnnknk.polaris.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table
public class Question {

    @Id
    @GeneratedValue
    private long id;

    @NotBlank
    @Column
    private String body;

    @NotNull
    @Column
    private boolean isOneAnswer;

    public Question() {
    }

    public Question(@NotBlank String body, @NotNull boolean isOneAnswer) {
        this.body = body;
        this.isOneAnswer = isOneAnswer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isOneAnswer() {
        return isOneAnswer;
    }

    public void setOneAnswer(boolean oneAnswer) {
        isOneAnswer = oneAnswer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", body='" + body + '\'' +
                ", isOneAnswer=" + isOneAnswer +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question)) return false;
        Question question = (Question) o;
        return getId() == question.getId();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());
    }
}
