package com.tutorialspoint;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class StudentJDBCTemplate implements StudentDAO{
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	private PlatformTransactionManager transactionManager;

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	@Override
	public void create(String name, Integer age, Integer marks, Integer year) {
		TransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);
		
		try {
			String SQL1 = "insert into Student (name, age) values (?,?)";
			jdbcTemplateObject.update(SQL1,name,age);
			
			// Get the latest student id to be used in the marks table
			Integer sid  = jdbcTemplateObject.queryForObject("SELECT MAX(ID) FROM Student",Integer.class);
			
			String SQL3 = "insert into Marks(sid,marks,year) values (?,?,?)";
			jdbcTemplateObject.update(SQL3,new Object[] {sid,marks,year});
			
			transactionManager.commit(status);
		}
		catch(DataAccessException ex) {
			System.out.println("Error in creating record, rolling back");
			transactionManager.rollback(status);
			throw ex;
		}
	}

	@Override
	public List<StudentMarks> listStudents() {
		String SQL = "select * from Student,Marks where Student.id=Marks.sid";
		List<StudentMarks> studentMarks = jdbcTemplateObject.query(SQL, new StudentMarksMapper());
		return studentMarks;
	}

}
