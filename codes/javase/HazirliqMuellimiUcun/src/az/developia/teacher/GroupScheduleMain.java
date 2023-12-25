package az.developia.teacher;

import az.developia.teacher.entity.GroupScheduleEntity;
import az.developia.teacher.exception.OurRuntimeException;

public class GroupScheduleMain {

	public static void main(String[] args) {
		try {
			GroupScheduleEntity schedulesEntity = new GroupScheduleEntity(null, 2, 1-3-5);
		} catch (OurRuntimeException e) {
			System.out.println(e.getOurMessage());
		}

	}

	}
