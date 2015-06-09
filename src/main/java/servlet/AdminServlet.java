package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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

@WebServlet(value = "/AdminServlet")
public class AdminServlet extends HttpServlet  {
private Connection conexao;
	
	/*@Override
	public void init() throws ServletException {
		try {
			criar();
			insereUserAdmin();
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}*/
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			System.out.println("Entrou no Servlet");
			String comando = req.getParameter("comando");

			if (comando == null) {
				System.out.println("AdminServlet redirecionou admin.jsp");
				resp.sendRedirect("./admin.jsp");
			} else if (comando.equals("Entrar")) {
				HttpSession session = req.getSession();
				session.setAttribute("logado", false);
				String login = req.getParameter("login");
				String senha = req.getParameter("senha");
				if(!login.isEmpty() && !senha.isEmpty()){
					boolean name =  true;
			        session.setAttribute("logado",name); 
					System.out.println("Redirecionou admin-panel.jsp");
					resp.sendRedirect("./ko-admin/admin-panel.jsp");
					//req.getRequestDispatcher("./ko-admin/admin-panel.jsp").include(req, resp);
				}else{
					System.out.println("AdminServlet redirecionou admin.jsp");
					resp.sendRedirect("./admin.jsp");
				}
			}else if (comando.equals("erro404")){
				req.getRequestDispatcher("./ko-admin/admin-pan123el.jsp").include(req, resp);
			}
		} catch (Throwable e) {
			//Retorna o 404
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			e.printStackTrace();
		}
	}

	/*private void transferir(int valor, int contaOrigem, int contaDestino) throws SQLException {
		String url = "jdbc:derby:db;create=true";
		conexao = DriverManager.getConnection(url);
		//Abrir transação.
		conexao.setAutoCommit(false);
		try {
			Statement stmt = conexao.createStatement();
			stmt.executeUpdate("update conta "
					+ "set saldo = (saldo - " + valor + ") "
					+ "where numero = " + contaOrigem);

			if (valor > 10) {
				throw new RuntimeException("Valor não permitido.");
			}
			
			stmt.executeUpdate("update conta "
					+ "set saldo = (saldo + " + valor + ") "
					+ "where numero = " + contaDestino);
			//Fechando transação efetivando comandos.
			conexao.commit();
		} catch(Exception e) {
			System.err.println(e.getMessage());
			//Fechando transação descartando comandos.
			conexao.rollback();
		}
	}*/

	private void criar() throws SQLException {
		String sql = ""
				+ "create table usuario ("
				+ "  login varchar(20) not null,"
				+ "  senha varchar(20) not null,"
				+ "  constraint pk_conta primary key (login) "
				+ ")";
		String url = "jdbc:derby:db;create=true";
		conexao = DriverManager.getConnection(url);
		Statement stmt = conexao.createStatement();
		stmt.execute(sql);
		stmt.close();
	}
	
	private void insereUserAdmin() throws SQLException {
		String sql = ""
				+ "insert into usuario "
				+ "  (login, senha) "
				+ "  values "
				+ "  ('admin', 'koiwin') ";
		String url = "jdbc:derby:db;create=true";
		conexao = DriverManager.getConnection(url);
		Statement stmt = conexao.createStatement();
		stmt.execute(sql);
		stmt.close();
	}
}
