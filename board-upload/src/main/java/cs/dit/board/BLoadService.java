package cs.dit.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BLoadService implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int bcode = Integer.parseInt(request.getParameter("bcode"));
		
		BoardDto dto = new BoardDto();
		BoardDao dao = new BoardDao();
		
		dto = dao.selectOne(bcode);
		request.setAttribute("dtos", dto);
	}

}
