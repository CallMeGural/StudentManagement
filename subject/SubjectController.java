package subject;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class SubjectController implements Initializable{
	@FXML
	private Parent root;
	@FXML
	private Stage stage = new Stage();
	@FXML
	private Scene scene;
	@FXML
	private Button menuButton,addSubjectButton,editSubjectButton,deleteSubjectButton;
	@FXML
	private TableView<Subject> studentTable;
	@FXML
	private TableColumn<Subject,String> nameCol,abbrCol;
	@FXML
	private TableColumn<Subject,Double> realCapCol;
	@FXML
	private TableColumn<Subject,Integer> maxCapCol;
	
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private ObservableList<Subject> subjectList = FXCollections.observableArrayList();
	public Subject subject;
	
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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
}
