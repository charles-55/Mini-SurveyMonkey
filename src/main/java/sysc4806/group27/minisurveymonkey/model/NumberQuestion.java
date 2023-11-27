package sysc4806.group27.minisurveymonkey.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Entity
@Getter
@Setter
public class NumberQuestion extends Question {

    @Id
    private Long id;
    private int minVal;
    private int maxVal;
    private int stepVal;

    //Answers with first integer as the range value and the second integer as the count
    @ElementCollection
    @CollectionTable(name = "numberQuestionAnswers", joinColumns = @JoinColumn(name = "id"))
    @MapKeyJoinColumn(name = "question_id")
    @Column(name = "selections")
    private Map<Integer, Integer> answers;

    public NumberQuestion() {
        this(0, 10, 1);
    }

    public NumberQuestion(int minVal, int maxVal, int stepVal) {
        setType(QuestionType.NUMBER);
        this.minVal = minVal;
        this.maxVal = maxVal;
        this.stepVal = stepVal;

        int x = minVal;
        int y = maxVal-minVal;

        //instantiate and initialize every key to have a count of 0
        answers = new HashMap<>();
        for(; x<y; x+=stepVal){
            answers.put(x, 0);
        }
    }

    public void addCount(int key){
        answers.replace(key, answers.get(key)+1);
    }

    @Override
    public void addAnswer(String s) {

    }

}