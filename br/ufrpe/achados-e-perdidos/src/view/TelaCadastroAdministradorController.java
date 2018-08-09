package view;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.*;


public class TelaCadastroAdministradorController {
	private Main main;

	@FXML private TextField tfNome;
	@FXML private TextField tfEmail;
	@FXML private TextField tfCPF;
	@FXML private TextField tfTelefone;
	@FXML private TextField tfLogin;
	@FXML private PasswordField pfSenha;
	@FXML private Button btCadastrar;
	@FXML private Button btVoltar;
	
	public void initialize(){
		this.main = Main.getInstancia();
		this.btCadastrar.setOnAction(e ->{

			File arquivo = new File("contAdm.bin");
			File arquivo2 = new File("administradores.json");
			
			Integer contAdm = 0;
			Administrador administradorTemp = new Administrador();
			Administrador adm = new Administrador();
			Gson gson = new Gson();
			String json;
			
			
			
			try( FileReader fr = new FileReader(arquivo) ){
				
				contAdm = fr.read();
			
			}catch(IOException ex){
			  ex.printStackTrace();
			}
			
					
			administradorTemp.setNome(tfNome.getText());
			administradorTemp.setEmail(tfEmail.getText());
			administradorTemp.setCpf(tfCPF.getText());
			administradorTemp.setTelefone(tfTelefone.getText());
			administradorTemp.setLogin(tfLogin.getText());
			administradorTemp.setSenha(pfSenha.getText());
			adm.cadastrarAdministrador(administradorTemp);
			json = gson.toJson(adm);
			
			contAdm++;
			
			try{
				
				FileWriter fw1 = new FileWriter(arquivo2, true);
				BufferedWriter bw1 = new BufferedWriter(fw1);
				bw1.write(json);
				bw1.newLine();
				bw1.close();
			    
			}catch(IOException ex){
			  ex.printStackTrace();
			}
			
			try( FileWriter fw = new FileWriter(arquivo) ){
			    fw.write(contAdm);
			   
			    fw.flush();
			 //   fw.close();
			}catch(IOException ex){
			  ex.printStackTrace();
			}
			
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Cadastrado!");
			alert.setHeaderText("Cadastrado com sucesso!");
			alert.setContentText("");
			alert.showAndWait();
			this.retornar();
			
		});
		this.btVoltar.setOnAction(e ->{
			this.retornar();
		});
	}
	
	public void retornar(){
			Stage stage;
			Parent root;
		try {
			root = (Parent) FXMLLoader.load(getClass().getResource("/view/TelaCadastroUsuario.fxml"));
			Scene scene = new Scene(root);
			stage = main.getPalcoPrincipal();
			stage.setScene(scene);
			main.changeStage(stage);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	

}
