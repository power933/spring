package com.company.item.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.company.item.domain.MemberDTO;
import com.company.item.domain.ReportDTO;

import lombok.extern.log4j.Log4j;



@Controller
@Log4j
public class test {
	
	
	@RequestMapping(value="blog/{num}",method=RequestMethod.GET)
	public String blog(Model model,@PathVariable int num) {
		
		model.addAttribute("num",num);
		
		return "hello";
	}
	
	@RequestMapping(value="parameter",method=RequestMethod.GET)
	public String parameter(Model model) {
		
		model.addAttribute("");
		
		return "parameter";
	}
	
	@RequestMapping(value="getform",method=RequestMethod.GET)
	public String getform(Model model, String name, String password) {
		
		model.addAttribute("name",name);
		model.addAttribute("password",password);
		
		return "hello";
	}
	
	@RequestMapping(value="postform",method=RequestMethod.POST)
	public String postform(Model model, MemberDTO dto) {
		
		System.out.println(dto.toString());
		
		return "hello";
	}
	
	@RequestMapping(value="getlink",method=RequestMethod.GET)
	public String getlink(HttpServletRequest request, Model model, String name, String job) {
		
//		String name = request.getParameter("name");
//		String job = request.getParameter("job");
		
//		System.out.println(dto.getName());
		
		model.addAttribute("name",name);
		model.addAttribute("password",job);
		
		return "hello";
	}
	
	@RequestMapping(value="fileupload", method = RequestMethod.POST)
	public void fileupload(ReportDTO dto,HttpServletRequest req) {
		if(dto.getPictureurl().isEmpty()) {
			System.out.println("업로드 파일이 없습니다");
		}else {
			String filepath = req.getServletContext().getRealPath("/upload");
			filepath =UUID.randomUUID()+ filepath+"/"+dto.getPictureurl().getOriginalFilename();
			
			File file = new File(filepath);
			try {
				dto.getPictureurl().transferTo(file);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
}
