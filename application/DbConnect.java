package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import student.Student;

public class DbConnect {
	private static String HOST = "127.0.0.1";
	private static int PORT = 3306;
	private static String DB_NAME = "school";
	private static String USERNAME = "root";
	private static String PASSWORD = "";
	private static Connection connection;
	
	public static Connection getConnect() {
		try {
			return connection = DriverManager.getConnection(String.format("jdbc:mysql://%s:%d/%s", HOST,PORT,DB_NAME),USERNAME,PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static void insertIntoStudent(Student s) {
		connection = getConnect();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("INSERT INTO `student` VALUES(null,?,?,?,?)");
			ps.setString(1, s.getName());
			ps.setString(2,s.getSurname());
			ps.setDate(3, s.getDob());
			ps.setString(4, s.getCity());
			ps.execute();
			connection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}	
	}

	public static void updateStudent(Student s) {
		connection=getConnect();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("UPDATE `student` SET `name` = ?, `surname` = ?, `dob`= ?, `address` = ? WHERE `student`.`idStudent` = ?");
			System.out.println(s.getId());
			ps.setString(1,s.getName());
			ps.setString(2,s.getSurname());
			ps.setDate(3, s.getDob());
			ps.setString(4, s.getCity());
			ps.setInt(5, s.getId());
			ps.execute();
			connection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public static void deleteStudent(int index) {
		connection=getConnect();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("DELETE FROM `student` WHERE `student`.`idStudent` = ?");
			ps.setInt(1, index);
			ps.execute();
			connection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
}
