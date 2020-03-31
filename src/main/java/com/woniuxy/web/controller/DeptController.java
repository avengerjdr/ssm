package com.woniuxy.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.woniuxy.domain.Dept;
import com.woniuxy.domain.Page;
import com.woniuxy.service.DeptService;

@Controller
@RequestMapping("depts")
public class DeptController {

	@Autowired
	private DeptService service;
	
	@PostMapping
	public String save(Dept d) {
		service.save(d);
		return "redirect:/depts/find";
	}
	
	@RequestMapping("find") 
	public String find(Model model, Integer p) {
		Page page = service.findPageData(p, 5);
		model.addAttribute("page", page);
		return "depts/findUI";
	}
	
	@RequestMapping("delete/{did}")
	public String delete(@PathVariable Integer did) {
		service.delete(did);
		return "redirect:/depts/find";
	}
	
	@RequestMapping("updateUI/{did}")
	public String updateUI(@PathVariable Integer did, Model model) {
		Dept dept = service.findOne(did);
		model.addAttribute("dept", dept);
		return "depts/updateUI";
	}
	
	@RequestMapping("update")
	public String update(Dept d) {
		service.update(d);
		return "redirect:/depts/find";
	}
}
