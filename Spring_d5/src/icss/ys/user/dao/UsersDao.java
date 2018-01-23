package icss.ys.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import icss.ys.user.pojo.Users;
@Repository
public class UsersDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 单个查询 SELECT
	 * @param username
	 * @return
	 */
	public Users queryByUsername(String username){
		StringBuilder sql = new StringBuilder()
				.append("SELECT * ")
				.append("FROM users ")
				.append("WHERE username=?");
		
		return jdbcTemplate.query(sql.toString(),new RowMapper<Users>(){

			@Override
			public Users mapRow(ResultSet rs, int arg1) throws SQLException {
				
				System.out.println(arg1);
				Users u = new Users();
				u.setUsername(rs.getString(1));
				u.setPassword(rs.getString(2));
				return u;
			}
			
		},username).get(0);
	}


	/**
	 * 插入数据 DML
	 */
	public int insertUser(Users user){
		StringBuilder sql = new StringBuilder()
		.append("INSERT INTO users ")
		.append("VALUES(?,?)");
	
		return jdbcTemplate.update(sql.toString(),user.getUsername(),user.getPassword());
	}
	
	
	
	/**
	 * 修改用户
	 */
	public int updateUser(Users user){
		StringBuilder sql = new StringBuilder()
		.append("UPDATE users  ")
		.append("SET password=? ")
		.append("WHERE username=?");
	
		return jdbcTemplate.update(sql.toString(), user.getPassword(),user.getUsername());
	}
	
	/**
	 * 查询所有用户
	 * @param args
	 */
	public List<Users> queryAllUsers(){
		StringBuilder sql = new StringBuilder()
				.append("SELECT *  ")
				.append("FROM users ");
		return jdbcTemplate.query(sql.toString(), new RowMapper<Users>() {

			@Override
			public Users mapRow(ResultSet rs, int arg1) throws SQLException {
				//创建对象
				Users u = new Users();
				u.setUsername(rs.getString(1));
				u.setPassword(rs.getString(2));
				return u;
			}
		});	
	}
}
