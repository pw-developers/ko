package servlet;

import static servlet.ServletUtil.forward;
import static servlet.ServletUtil.validaLogin;

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
		} catch (Exception e) {
			// System.err.println(e.getMessage());
		}
	}

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String comando = req.getParameter("comando") == null ? "" : (String) req.getParameter("comando");

			if (!comando.isEmpty() && comando.equals("Entrar")) {
				Boolean validaSenha = validaLogin(req, resp);
				if (validaSenha) {
					HttpSession session = req.getSession();
					session.setAttribute("login", (String) req.getParameter("login"));
					session.setAttribute("senha", (String) req.getParameter("senha"));
					forward(req, resp, "/ko-admin/admin-panel.jsp");
				} else {
					if (!validaSenha) {
						req.setAttribute("MsgErro", "Usuário e/ou Senha inválidos.");
					}
					forward(req, resp, "./admin.jsp");
				}
			} else {
				forward(req, resp, "./admin.jsp");
			}
		} catch (Throwable e) {
			// Retorna o 404
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			e.printStackTrace();
		}

	}

	private void criarDB() throws SQLException {
		try {
			String sql = "" + "create table usuario (" + "  id numeric(18,0) not null," + "  login varchar(20) not null," + "  senha varchar(20) not null," + "  nome varchar(40) not null," + "  sobrenome varchar(40) not null,"
					+ "  email varchar(40) not null," + "  constraint pk_conta primary key (id) " + ")";
			String sql2 = "insert into usuario (id, login, senha, nome, sobrenome, email) values (0,'admin','koiwin','Admin', 'Admin','admin@komail.com')";
			String url = "jdbc:derby:db;create=true";
			Connection conexao;
			conexao = DriverManager.getConnection(url);
			Statement stmt = conexao.createStatement();
			stmt.execute(sql);
			stmt.execute(sql2);
			stmt.close();
		} catch (Exception e) {
			System.err.println("criarDB: " + e.getMessage());
		}
	}

}
