package com.bitcamp.mvc.Controller;

import java.io.File;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DownloadController implements ApplicationContextAware{

	private WebApplicationContext context;
	
	@RequestMapping("/file")
	public ModelAndView download() {
		//파일 전달하기
		//뷰를 등록해야됨. 컨트롤러에서는 download로 했기 때문에~ 이것으로 DownloadView를 찾을 수 있게 해야댐
		
		return new ModelAndView("download", "downloadFile", getFile());
			//ModelAndView(전달할 뷰이름, 객체이름(전달할 데이터 변수), 객체(전달할 데이터)
	}
	
	//파일객체를 얻어오는 메서드
	private File getFile() {
		//파일 경로를 받아오는 변수 , 파일업로드때 배운것과 동일
		String path = context.getServletContext().getRealPath("/WEB-INF/설명.txt");
		System.out.println(path);
		//파일객체 만들어서 반환
		return new File(path);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		this.context = (WebApplicationContext) applicationContext;	
	}

	
}
