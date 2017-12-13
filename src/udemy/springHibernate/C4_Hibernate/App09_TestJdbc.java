package udemy.springHibernate.C4_Hibernate;

import java.sql.Connection;
import java.sql.DriverManager;


public class App09_TestJdbc {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user = "hbstudent";
		String pass = "hbstudent";

		try {
			System.out.println("Connection to database "+jdbcUrl);
			Connection myConnection = DriverManager.getConnection(jdbcUrl,user,pass);
			System.out.println("Connection Successful! "+jdbcUrl);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
