package cs.dit;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MViewService implements MemberService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		
		MemberDao dao = new MemberDao();
		MemberDto dto = new MemberDto();
		
		dto = dao.selectOne(id);
		
		request.setAttribute("dto", dto);

	}

}
