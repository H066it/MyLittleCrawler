package com.h066it.myLittleCrawler.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.h066it.myLittleCrawler.dto.BoardDto;
import com.h066it.myLittleCrawler.repository.CRUDRepository;
import com.h066it.myLittleCrawler.serviceImpl.CRUDServiceImpl;

@Controller
public class CRUDController {

	@Autowired
	private CRUDRepository repository;
	
	@Autowired
	private CRUDServiceImpl service;
	
	/* ----------- CRUD 관련. ----------- */
	
	@RequestMapping("/list")
	public String list(BoardDto dto, Model model, Authentication auth,
			@PageableDefault(sort = {"FId"}, direction = Direction.DESC, size = 10) Pageable page) {

		System.out.println("list");
		if(auth != null)
		model.addAttribute("auth", auth.getName());
		
		Page<BoardDto> pageList = repository.findAll(page);
		model.addAttribute("pageList", pageList);
		
		/*List<BoardDto> list = service.findAllOrderByFIdDesc();
		model.addAttribute("list", list);
		
		@PageableDefault 안 쓸 경우는 위에껄로 해서 paging 설정 만들어야 함.*/
		
		return "/crud/list";
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String writeForm(Authentication auth, Model model) {
		
		System.out.println("writeForm");
		if(auth != null)
		model.addAttribute("auth", auth.getName());
		
		return "/crud/form";
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(BoardDto dto) {
		
		System.out.println("write");
		repository.save(dto);
		
		return "redirect:/list";
	}
	
	@RequestMapping("/{fId}")
	public String view(@PathVariable int fId, Model model, Authentication auth) {
		
		System.out.println("view");
		if(auth != null)
		model.addAttribute("auth", auth.getName());
		
		service.viewCount(fId);
		
		BoardDto dto = repository.findOne(fId);
		model.addAttribute("dto", dto);
		
		return "/crud/view";
	}
	
	@RequestMapping(value = "/{fId}/update", method = RequestMethod.GET)
	public String updateForm(@PathVariable int fId, Model model, Authentication auth) {
		
		System.out.println("updateForm");
		if(auth != null)
		model.addAttribute("auth", auth.getName());
		
		BoardDto dto = repository.findOne(fId);
		model.addAttribute("dto", dto);
		
		return "/crud/form";
	}
	
	@RequestMapping(value = "/{fId}/update", method = RequestMethod.POST)
	public String update(@PathVariable int fId, BoardDto dto) {
		
		System.out.println("update");
		
		dto.setFDate(new Date());	// 작성일은 최근 수정일로 교체됨.
		repository.save(dto);
		
		return "redirect:/list";
	}
	
	@RequestMapping("/delete")
	public String delete(BoardDto dto, Model model) {
		
		System.out.println("delete");
		
		boolean pwChkRst = service.delete(dto.getFId(), dto.getFPassword());
		
		System.out.println("pwChkRst : " + pwChkRst);
		
		if(pwChkRst == false) {
			model.addAttribute("rst", "비밀번호가 틀립니다.");
			model.addAttribute("returnUrl", "/" + dto.getFId());
		} else {
			model.addAttribute("rst", "글이 삭제되었습니다.");
			model.addAttribute("returnUrl", "/list");
		}
		
		return "/crud/alertAndRedirect";
	}
	
	@RequestMapping("/udtPwdChk")
	public String udtPwdChk(BoardDto dto, Model model) {
		
		System.out.println("udtPwdChk");
		
		boolean pwChkRst = service.udtPwdChk(dto.getFId(), dto.getFPassword());
		
		if(pwChkRst == false) {
			model.addAttribute("rst", "비밀번호가 틀립니다.");
			model.addAttribute("returnUrl", "/" + dto.getFId());

			return "/crud/alertAndRedirect";
		}
		
		return "redirect:/" + dto.getFId() + "/update";
	}
	
	/* ----------- search 관련. ----------- */
	
	@RequestMapping("/search")
	public String search(HttpServletRequest request, BoardDto dto, Model model, Authentication auth,
			@PageableDefault(sort = {"FId"}, direction = Direction.DESC, size = 10) Pageable page) {
		
		System.out.println("search");
		if(auth != null)
		model.addAttribute("auth", auth.getName());

		String searchType = request.getParameter("searchType");
		String keyword = request.getParameter("keyword");
		
		Page<BoardDto> pageList = service.findAllWithKeyword(page, searchType, keyword);
		model.addAttribute("pageList", pageList);
		if(keyword.equals("")) {
			return "redirect:/list";
		}
		model.addAttribute("searchType", searchType);
		model.addAttribute("keyword", keyword);
		
		return "/crud/list";
	}
	
}
