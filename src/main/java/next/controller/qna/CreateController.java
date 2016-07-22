package next.controller.qna;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import core.mvc.AbstractController;
import core.mvc.Controller;
import core.mvc.ModelAndView;
import next.dao.QuestionDao;
import next.model.Question;

public class CreateController extends AbstractController implements Controller {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateController.class);
    
    private QuestionDao questionDao = new QuestionDao();

    @Override
    public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Question question = new Question(request.getParameter("writer"),
                request.getParameter("title"),
                request.getParameter("contents"));
        LOGGER.debug("question : " + question);
        questionDao.insert(question);

        ModelAndView mav = jspView("redirect:/");
        return mav;
    }
    
} // end of CreateController
