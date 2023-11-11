package sysc4806.group27.minisurveymonkey.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class TextQuestion extends Question {

    @Id
    @GeneratedValue
    private int id;

    private String content;
    @ElementCollection
    private List<String> answers;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void addAnswer(String answer) {
        answers.add(answer);
    }
}
