package sysc4806.group27.minisurveymonkey.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Survey {

    @Id
    private String name;
    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<TextQuestion> questions;

    public Survey() {
        questions = new ArrayList<>();
    }

    public Survey(String name) {
        this.name = name;
        questions = new ArrayList<>();
    }

    public void addQuestion(TextQuestion question) {
        questions.add(question);
    }

    public void removeQuestion(TextQuestion question) {
        questions.remove(question);
    }
}
