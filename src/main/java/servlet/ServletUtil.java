package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletUtil {

	public static void forward(HttpServletRequest req, HttpServletResponse resp, String path) throws ServletException, IOException {
		req.getRequestDispatcher(path).forward(req, resp);
	}

}
