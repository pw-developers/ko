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
		/*String comando = req.getParameter("comando");

		if (comando == null) {
			req.setAttribute("campoX", 10);
			forward(req, resp, "/admin.jsp");
		}else{
			req.setAttribute("campoX", 10);
			forward(req, resp, "/admin.jsp");
		}*/
		
		try {
			System.out.println("Entrou no Servlet");
			String comando = req.getParameter("comando");

			if (comando == null) {
				System.out.println("AdminServlet redirecionou admin.jsp");
				forward(req, resp, "/admin.jsp");
			} else if (comando.equals("Entrar")) {
				HttpSession session = req.getSession();
				session.setAttribute("logado", false);
				String login = req.getParameter("login");
				String senha = req.getParameter("senha");
				if(!login.isEmpty() && !senha.isEmpty()){
					boolean name =  true;
			        session.setAttribute("logado",name);
			        session.setAttribute("login",login);
					forward(req, resp, "/ko-admin/admin-panel.jsp");
			        //String url = req.getContextPath()+"/ko-admin/admin-panel.jsp";
					//System.out.println("Redirecionou "+url);
					//resp.sendRedirect(url);
				}else{
					System.out.println("AdminServlet redirecionou admin.jsp");
					forward(req, resp, "/admin.jsp");
				}
			}else if (comando.equals("erro404")){
				req.getRequestDispatcher("./ko-admin/admin-pan123el.jsp").forward(req, resp);
			}
		} catch (Throwable e) {
			//Retorna o 404
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			e.printStackTrace();
		}

	}

}
