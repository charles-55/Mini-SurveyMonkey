package sysc4806.group27.minisurveymonkey.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Entity
@Setter
public class NumberQuestion extends Question {

    private int minVal;
    private int maxVal;

    //Answers with first integer as the range value and the second integer as the count
    @ElementCollection
    private Map<Integer, Integer> answers;

    public NumberQuestion() {
        this(0, 0);
        answers = new HashMap<>();
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

    public int getMinVal() {
        return minVal;
    }

    public int getMaxVal() {
        return maxVal;
    }

    @Override
    public void addAnswer(String s) {}

    @Override
    public Map<Integer, Integer> getAnswers() {
        return answers;
    }

    void addCount(int key){
        answers.replace(key, answers.get(key)+1);
    }
}