package servlet;

import static servlet.ServletUtil.forward;

import java.io.IOException;

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
	UsuarioDAO userDAO = new UsuarioDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String comando = req.getParameter("comando");

		try{
			if (comando == null) {
				forward(req, resp, "/index.jsp");
			}else if(comando.equals("salvar")){
				doPost(req, resp);
			}else if(comando.equals("deletar")){
				doGet(req, resp);
			}
		} catch (Throwable e) {
			//Retorna o 404
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Usuario user = new Usuario();
		user.setLogin(request.getParameter("login"));
		user.setSenha(request.getParameter("senha"));
		this.userDAO.create(user);
		forward(request, response, "/index.jsp");
	}

}
