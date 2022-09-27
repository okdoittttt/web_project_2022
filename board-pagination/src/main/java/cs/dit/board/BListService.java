package cs.dit.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BListService implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException {
		int page = 1;
		int numOfRecods = 10;
		
		BoardDao dao = new BoardDao();
		
		ArrayList<BoardDto> dtos = dao.list(page, numOfRecods);
		
		int count = dao.recordCount();
		System.out.println(count);
		
		request.setAttribute("dtos", dtos);
	}
}
