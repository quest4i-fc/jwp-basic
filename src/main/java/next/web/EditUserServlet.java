package next.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import core.db.DataBase;
import next.model.User;



@WebServlet("/user/edit") 
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
    private static final Logger LOGGER = LoggerFactory.getLogger(EditUserServlet.class);

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    User user = DataBase.findUserById(request.getParameter("userid"));
	    LOGGER.debug("user name to edit : {}", user.getName());
	    // TODO user객체를 전달하기 위해서 forward를 해야 한다.
	    RequestDispatcher rd = request.getRequestDispatcher("edit.jsp");
	}

}
