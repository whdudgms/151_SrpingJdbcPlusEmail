package com.feb.jdbc.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.SingleColumnRowMapper;

public class NoticeRowMapper extends SingleColumnRowMapper<Notice>{
	
	
	
	
	public Notice mapRow(ResultSet rs, int  rowNum) throws SQLException{
	Notice notice  = new Notice();
	notice.setAuthor(rs.getString("author"));
	notice.setContent(rs.getString("content"));
	notice.setNoticeIdx(rs.getInt("notice_idx"));
	notice.setWrtDtm(rs.getString("wrt_dtm"));
	return notice;
	}

}
