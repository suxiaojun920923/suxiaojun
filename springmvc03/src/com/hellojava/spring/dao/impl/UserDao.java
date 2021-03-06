package com.hellojava.spring.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.hellojava.spring.dao.IUserDao;
import com.hellojava.spring.entity.User;

@Repository("userDao")
public class UserDao extends JdbcDaoSupport implements IUserDao{
	@Autowired
	public void init(DataSource dataSource) {
		setDataSource(dataSource);
	}
	
	public UserDao() {
		System.out.println("userDao");
	}
	
	@Override
	public User loadUser(User user) {
		String sql="select * from users where userName=? and userPwd=?";
		return this.getJdbcTemplate().query(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement psment=conn.prepareStatement(sql);
				psment.setString(1, user.getUserName());
				psment.setString(2, user.getUserPwd());
				return psment;
			}
		}, new ResultSetExtractor<User>() {

			@Override
			public User extractData(ResultSet rs) throws SQLException, DataAccessException {
				User u=null;
				if(rs.next()) {
					u=new User();
					u.setUserId(rs.getInt("userId"));
					u.setUserName(rs.getString("userName"));
					u.setUserPwd(rs.getString("userPwd"));
				}
				return u;
			}
		});
	}
}
