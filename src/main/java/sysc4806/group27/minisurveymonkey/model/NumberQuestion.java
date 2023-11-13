package sysc4806.group27.minisurveymonkey.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
@Entity
@Getter
@Setter
public class NumberQuestion extends Question {

    @Id
    private Long id;
    private int minVal;
    private int maxVal;

    //Answers with first integer as the range value and the second integer as the count
    @ElementCollection
    @CollectionTable(name = "numberQuestionAnswers", joinColumns = @JoinColumn(name = "id"))
    @MapKeyJoinColumn(name = "question_id")
    @Column(name = "selections")
    private HashMap<Integer, Integer> answers;

    public NumberQuestion() {
        this(0, 10);
    }

    public NumberQuestion(int minVal, int maxVal){
        this.minVal = minVal;
        this.maxVal = maxVal;

        int x = minVal;
        int y = maxVal-minVal;

        //instantiate and initialize every key to have a count of 0
        answers = new HashMap<>();
        for(; x<y; x++){
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