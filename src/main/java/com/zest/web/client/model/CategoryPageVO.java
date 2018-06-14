package com.zest.web.client.model;

public class CategoryPageVO {
	private Integer talent_no; // talent 테이블 고유번호
	private Integer talent_price_hour; // 1시간당 가격
	private Integer talent_acc_client; // 누적 인원 수
	private String tc_subject; //제목
	private String tc_image_path; // 이미지경로
	private String zone_id; // 구역의 영어 약자
	private String zone_name; // 구역의 한글 이름
	
	public Integer getTalent_no() {
		return talent_no;
	}
	public void setTalent_no(Integer talent_no) {
		this.talent_no = talent_no;
	}
	public Integer getTalent_price_hour() {
		return talent_price_hour;
	}
	public void setTalent_price_hour(Integer talent_price_hour) {
		this.talent_price_hour = talent_price_hour;
	}
	public Integer getTalent_acc_client() {
		return talent_acc_client;
	}
	public void setTalent_acc_client(Integer talent_acc_client) {
		this.talent_acc_client = talent_acc_client;
	}
	public String getTc_subject() {
		return tc_subject;
	}
	public void setTc_subject(String tc_subject) {
		this.tc_subject = tc_subject;
	}
	public String getTc_image_path() {
		return tc_image_path;
	}
	public void setTc_image_path(String tc_image_path) {
		this.tc_image_path = tc_image_path;
	}
	public String getZone_id() {
		return zone_id;
	}
	public void setZone_id(String zone_id) {
		this.zone_id = zone_id;
	}
	public String getZone_name() {
		return zone_name;
	}
	public void setZone_name(String zone_name) {
		this.zone_name = zone_name;
	}
	
	@Override
	public String toString() {
		return "CategoryPageVO [talent_no=" + talent_no + ", talent_price_hour=" + talent_price_hour
				+ ", talent_acc_client=" + talent_acc_client + ", tc_subject=" + tc_subject + ", tc_image_path="
				+ tc_image_path + ", zone_id=" + zone_id + ", zone_name=" + zone_name + "]";
	}

	
}
