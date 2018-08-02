package com.bitcamp.mvc.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class DownloadView extends AbstractView{

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		File file = (File)model.get("downloadFile"); //컨트롤러에서 보낸 파일을 받음
		
		response.setContentType("application/download; charset=utf-8");
		response.setContentLength((int)file.length()); //메서드 int형 반환이라 명시적 형변환
		
		// MSIE 여부 확인 후 파일이름(한글일 경우) 인코딩 처리
		//현재 브라우저 정보를 받을 수 있는것이 헤더정보.
		//헤더정보는 request에 있음.
		
		//헤더정보
		String userAgent = request.getHeader("User-Agent"); //브라우저 정보를 담음
		String fileName = "";
		
		if(userAgent.indexOf("MSIE")> -1) {//뭘로시작하는지 
			//URL인코더 : 스태틱메서드 이용, 어떤타입으로 인코딩할것인지 정의해줌
			//한글처리가 되게함. 
			fileName = URLEncoder.encode(file.getName(), "utf-8"); 
		}else { 
			//다른 브라우져일 경우
			//캐릭터셋 변경
			fileName = new String(file.getName().getBytes("utf-8"), "iso-8859-1");		
		}
		//반환하고있는 타입의 파일이름, 반환
		response.setHeader("Content-Disposition", "attachment; filename=\""+fileName+"\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		//서버쪽 파일과 연결
		OutputStream out = response.getOutputStream();
		
		//바이너리 코드로 파일 이동시키기 위해서 ~해야됨
		FileInputStream fis = null;
		
		//파일객체
		//서버에 있는 파일하나를 지정해서 그 파일을 사용자 브라우져쪽으로 데이터를 보내야함
		fis = new FileInputStream(file); //그러기 위해서 inputStream생성
		FileCopyUtils.copy(fis,out); ////output을 이용해서 전송
		
		//스트림 생성할때 열었으므로 닫음
		fis.close();
		out.flush();
		out.close();
		
		
	}
	
	
}
