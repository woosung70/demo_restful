package com.demo.restful.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.demo.restful.domain.Board;

//@Repository
public interface BoardMapper {
	@Select("select idx, userId, userName, title, to_char(regDate, 'YYYY-MM-DD') regDate, hit from board order by idx desc")
	public List<Board> list();
	
	@Insert("insert into board (userId, userName, userEmail, userPhone, title, content, kind, regDate, modDate) "
			+ "values (#{userId}, #{userName}, #{userEmail}, #{userPhone}, #{title}, #{content}, #{kind}, now(), now()"
			+ ")")
	public void insert(Board dto);
	
	@Select("select * from board where idx=#{idx}")
	public Board view(int idx);
	
	@Update("update board set userName=#{userName}, userEmail=#{userEmail}, userPhone=#{userPhone}, "
			+ "title=#{title}, content=#{content}, modDate=now() where idx=#{idx}")
	public void update(Board dto);

	@Delete("delete from board where idx=#{idx}")
	public void delete(int idx);
	
}
