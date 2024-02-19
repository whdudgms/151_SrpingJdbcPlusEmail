package com.feb.jdbc.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.feb.jdbc.dao.NoticeDao;
import com.feb.jdbc.entity.Notice;

public class NoticeService {
	
	private NoticeDao noticeDao;
	
	public NoticeService() {}
	
	public NoticeService(NoticeDao noticeDao) {
		System.out.println(noticeDao);
		this.noticeDao = noticeDao;
	}
	

	public int insertNotice(HashMap<String, String> params) {
		return noticeDao.insertNotice(params);
	}
	
	public int updateNotice(HashMap<String,String> params) {
		return noticeDao.updateNotice(params);
	}

	public ArrayList<Notice> selectNoticeList(HashMap<String, String> params) {
		return noticeDao.selectNoticeList(params);
	}

	public int deleteNotice(HashMap<String, String> params) {
		return noticeDao.deleteNotice(params);
	}


}
