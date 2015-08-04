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

import com.aheizi.bean.HouseIn;

public class HouseInDaoImpl extends BaseDao implements HouseInDao {

	public void saveHouseIn(final HouseIn houseIn) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		getJdbcTemplate().update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				StringBuffer sql = new StringBuffer();
				sql.append("insert into house_in_dtail (in_id, in_publisher, in_publishDate, in_title, in_provinces, in_city, " +
						"in_country, in_rent, in_rentWay, in_description, in_time, in_contactTel, " +
						"in_contact, in_qqNum, in_state) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
				PreparedStatement ps = con.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1, houseIn.getId());
				ps.setString(2, houseIn.getPublisher());
				ps.setString(3, houseIn.getPublishDate());
				ps.setString(4, houseIn.getTitle());
				ps.setString(5, houseIn.getProvinces());
				ps.setString(6, houseIn.getCity());
				ps.setString(7, houseIn.getCountry());
				ps.setInt(8, houseIn.getRent());
				ps.setString(9, houseIn.getRentWay());
				ps.setString(10, houseIn.getDescription());
				ps.setString(11, houseIn.getTime());
				ps.setString(12, houseIn.getContact());
				ps.setString(13, houseIn.getContactTel());
				ps.setString(14, houseIn.getQqNum());
				ps.setInt(15, Integer.parseInt(houseIn.getState()));
				return ps;
			}
		}, keyHolder);
		houseIn.setId(keyHolder.getKey().intValue());
	}

	public List<HouseIn> searchHouseIn(String provinces, String city, String country, int rentStart,
			int rentEnd, String hireWay) {
		StringBuilder querySql=new StringBuilder ();
    	querySql.append("SELECT * from house_in_dtail hd where 1=1");
    	System.out.println("country ====" + country);
    	//加上地区限制
    	if(!provinces.equals("请选择省")){
    		querySql.append(" AND hd.in_provinces = '" + provinces +"'");
    	}
    	if(!city.equals("请选择市")){
    		querySql.append(" AND hd.in_city = '" + city +"'");
    	}
    	if(!country.equals("请选择区/县")){
    		querySql.append(" AND hd.in_country = '" + country +"'");
    	}
    	//加上租金限制
    	if(!(rentStart == 0 && rentEnd == 0)){
    		querySql.append(" AND hd.in_rent BETWEEN '" + rentStart + "' and '" + rentEnd +"'");
    	}
    	//加上出租方式限制
    	if(!hireWay.equals("no") ){
    		querySql.append(" AND hd.in_rentWay = '" + hireWay + "'");
    	}
    	querySql.append(" order by hd.in_id desc");
    	System.out.println(querySql.toString());
    	Object[] params=new Object[]{};
    	List<HouseIn> list= this.getJdbcTemplate().query(querySql.toString(), params, new RowMapper<HouseIn>() {
			public HouseIn mapRow(ResultSet rs, int rowNum) throws SQLException {
				HouseIn houseIn = new HouseIn();
				houseIn.setId(rs.getInt("in_id"));
				houseIn.setPublisher(rs.getString("in_publisher"));
				houseIn.setPublishDate(rs.getString("in_publishDate"));
				houseIn.setTitle(rs.getString("in_title"));
				houseIn.setProvinces(rs.getString("in_provinces"));
				houseIn.setCity(rs.getString("in_city"));
				houseIn.setCountry(rs.getString("in_country"));
				houseIn.setRent(rs.getInt("in_rent"));
				houseIn.setRentWay(rs.getString("in_rentWay"));
				houseIn.setDescription(rs.getString("in_description"));
				houseIn.setTime(rs.getString("in_time"));
				houseIn.setContact(rs.getString("in_contact"));
				houseIn.setContactTel(rs.getString("in_contactTel"));
				houseIn.setQqNum(rs.getString("in_qqNum"));
				houseIn.setState(rs.getString("in_state"));
				return houseIn;
			}
    	});
    	return list;
	}

	public HouseIn findHouseInById(int houseInId) {
		StringBuilder querySql=new StringBuilder ();
		querySql.append("SELECT * from house_in_dtail hd");
		querySql.append(" where hd.in_id = ?");
    	Object[] params=new Object[]{houseInId};
    	List<HouseIn> list= this.getJdbcTemplate().query(querySql.toString(), params, new RowMapper<HouseIn>() {
			public HouseIn mapRow(ResultSet rs, int rowNum) throws SQLException {
				HouseIn houseIn = new HouseIn();
				houseIn.setId(rs.getInt("in_id"));
				houseIn.setPublisher(rs.getString("in_publisher"));
				houseIn.setPublishDate(rs.getString("in_publishDate"));
				houseIn.setTitle(rs.getString("in_title"));
				houseIn.setProvinces(rs.getString("in_provinces"));
				houseIn.setCity(rs.getString("in_city"));
				houseIn.setCountry(rs.getString("in_country"));
				houseIn.setRent(rs.getInt("in_rent"));
				houseIn.setRentWay(rs.getString("in_rentWay"));
				houseIn.setDescription(rs.getString("in_description"));
				houseIn.setTime(rs.getString("in_time"));
				houseIn.setContact(rs.getString("in_contact"));
				houseIn.setContactTel(rs.getString("in_contactTel"));
				houseIn.setQqNum(rs.getString("in_qqNum"));
				houseIn.setState(rs.getString("in_state"));
				return houseIn;
			}
    	});
    	if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	//收藏求租房屋信息
	public void collectHouseIn(final int houseInId, final int userId) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		getJdbcTemplate().update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				StringBuffer sql = new StringBuffer();
				sql.append("insert into house_collection (user_id, in_dtail_id, out_dtail_id) values (?,?,'0');");
				PreparedStatement ps = con.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1, userId);
				ps.setInt(2, houseInId);
				return ps;
			}
		}, keyHolder);
	}

	@Override
	public boolean isCollectHouseOut(int hosueInId, int userId) {
		StringBuilder querySql=new StringBuilder ();
		querySql.append("SELECT COUNT(*) from house_collection hc");
		querySql.append(" where hc.user_id = ? and hc.in_dtail_id = ?");
    	Object[] params=new Object[]{userId,hosueInId};
    	int i = this.getJdbcTemplate().queryForInt(querySql.toString(), params);
    	if(i>0){
    		return true;
    	}else{
    		return false;
    	}
	}

	@Override
	public List<HouseIn> findHouseInByUserName(String userName) {
		StringBuilder querySql=new StringBuilder ();
		querySql.append("SELECT * from house_in_dtail hd");
		querySql.append(" where hd.in_publisher = ? order by hd.in_id desc");
    	Object[] params=new Object[]{userName};
    	List<HouseIn> list= this.getJdbcTemplate().query(querySql.toString(), params, new RowMapper<HouseIn>() {
			public HouseIn mapRow(ResultSet rs, int rowNum) throws SQLException {
				HouseIn houseIn = new HouseIn();
				houseIn.setId(rs.getInt("in_id"));
				houseIn.setPublisher(rs.getString("in_publisher"));
				houseIn.setPublishDate(rs.getString("in_publishDate"));
				houseIn.setTitle(rs.getString("in_title"));
				houseIn.setProvinces(rs.getString("in_provinces"));
				houseIn.setCity(rs.getString("in_city"));
				houseIn.setCountry(rs.getString("in_country"));
				houseIn.setRent(rs.getInt("in_rent"));
				houseIn.setRentWay(rs.getString("in_rentWay"));
				houseIn.setDescription(rs.getString("in_description"));
				houseIn.setTime(rs.getString("in_time"));
				houseIn.setContact(rs.getString("in_contact"));
				houseIn.setContactTel(rs.getString("in_contactTel"));
				houseIn.setQqNum(rs.getString("in_qqNum"));
				houseIn.setState(rs.getString("in_state"));
				return houseIn;
			}
    	});
    	if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	public void deleteHouseInById(int houseInId) {
		StringBuilder sql = new  StringBuilder();
		sql.append(" delete from house_in_dtail");
		sql.append(" where in_id = ?");
		getJdbcTemplate().update(sql.toString(), houseInId);
	}

	public List<HouseIn> findCollectHouseIn(int userId) {
		StringBuilder querySql=new StringBuilder ();
		querySql.append("select * from house_in_dtail hid LEFT JOIN house_collection hc on hid.in_id = hc.in_dtail_id");
		querySql.append(" where hc.user_id = ? order by hid.in_id desc");
    	Object[] params=new Object[]{userId};
    	List<HouseIn> list= this.getJdbcTemplate().query(querySql.toString(), params, new RowMapper<HouseIn>() {
			public HouseIn mapRow(ResultSet rs, int rowNum) throws SQLException {
				HouseIn houseIn = new HouseIn();
				houseIn.setId(rs.getInt("in_id"));
				houseIn.setPublisher(rs.getString("in_publisher"));
				houseIn.setPublishDate(rs.getString("in_publishDate"));
				houseIn.setTitle(rs.getString("in_title"));
				houseIn.setProvinces(rs.getString("in_provinces"));
				houseIn.setCity(rs.getString("in_city"));
				houseIn.setCountry(rs.getString("in_country"));
				houseIn.setRent(rs.getInt("in_rent"));
				houseIn.setRentWay(rs.getString("in_rentWay"));
				houseIn.setDescription(rs.getString("in_description"));
				houseIn.setTime(rs.getString("in_time"));
				houseIn.setContact(rs.getString("in_contact"));
				houseIn.setContactTel(rs.getString("in_contactTel"));
				houseIn.setQqNum(rs.getString("in_qqNum"));
				houseIn.setState(rs.getString("in_state"));
				return houseIn;
			}
    	});
    	if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	@Override
	public void cancelCollectHouseIn(int userId, int houseInId) {
		StringBuilder sql = new  StringBuilder();
		sql.append(" delete from house_collection");
		sql.append(" where user_id = ? and in_dtail_id = ?");
		getJdbcTemplate().update(sql.toString(), userId , houseInId);
	}

	@Override
	public List<HouseIn> findNoCheckHouseIn() {
		StringBuilder querySql=new StringBuilder ();
		querySql.append("SELECT * from house_in_dtail hd");
		querySql.append(" where hd.in_state = 1 order by hd.in_id desc");
    	Object[] params=new Object[]{};
    	List<HouseIn> list= this.getJdbcTemplate().query(querySql.toString(), params, new RowMapper<HouseIn>() {
			public HouseIn mapRow(ResultSet rs, int rowNum) throws SQLException {
				HouseIn houseIn = new HouseIn();
				houseIn.setId(rs.getInt("in_id"));
				houseIn.setPublisher(rs.getString("in_publisher"));
				houseIn.setPublishDate(rs.getString("in_publishDate"));
				houseIn.setTitle(rs.getString("in_title"));
				houseIn.setProvinces(rs.getString("in_provinces"));
				houseIn.setCity(rs.getString("in_city"));
				houseIn.setCountry(rs.getString("in_country"));
				houseIn.setRent(rs.getInt("in_rent"));
				houseIn.setRentWay(rs.getString("in_rentWay"));
				houseIn.setDescription(rs.getString("in_description"));
				houseIn.setTime(rs.getString("in_time"));
				houseIn.setContact(rs.getString("in_contact"));
				houseIn.setContactTel(rs.getString("in_contactTel"));
				houseIn.setQqNum(rs.getString("in_qqNum"));
				houseIn.setState(rs.getString("in_state"));
				return houseIn;
			}
    	});
    	if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	@Override
	public List<HouseIn> findCheckHouseIn() {
		StringBuilder querySql=new StringBuilder ();
		querySql.append("SELECT * from house_in_dtail hd");
		querySql.append(" where hd.in_state = 2 order by hd.in_id desc");
    	Object[] params=new Object[]{};
    	List<HouseIn> list= this.getJdbcTemplate().query(querySql.toString(), params, new RowMapper<HouseIn>() {
			public HouseIn mapRow(ResultSet rs, int rowNum) throws SQLException {
				HouseIn houseIn = new HouseIn();
				houseIn.setId(rs.getInt("in_id"));
				houseIn.setPublisher(rs.getString("in_publisher"));
				houseIn.setPublishDate(rs.getString("in_publishDate"));
				houseIn.setTitle(rs.getString("in_title"));
				houseIn.setProvinces(rs.getString("in_provinces"));
				houseIn.setCity(rs.getString("in_city"));
				houseIn.setCountry(rs.getString("in_country"));
				houseIn.setRent(rs.getInt("in_rent"));
				houseIn.setRentWay(rs.getString("in_rentWay"));
				houseIn.setDescription(rs.getString("in_description"));
				houseIn.setTime(rs.getString("in_time"));
				houseIn.setContact(rs.getString("in_contact"));
				houseIn.setContactTel(rs.getString("in_contactTel"));
				houseIn.setQqNum(rs.getString("in_qqNum"));
				houseIn.setState(rs.getString("in_state"));
				return houseIn;
			}
    	});
    	if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	public void updateHouseInState(int houseInId, int state) {
		StringBuilder sql = new  StringBuilder();
		sql.append(" update house_in_dtail set in_state = ? ");
		sql.append(" where in_id = ?;");
		getJdbcTemplate().update(sql.toString(), state , houseInId);
	}

	public List<HouseIn> findIndexHouseIn() {
		StringBuilder querySql=new StringBuilder ();
		querySql.append("SELECT * from house_in_dtail hd");
		querySql.append(" where hd.in_state = 2 order by hd.in_id desc");
    	Object[] params=new Object[]{};
    	List<HouseIn> list= this.getJdbcTemplate().query(querySql.toString(), params, new RowMapper<HouseIn>() {
			public HouseIn mapRow(ResultSet rs, int rowNum) throws SQLException {
				HouseIn houseIn = new HouseIn();
				houseIn.setId(rs.getInt("in_id"));
				houseIn.setPublisher(rs.getString("in_publisher"));
				houseIn.setPublishDate(rs.getString("in_publishDate"));
				houseIn.setTitle(rs.getString("in_title"));
				houseIn.setProvinces(rs.getString("in_provinces"));
				houseIn.setCity(rs.getString("in_city"));
				houseIn.setCountry(rs.getString("in_country"));
				houseIn.setRent(rs.getInt("in_rent"));
				houseIn.setRentWay(rs.getString("in_rentWay"));
				houseIn.setDescription(rs.getString("in_description"));
				houseIn.setTime(rs.getString("in_time"));
				houseIn.setContact(rs.getString("in_contact"));
				houseIn.setContactTel(rs.getString("in_contactTel"));
				houseIn.setQqNum(rs.getString("in_qqNum"));
				houseIn.setState(rs.getString("in_state"));
				return houseIn;
			}
    	});
    	if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

}
