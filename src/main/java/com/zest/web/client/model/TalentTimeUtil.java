package com.zest.web.client.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//수업을 등록할때 시간관련 유틸 클래스
public class TalentTimeUtil {
	
	String zone_id; //zone_id
	List<String> mon;     //월요일 내용 저장
	List<String> tue;
	List<String> wed;
	List<String> tur;
	List<String> fri;
	List<String> sat;
	List<String> sun;
	
	Map<String, TalentTimeUtil> timeData; //해당지역의 timeData가 저장되는 hashMap
	int count; // 해쉬맵안에 몇개의 주머니가 있는지 확인시 저장되는 변수	
	
	

	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getZone_id() {
		return zone_id;
	}
	public void setZone_id(String zone_id) {
		this.zone_id = zone_id;
	}
	
	
	
	public Map<String, TalentTimeUtil> getTimeData() {
		return timeData;
	}
	public void setTimeData(Map<String, TalentTimeUtil> timeData) {
		this.timeData = timeData;
	}
	public List<String> getMon() {
		return mon;
	}
	public void setMon(List<String> mon) {
		this.mon = mon;
	}
	public List<String> getTue() {
		return tue;
	}
	public void setTue(List<String> tue) {
		this.tue = tue;
	}
	public List<String> getWed() {
		return wed;
	}
	public void setWed(List<String> wed) {
		this.wed = wed;
	}
	public List<String> getTur() {
		return tur;
	}
	public void setTur(List<String> tur) {
		this.tur = tur;
	}
	public List<String> getFri() {
		return fri;
	}
	public void setFri(List<String> fri) {
		this.fri = fri;
	}
	public List<String> getSat() {
		return sat;
	}
	public void setSat(List<String> sat) {
		this.sat = sat;
	}
	public List<String> getSun() {
		return sun;
	}
	public void setSun(List<String> sun) {
		this.sun = sun;
	}
	
	
}
