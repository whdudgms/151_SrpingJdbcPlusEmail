package com.feb.jdbc.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.feb.jdbc.dao.NoticeDao;
import com.feb.jdbc.entity.Notice;
import com.feb.jdbc.entity.NoticeRowMapper;

public class NoticeDaoImpl extends JdbcDaoSupport implements NoticeDao{


	@Override
	public ArrayList<Notice> selectNoticeList(HashMap<String, String> params) {
		int offset = Integer.parseInt((String)params.get("offset"));
		int limit  = Integer.parseInt((String)params.get("limit"));
		String sql = "SELECT notice_idx, author, \"content\", wrt_dtm\n"
				+ "FROM lecture.notice offset " + offset + " limit " + limit;
		return (ArrayList<Notice>) getJdbcTemplate().query(sql.toString(), new NoticeRowMapper());
	}

	@Override
	public int insertNotice(HashMap<String, String> params) {
		
		String sql = "INSERT INTO lecture.notice"
				+ "(author, content, wrt_dtm) "
				+ "VALUES('" + params.get("author")
				+ "', '" + params.get("content")
				+ "', '" + params.get("wrt_dtm")+"')";
	
		return getJdbcTemplate().update(sql);
	}

	@Override
	public int updateNotice(HashMap<String, String> params) {
		String sql = "UPDATE lecture.\"notice\"\n"
				+ "SET "
				+ " \"content\"='"  +params.get("content")+ "',"
				+ " wrt_dtm='" +params.get("wrt_dtm")+"' " 
				+ "where notice_idx='"+params.get("notice_idx")+"';";
		return getJdbcTemplate().update(sql);
	}
	
	


	@Override
	public int deleteNotice(HashMap<String, String> params) {
		String sql = "delete from lecture.notice where notice_idx = "+ params.get("notice_idx");
		return getJdbcTemplate().update(sql);
	}
	

}

