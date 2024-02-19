package com.feb.jdbc.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.feb.jdbc.entity.Notice;

public interface NoticeDao {

	ArrayList<Notice> selectNoticeList(HashMap<String,String > params);
	int insertNotice(HashMap<String,String> params);
	int updateNotice(HashMap<String,String> params);
	int deleteNotice(HashMap<String,String> params);
	
}
