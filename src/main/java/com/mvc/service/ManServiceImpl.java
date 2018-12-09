package com.mvc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mvc.dao.ManDao;
import com.mvc.entities.Man;

@Component
public class ManServiceImpl implements ManService {
	
	@Autowired
	private ManDao mdao;


	public List<Man> getAllMan() {
		List<Man> manList = mdao.getAllMan();
		return manList;
	}
}
