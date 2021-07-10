package kr.or.ddit.basic.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/jsonServelt.do")
public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String choice = request.getParameter("choice");

		Gson gson = new Gson();
		String jsonData = "";

		switch (choice) {
		case "str":
			String str = "안녕하세요";
			jsonData = gson.toJson(str);
			break;
		case "array" :
			int[] arr = {100, 200, 300, 400};
			jsonData = gson.toJson(arr);
			break;
		case "obj" :
			SampleVO samVO = new SampleVO(1, "홍길동");
			jsonData = gson.toJson(samVO);
			break;
		case "list"	:
			List<SampleVO> samList = new ArrayList<>();
			samList.add(new SampleVO(11, "일지매"));
			samList.add(new SampleVO(12, "강감찬"));
			samList.add(new SampleVO(13, "변학도"));
			jsonData = gson.toJson(samList);
			break;
		case "map" :
			Map<String, String> map = new HashMap<>();
			map.put("name", "이순신");
			map.put("tel", "010-1234-5789");
			map.put("addr", "대전시 중구 대흥동");
			jsonData = gson.toJson(map);
			break;
		}
		// 변환된 jsonData 출력해보기
		System.out.println(choice + " ==> " + jsonData);
		
		// 변환된 jsonData를 응답 데이터로 보내준다.
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.write(jsonData);
		//응답 데이터를 모두 출력한다.
		response.flushBuffer();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
