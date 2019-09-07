package com.demo.restful.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.restful.domain.Board;
import com.demo.restful.mapper.BoardMapper;

@Service //service bean으로 등록
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper mapper;
	
	@Override
	public List<Board> list() {
		return mapper.list(); 
	}

	@Override
	public void insert(Board dto) {
		mapper.insert(dto); 
	}

	@Override
	public Board view(int idx) {
		return mapper.view(idx); 
	}

	@Override
	public void update(Board dto) {
		mapper.update(dto); 
	}

	@Override
	public void delete(int idx) {
		mapper.delete(idx);
	}

}










