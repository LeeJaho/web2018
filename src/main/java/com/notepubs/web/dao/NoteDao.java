package com.notepubs.web.dao;

import java.util.List;

import com.notepubs.web.entity.Note;



public interface NoteDao {
	
	/*마이바티스 어노테이션 방법*/
	/*@Select("select * from Note order by regDate desc" + 
			"		limit ${(page-1)*15}, 15")*/
	List<Note> getList(/*@Param("page") */Integer page);
	
	Note get(Integer id);
	
	int insert(Note note);

	Note getPrevNote(Integer id);

	Note getNextNote(Integer id);
}
