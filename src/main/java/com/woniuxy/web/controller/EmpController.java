package com.woniuxy.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.woniuxy.domain.Dept;
import com.woniuxy.domain.Emp;
import com.woniuxy.service.DeptService;
import com.woniuxy.service.EmpService;

@Controller
@RequestMapping("emps")
public class EmpController {

	@Autowired
	private DeptService deptService;
	
	@Autowired
	private EmpService empService;
	
	
	@RequestMapping("saveUI")
	public String saveUI(Model model) {
		List<Dept> deptList = deptService.findAll();
		model.addAttribute("deptList", deptList);
		return "emps/saveUI";  // /emps/saveUI.jsp
	}
	
	@RequestMapping("save")
	public String save(Emp e) {
		empService.save(e);
		return "redirect:/emps/find";  
	}
	
	
	@RequestMapping("find")
	public String find(Model model) {
		List<Emp> empList = empService.findAll();
		model.addAttribute("empList", empList);
		return "emps/findUI";  
	}
	
	@RequestMapping("delete/{eid}")
	public String delete(@PathVariable Integer eid) {
		empService.delete(eid);
		return "redirect:/emps/find";  
	}
	
	@RequestMapping("updateUI/{eid}")
	public String updateUI(@PathVariable Integer eid, Model model) {
		Emp emp = empService.findOne(eid);
		model.addAttribute("emp", emp);
		
		List<Dept> deptList = deptService.findAll();
		model.addAttribute("deptList", deptList);
		
		
		return "emps/updateUI";  
	}
	
	
	@RequestMapping("update")
	public String update(Emp e) {
		empService.update(e);
		return "redirect:/emps/find";  
	}
}
