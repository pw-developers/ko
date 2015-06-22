package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = "*.ko")
public class AdminFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Entrou no AdminFilter");
		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();
		HttpServletResponse resp = (HttpServletResponse) response;

			Boolean logado = (Boolean) req.getSession().getAttribute("logado");
			String login = null;
			String senha = null;
			//Pego login e senha, verifico se o usuario ja realizou login anteriormente para nao acessar admin.jsp
			if(req.getSession().getAttribute("login") != null && req.getSession().getAttribute("senha") != null){
				login = (String) req.getSession().getAttribute("login");
				senha = (String) req.getSession().getAttribute("senha");
			}else if(req.getParameter("login") != null && req.getParameter("senha") != null){
				login = (String) req.getParameter("login");
				senha = (String) req.getParameter("senha");
			}
			System.out.println("Login e senha: "+login+" "+senha);

			if((login != null && !login.isEmpty())
			&& (senha != null && !senha.isEmpty())){
				System.out.println("AdminFilter continuou para servlet ");
				chain.doFilter(req, resp);
			} else {
				System.out.println("AdminFilter redirecionou para admin.jsp");
				resp.sendRedirect("/ko/admin.jsp");
			}
		}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}

}
