package sysc4806.group27.minisurveymonkey.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Surveyors")

public class Surveyor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false, unique=true)
    private String email;

    @Column(nullable=false, unique=true)
    private String password;

    /**  @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
     @JoinTable(
     name="Surveyor_roles",
     joinColumns={@JoinColumn(name="Surveyor_ID", referencedColumnName="ID")},
     inverseJoinColumns={@JoinColumn(name="Survey_ID", referencedColumnName="ID")})
     private List<Survey> Surveys = new ArrayList<>();**/

    @OneToMany
    private List<Survey> Surveys;

    public void addSurveys(Survey survey){
        Surveys.add(survey);
    }
    public void removeSurveys(Survey survey){
        Surveys.remove(survey);
    }


}
