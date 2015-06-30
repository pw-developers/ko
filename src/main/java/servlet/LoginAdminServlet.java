package servlet;

import static servlet.ServletUtil.forward;
import static servlet.ServletUtil.validaLogin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

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

import admin.Usuario;
import dao.UsuarioDAO;

/**
 * Objetivo: servlet que gerencia o login dos usuarios e cria o BD
 *
 */

@WebServlet(value = "/login-admin.ko")
public class LoginAdminServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		try {
			criarDB();
			criaAdminUser();
		} catch (Exception e) {
			// System.err.println(e.getMessage());
		}
	}

	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			String comando = req.getParameter("comando") == null ? ""
					: (String) req.getParameter("comando");
			if (!comando.isEmpty() && comando.equals("entrar")) {
				
				Boolean validaSenha = validaLogin(req, resp);
				
				if (validaSenha) {
					HttpSession session = req.getSession();
					session.setAttribute("login",
							(String) req.getParameter("login"));
					session.setAttribute("senha",
							(String) req.getParameter("senha"));
					forward(req, resp, "/ko-admin/admin-panel.jsp");
				} else {
					if (!validaSenha) {
						req.setAttribute("MsgErro",
								"Usu�rio e/ou Senha inv�lidos.");
					}
					forward(req, resp, "./admin.jsp");
				}
			} else if (!comando.isEmpty() && comando.equals("logout")) {
				logoutUser(req);
				resp.sendRedirect("/ko/ko?caminho=index");
			} else {
				forward(req, resp, "./admin.jsp");
			}
		} catch (Throwable e) {
			// Retorna o 404
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			e.printStackTrace();
		}

	}

	private void logoutUser(HttpServletRequest req){
		req.getSession().invalidate();
	}
	
	private void criarDB() throws SQLException {
		try {
			String sql = "" + "create table usuario ("
					+ "  id numeric(18,0) not null,"
					+ "  login varchar(20) not null,"
					+ "  senha varchar(20) not null,"
					+ "  nome varchar(40),"
					+ "  sobrenome varchar(40),"
					+ "  email varchar(40) not null,"
					+ "  constraint pk_conta primary key (id) " + ")";
			String url = "jdbc:derby:db;create=true";
			Connection conexao;
			conexao = DriverManager.getConnection(url);
			Statement stmt = conexao.createStatement();
			stmt.execute(sql);
			stmt.close();
		} catch (Exception e) {
			System.err.println("criarDB: " + e.getMessage());
		}
	}

	/**
	 * Cria usuario admin, utiliza as configuracoes Singleton para persistencia
	 */
	private void criaAdminUser() {
		try {
			Usuario user = new Usuario();
			user.setEmail("admin@admin.com");
			user.setLogin("admin");
			user.setNome("Admin");
			user.setSenha("koiwin");
			user.setSobreNome("Admin");
			UsuarioDAO userDAO = UsuarioDAO.getInstance();
			List listUser = userDAO.findOne("admin", "koiwin");
			if (listUser != null && listUser.size() == 0) {
				userDAO.getInstance().create(user);
			}
		} catch (Exception e) {
			System.err.println("criarDB: " + e.getMessage());
		}

	}

}
