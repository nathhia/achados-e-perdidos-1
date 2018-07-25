package view;

import javafx.scene.control.TextField;
import java.io.IOException;

import classes.Item;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class TelaCadastroItemPerdidoController {private Main main;

@FXML private TextField tfTipo;
@FXML private TextField tfCor;
@FXML private TextField tfQuantidade;
@FXML private TextField tfDescricao;
@FXML private Button btCadastrar;
@FXML private Button btVoltar;

public void initialize(){
	this.main = Main.getInstancia();
	this.btCadastrar.setOnAction(e ->{
		
		Item item = new Item();
		item.setTipo(tfTipo.getText());
		item.setCor(tfCor.getText());
		item.setQuantidade(Integer.parseInt(tfQuantidade.getText()));
		item.setDescricao(tfDescricao.getText());
		item.cadastrarItem(item);
		
		Alert alert = new Alert(AlertType.ERROR);
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
		root = (Parent) FXMLLoader.load(getClass().getResource("/view/TelaCadastro.fxml"));
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
