package sysc4806.group27.minisurveymonkey.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="surveyors")

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

    @OneToMany(mappedBy = "surveyor", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<Survey> surveys=new ArrayList<>();

    public void addSurvey(Survey survey){
        surveys.add(survey);
    }
    public void removeSurvey(Survey survey){
        surveys.remove(survey);
    }


}
