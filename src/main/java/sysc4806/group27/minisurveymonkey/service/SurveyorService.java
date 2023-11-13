package sysc4806.group27.minisurveymonkey.service;

import org.springframework.stereotype.Service;
import sysc4806.group27.minisurveymonkey.model.Surveyor;
import sysc4806.group27.minisurveymonkey.repository.SurveyorRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SurveyorService {
    private final SurveyorRepository surveyorRepository;

    public SurveyorService(SurveyorRepository surveyorRepository) {
        this.surveyorRepository = surveyorRepository;
    }

    public void  saveSurveyor(Surveyor s){
        Surveyor surveyor=new Surveyor();
        surveyor.setName(s.getName());
        surveyor.setEmail(s.getEmail());
        surveyor.setPassword(s.getPassword());
        surveyorRepository.save(surveyor);
    }

    public List<Surveyor> findAllSurveyor(){
        Iterable<Surveyor> surveyorsIterable = surveyorRepository.findAll();
        return StreamSupport.stream(surveyorsIterable.spliterator(), false)
                .collect(Collectors.toList());
    }

    /** public Surveyor findUserByEmail(String email) {
     return surveyorRepository.findByEmail(email);
     }
     **/

}
