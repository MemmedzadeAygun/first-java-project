package az.developia.teacher.repository;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import az.developia.teacher.Constants;
import az.developia.teacher.entity.StudentEntity;
import az.developia.teacher.entity.TeacherEntity;
import az.developia.teacher.exception.OurRuntimeException;

public class StudentRepository {
	//Telebenin qeydiyyati..
	
	public void registerStudent(StudentEntity student) {
		
		String query="INSERT INTO students"+ "(name,surname,phone,birthday) values "
		+"('"+student.getName()+"','"+student.getSurname()+"','"
				+student.getPhone()+"','"+student.getBirthday()+"');";
		
		try {
			Connection conn=DriverManager.getConnection(Constants.url, Constants.username, Constants.password);
			
			Statement st=conn.createStatement();
			
			st.executeUpdate(query);
			
			conn.close();
			
		
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
	}
	
	
	
	//id'e gore silinmesi
	public void deleteById(Integer id) throws OurRuntimeException{
		
		String query="delete from students where id="+id;
		
		try {

			Connection conn = DriverManager.getConnection(Constants.url, Constants.username, Constants.password);
			Statement st = conn.createStatement();

			st.executeUpdate(query);

			conn.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	//id'e gore qaytarilmasi
	public StudentEntity findById(Integer id) {
		
		StudentEntity entity=new StudentEntity();
		
		try{Connection conn=DriverManager.getConnection(Constants.url, Constants.username, Constants.password);
		
		Statement st=conn.createStatement();
		
		ResultSet rs=st.executeQuery("SELECT * FROM students where id="+id + " ");
		
		if(rs.next()) {
			entity.setId(rs.getInt("id"));
			entity.setName(rs.getString("name"));
			entity.setSurname(rs.getString("surname"));
			entity.setPhone(rs.getString("phone"));
			entity.setBirthday(rs.getTimestamp("birthday").toLocalDateTime());
		}else {
			
		}
	}catch(Exception e){
		System.out.println(e.getMessage());
	}
		
	if (entity.getId() == null) {
		throw new OurRuntimeException("sagird tapilmadi, id = " + id);
	}
	
		return entity;
	}

	private Timestamp DateTime(Timestamp timestamp) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	//butun telebeleri qaytaran
	public ArrayList<StudentEntity> findAll(){
		ArrayList<StudentEntity> entities= new ArrayList<>();
		
		try {
			Connection conn=DriverManager.getConnection(Constants.url, Constants.username, Constants.password);
			Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery("SELECT * FROM  students  ");
			
			while(rs.next()) {
				StudentEntity entity=new StudentEntity();
				entity.setId(rs.getInt("id"));
				entity.setName(rs.getString("name"));
				entity.setSurname(rs.getString("surname"));
				entity.setPhone(rs.getString("phone"));
				entity.setBirthday(rs.getTimestamp("birthday").toLocalDateTime());
				entities.add(entity);
			}
			
			conn.close();
			
		} catch (Exception e) {
			
		System.out.println(e.getMessage());
		}
		
		return entities;
	}
}
