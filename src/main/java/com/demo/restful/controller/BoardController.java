package com.demo.restful.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.demo.restful.domain.Board;
import com.demo.restful.service.BoardService;


@RestController // @Controller + @ResponseBody 묶음 
@RequestMapping("/board/*")
public class BoardController {
	@Autowired
	BoardService service; 
	
	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("board/index");
	}
	
//	@RequestMapping("/")
//	public ModelAndView index(ModelAndView mav) {
//		mav.setViewName("board/index");
//		return mav;
//	}

	@RequestMapping("/hello.html")
	public ModelAndView hello(ModelAndView mav) {
		mav.setViewName("board/hello");
		return mav;
	}

	@RequestMapping("viewBoard.data")
	public Board getBoard() {
		Board vo = service.view(1);
		return vo;
	}
	@RequestMapping("list.data")
	public List<Board> listBoard2() {
		List<Board> list = service.list();
		return list;
	}
	@GetMapping("list2.data")
	public ResponseEntity<?> getBoardInfoList() {
		List<Board> list = service.list();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@RequestMapping("map.data")
	public Map<Integer, Board> mapBoard2() {
		Map<Integer, Board> map = new HashMap<Integer, Board>();
		List<Board> list = service.list();
		for(int i=0; i<list.size(); i++) {
			map.put(i+1, list.get(i));
		}
		return map;
	}
//	@RequestMapping("map2.data")
//	public ResponseEntity<Map<String, Object>> getBoardList() {
//		List<Board> list = service.list();
//		System.out.println(list);
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("result", Boolean.TRUE);
//		map.put("data", list);
//		return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
//	}
	@RequestMapping(value = "boards", method = RequestMethod.GET)
	public Map getBoardList() {
		List<Board> list = service.list();
		Map result = new HashMap();
		result.put("result", Boolean.TRUE);
		result.put("data", list);
		return result;
	}
	@RequestMapping(value = "/users/{idx}", method = RequestMethod.GET)
	public Map getUser(@PathVariable int idx) {
		Board board = service.view(idx);
		Map result = new HashMap();
		result.put("result", Boolean.TRUE);
		result.put("data", board);
		return result;
	}
}
