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
		if (uri.endsWith("login-admin.ko")) {
			chain.doFilter(req, resp);
		} else {
			Boolean logado = (Boolean) req.getSession().getAttribute("logado");
			if (logado != null && logado) {
				System.out.println("AdminFilter continuou para servlet");
				chain.doFilter(req, resp);
			} else {
				System.out.println("AdminFilter redirecionou para admin.jsp");
				resp.sendRedirect("login-admin.ko");
			}
		}
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}

}
