package cs.dit;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MListService implements MemberService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException {
		int page = 1;
		int numOfRecords = 10;
		
		MemberDao dao = new MemberDao();
		
		ArrayList<MemberDto> dtos = dao.list(page, numOfRecords);
		
		int count = dao.recordCount();
		System.out.println(count);
		
		request.setAttribute("dtos", dtos);

	}

}
