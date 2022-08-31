package test3;

import java.io.File;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@MultipartConfig(
		maxFileSize = 1024*1024*2, 
		fileSizeThreshold = 1024*1024*2,
		maxRequestSize = 1024*1024*50,
		location="c:\\upload"
		)
@Controller
public class upload {
	
	@RequestMapping("fileupload.do")
	public String filesok(Model m, MultipartHttpServletRequest req){
		try {
			Part part = req.getPart("file1");
			String filenm = part.getSubmittedFileName();
			System.out.println(filenm);
		} catch (Exception e) {
		}
		return "view/okfile";
	}
	
}
