package student;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import application.DbConnect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class StudentController implements Initializable {
	@FXML
	private Parent root;
	@FXML
	private Stage stage = new Stage();
	@FXML
	private Scene scene;
	@FXML
	private Button menuButton,addStudentButton,editStudentButton,deleteStudentButton;
	@FXML
	private TableView<Student> studentTable;
	@FXML
	private TableColumn<Student,String> nameCol,surnameCol,cityCol;
	@FXML
	private TableColumn<Student,Date> dobCol;
	@FXML
	private TableColumn<Student,Integer> idCol;
	
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private ObservableList<Student> studentList = FXCollections.observableArrayList();
	public Student student;
	
	public void viewMenu(ActionEvent e) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Main.fxml"));
		try {
			root = loader.load();
			stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void getStudentData() {
		studentList.clear();
		try {
			ps = connection.prepareStatement("SELECT * FROM `student`");
			rs = ps.executeQuery();
			while(rs.next()) {
				studentList.add(new Student (
						rs.getInt("idStudent"),
						rs.getString("name"),
						rs.getString("surname"),
						rs.getDate("dob"),
						rs.getString("address")));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		studentTable.setItems(studentList);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			loadData();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void loadData() throws SQLException {
		connection = DbConnect.getConnect();
		getStudentData();
		idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
		nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
		surnameCol.setCellValueFactory(new PropertyValueFactory<>("surname"));
		dobCol.setCellValueFactory(new PropertyValueFactory<>("dob"));
		cityCol.setCellValueFactory(new PropertyValueFactory<>("city"));	
	}
	
	public void addStudent() {
		try {
			root = FXMLLoader.load(getClass().getResource("/student/addStudentView.fxml"));
			scene = new Scene(root,460,600);
			stage.setScene(scene);
			stage.show();
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void editStudent() {
		student = studentTable.getSelectionModel().getSelectedItem();
		FXMLLoader loader = new FXMLLoader();		
		loader.setLocation(getClass().getResource("/student/addStudentView.fxml"));
		try {
			loader.load();
			Parent parent = loader.getRoot();
			scene = new Scene(parent,460,600);
			stage.setScene(scene);
			stage.show();
			
			AddStudentController sc = loader.getController();
			sc.student=student;
			sc.update=true;
			sc.nameField.setText(student.name);
			sc.surnameField.setText(student.surname);
			sc.cityField.setText(student.city);
			sc.dobField.setValue(student.dob.toLocalDate());
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void deleteStudent() {
		student = studentTable.getSelectionModel().getSelectedItem();
		int index=student.getId();
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setContentText("Are you sure to delete Student "+student.getName()+" "+student.getSurname()+"?");
		if(alert.showAndWait().get()==ButtonType.OK) {
			DbConnect.deleteStudent(index);
			try {
				loadData();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
