package cs.dit;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MListService implements MemberService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException {
		
		MemberDao dao = new MemberDao();
		int numOfRecods = 10;
		int count = dao.recordCount();
		
		String page_ = request.getParameter("p");
		int p = 1;
		
		if(page_ != null && !page_.equals(""))
			p = Integer.parseInt(page_);
		
		int startNum = p-((p-1)%5);
		int lastNum = (int)(Math.ceil((float)count / (float)numOfRecods));
		
		ArrayList<MemberDto> dtos = dao.list(p, numOfRecods);
		
		request.setAttribute("dtos", dtos);
		request.setAttribute("p", p);
		request.setAttribute("startNum", startNum);
		request.setAttribute("lastNum", lastNum);

	}

}
