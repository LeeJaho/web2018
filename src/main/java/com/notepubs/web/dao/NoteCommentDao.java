package com.notepubs.web.dao;

import java.util.List;

import com.notepubs.web.entity.NoteComment;

public interface NoteCommentDao {

	int insert(NoteComment comment);

	//List<NoteComment> getList(Integer page);

}
