package servlet;

import static servlet.ServletUtil.forward;
import static servlet.ServletUtil.validaLogin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.Usuario;
import dao.UsuarioDAO;

/**
 * Servlet para gerenciar o CRUD da entidade Usuario Todas funcoes relacionadas
 * a Usuario sao gerenciadas aqui
 */
@WebServlet(value = "/UserServlet.ko")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDAO userDAO = UsuarioDAO.getInstance();

	public UserServlet() {
		super();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String comando = req.getParameter("comando") == null ? ""
				: (String) req.getParameter("comando");

		try {
			// Valida login

			if (!comando.isEmpty()) {

				switch (comando) {

				case "painel":
					forward(req, resp, "./ko-admin/admin-panel.jsp");
					break;

				case "usuarios":
					listar(req);
					forward(req, resp, "./ko-admin/user.jsp");
					break;

				case "addUser":
					forward(req, resp, "./ko-admin/user-new.jsp");
					break;

				case "editUser":
					prepararEditar(req);
					forward(req, resp, "./ko-admin/user-edit.jsp");
					break;

				case "salvar":
					salvar(req);
					req.setAttribute("comando", "usuarios");
					forward(req, resp, "/AdminServlet.ko");
					break;

				case "editar":
					editar(req);
					req.setAttribute("comando", "usuarios");
					forward(req, resp, "/AdminServlet.ko");
					break;

				case "deletar":
					deletar(req);
					req.setAttribute("comando", "usuarios");
					forward(req, resp, "/AdminServlet.ko");
					break;
				}
			}
		} catch (Throwable e) {
			// Retorna o 404
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			e.printStackTrace();
		}
	}

	protected void salvar(HttpServletRequest request) throws Exception {
		Usuario user = new Usuario();
		preencheAtributosUsuario(user, request);
		userDAO.create(user);
	}

	protected void editar(HttpServletRequest request) throws Exception {
		String id = request.getParameter("id-usuario");
		long idLong = Long.parseLong(id);
		Usuario user = UsuarioDAO.getInstance().findOne(idLong);
		preencheAtributosUsuario(user, request);
		userDAO.update(user);
	}

	protected void deletar(HttpServletRequest request) throws Exception {
		String id = request.getParameter("id-usuario");
		userDAO.deleteById(Long.valueOf(id));
	}

	private void listar(HttpServletRequest req) {
		List<Usuario> listaUsuario = UsuarioDAO.getInstance().findAll();
		req.setAttribute("listaUsuarios", listaUsuario);
	}

	private void prepararEditar(HttpServletRequest request) throws Exception {
		String id = request.getParameter("id-usuario");
		long idLong = Long.parseLong(id);
		Usuario user = UsuarioDAO.getInstance().findOne(idLong);
		request.setAttribute("userEdit", user);
	}

	private void preencheAtributosUsuario(Usuario user,
			HttpServletRequest request) throws Exception {
		user.setLogin(request.getParameter("login"));
		user.setEmail(request.getParameter("email-usuario"));
		user.setNome(request.getParameter("nome-usuario"));
		user.setSobreNome(request.getParameter("sobrenome-usuario"));
		user.setSenha(request.getParameter("senha"));
	}

}
