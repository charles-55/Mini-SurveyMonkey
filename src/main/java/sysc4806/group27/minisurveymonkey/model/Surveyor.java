package sysc4806.group27.minisurveymonkey.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


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


}
