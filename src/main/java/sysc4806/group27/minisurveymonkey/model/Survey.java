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
    @GeneratedValue
    private int id;
    private String name;

    @OneToMany(mappedBy = "survey", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<Question> questions;

    public Survey() {
        questions = new ArrayList<>();
    }

    public Survey(String name) {
        this.name = name;
        questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        // may want to move this into controller or service
        question.setSurvey(this);
        if (question instanceof OpenEndedQuestion) {
            questions.add((OpenEndedQuestion) question);
        } else if (question instanceof NumberQuestion) {
            questions.add((NumberQuestion) question);
        } else {
            questions.add((OptionQuestion) question);
        }
    }

    public void removeQuestion(Question question) {
        questions.remove(question);
    }
}
