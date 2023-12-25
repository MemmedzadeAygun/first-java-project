package az.developia.teacher.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import az.developia.teacher.entity.TeacherEntity;
import az.developia.teacher.exception.OurRuntimeException;

public class TeacherRepository {

	public void add(TeacherEntity teacher) throws OurRuntimeException {
		if (teacher.getName().length() > 50) {
			throw new OurRuntimeException("ad max 50 simvol ola biler");
		}

		if (teacher.getSurname().length() > 50) {
			throw new OurRuntimeException("soyad max 50 simvol ola biler");
		}

		String query = "INSERT INTO teachers " + "(name,surname,phone,address,username,password,register_date) values "
				+ "('" + teacher.getName() + "','" + teacher.getSurname() + "','" + teacher.getPhone() + "','"
				+ teacher.getAddress() + "','" + teacher.getUsername() + "','" + teacher.getPassword() + "','"
				+ teacher.getRegisterDate() + "');";
		try {

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java13_teacher?useSSL=false&serverTimezone=UTC",
					"root", "2004");
			Statement st = conn.createStatement();

			st.executeUpdate(query);

			conn.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public boolean checkUsernameIfExists(String username) {

		boolean exists = false;

		try {

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java13_teacher?useSSL=false&serverTimezone=UTC",
					"root", "2004");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT count(*) FROM  teachers  where username='" + username + "';");

			rs.next();
			exists = rs.getInt(1) == 1 ? true : false;

			conn.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return exists;
	}

	public boolean checkUserIfExists(String username, String password) {

		boolean exists = false;

		try {

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java13_teacher?useSSL=false&serverTimezone=UTC",
					"root", "2004");
			Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery("SELECT count(*)  FROM  teachers  where username='" + username
					+ "' and password='" + password + "' ;");

			rs.next();
			exists = rs.getInt(1) == 1 ? true : false;

			conn.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return exists;
	}

	// 22
	public TeacherEntity findById(Integer id) {

		TeacherEntity entity = new TeacherEntity();

		try {

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java13_teacher?useSSL=false&serverTimezone=UTC",
					"root", "2004");
			Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery("SELECT * FROM  teachers where id=" + id + "");

			if (rs.next()) {
				entity.setId(rs.getInt("id"));
				entity.setName(rs.getString("name"));
				entity.setSurname(rs.getString("surname"));
				entity.setPhone(rs.getString("phone"));
				entity.setAddress(rs.getString("address"));
				entity.setUsername(rs.getString("username"));
				entity.setPassword(rs.getString("password"));
			} else {

			}

			conn.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		if (entity.getId() == null) {
			throw new OurRuntimeException("muellim tapilmadi, id = " + id);
		}
		return entity;
	}

	public ArrayList<TeacherEntity> findAll() {

		ArrayList<TeacherEntity> entities = new ArrayList<>();

		try {

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java13_teacher?useSSL=false&serverTimezone=UTC",
					"root", "2004");
			Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery("SELECT * FROM  teachers  ");

			while (rs.next()) {
				TeacherEntity entity = new TeacherEntity();
				entity.setId(rs.getInt("id"));
				entity.setName(rs.getString("name"));
				entity.setSurname(rs.getString("surname"));
				entity.setPhone(rs.getString("phone"));
				entity.setAddress(rs.getString("address"));
				entity.setUsername(rs.getString("username"));
				entity.setPassword(rs.getString("password"));
				entity.setRegisterDate(rs.getTimestamp("register_date").toLocalDateTime());
				entities.add(entity);
			}

			conn.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return entities;
	}

	public void deleteById(Integer id) throws OurRuntimeException {

		String query = "delete from teachers where id=" + id;
		try {

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java13_teacher?useSSL=false&serverTimezone=UTC",
					"root", "2004");
			Statement st = conn.createStatement();

			st.executeUpdate(query);

			conn.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}