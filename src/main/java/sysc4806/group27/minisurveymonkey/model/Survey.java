package sysc4806.group27.minisurveymonkey.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
//@Getter
//@Setter
public class Survey {

    @Id
    private String name;
    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<Question> questions;

    public Survey() {
        questions = new ArrayList<>();
    }

    public Survey(String name) {
        this.name = name;
        questions = new ArrayList<>();
    }

    public void addQuestion(OpenEndedQuestion question) {
        questions.add(question);
    }

    public void removeQuestion(OpenEndedQuestion question) {
        questions.remove(question);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
