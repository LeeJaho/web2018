package com.notepubs.web.dao;

import com.notepubs.web.entity.NoteLike;

public interface NoteLikeDao {

	NoteLike get(Integer noteId, String memberId);

	int insert(NoteLike noteLike);

	int delete(NoteLike noteLike);

}
