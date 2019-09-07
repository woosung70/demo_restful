package com.demo.restful.service;

import java.util.List;

import com.demo.restful.domain.Board;

public interface BoardService {
	public List<Board> list();
	public void insert(Board dto);
	public Board view(int idx);
	public void update(Board dto);
	public void delete(int idx);
}









