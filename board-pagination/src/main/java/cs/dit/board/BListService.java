package cs.dit.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BListService implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException {
		
		BoardDao dao = new BoardDao();
		int numOfRecods = 10;
		int count = dao.recordCount();
		
		// 전달되는 page 번호를 얻은 후 확인
		String page_ = request.getParameter("p");
		int p = 1;	// 페이지 초기 값

		// p = Integer.parseInt(request.getParameter("p"));
		if(page_ != null && !page_.equals("")) {
			p = Integer.parseInt(page_);
		}
		
		ArrayList<BoardDto> dtos = dao.list(p, numOfRecods);
		
		int startNum = p-((p-1)%5);
		int lastNum = (int)(Math.ceil((float)count / (float)numOfRecods));
		
		System.out.println(count);
		System.out.println(lastNum);
		System.out.println(startNum);
		
		request.setAttribute("dtos", dtos);
		request.setAttribute("p", p);
		request.setAttribute("startNum", startNum);
		request.setAttribute("lastNum", lastNum);
	}
}
