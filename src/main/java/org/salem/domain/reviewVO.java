package org.salem.domain;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import lombok.Data;

@Data
public class reviewVO {
	private int reviewNo;
	private int bookingCode;
	private double rating;
	private Timestamp writingDate;
	private String title;
	private String content;
	private String replyContent;
	private Timestamp replyDate;
	
	//추가
	private int laneNumber;
	private String patternName;
	private String writer;
	
	
}
