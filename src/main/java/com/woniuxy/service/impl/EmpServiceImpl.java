package com.woniuxy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.EmpMapper;
import com.woniuxy.domain.Emp;
import com.woniuxy.service.EmpService;

@Service
@Transactional
public class EmpServiceImpl implements EmpService {
	
	@Autowired
	private EmpMapper mapper;

	@Override
	public void save(Emp e) {
		mapper.insertSelective(e);
	}

	@Override
	public void delete(Integer eid) {
		mapper.deleteByPrimaryKey(eid);
	}

	@Override
	public void update(Emp e) {
		mapper.updateByPrimaryKeySelective(e);
	}

	@Override
	public Emp findOne(Integer eid) {
		return mapper.selectByPrimaryKey(eid);
	}

	@Override
	public List<Emp> findAll() {
		return mapper.selectAllWithDept();
	}

}
