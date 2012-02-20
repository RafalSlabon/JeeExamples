package home;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String login = (String)req.getParameter("login");
		String password = (String)req.getParameter("password");
		
		LOGGER.info("Login = " + login + " | Password = " + password);
		
		User loggedUser = (User) session.getAttribute("user");
		if(loggedUser == null){
			loggedUser = new User();
			EntityManager em = DBManager.getDbManager().createEntityManager();
			em.getTransaction().begin();
			em.persist(loggedUser);
			em.getTransaction().commit();
			em.close();
			
		}
		loggedUser.setLogin(login);
		loggedUser.setPassword(password);
		loggedUser.setSession(session);
		
		session.setAttribute("user", loggedUser);
		
		LOGGER.info("User = " + loggedUser);
		
		req.getRequestDispatcher("/main.jsp").forward(req, resp);
		
	}
	
	public static void main(String[] args) {
		EntityManager em = DBManager.getDbManager().createEntityManager();
		em.getTransaction().begin();
		em.persist(new User());
		em.getTransaction().commit();
		em.close();
	}

}
