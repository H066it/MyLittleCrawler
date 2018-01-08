package com.h066it.myLittleCrawler.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.h066it.myLittleCrawler.dto.MemberDto;
import com.h066it.myLittleCrawler.repository.HomeRepository;
import com.h066it.myLittleCrawler.serviceImpl.HomeServiceImpl;

@Controller
public class HomeController {

	@Autowired
	private HomeRepository repository;
	
	@Autowired
	private HomeServiceImpl service; 
	
	@RequestMapping("/")
	public String index(MemberDto dto, Authentication auth, Model model) {
		
		System.out.println("index");
		if(auth != null)
		model.addAttribute("auth", auth.getName());
		
		return "index";
	}
	
	@RequestMapping(value = "/crawl", method = RequestMethod.POST)
	public void crawl(HttpServletRequest request) throws UnsupportedEncodingException, IOException {

		System.out.println("crawl");
		
		String strUrl = request.getParameter("url");
		
		try {
			URL url = new URL(strUrl);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));;

            String path = "C:\\test.html";
            File file = new File(path);
            
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
            		new FileOutputStream(file.getPath()), "UTF-8"));

            String line;
            
            while((line=br.readLine())!=null){
            	bw.write(line);
            }

            bw.close();
            br.close();            
            System.out.println("crawl success!");
            
		} catch (MalformedURLException e) {
			System.out.println("crawl fail!");
			System.out.println("Warning! url Error!");
		}
	}
	
}
