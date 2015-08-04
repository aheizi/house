package com.aheizi.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.aheizi.bean.User;

public class UserDaoImpl extends BaseDao implements UserDao{
	
	//新增用户
	public void saveUser(final User user) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		getJdbcTemplate().update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				StringBuffer sql = new StringBuffer();
				sql.append("insert into house_user (user_id, user_name, user_password, user_emial, user_realname, user_address, user_zipcode, user_type) values (?,?,?,?,?,?,?,?)");
				PreparedStatement ps = con.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1, user.getId());
				ps.setString(2, user.getUserName());
				ps.setString(3, user.getPassword());
				ps.setString(4, user.getEmail());
				ps.setString(5, user.getRealName());
				ps.setString(6, user.getAddress());
				ps.setString(7, user.getZipCode());
				ps.setString(8, user.getType());
				return ps;
			}
		}, keyHolder);
		user.setId(keyHolder.getKey().intValue());
	}

	//查找用户 通过用户名
	public User getUserByUserName(String userName) {
		StringBuilder querySql=new StringBuilder ();
    	querySql.append("select * from house_user user");
		querySql.append(" where user.user_name = ? and user.user_type = 'normal'");
    	Object[] params=new Object[]{userName};
    	List<User> list= this.getJdbcTemplate().query(querySql.toString(), params, new RowMapper<User>() {
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setId(rs.getInt("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setEmail(rs.getString("user_emial"));
				user.setPassword(rs.getString("user_password"));
				user.setRealName(rs.getString("user_realname"));
				user.setAddress(rs.getString("user_address"));
				user.setZipCode(rs.getString("user_zipcode"));
				user.setType(rs.getString("user_type"));
				return user;
			}
    	});
    	if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	//更新用户资料
	public void updateUser(final User user) {
		StringBuffer sql=new StringBuffer();
		 sql.append("update house_user set user_password = ?, user_realName = ?, user_address = ?, user_zipcode = ? where user_name = ?");
		 PreparedStatementSetter setter = new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {	
				ps.setString(1, user.getPassword());
				ps.setString(2, user.getRealName());
				ps.setString(3, user.getAddress());
				ps.setString(4, user.getZipCode());
				ps.setString(5, user.getUserName());
			}
		};
		getJdbcTemplate().update(sql.toString(), setter);
	}

	//改密码
	public void updatePassword(final String userName, final String password) {
		StringBuffer sql=new StringBuffer();
		 sql.append("update house_user set user_password = ? where user_name = ?");
		 PreparedStatementSetter setter = new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {	
				ps.setString(1, password);
				ps.setString(2, userName);
			}
		};
		getJdbcTemplate().update(sql.toString(), setter);
	}

	@Override
	public User getManagerByUserName(String userName) {
		StringBuilder querySql=new StringBuilder ();
    	querySql.append("select * from house_user user");
		querySql.append(" where user.user_name = ? and (user.user_type = 'manager' or user.user_type = 'admin')");
    	Object[] params=new Object[]{userName};
    	List<User> list= this.getJdbcTemplate().query(querySql.toString(), params, new RowMapper<User>() {
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setId(rs.getInt("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setEmail(rs.getString("user_emial"));
				user.setPassword(rs.getString("user_password"));
				user.setRealName(rs.getString("user_realname"));
				user.setAddress(rs.getString("user_address"));
				user.setZipCode(rs.getString("user_zipcode"));
				user.setType(rs.getString("user_type"));
				return user;
			}
    	});
    	if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	public List<User> getAllUser() {
		StringBuilder querySql=new StringBuilder ();
    	querySql.append("select * from house_user user");
		querySql.append(" where user.user_type = 'normal' or user.user_type = 'manager'");
    	Object[] params=new Object[]{};
    	List<User> list= this.getJdbcTemplate().query(querySql.toString(), params, new RowMapper<User>() {
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setId(rs.getInt("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setEmail(rs.getString("user_emial"));
				user.setPassword(rs.getString("user_password"));
				user.setRealName(rs.getString("user_realname"));
				user.setAddress(rs.getString("user_address"));
				user.setZipCode(rs.getString("user_zipcode"));
				user.setType(rs.getString("user_type"));
				return user;
			}
    	});
    	if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	public void saveManager(final String managerName, final String managerPassword) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		getJdbcTemplate().update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				StringBuffer sql = new StringBuffer();
				sql.append("insert into house_user (user_name, user_password, user_type) values (?,?,'manager')");
				PreparedStatement ps = con.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, managerName);
				ps.setString(2, managerPassword);
				return ps;
			}
		}, keyHolder);
	}
}
