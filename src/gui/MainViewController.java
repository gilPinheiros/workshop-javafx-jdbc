package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

public class MainViewController implements Initializable{


    @FXML private MenuItem menuItemAbout;

    @FXML private MenuItem menuItemDepartment;

    @FXML private MenuItem menuItemSeller;
    
    @FXML
    private void onMenuItemSellerAction() {
    	System.out.println("Meu selecionado");
    }
    
    @FXML
    private void onMenuItemDepartmentAction() {
    	System.out.println("Menu Department criado");
    }
    
    @FXML
    private void onMenuItemAboutAction() {
    	System.out.println("Meu About selecionado");
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
     
}
