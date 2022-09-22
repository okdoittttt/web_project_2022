package cs.dit.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String com = uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf(".do"));
		String viewPage = null;
		
		BoardService service = null;
		
		switch (com.trim()){
		case "list":
			service = new BListService();
			service.execute(request, response);
			viewPage = "/WEB-INF/view/list.jsp";
			break;
		case "insertForm":
			service = new BListService();
			service.execute(request, response);
			viewPage = "/WEB-INF/view/insertForm.jsp";
			break;
		case "insert":
			service = new BInsertService();
			service.execute(request, response);
			viewPage = "/WEB-INF/view/list.do";
			break;
		case "update":
			viewPage = "WEB-INF/view/insertForm.jsp";
			break;
		case "updateForm":
//			service = new BLoadService();
//			service.execute(request, response);
			viewPage = "WEB-INF/view/updateForm.jsp";
			break;
		case "delete":
			service = new BDeleteService();
			service.execute(request, response);
			viewPage = "WEB-INF/view/list.do";
			break;
		case "updateService":
			service = new BUpdateService();
			service.execute(request, response);
			viewPage = "WEB-INF/view/list.do";
			break;
		case "index":
			viewPage = "WEB-INF/view/index.jsp";
		
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
