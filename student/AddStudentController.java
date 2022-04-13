package student;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import application.DbConnect;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class AddStudentController {
	@FXML
	public TextField nameField = new TextField(),surnameField = new TextField(),cityField = new TextField();
	@FXML
	public DatePicker dobField = new DatePicker();
	@FXML
	private Button addButton;
	
	private Connection connection;
	
	public Student student;
	public boolean update=false;
	private String name,surname,city;
	private Date dob;
	
	public void addStudent(ActionEvent e) {
		try {
			connection = DbConnect.getConnect();
			name=nameField.getText();
			surname=surnameField.getText();
			city=cityField.getText();
			dob=Date.valueOf(dobField.getValue());
			if(!update)
				DbConnect.insertIntoStudent(new Student(name,surname,dob,city));
			else {
				DbConnect.updateStudent(new Student(student.id,name,surname,dob,city));
				update = false;
			}
			connection.close();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
