package sysc4806.group27.minisurveymonkey.model;

import jakarta.persistence.Entity;

import java.util.ArrayList;

@Entity
public class OptionQuestion extends Question {
    private ArrayList<String> answers;

    public void addAnswer(String answer) {
        answers.add(answer);
    }

    @Override
    public Object getAnswers() {
        return null;
    }
}
