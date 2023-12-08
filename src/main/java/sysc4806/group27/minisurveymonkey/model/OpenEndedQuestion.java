package sysc4806.group27.minisurveymonkey.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Map;

@Entity
public class OpenEndedQuestion extends Question {

    private ArrayList<String> answers;

    public OpenEndedQuestion() {
        setType(QuestionType.OPEN_ENDED);
        answers = new ArrayList<>();
    }
  
    @Override
    public void addAnswer(String answer) {
        answers.add(answer);
    }

    @Override
    public Object getAnswers() {
        return answers;
    }

    @ElementCollection
    @CollectionTable(name = "openEndedQuestionAnswers", joinColumns = @JoinColumn(name = "id"))
    @MapKeyJoinColumn(name = "question_id")
    @Column(name = "selections")
    @Override
    public Map<String, Integer> getAnswerAsMap() {
        return null;
    }
}
