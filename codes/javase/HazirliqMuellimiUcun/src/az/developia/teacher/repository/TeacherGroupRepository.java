package az.developia.teacher.repository;

import java.sql.Connection;
import java.sql.DriverManager;
 
import java.sql.ResultSet;
import java.sql.Statement;

 
 
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
 
 
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

 
import java.sql.Statement;

import az.developia.teacher.Constants;
import az.developia.teacher.entity.TeacherEntity;
 
import az.developia.teacher.entity.TeacherGroupEntity;
import az.developia.teacher.exception.OurRuntimeException;

public class TeacherGroupRepository {
 

// Namiq yazdi	
	public TeacherGroupEntity findById(Integer id) throws OurRuntimeException {
		TeacherGroupEntity entity = new TeacherGroupEntity();

		
		try {

			Connection conn = DriverManager.getConnection(
					Constants.url,Constants.username , Constants.password);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM teacher_groups where id = " + id + "");

			if (rs.next()) {
				entity.setId(rs.getInt("id"));
				entity.setName(rs.getString("name"));
				entity.setRegisterDate(rs.getTimestamp("register_date").toLocalDateTime());
				entity.setPaymentDay(rs.getInt("payment_day"));
			}

			conn.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		
		if (entity.getId() == null) {
			throw new OurRuntimeException("Id-si " + id + " olan qrup tapilmadi");
		}

		return entity;
	}

// Saleh yazdi
	public void add(TeacherGroupEntity group) throws OurRuntimeException {

		String query = "INSERT INTO teacher_groups (name, teacher_id, register_date, payment_day) values " + "('"
				+ group.getName() + "','" + group.getTeacherId() + "','" + group.getRegisterDate() + "','"
				+ group.getPaymentDay() + "');";

		try {
 
			Connection connection = DriverManager
					.getConnection( Constants.url,Constants.username , Constants.password );
 
		 
			Statement st = connection.createStatement();
			st.executeUpdate(query);

			connection.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
 
 

		 
			
			public ArrayList<TeacherGroupEntity> findAllGroups(Integer teacherId) {
				ArrayList<TeacherGroupEntity> entities = new ArrayList<TeacherGroupEntity>();
				
				
				try {
					Connection conn=DriverManager.getConnection(Constants.url,Constants.username , Constants.password );
					Statement st =conn.createStatement();
					ResultSet rs=st.executeQuery("SELECT * FROM teacher_groups where teacher_id ="+teacherId);
					
					while(rs.next()) {
						TeacherGroupEntity entity = new TeacherGroupEntity();
			 
					entity.setId(rs.getInt("id"));
					entity.setName(rs.getString("name"));
					entity.setTeacherId(rs.getInt("teacher_id"));
					entity.setRegisterDate(rs.getTimestamp("register_date").toLocalDateTime());
					entity.setPaymentDay(rs.getInt("payment_day"));					
					entities.add(entity);
					
				}
			
					conn.close();
				}catch (Exception e) {
					System.out.println(e.getMessage());
					
				}
				return entities;
		
			}
 
  
		public void deleteById(Integer id) {
			String query = "delete from teacher_groups where id = " + id;
			try {
				Connection connect = DriverManager.getConnection(Constants.url,Constants.username , Constants.password );
				Statement state = connect.createStatement();
				state.executeUpdate(query);

				connect.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());

			}

		}
 
 
	}
