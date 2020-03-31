package com.woniuxy.service;

import java.util.List;

import com.woniuxy.domain.Dept;
import com.woniuxy.domain.Page;

public interface DeptService {
	void save(Dept d);
	void delete(Integer did);
	void update(Dept d);
	Dept findOne(Integer did);
	List<Dept> findAll();
	
	Page findPageData(int p, int size);
}
