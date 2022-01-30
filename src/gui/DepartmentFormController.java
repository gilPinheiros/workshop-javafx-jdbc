package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import db.DbException;
import gui.listeners.DataChangeListener;
import gui.util.Alerts;
import gui.util.Constraints;
import gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Department;
import model.service.DepartmentService;

public class DepartmentFormController implements Initializable{
    
    private Department entity;
    private DepartmentService service;
    private List<DataChangeListener> dataChangeListener = new ArrayList<>();
    
    
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
    
    public void setDepartmentService(DepartmentService service) {
    	this.service = service;
    }
    
    public void subscribleDataChangeListener(DataChangeListener listener) {
    	dataChangeListener.add(listener);
    }
    
    public void onBtSaveAction(ActionEvent event) {
    	if(entity == null) {
    		throw new IllegalStateException("Entity was null");
    	}
    	if(service == null) {
    		throw new IllegalStateException("Service was null");
    	}
    	try {
	    	entity = getFormData();
	    	service.saveOrUpdate(entity);
	    	notifyDataChangeListeners();
	    	Utils.currentStage(event).close();
    	}
    	catch(DbException e) {
    		Alerts.showAlert("Erro saving object", null, e.getMessage(), AlertType.ERROR);
    	}
    }
    
    private void notifyDataChangeListeners() {
		
    	for(DataChangeListener listener : dataChangeListener) {
    		listener.onDataChanged();
    	}
		
	}

	private Department getFormData() {
		Department obj = new Department();
		
		obj.setId(Utils.tryParseToInt(txtId.getText()));
		obj.setName(txtName.getText());
		
		return obj;
	}

	public void onBtCancelAction(ActionEvent event) {
		Utils.currentStage(event).close();
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
