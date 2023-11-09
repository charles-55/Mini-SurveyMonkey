package sysc4806.group27.minisurveymonkey.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Survey {

    @Id
    @GeneratedValue
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void removeQuestion(Question question) {
        questions.remove(question);
    }
}
