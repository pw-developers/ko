package servlet;

import static servlet.ServletUtil.forward;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value = "/login-admin.ko")
public class LoginAdminServlet extends HttpServlet  {

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String comando = req.getParameter("comando");

		if (comando == null) {
			req.setAttribute("campoX", 10);
			forward(req, resp, "/admin.jsp");
		}
	}

}
