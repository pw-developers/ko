package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;

public class ServletUtil {

	public static void forward(HttpServletRequest req, HttpServletResponse resp, String path) throws ServletException, IOException {
		req.getRequestDispatcher(path).forward(req, resp);
	}

	/**
	 * Valida o login e senha
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public static boolean validaLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = "";
		String senha = "";

		// Pego login e senha, verifico se o usuario ja realizou login anteriormente para nao acessar admin.jsp
		if (req.getSession().getAttribute("login") != null && req.getSession().getAttribute("senha") != null) {
			login = (String) req.getSession().getAttribute("login");
			senha = (String) req.getSession().getAttribute("senha");
		} else if (req.getParameter("login") != null && req.getParameter("senha") != null) {
			login = (String) req.getParameter("login");
			senha = (String) req.getParameter("senha");
		}
		
		return UsuarioDAO.validaUsuario(login, senha);
	}
}
