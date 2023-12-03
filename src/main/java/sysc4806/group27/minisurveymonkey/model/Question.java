package sysc4806.group27.minisurveymonkey.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;

@Entity
@Getter
@Setter
public abstract class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String content;
    @ManyToOne
    private Survey survey;
    private QuestionType type;

    public abstract Object getAnswers();

    public HashMap<String, Integer> getAnswerAsMap() {
        try {
            return (HashMap<String, Integer>) getAnswers();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public abstract void addAnswer(String s);

    public List<String> getOptions() {
        return null;
    }

    public int getMinVal() {
        return -1;
    }

    public int getMaxVal() {
        return -1;
    }

    public int getStepVal() {
        return -1;
    }
}
