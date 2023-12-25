package az.developia.teacher.entity;
 
import java.time.LocalDateTime;
import java.util.Objects;

import java.time.LocalDateTime;
import java.util.Objects;

public class TeacherGroupEntity {
	
		private Integer id;
		private String name;
		private Integer teacherId;
		private LocalDateTime registerDate;
		private Integer paymentDay;
		
		public TeacherGroupEntity(Integer id, String name, Integer teacherId, LocalDateTime registerDate,
				Integer paymentDay) {
			super();
			this.id = id;
			this.name = name;
			this.teacherId = teacherId;
			this.registerDate = registerDate;
			this.paymentDay = paymentDay;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getTeacherId() {
			return teacherId;
		}

		public void setTeacherId(Integer teacherId) {
			this.teacherId = teacherId;
		}

		public LocalDateTime getRegisterDate() {
			return registerDate;
		}

		public void setRegisterDate(LocalDateTime registerDate) {
			this.registerDate = registerDate;
		}

		public Integer getPaymentDay() {
			return paymentDay;
		}

		public void setPaymentDay(Integer paymentDay) {
			this.paymentDay = paymentDay;
		}

		 public TeacherGroupEntity() {
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "TeacherGroupEntity [id=" + id + ", name=" + name + ", teacherId=" + teacherId + ", registerDate="
					+ registerDate + ", paymentDay=" + paymentDay + "]";
		}

		 
  
}
 