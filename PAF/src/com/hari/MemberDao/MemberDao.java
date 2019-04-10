package com.hari.MemberDao;
import org.springframework.jdbc.core.JdbcTemplate;
import com.hari.model.*;

public class MemberDao {
private JdbcTemplate jdbcTemplate;

public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	this.jdbcTemplate = jdbcTemplate;
}

public int addMember(Member m){
	String query="INSERT INTO `member`(`mid`, `mname`, `password`, `mtype`) VALUES ('"+m.getId()+"','"+m.getName()+"','"+m.getPassword()+"', '"+m.getType()+"')";

	return jdbcTemplate.update(query);
}
/*
public int updateEmployee(Member e){
	String query="update employee set name='"+e.getName()+"',salary='"+e.getSalary()+"' where id='"+e.getId()+"' ";
	return jdbcTemplate.update(query);
}
public int deleteEmployee(Member e){
	String query="delete from employee where id='"+e.getId()+"' ";
	return jdbcTemplate.update(query);
}
*/
}
