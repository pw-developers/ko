package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import contato.EnviarMensagem;

@WebServlet(value = "/ko")
public class KoServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String caminho = req.getParameter("caminho");
		String enviaMSG = req.getParameter("enviaMsg");

		// Redireciona a pagina
		if (caminho != null) {
			if (caminho.equals("index")) {
				resp.sendRedirect("index.jsp");
			} else if (caminho.equals("contato")) {
				resp.sendRedirect("contato.jsp");
			} else if (caminho.equals("noticias")) {
				resp.sendRedirect("noticias.jsp");
			} else if (caminho.equals("sobrenos")) {
				resp.sendRedirect("sobrenos.jsp");
			}
		}

		/**
		 * Valida envio de mensagem Página Cotato.jsp
		 **/
		if (enviaMSG != null) {
			String c_name = (String) req.getParameter("c_name");
			String c_email = (String) req.getParameter("c_email");
			String c_message = (String) req.getParameter("c_message");
			if (enviaMSG.equals("enviando")) {
				String msgErro = EnviarMensagem.validaMsg(c_name, c_email,c_message);
				if (msgErro.equals("")) {
					req.setAttribute("enviandoMsg", "true");
				} else {
					req.setAttribute("enviandoMsg", "false");
					req.setAttribute("enviandoMsgErro", msgErro);
					System.out.println(msgErro);
				}
				req.getRequestDispatcher("/contato.jsp").include(req, resp);
			}
		}
	}
}