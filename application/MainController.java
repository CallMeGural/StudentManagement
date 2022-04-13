package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainController {
	@FXML
	private Parent root;
	@FXML
	private Stage stage;
	@FXML
	private Scene scene;
	@FXML
	private Button studentButton,subjectButton,gradeButton;
	
	public void viewStudents(ActionEvent e) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/student/StudentView.fxml"));
		System.out.println("Student Button pressed!");
	    root = fxmlLoader.load();
	    stage=(Stage)((Node)e.getSource()).getScene().getWindow();
	    scene = new Scene(root);
	    stage.setScene(scene);
	    stage.show();
	}
	public void viewSubjects(ActionEvent e) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/subject/SubjectView.fxml"));
		System.out.println("Subject Button pressed!");
	    root = fxmlLoader.load();
	    stage=(Stage)((Node)e.getSource()).getScene().getWindow();
	    scene = new Scene(root);
	    stage.setScene(scene);
	    stage.show();
	}
	
	
}
