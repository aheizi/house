package com.aheizi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
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
				sql.append("insert into house_out_dtail (house_id, house_publisher, house_publishDate, house_region," +
						" house_hireWay, house_identity, house_provinces, house_city, house_country, house_communityName, house_room, house_hall, house_toilet, house_squareMeter, " +
						" house_floor, house_floorth, house_rent, house_rentWay, house_title, house_description," +
						" house_imgUrl, house_contact, house_contactTel, hosue_qqNum, house_state) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
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
				ps.setString(25, house.getState());
				return ps;
			}
		}, keyHolder);
		house.setId(keyHolder.getKey().intValue());
	}

	//根据条件查找房屋信息
	public List<House> searchHouse(String provinces, String city, String country, int rentStart, int rentEnd,
			int room, String hireWay) {
		StringBuilder querySql=new StringBuilder ();
    	querySql.append("SELECT * from house_out_dtail hd where 1=1");
    	System.out.println("country ====" + country);
    	//加上地区限制
    	if(!provinces.equals("请选择省")){
    		querySql.append(" AND hd.house_provinces = '" + provinces +"'");
    	}
    	if(!city.equals("请选择市")){
    		querySql.append(" AND hd.house_city = '" + city +"'");
    	}
    	if(!country.equals("请选择区/县")){
    		querySql.append(" AND hd.house_country = '" + country +"'");
    	}
    	//加上租金限制
    	if(!(rentStart == 0 && rentEnd == 0)){
    		querySql.append(" AND hd.house_rent BETWEEN '" + rentStart + "' and '" + rentEnd +"'");
    	}
    	//加上居室限制
    	if(room == 0){
    		
    	}else if(room == 5){
    		querySql.append(" AND hd.house_room > 4");
    	}else{
    		querySql.append(" AND hd.house_room = '" + room +"'");
    	}
    	//加上出租方式限制
    	if(!hireWay.equals("no") ){
    		querySql.append(" AND hd.house_hireWay = '" + hireWay + "'");
    	}
    	querySql.append(" order by hd.house_id desc");
    	System.out.println(querySql.toString());
    	Object[] params=new Object[]{};
    	List<House> list= this.getJdbcTemplate().query(querySql.toString(), params, new RowMapper<House>() {
			public House mapRow(ResultSet rs, int rowNum) throws SQLException {
				House house = new House();
				house.setId(rs.getInt("house_id"));
				house.setPublisher(rs.getString("house_publisher"));
				house.setPublishDate(rs.getString("house_publishDate"));
				house.setRegion(rs.getString("house_region"));
				house.setHireWay(rs.getString("house_hireWay"));
				house.setIdentity(rs.getString("house_identity"));
				house.setProvinces(rs.getString("house_provinces"));
				house.setCity(rs.getString("house_city"));
				house.setCountry(rs.getString("house_country"));
				house.setCommunityName(rs.getString("house_communityName"));
				house.setRoom(rs.getInt("house_room"));
				house.setHall(rs.getInt("house_hall"));
				house.setToilet(rs.getInt("house_toilet"));
				house.setSquareMeter(rs.getInt("house_squareMeter"));
				house.setFloor(rs.getInt("house_floor"));
				house.setFloorth(rs.getInt("house_floorth"));
				house.setRent(rs.getInt("house_rent"));
				house.setRentWay(rs.getString("house_rentWay"));
				house.setTitle(rs.getString("house_title"));
				house.setDescription(rs.getString("house_description"));
				house.setImgUrl(rs.getString("house_imgUrl"));
				house.setContact(rs.getString("house_contact"));
				house.setContactTel(rs.getString("house_contactTel"));
				house.setQqNum(rs.getString("hosue_qqNum"));
				house.setState(rs.getString("house_state"));
				return house;
			}
    	});
    	return list;
	}

	@Override
	public House findHouseById(int houseId) {
		StringBuilder querySql=new StringBuilder ();
		querySql.append("SELECT * from house_out_dtail hd");
		querySql.append(" where hd.house_id = ?");
    	Object[] params=new Object[]{houseId};
    	List<House> list= this.getJdbcTemplate().query(querySql.toString(), params, new RowMapper<House>() {
			public House mapRow(ResultSet rs, int rowNum) throws SQLException {
				House house = new House();
				house.setId(rs.getInt("house_id"));
				house.setPublisher(rs.getString("house_publisher"));
				house.setPublishDate(rs.getString("house_publishDate"));
				house.setRegion(rs.getString("house_region"));
				house.setHireWay(rs.getString("house_hireWay"));
				house.setIdentity(rs.getString("house_identity"));
				house.setProvinces(rs.getString("house_provinces"));
				house.setCity(rs.getString("house_city"));
				house.setCountry(rs.getString("house_country"));
				house.setCommunityName(rs.getString("house_communityName"));
				house.setRoom(rs.getInt("house_room"));
				house.setHall(rs.getInt("house_hall"));
				house.setToilet(rs.getInt("house_toilet"));
				house.setSquareMeter(rs.getInt("house_squareMeter"));
				house.setFloor(rs.getInt("house_floor"));
				house.setFloorth(rs.getInt("house_floorth"));
				house.setRent(rs.getInt("house_rent"));
				house.setRentWay(rs.getString("house_rentWay"));
				house.setTitle(rs.getString("house_title"));
				house.setDescription(rs.getString("house_description"));
				house.setImgUrl(rs.getString("house_imgUrl"));
				house.setContact(rs.getString("house_contact"));
				house.setContactTel(rs.getString("house_contactTel"));
				house.setQqNum(rs.getString("hosue_qqNum"));
				house.setState(rs.getString("house_state"));
				return house;
			}
    	});
    	if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}
	
	//收藏出租房屋信息
	public void collectHouseOut(final int houseOutId, final int userId) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		getJdbcTemplate().update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				StringBuffer sql = new StringBuffer();
				sql.append("insert into house_collection (user_id, in_dtail_id, out_dtail_id) values (?,'0',?);");
				PreparedStatement ps = con.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1, userId);
				ps.setInt(2, houseOutId);
				return ps;
			}
		}, keyHolder);
	}

	//是否收藏出租房屋信息
	public boolean isCollectHouseOut(int hosueOutId, int userId) {
		StringBuilder querySql=new StringBuilder ();
		querySql.append("SELECT COUNT(*) from house_collection hc");
		querySql.append(" where hc.user_id = ? and hc.out_dtail_id = ?");
    	Object[] params=new Object[]{userId,hosueOutId};
    	int i = this.getJdbcTemplate().queryForObject(querySql.toString(), params, Integer.class);
    	if(i>0){
    		return true;
    	}else{
    		return false;
    	}
	}

	//根据用户名查找房屋信息
	public List<House> findHouseByUserName(String userName) {
		StringBuilder querySql=new StringBuilder ();
		querySql.append("SELECT * from house_out_dtail hd");
		querySql.append(" where hd.house_publisher = ? order by hd.house_id desc");
    	Object[] params=new Object[]{userName};
    	List<House> list= this.getJdbcTemplate().query(querySql.toString(), params, new RowMapper<House>() {
			public House mapRow(ResultSet rs, int rowNum) throws SQLException {
				House house = new House();
				house.setId(rs.getInt("house_id"));
				house.setPublisher(rs.getString("house_publisher"));
				house.setPublishDate(rs.getString("house_publishDate"));
				house.setRegion(rs.getString("house_region"));
				house.setHireWay(rs.getString("house_hireWay"));
				house.setIdentity(rs.getString("house_identity"));
				house.setProvinces(rs.getString("house_provinces"));
				house.setCity(rs.getString("house_city"));
				house.setCountry(rs.getString("house_country"));
				house.setCommunityName(rs.getString("house_communityName"));
				house.setRoom(rs.getInt("house_room"));
				house.setHall(rs.getInt("house_hall"));
				house.setToilet(rs.getInt("house_toilet"));
				house.setSquareMeter(rs.getInt("house_squareMeter"));
				house.setFloor(rs.getInt("house_floor"));
				house.setFloorth(rs.getInt("house_floorth"));
				house.setRent(rs.getInt("house_rent"));
				house.setRentWay(rs.getString("house_rentWay"));
				house.setTitle(rs.getString("house_title"));
				house.setDescription(rs.getString("house_description"));
				house.setImgUrl(rs.getString("house_imgUrl"));
				house.setContact(rs.getString("house_contact"));
				house.setContactTel(rs.getString("house_contactTel"));
				house.setQqNum(rs.getString("hosue_qqNum"));
				house.setState(rs.getString("house_state"));
				return house;
			}
    	});
    	if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	//根据id删除出租房屋信息
	public void deleteHouseOutById(int houseOutId) {
		StringBuilder sql = new  StringBuilder();
		sql.append(" delete from house_out_dtail");
		sql.append(" where house_id = ?");
		getJdbcTemplate().update(sql.toString(), houseOutId);
	}

	//查找用户收藏的出租房屋信息
	public List<House> findCollectHouseOut(int userId) {
		StringBuilder querySql=new StringBuilder ();
		querySql.append("select * from house_out_dtail hod LEFT JOIN house_collection hc on hod.house_id = hc.out_dtail_id");
		querySql.append(" where hc.user_id = ? order by hod.house_id desc");
    	Object[] params=new Object[]{userId};
    	List<House> list= this.getJdbcTemplate().query(querySql.toString(), params, new RowMapper<House>() {
			public House mapRow(ResultSet rs, int rowNum) throws SQLException {
				House house = new House();
				house.setId(rs.getInt("house_id"));
				house.setPublisher(rs.getString("house_publisher"));
				house.setPublishDate(rs.getString("house_publishDate"));
				house.setRegion(rs.getString("house_region"));
				house.setHireWay(rs.getString("house_hireWay"));
				house.setIdentity(rs.getString("house_identity"));
				house.setProvinces(rs.getString("house_provinces"));
				house.setCity(rs.getString("house_city"));
				house.setCountry(rs.getString("house_country"));
				house.setCommunityName(rs.getString("house_communityName"));
				house.setRoom(rs.getInt("house_room"));
				house.setHall(rs.getInt("house_hall"));
				house.setToilet(rs.getInt("house_toilet"));
				house.setSquareMeter(rs.getInt("house_squareMeter"));
				house.setFloor(rs.getInt("house_floor"));
				house.setFloorth(rs.getInt("house_floorth"));
				house.setRent(rs.getInt("house_rent"));
				house.setRentWay(rs.getString("house_rentWay"));
				house.setTitle(rs.getString("house_title"));
				house.setDescription(rs.getString("house_description"));
				house.setImgUrl(rs.getString("house_imgUrl"));
				house.setContact(rs.getString("house_contact"));
				house.setContactTel(rs.getString("house_contactTel"));
				house.setQqNum(rs.getString("hosue_qqNum"));
				house.setState(rs.getString("house_state"));
				return house;
			}
    	});
    	if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	public void cancelCollectHouseOut(int userId , int houseOutId) {
		StringBuilder sql = new  StringBuilder();
		sql.append(" delete from house_collection");
		sql.append(" where user_id = ? and out_dtail_id = ?");
		getJdbcTemplate().update(sql.toString(), userId , houseOutId);
	}

	public List<House> findNoCheckHouseOut() {
		StringBuilder querySql=new StringBuilder ();
		querySql.append("SELECT * from house_out_dtail hd");
		querySql.append(" where hd.house_state = 1");
    	Object[] params=new Object[]{};
    	List<House> list= this.getJdbcTemplate().query(querySql.toString(), params, new RowMapper<House>() {
			public House mapRow(ResultSet rs, int rowNum) throws SQLException {
				House house = new House();
				house.setId(rs.getInt("house_id"));
				house.setPublisher(rs.getString("house_publisher"));
				house.setPublishDate(rs.getString("house_publishDate"));
				house.setRegion(rs.getString("house_region"));
				house.setHireWay(rs.getString("house_hireWay"));
				house.setIdentity(rs.getString("house_identity"));
				house.setProvinces(rs.getString("house_provinces"));
				house.setCity(rs.getString("house_city"));
				house.setCountry(rs.getString("house_country"));
				house.setCommunityName(rs.getString("house_communityName"));
				house.setRoom(rs.getInt("house_room"));
				house.setHall(rs.getInt("house_hall"));
				house.setToilet(rs.getInt("house_toilet"));
				house.setSquareMeter(rs.getInt("house_squareMeter"));
				house.setFloor(rs.getInt("house_floor"));
				house.setFloorth(rs.getInt("house_floorth"));
				house.setRent(rs.getInt("house_rent"));
				house.setRentWay(rs.getString("house_rentWay"));
				house.setTitle(rs.getString("house_title"));
				house.setDescription(rs.getString("house_description"));
				house.setImgUrl(rs.getString("house_imgUrl"));
				house.setContact(rs.getString("house_contact"));
				house.setContactTel(rs.getString("house_contactTel"));
				house.setQqNum(rs.getString("hosue_qqNum"));
				house.setState(rs.getString("house_state"));
				return house;
			}
    	});
    	if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	@Override
	public List<House> findCheckHouseOut() {
		StringBuilder querySql=new StringBuilder ();
		querySql.append("SELECT * from house_out_dtail hd");
		querySql.append(" where hd.house_state = 2 order by hd.house_id desc");
    	Object[] params=new Object[]{};
    	List<House> list= this.getJdbcTemplate().query(querySql.toString(), params, new RowMapper<House>() {
			public House mapRow(ResultSet rs, int rowNum) throws SQLException {
				House house = new House();
				house.setId(rs.getInt("house_id"));
				house.setPublisher(rs.getString("house_publisher"));
				house.setPublishDate(rs.getString("house_publishDate"));
				house.setRegion(rs.getString("house_region"));
				house.setHireWay(rs.getString("house_hireWay"));
				house.setIdentity(rs.getString("house_identity"));
				house.setProvinces(rs.getString("house_provinces"));
				house.setCity(rs.getString("house_city"));
				house.setCountry(rs.getString("house_country"));
				house.setCommunityName(rs.getString("house_communityName"));
				house.setRoom(rs.getInt("house_room"));
				house.setHall(rs.getInt("house_hall"));
				house.setToilet(rs.getInt("house_toilet"));
				house.setSquareMeter(rs.getInt("house_squareMeter"));
				house.setFloor(rs.getInt("house_floor"));
				house.setFloorth(rs.getInt("house_floorth"));
				house.setRent(rs.getInt("house_rent"));
				house.setRentWay(rs.getString("house_rentWay"));
				house.setTitle(rs.getString("house_title"));
				house.setDescription(rs.getString("house_description"));
				house.setImgUrl(rs.getString("house_imgUrl"));
				house.setContact(rs.getString("house_contact"));
				house.setContactTel(rs.getString("house_contactTel"));
				house.setQqNum(rs.getString("hosue_qqNum"));
				house.setState(rs.getString("house_state"));
				return house;
			}
    	});
    	if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	@Override
	public void updateHouseOutState(int houseOutId, int state) {
		StringBuilder sql = new  StringBuilder();
		sql.append(" update house_out_dtail set house_state = ? ");
		sql.append(" where house_id = ?;");
		getJdbcTemplate().update(sql.toString(), state , houseOutId);
	}

	@Override
	public List<House> findIndexHouseList() {
		StringBuilder querySql=new StringBuilder ();
		querySql.append("SELECT * from house_out_dtail hd");
		querySql.append(" where hd.house_state = 2 order by hd.house_id desc");
    	Object[] params=new Object[]{};
    	List<House> list= this.getJdbcTemplate().query(querySql.toString(), params, new RowMapper<House>() {
			public House mapRow(ResultSet rs, int rowNum) throws SQLException {
				House house = new House();
				house.setId(rs.getInt("house_id"));
				house.setPublisher(rs.getString("house_publisher"));
				house.setPublishDate(rs.getString("house_publishDate"));
				house.setRegion(rs.getString("house_region"));
				house.setHireWay(rs.getString("house_hireWay"));
				house.setIdentity(rs.getString("house_identity"));
				house.setProvinces(rs.getString("house_provinces"));
				house.setCity(rs.getString("house_city"));
				house.setCountry(rs.getString("house_country"));
				house.setCommunityName(rs.getString("house_communityName"));
				house.setRoom(rs.getInt("house_room"));
				house.setHall(rs.getInt("house_hall"));
				house.setToilet(rs.getInt("house_toilet"));
				house.setSquareMeter(rs.getInt("house_squareMeter"));
				house.setFloor(rs.getInt("house_floor"));
				house.setFloorth(rs.getInt("house_floorth"));
				house.setRent(rs.getInt("house_rent"));
				house.setRentWay(rs.getString("house_rentWay"));
				house.setTitle(rs.getString("house_title"));
				house.setDescription(rs.getString("house_description"));
				house.setImgUrl(rs.getString("house_imgUrl"));
				house.setContact(rs.getString("house_contact"));
				house.setContactTel(rs.getString("house_contactTel"));
				house.setQqNum(rs.getString("hosue_qqNum"));
				house.setState(rs.getString("house_state"));
				return house;
			}
    	});
    	if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}
}
