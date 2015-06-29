package servlet;

import static servlet.ServletUtil.forward;
import static servlet.ServletUtil.validaLogin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.JpaUtil;
import dao.UsuarioDAO;
import admin.Usuario;

/**
 * Servlet que gerencia movimentacao dentro das funcoes de AMD
 *
 */
@WebServlet(value = "/AdminServlet.ko")
public class AdminServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			// Valida login
			if (!validaLogin(req, resp)) {
				resp.sendRedirect("/ko/login-admin.ko");
			} else {
				String comando = req.getParameter("comando") == null ? ""
						: (String) req.getParameter("comando");

				if (!comando.isEmpty()) {
					switch (comando) {
					
					case "painel":
						req.setAttribute("comando", "painel");
						forward(req, resp, "/UserServlet.ko");
						break;
					
					case "usuarios":
						req.setAttribute("comando", "painel-usuario");
						forward(req, resp, "/UserServlet.ko");
						break;

					}
				}
			}
		} catch (Throwable e) {
			// Retorna o 404
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			e.printStackTrace();
		}
	}

}
