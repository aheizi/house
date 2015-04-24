package com.aheizi.bean;

public class House {
	private String publisher;    //发布者
	private String publishDate;	 //发布日期
	private String region;		 //地区，存市（根据IP获得）
	private String hireWay;      //出租方式
	private String identity;     //身份（个人，经纪人）
	private String communityName;//小区名称
	private String room;         //房屋类型（室）
	private String hall;         //房屋类型（厅）
	private String toilet;       //房屋类型（卫）
	private String squareMeter;  //房屋类型（平方米）
	private String floor;        //楼层（第几层）
	private String floorth;      //楼层（共几层）
	private String rent;         //租金（租金）
	private String rentWay;      //租金（租金方式）
	private String title;        //标题
	private String description;  //房源描述
	private String imgUrl;       //图片URL
	private String contact;      //联系人
	private String contactTel;   //联系人电话
	
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getHireWay() {
		return hireWay;
	}
	public void setHireWay(String hireWay) {
		this.hireWay = hireWay;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getCommunityName() {
		return communityName;
	}
	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getHall() {
		return hall;
	}
	public void setHall(String hall) {
		this.hall = hall;
	}
	public String getToilet() {
		return toilet;
	}
	public void setToilet(String toilet) {
		this.toilet = toilet;
	}
	public String getSquareMeter() {
		return squareMeter;
	}
	public void setSquareMeter(String squareMeter) {
		this.squareMeter = squareMeter;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getFloorth() {
		return floorth;
	}
	public void setFloorth(String floorth) {
		this.floorth = floorth;
	}
	public String getRent() {
		return rent;
	}
	public void setRent(String rent) {
		this.rent = rent;
	}
	public String getRentWay() {
		return rentWay;
	}
	public void setRentWay(String rentWay) {
		this.rentWay = rentWay;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getContactTel() {
		return contactTel;
	}
	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}
}
