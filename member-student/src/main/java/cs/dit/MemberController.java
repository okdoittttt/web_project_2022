package cs.dit;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String com = uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf(".do"));
		String viewPage = null;
		
		MemberService service = null;
		
		switch (com.trim()) {
		case "index":
			viewPage = "WEB-INF/view/index.jsp";
			break;
		case "insertForm":
			viewPage = "WEB-INF/view/insertForm.jsp";
			break;
		case "insert":
			service = new MInsertService();
			service.execute(request, response);
			viewPage = "WEB-INF/view/list.do";
			break;
		case "list":
			service = new MListService();
			service.execute(request, response);
			viewPage = "WEB-INF/view/list.do";
			break;
		case "updateForm":
			service = new MViewService();
			service.execute(request, response);
			viewPage = "WEB-INF/view/updateForm.jsp";
			break;
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
}
