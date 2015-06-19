package servlet;

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
import admin.Usuario;

@WebServlet(value = "/AdminServlet")
public class AdminServlet extends HttpServlet  {
private Connection conexao;
	
	@Override
	public void init() throws ServletException {
		try {
			criarDB();
			insereUserAdmin();
			carregaUserAdmin();
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
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
			        session.setAttribute("login",login);
			        String url = req.getContextPath()+"/ko-admin/admin-panel.jsp";
					System.out.println("Redirecionou "+url);
					resp.sendRedirect(url);
					//req.getRequestDispatcher(url).forward(req, resp);
				}else{
					System.out.println("AdminServlet redirecionou admin.jsp");
					resp.sendRedirect("./admin.jsp");
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

	/*private void transferir(int valor, int contaOrigem, int contaDestino) throws SQLException {
		String url = "jdbc:derby:db;create=true";
		conexao = DriverManager.getConnection(url);
		//Abrir transa��o.
		conexao.setAutoCommit(false);
		try {
			Statement stmt = conexao.createStatement();
			stmt.executeUpdate("update conta "
					+ "set saldo = (saldo - " + valor + ") "
					+ "where numero = " + contaOrigem);

			if (valor > 10) {
				throw new RuntimeException("Valor n�o permitido.");
			}
			
			stmt.executeUpdate("update conta "
					+ "set saldo = (saldo + " + valor + ") "
					+ "where numero = " + contaDestino);
			//Fechando transa��o efetivando comandos.
			conexao.commit();
		} catch(Exception e) {
			System.err.println(e.getMessage());
			//Fechando transa��o descartando comandos.
			conexao.rollback();
		}
	}*/

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
			conexao = DriverManager.getConnection(url);
			Statement stmt = conexao.createStatement();
			stmt.execute(sql);
			stmt.close();
		} catch(Exception e) {
			System.err.println("criarDB: "+e.getMessage());
		}
	}
	
	private void insereUserAdmin() throws SQLException {
		try {
			Usuario usuario = new Usuario();
			usuario.setLogin("admin");
			usuario.setSenha("koiwin");
	
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("koDataBase");
			EntityManager manager = factory.createEntityManager();
	
			JpaUtil.getEntityManager().getTransaction().begin();    
			JpaUtil.getEntityManager().persist(usuario);
			JpaUtil.getEntityManager().getTransaction().commit();  
	
			System.out.println("Usuario: " + usuario.getLogin());
	
			manager.close();
		} catch(Exception e) {
			System.err.println("insereUserAdmin: "+e.getMessage());
		}
	}
	
	private void carregaUserAdmin() throws SQLException {
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("koDataBase");
			EntityManager manager = factory.createEntityManager();
			Usuario usuario = manager.find(Usuario.class, "admin");
			System.out.println(usuario.getLogin());    
			manager.close();
		} catch(Exception e){
			System.err.println("insereUserAdmin: "+e.getMessage());
		}
	}
}
