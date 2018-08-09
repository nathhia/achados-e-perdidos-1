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

public class TelaCadastroAlunoController {
	
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


			File arquivo = new File("contAluno.bin");
			File arquivo2 = new File("alunos.json");
			
			Integer contAluno = 0;
			Aluno alunoTemp = new Aluno();
			Aluno aluno = new Aluno();
			Gson gson = new Gson();
			String json;
			
			
			try( FileReader fr = new FileReader(arquivo) ){
				
				contAluno = fr.read();
			
			}catch(IOException ex){
			  ex.printStackTrace();
			}
			
					
			alunoTemp.setNome(tfNome.getText());
			alunoTemp.setEmail(tfEmail.getText());
			alunoTemp.setCpf(tfCPF.getText());
			alunoTemp.setTelefone(tfTelefone.getText());
			alunoTemp.setLogin(tfLogin.getText());
			alunoTemp.setSenha(pfSenha.getText());
			alunoTemp.setId(contAluno);
			aluno.cadastrarAluno(alunoTemp);
			json = gson.toJson(aluno);
			contAluno++;
			
			
			
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
			    fw.write(contAluno);
			   
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
	

	
	//mascara do campo cpf cadastro aluno aceitar apenas numeros
			@FXML
			public void tfCPFAlunoKeyReleased() {
				TextFieldFormatter tff = new TextFieldFormatter();
				tff.setMask("###.###.###-##");
				tff.setCaracteresValidos("0123456789");
				tff.setTf(tfCPF);
				tff.formatter();
			}
			
	//mascara do campo telefone cadastro ADM aceitar apenas numeros
			@FXML
			public void tfTelefoneAlunoKeyReleased() {
				TextFieldFormatter tff = new TextFieldFormatter();
				tff.setMask("(##)#####-####");
				tff.setCaracteresValidos("0123456789");
				tff.setTf(tfTelefone);
				tff.formatter();
			}

}
