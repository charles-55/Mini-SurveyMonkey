package sysc4806.group27.minisurveymonkey.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

import java.util.HashMap;
@Entity
public class NumberQuestion extends Question {
    @Getter
    @Id
    private Long ID;
    private int minVal;
    private int maxVal;

    //Answers with first integer as the range value and the second integer as the count
    @ElementCollection
    private HashMap<Integer, Integer> answers;

    public NumberQuestion() {
        this(0, 10);
    }

    NumberQuestion(int minVal, int maxVal){
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

    public void setID(Long id) {
        this.ID = id;
    }

    int getMinVal() {
        return minVal;
    }

    int getMaxVal() {
        return maxVal;
    }

    void addCount(int key){
        answers.replace(key, answers.get(key)+1);
    }

    HashMap<Integer, Integer> getAnswers() {
        return answers;
    }

}
