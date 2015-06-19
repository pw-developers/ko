package servlet;

import static servlet.ServletUtil.forward;

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

import dao.UsuarioDAO;
import admin.Usuario;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet(value = "/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDAO userDAO = UsuarioDAO.getInstance();
	
	private Connection conexao;
	
	@Override
	public void init() throws ServletException {
		try {
			criarDB();
		} catch(Exception e) {
			//System.err.println(e.getMessage());
		}
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
    }
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String comando = req.getParameter("comando");
		System.out.println("UserServlet Teste1"+comando);
		try{
			if (comando != null) {
				if(comando.equals("salvar")){
					salvar(req);
				} else if(comando.equals("deletar")){
					deletar(req);
				}
			}
			listar(req);
			forward(req, resp, "/index.jsp");
		} catch (Throwable e) {
			//Retorna o 404
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			e.printStackTrace();
		}

	}

	private void listar(HttpServletRequest req) {
		List<Usuario> listaUsuario = UsuarioDAO.getInstance().findAll();
		System.out.println("Tamanho "+listaUsuario.size());
		req.setAttribute("listaUsuarios", listaUsuario);
	}

	protected void salvar(HttpServletRequest request) {
		Usuario user = new Usuario();
		user.setLogin(request.getParameter("login"));
		user.setSenha(request.getParameter("senha"));
		userDAO.create(user);
		System.out.println("Salvar Teste1");
	}

	protected void deletar(HttpServletRequest request) {
		String id = request.getParameter("id");
		userDAO.deleteById(Long.valueOf(id));
		System.out.println("Deletar Teste1");
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
			conexao = DriverManager.getConnection(url);
			Statement stmt = conexao.createStatement();
			stmt.execute(sql);
			stmt.close();
		} catch(Exception e) {
			System.err.println("criarDB: "+e.getMessage());
		}
	}

}
