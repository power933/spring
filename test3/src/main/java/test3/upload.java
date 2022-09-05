package test3;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class upload {
	
	//파일업로드 : 바이너리파일 exception
	@RequestMapping("/fileupload.do")
	public String filesok(Model m, MultipartFile file1[],HttpServletRequest req) throws Exception{
		String directory = "c:\\upload\\"; //로컬 경로
		for(int i =0; i<file1.length;i++) {
		String filename = file1[i].getOriginalFilename(); //파일명 받아옴
		
		//저장할 경로 부분
		String url = "";
		if(filename.equals("")) {
			url = "첨부파일은 없습니다";
		}
		else {
			File fe = new File(directory);
			if(!fe.exists()) {
				fe.mkdir();
			}
			url = directory+filename;
			//FileCopyUtils.copy
			FileCopyUtils.copy(file1[i].getBytes(), new File(url));
			m.addAttribute("result_file"+i,url);
		}
		}
		return "view/okfile";
	}
	
	@RequestMapping("/fileupload2.do")
	public String server_upload(Model m, MultipartFile file2, HttpServletRequest req) throws Exception{
		
		if(!file2.equals("")) {
			String filetype = file2.getContentType();	
			//업로드 할 파일 type을 확인 하는 사항
			System.out.println(filetype);
			if(!(filetype.equals("image/jpeg") || !filetype.equals("image/png"))) {
				System.out.println("이미지만 가능");
			}
			else {
			//req.getServletContext().getRealPath("") : 서버 상대경로
			String directory = req.getServletContext().getRealPath("");
			String upload_directory = directory+ "upload/";
			File fe = new File(upload_directory);
			if(!fe.exists()) {
				fe.mkdir();
			}
			String filename = file2.getName();
			String copyfile = upload_directory + filename;
			FileCopyUtils.copy(file2.getBytes(), new File(copyfile));
			m.addAttribute("result_file",copyfile);
		}
		}
		else {
			m.addAttribute("result_file","첨부파일이 없습니다");
		}
		
		return "view/okfile";
	}
	
}








