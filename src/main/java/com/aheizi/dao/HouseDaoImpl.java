package com.aheizi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.aheizi.bean.House;

public class HouseDaoImpl extends BaseDao implements HouseDao {
	
	//保存房屋信息
	public void saveHouse(final House house) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		getJdbcTemplate().update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				StringBuffer sql = new StringBuffer();
				sql.append("insert into house_dtail (house_id, house_publisher, house_publishDate, house_region," +
						" house_hireWay, house_identity, house_provinces, house_city, house_country, house_communityName, house_room, house_hall, house_toilet, house_squareMeter, " +
						" house_floor, house_floorth, house_rent, house_rentWay, house_title, house_description," +
						" house_imgUrl, house_contact, house_contactTel, hosue_qqNum) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				PreparedStatement ps = con.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1, house.getId());
				ps.setString(2, house.getPublisher());
				ps.setString(3, house.getPublishDate());//是时间   待会儿处理
				ps.setString(4, house.getRegion());
				ps.setString(5, house.getHireWay());
				ps.setString(6, house.getIdentity());
				ps.setString(7, house.getProvinces());
				ps.setString(8, house.getCity());
				ps.setString(9, house.getCountry());
				ps.setString(10, house.getCommunityName());
				ps.setInt(11, house.getRoom());
				ps.setInt(12, house.getHall());
				ps.setInt(13, house.getToilet());
				ps.setInt(14, house.getSquareMeter());
				ps.setInt(15, house.getFloor());
				ps.setInt(16, house.getFloorth());
				ps.setInt(17, house.getRent());
				ps.setString(18, house.getRentWay());
				ps.setString(19, house.getTitle());
				ps.setString(20, house.getDescription());
				ps.setString(21, house.getImgUrl());
				ps.setString(22, house.getContact());
				ps.setString(23, house.getContactTel());
				ps.setString(24, house.getQqNum());
				return ps;
			}
		}, keyHolder);
		house.setId(keyHolder.getKey().intValue());
	}
}
