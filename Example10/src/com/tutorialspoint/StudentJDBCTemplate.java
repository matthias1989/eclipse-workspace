package com.tutorialspoint;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

public class StudentJDBCTemplate implements StudentDAO{
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public void create(String name, Integer age) {
		String SQL = "insert into Student (name, age) values (?, ?)";
		jdbcTemplateObject.update(SQL,new Object[] {name,age});
		System.out.println("Created Record Name = " +name + " Age = " + age);
	}
	
	
	public Student getStudent(Integer id) {
		/*String SQL = "select * from Student where id = ?";
		Student student = jdbcTemplateObject.queryForObject(SQL, new Object[]{id}, new StudentMapper());
		return student;*/
		 SimpleJdbcCall jdbcCall =  new SimpleJdbcCall(dataSource).withProcedureName("getRecord");
		 SqlParameterSource in = new MapSqlParameterSource().addValue("in_id", id);
		 
	     Map<String, Object> out = jdbcCall.execute(in);
	      Student student = new Student();
	      student.setId(id);
	      student.setName((String) out.get("out_name"));
	      student.setAge((Integer) out.get("out_age"));
	      return student;
	}
	
	public List<Student> listStudents(){
		String SQL = "select * from Student";
		List<Student> students = jdbcTemplateObject.query(SQL, new StudentMapper());
		return students;
	}
	
	public void delete(Integer id) {
		String SQL = "delete from Student where id = ?";
		jdbcTemplateObject.update(SQL,new Object[] {id});
		System.out.println("Deleted REcord with ID = " +id);
	}
	
	public void deleteList(Set<Integer> ids) {
		if(ids!= null && ids.size()>0) {
			String SQL = "delete from Student where id IN (";
			
			for(Integer id : ids) {
				SQL += id + ",";
			}
			SQL = SQL.substring(0,SQL.length()-1);
			SQL += ")";
			System.out.println("test:"+SQL);
			jdbcTemplateObject.update(SQL);
		}
	}
	
	public void deleteAll() {
		String SQL = "delete from Student";
		jdbcTemplateObject.update(SQL);
	}
	
	public void update(Integer id, Integer age) {
		String SQL = "update Student set age = ? where id = ?";
		jdbcTemplateObject.update(SQL,age,id);
		System.out.println("Updated Record with ID = " + id);
	}
}
