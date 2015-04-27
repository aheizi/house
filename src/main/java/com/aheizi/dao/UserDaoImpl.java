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

import com.aheizi.bean.User;

public class UserDaoImpl extends BaseDao implements UserDao{
	
	//新增用户
	public void saveUser(final User user) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		getJdbcTemplate().update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				StringBuffer sql = new StringBuffer();
				sql.append("insert into house_user (user_id, user_name, user_password, user_emial, user_type) values (?,?,?,?,?)");
				PreparedStatement ps = con.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1, user.getId());
				ps.setString(2, user.getUserName());
				ps.setString(3, user.getPassword());
				ps.setString(4, user.getEmail());
				ps.setString(5, user.getType());
				return ps;
			}
		}, keyHolder);
		user.setId(keyHolder.getKey().intValue());
	}

	//查找用户 通过用户名
	public User getUserByUserName(String userName) {
		StringBuilder querySql=new StringBuilder ();
    	querySql.append("select * from house_user user");
		querySql.append(" where user.user_name = ?");
    	Object[] params=new Object[]{userName};
    	List<User> list= this.getJdbcTemplate().query(querySql.toString(), params, new RowMapper<User>() {
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setId(rs.getInt("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setEmail(rs.getString("user_emial"));
				user.setPassword(rs.getString("user_password"));
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
}
