package com.zest.web.client.model;

import java.sql.Date;

//원데이 항목 VO
public class Talent_OneDayTimeVO {

	private int tt_od_no;
	private Date day1;
	private String day1Time;
	private Date day2;
	private String day2Time;
	private Date day3;
	private String day3Time;
	private int dayOfWekk; // 해당 time VO가 무슨 요일의 vo인지 구분하는 녀석
	
	
	
	
	public int getDayOfWekk() {
		return dayOfWekk;
	}
	public void setDayOfWekk(int dayOfWekk) {
		this.dayOfWekk = dayOfWekk;
	}
	public int getTt_od_no() {
		return tt_od_no;
	}
	public void setTt_od_no(int tt_od_no) {
		this.tt_od_no = tt_od_no;
	}
	public Date getDay1() {
		return day1;
	}
	public void setDay1(Date day1) {
		this.day1 = day1;
	}
	public String getDay1Time() {
		return day1Time;
	}
	public void setDay1Time(String day1Time) {
		this.day1Time = day1Time;
	}
	public Date getDay2() {
		return day2;
	}
	public void setDay2(Date day2) {
		this.day2 = day2;
	}
	public String getDay2Time() {
		return day2Time;
	}
	public void setDay2Time(String day2Time) {
		this.day2Time = day2Time;
	}
	public Date getDay3() {
		return day3;
	}
	public void setDay3(Date day3) {
		this.day3 = day3;
	}
	public String getDay3Time() {
		return day3Time;
	}
	public void setDay3Time(String day3Time) {
		this.day3Time = day3Time;
	}
	@Override
	public String toString() {
		return "Talent_OneDayTimeVO [tt_od_no=" + tt_od_no + ", day1=" + day1 + ", day1Time=" + day1Time + ", day2="
				+ day2 + ", day2Time=" + day2Time + ", day3=" + day3 + ", day3Time=" + day3Time + "]";
	}
	
	
	
	
	
}
