package sysc4806.group27.minisurveymonkey.model;
import jakarta.persistence.*;

import java.util.ArrayList;

public class OptionQuestion extends Question {

    private OptionQuestion question;
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private ArrayList<Option> options = new ArrayList<>();


    public OptionQuestion(String text){
        super(text);
    }

    public void addOption(String optionValue){
        Option option = new Option(optionValue);
        option.setQuestion (this);
        options.add(option);
    }


    public static void main(String[] args) {
        OptionQuestion q1 = new OptionQuestion("Do you like Java?");
        Option op1 = new Option("yes");
        Option op2 = new Option("no");
        q1.addOption(String.valueOf(op1));
        q1.addOption(String.valueOf(op2));
    }
}
