package com.csyang.coding.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.csyang.coding.bean.User;
import com.csyang.coding.util.SqlCacheUtil;

@Component
public class UserService {

	@Autowired
	private JdbcTemplate JdbcTemplate;
	
	public List<User> getAllUser()
	{
		String sql = SqlCacheUtil.getSql("test");
		
		return JdbcTemplate.query(sql, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setId(rs.getLong("id"));
				user.setName(rs.getString("name"));
				return user;
			}
		});
	}
}
