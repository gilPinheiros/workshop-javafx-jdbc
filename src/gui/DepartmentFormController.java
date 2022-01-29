package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DepartmentFormController implements Initializable{
    

    @FXML
    private Button btCancel;

    @FXML
    private Button btSave;

    @FXML
    private Label lblErroName;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;
    
    public void onBtSaveAction() {
    	System.out.println("Salvando dados");
    }
    
    public void onBtCancelAction() {
    	System.out.println("Cancelando ações dos dados");
    }
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {

		initializeNode();
		
	}
	
	public void initializeNode() {
		Constraints.setTextFieldInteger(txtId);
		Constraints.setTextFieldMaxLength(txtName, 30);
	}

}
