package sysc4806.group27.minisurveymonkey.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
public class OptionQuestion extends Question {

//    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    @ElementCollection
    @CollectionTable(name = "optionQuestionAnswers", joinColumns = @JoinColumn(name = "id"))
    @MapKeyJoinColumn(name = "question_id")
    @Column(name = "selections")
    private Map<String, Integer> answers;

    public OptionQuestion() {
        setType(QuestionType.OPTION);
        answers = new HashMap<>();
    }

    @Override
    public Map<String, Integer> getAnswerAsMap() {
        return null;
    }

    @Override
    public void addAnswer(String option) {
        answers.replace(option, answers.get(option) + 1);
    }

    public void addOption(String optionValue){
        answers.put(optionValue, 0);
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