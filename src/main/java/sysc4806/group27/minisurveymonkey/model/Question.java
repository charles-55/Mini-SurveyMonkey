package sysc4806.group27.minisurveymonkey.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public abstract class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String content;
    @ManyToOne
    private Survey survey;

    public abstract void addAnswer(String s);

    public abstract Object getAnswers();

    public abstract void addAnswer(String s);
}
