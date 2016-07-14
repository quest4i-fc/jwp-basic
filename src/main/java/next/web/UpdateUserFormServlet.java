package next.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import core.db.DataBase;
import next.model.User;

@WebServlet("/user/update")
public class UpdateUserFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
    private static final Logger LOGGER = LoggerFactory.getLogger(UpdateUserFormServlet.class);
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    User user = DataBase.findUserById(request.getParameter("userId"));
	    user.setPassword(request.getParameter("password"));
	    user.setName(request.getParameter("name"));
	    user.setEmail(request.getParameter("email"));
        LOGGER.debug("user : {}", user);

        response.sendRedirect("/user/list"); 
	}

}
