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

    public UserServlet() {
        super();
    }
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String comando = req.getParameter("comando") == null ? "" : (String) req.getParameter("comando");

		try{
			if (!comando.isEmpty()) {
				if(comando.equals("addUser")){
					forward(req, resp, "/addUser.jsp");
				}else if(comando.equals("salvar")){
					salvar(req);
				} else if(comando.equals("deletar")){
					deletar(req);
				}
			}
			if(!comando.equals("addUser")){
				listar(req);
				forward(req, resp, "/index2.jsp");
			}
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

	protected void salvar(HttpServletRequest request) throws Exception {
		Usuario user = new Usuario();
		user.setLogin(request.getParameter("login"));
		user.setSenha(request.getParameter("senha"));
		userDAO.create(user);
		System.out.println("Salvar Teste1");
	}

	protected void deletar(HttpServletRequest request) throws Exception {
		String id = request.getParameter("id");
		userDAO.deleteById(Long.valueOf(id));
		System.out.println("Deletar Teste1");
	}

}
