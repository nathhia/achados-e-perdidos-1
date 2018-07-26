package view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

public class TelaCadastroController {
	private Main main;
	@FXML private Button btItemAchado;
	@FXML private Button btItemPerdido;
	@FXML private Button btVoltar;
	
	public void initialize(){
		this.main = Main.getInstancia();	
			this.btItemPerdido.setOnAction(e2 -> {
				main = Main.getInstancia();
				 Stage stage;
				 Parent root;
				 
				 try{
					 
					 stage=(Stage) btItemPerdido.getScene().getWindow();
					 root = (Parent) FXMLLoader.load(getClass().getResource("/view/TelaCadastroItemPerdido.fxml"));
					 Scene scene = new Scene(root);
					 stage = main.getPalcoPrincipal();
					 stage.setScene(scene);
					 main.changeStage(stage);
				 }catch(IOException e3){
					 e3.printStackTrace(); 
				 }
				
			});
			this.btItemAchado.setOnAction(e -> {
				main = Main.getInstancia();
				Stage stage;
				Parent root;
				try {
					
					stage=(Stage) btItemAchado.getScene().getWindow();
					root = (Parent) FXMLLoader.load(getClass().getResource("/view/TelaCadastroItemAchado.fxml"));
					Scene scene = new Scene(root);
					stage = main.getPalcoPrincipal();
					stage.setScene(scene);
					main.changeStage(stage);
				}catch(IOException e1) {
					e1.printStackTrace();
				}
			});
			this.btVoltar.setOnAction(e4 ->{
				Stage stage;
				Parent root;
			try {
				root = (Parent) FXMLLoader.load(getClass().getResource("/view/TelaInicial.fxml"));
				Scene scene = new Scene(root);
				stage = main.getPalcoPrincipal();
				stage.setScene(scene);
				main.changeStage(stage);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
				
			});
			
			
	}
	

}
