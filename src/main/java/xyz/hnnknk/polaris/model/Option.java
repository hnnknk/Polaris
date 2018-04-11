package xyz.hnnknk.polaris.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table
public class Option {

    @Id
    @GeneratedValue
    private long id;

    @NotBlank
    @Column
    private String body;

    @NotNull
    @Column
    private boolean isAnswer;

    public Option() {
    }

    public Option(@NotBlank String body, @NotNull boolean isAnswer) {
        this.body = body;
        this.isAnswer = isAnswer;
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

    public boolean isAnswer() {
        return isAnswer;
    }

    public void setAnswer(boolean answer) {
        isAnswer = answer;
    }

    @Override
    public String toString() {
        return "Option{" +
                "id=" + id +
                ", body='" + body + '\'' +
                ", isAnswer=" + isAnswer +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Option)) return false;
        Option option = (Option) o;
        return getId() == option.getId();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());
    }
}
