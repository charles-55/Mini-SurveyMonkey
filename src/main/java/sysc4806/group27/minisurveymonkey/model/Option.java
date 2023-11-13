package sysc4806.group27.minisurveymonkey.model;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private OptionQuestion question;

    @Getter
    private String text;

    public Option(String text) {
        this.text = text;
    }

    public Option() {

    }


    public void setText(String text) {
        this.text = text;
    }

    public void setQuestion(OptionQuestion optionQuestion) {
        this.question = optionQuestion;
    }
}
