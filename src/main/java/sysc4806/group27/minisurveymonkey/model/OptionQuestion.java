package sysc4806.group27.minisurveymonkey.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Entity
@Getter
@Setter
public class OptionQuestion extends Question {

//    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private ArrayList<String> options;
    private ArrayList<String> answers;

    public OptionQuestion() {
        options = new ArrayList<>();
        answers = new ArrayList<>();
    }

    @Override
    public void addAnswer(String answer) {
        answers.add(answer);
    }

    public void addOption(String optionValue){
        options.add(optionValue);
    }

//    public void addOption(String optionValue){
//        Option option = new Option(optionValue);
//        option.setQuestion (this);
//        options.add(option);
//    }
//
//
//    public static void main(String[] args) {
//        OptionQuestion q1 = new OptionQuestion("Do you like Java?");
//        Option op1 = new Option("yes");
//        Option op2 = new Option("no");
//        q1.addOption(String.valueOf(op1));
//        q1.addOption(String.valueOf(op2));
//    }
}