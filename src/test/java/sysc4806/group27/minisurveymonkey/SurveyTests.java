//package sysc4806.group27.minisurveymonkey;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//import sysc4806.group27.minisurveymonkey.model.Survey;
//import sysc4806.group27.minisurveymonkey.repository.SurveyRepository;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest(classes = {MiniSurveyMonkeyApplication.class})
//@AutoConfigureMockMvc
//public class SurveyTests {
//
//    @Autowired
//    private MockMvc mockMvc;
//    @Autowired
//    private SurveyRepository surveyRepository;
//
//    @Test
//    public void allSurveys() throws Exception {
//        this.mockMvc.perform(get("/survey/all")).andDo(print()).andExpect(status().isOk());
//    }
//
//    @Test
//    public void showSurveys() throws Exception {
//        for(Survey survey : surveyRepository.findAll())
//            this.mockMvc.perform(post("/survey/" + survey.getName())).andDo(print()).andExpect(status().isOk());
//    }
//}
