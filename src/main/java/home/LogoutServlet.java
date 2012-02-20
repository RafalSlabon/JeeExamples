package home;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("serial")
public class LogoutServlet extends HttpServlet {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LogoutServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
		if(session != null){
			LOGGER.info("Invalidating session for user: " + session.getAttribute("user"));
			session.invalidate();
		}

		req.getRequestDispatcher("/login.jsp").forward(req, resp);
		
	}

}
