package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Department;

public class DepartmentFormController implements Initializable{
    
    private Department entity;
    
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
    
    public void setDepartment(Department entity) {
    	this.entity = entity;
    }
    
    
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
	
	public void updateFormDate() {
		if(entity == null) {
			throw new IllegalStateException("Entity was null");
		}
		txtId.setText(String.valueOf(entity.getId()));
		txtName.setText(entity.getName());
	}

}
