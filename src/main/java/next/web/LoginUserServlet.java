package next.web;

import java.io.IOException;
import java.util.Optional;

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

/**
 * Servlet implementation class LoginUserServlet
 */
@WebServlet("/user/login")
public class LoginUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginUserServlet.class);
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
	    Optional<User> user = Optional.ofNullable(DataBase.findUserById(request.getParameter("userId")));
	    LOGGER.debug("" + user.isPresent());

	    if (user.isPresent() &&  user.get().isLogin(request.getParameter("password"))) {
	        LOGGER.debug("login user : " + user.get().getName());
	        request.setAttribute("user", user.get());
//	        RequestDispatcher rd = request.getRequestDispatcher("/index.html");
//	        rd.forward(request, response);
	        response.sendRedirect("/index.html");
	    } else {
	        goFail(response);
	    }
	} // end of doPost

	void goFail(HttpServletResponse response) throws IOException {
	    LOGGER.debug("go fail");
	    response.sendRedirect("/user/login_failed.html");
	}
}