package az.developia.teacher.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import az.developia.teacher.Constants;
import az.developia.teacher.entity.GroupScheduleEntity;

import az.developia.teacher.exception.OurRuntimeException;

public class GroupScheduleRepository {
	public void addSchedules(GroupScheduleEntity groupSchedule) {
		String query = "INSERT INTO group_schedules " + "(group_id,day,hour) values " + "("
				+ groupSchedule.getGroupId() + "," + groupSchedule.getDay() + ",'" + groupSchedule.getHour()
				+ "')";

		try {
			Connection connect = DriverManager.getConnection(Constants.url,Constants.username , Constants.password );
			Statement state = connect.createStatement();
			state.executeUpdate(query);

			connect.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());

  
}
		
	}}
