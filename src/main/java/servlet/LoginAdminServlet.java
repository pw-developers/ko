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

import dao.UsuarioDAO;

@WebServlet(value = "/login-admin.ko")
public class LoginAdminServlet extends HttpServlet  {

	@Override
	public void init() throws ServletException {
		try {
			criarDB();
		} catch(Exception e) {
			//System.err.println(e.getMessage());
		}
	}
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		try {
			System.out.println("Entrou no AdminServlet");
			String comando = req.getParameter("comando");

			if (comando == null) {
				forward(req, resp, "./admin.jsp");
			} else if (comando.equals("Entrar")) {
				HttpSession session = req.getSession();
				String login = req.getParameter("login");
				String senha = req.getParameter("senha");
				Boolean validaSenha = UsuarioDAO.validaUsuario(login, senha);
				System.out.println("Login e senha "+login+" "+senha);
				if(!login.isEmpty() && !senha.isEmpty() && validaSenha){
					System.out.println("AdminServlet entrou aqui1");
					session.setAttribute("login", login);
					session.setAttribute("senha", senha);
					forward(req, resp, "/ko-admin/admin-panel.jsp");
				} else {
					if(!validaSenha){
						req.setAttribute("MsgErro", "Usuário e/ou Senha inválidos.");
					}
					System.out.println("AdminServlet redireionou para Admin.jsp");
					forward(req, resp, "./admin.jsp");
					//resp.sendRedirect("./admin.jsp");
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
	
	private void criarDB() throws SQLException {
		try {
			String sql = ""
					+ "create table usuario ("
					+ "  id numeric(18,0) not null,"
					+ "  login varchar(20) not null,"
					+ "  senha varchar(20) not null,"
					+ "  constraint pk_conta primary key (id) "
					+ ")";
			String url = "jdbc:derby:db;create=true";
			Connection conexao;
			conexao = DriverManager.getConnection(url);
			Statement stmt = conexao.createStatement();
			stmt.execute(sql);
			stmt.close();
		} catch(Exception e) {
			System.err.println("criarDB: "+e.getMessage());
		}
	}

}
