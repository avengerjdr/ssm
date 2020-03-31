package com.woniuxy.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.DeptMapper;
import com.woniuxy.domain.Dept;
import com.woniuxy.domain.Page;
import com.woniuxy.service.DeptService;

@Service
@Transactional
public class DeptServiceImpl implements DeptService {

	@Autowired
	private DeptMapper mapper;
	
	@Override
	public void save(Dept d) {
		mapper.insertSelective(d);
	}

	@Override
	public void delete(Integer did) {
		mapper.deleteByPrimaryKey(did);
	}

	@Override
	public void update(Dept d) {
		mapper.updateByPrimaryKeySelective(d);
	}

	@Override
	public Dept findOne(Integer did) {
		return mapper.selectByPrimaryKey(did);
	}

	@Override
	public List<Dept> findAll() {
		return mapper.selectByExample(null);
	}

	@Override
	public Page findPageData(int p, int size) {
		
		int rowCount = (int) mapper.countByExample(null);
		
		// page=3, rowCount=73,size=5
		Page page = new Page(p,rowCount,size);
		// 流程走到这里，page.getStartLine()就是10， page.getSize()就是5
		
		Map<String, Integer> map = new HashMap<>();
		map.put("startLine", page.getStartLine());
		map.put("size", page.getSize());
		
		List<Dept> list = mapper.selectByPage(map);
		page.setList(list);
		
		return page;
	}

}
