package home;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ElServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Logger log = LoggerFactory.getLogger(this.getClass());
		
		resp.setContentType("text/html;charset=UTF-8");
		
		HttpSession httpSession = req.getSession();

		log.info("ElServlet session is: " + httpSession);
		log.info("Encoded url: " + resp.encodeURL("/Result.jsp"));
		
		int result = 5 + Integer.parseInt(req.getParameter("number"));
		req.setAttribute("result", result);
		req.getRequestDispatcher(resp.encodeURL("/Result.jsp")).include(req, resp);
	}

}
