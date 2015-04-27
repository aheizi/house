package com.aheizi.bean;



public class House {
	private int id;				 //ID
	private String publisher;    //发布者
	private String publishDate;	 //发布日期
	private String region;		 //地区，存市（根据IP获得）
	private String hireWay;      //出租方式
	private String identity;     //身份（个人，经纪人）
	private String provinces;    //省
	private String city;         //市
	private String country;      //区
	private String communityName;//小区名称
	private int room;            //房屋类型（室）
	private int hall;            //房屋类型（厅）
	private int toilet;          //房屋类型（卫）
	private int squareMeter;     //房屋类型（平方米）
	private int floor;           //楼层（第几层）
	private int floorth;         //楼层（共几层）
	private int rent;            //租金（租金）
	private String rentWay;      //租金（租金方式）
	private String title;        //标题
	private String description;  //房源描述
	private String imgUrl;       //图片URL
	private String contact;      //联系人
	private String contactTel;   //联系人电话
	private String qqNum;        //QQ号码
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getProvinces() {
		return provinces;
	}
	public void setProvinces(String provinces) {
		this.provinces = provinces;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCommunityName() {
		return communityName;
	}
	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	public int getHall() {
		return hall;
	}
	public void setHall(int hall) {
		this.hall = hall;
	}
	public int getToilet() {
		return toilet;
	}
	public void setToilet(int toilet) {
		this.toilet = toilet;
	}
	public int getSquareMeter() {
		return squareMeter;
	}
	public void setSquareMeter(int squareMeter) {
		this.squareMeter = squareMeter;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public int getFloorth() {
		return floorth;
	}
	public void setFloorth(int floorth) {
		this.floorth = floorth;
	}
	public int getRent() {
		return rent;
	}
	public void setRent(int rent) {
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
	public String getQqNum() {
		return qqNum;
	}
	public void setQqNum(String qqNum) {
		this.qqNum = qqNum;
	}
}
