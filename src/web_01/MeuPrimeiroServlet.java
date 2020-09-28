package web_01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author Admin
 *
 */

@WebServlet("/aula01")
public class MeuPrimeiroServlet extends HttpServlet{
	public static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
		PrintWriter resposta = res.getWriter();
		resposta.println("<html>");
		resposta.println("<body>");
		
		String name = req.getParameter("name");
		resposta.println("Nome: "+name);
		resposta.println("</body>");
		resposta.println("</html>");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		request.setAttribute("login", login);
		
		if(senha.equals("123")) {
			//RequestDispatcher rd = request.getRequestDispatcher("bemvindo.html");
			//rd.forward(request, response);
			PrintWriter resposta = response.getWriter();
			resposta.println("<center><p>Seja bem-vindo, Sr. "+login+"</p></center>");
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.forward(request, response);
		}
		
		
	}
}