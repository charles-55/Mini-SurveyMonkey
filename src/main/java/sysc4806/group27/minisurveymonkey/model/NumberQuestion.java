package sysc4806.group27.minisurveymonkey.model;

import java.util.HashMap;

public class NumberQuestion extends Question {
    private int minVal;
    private int maxVal;

    //Answers with first integer as the range value and the second integer as the count
    private HashMap<Integer, Integer> answers;

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

    int getMinVal() {
        return minVal;
    }

    int getMaxVal() {
        return maxVal;
    }

    @Override
    public HashMap<Integer, Integer> getAnswers() {
        return answers;
    }

    void addCount(int key){
        answers.replace(key, answers.get(key)+1);
    }

}
