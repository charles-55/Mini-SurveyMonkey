package sysc4806.group27.minisurveymonkey.model;

import jakarta.persistence.*;
import java.util.ArrayList;

@Entity
public class OpenEndedQuestion extends Question {

    private ArrayList<String> answers;

    public OpenEndedQuestion() {
        answers = new ArrayList<>();
    }

    @Override
    public void addAnswer(String answer) {
        answers.add(answer);
    }

    public Object getAnswers() {
        return answers;
    }
}
