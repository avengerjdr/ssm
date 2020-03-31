package com.woniuxy.service;

import java.util.List;

import com.woniuxy.domain.Emp;

public interface EmpService {
	void save(Emp e);
	void delete(Integer eid);
	void update(Emp e);
	Emp findOne(Integer eid);
	List<Emp> findAll();
}
