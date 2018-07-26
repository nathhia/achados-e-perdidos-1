package view;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application{
	
private static Main instancia;

	
	public static Main getInstancia(){
		if(instancia == null){
			instancia = new Main();
		}
		return instancia;
	}
	private Stage palcoPrincipal;
	private Pane rootScene;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		instancia = this;
		this.palcoPrincipal = primaryStage;
		this.palcoPrincipal.setResizable(false);
		this.palcoPrincipal.setTitle("Achados e perdidos - BetaVersion");
		this.rootScene = new Pane();
		
		Scene scene = new Scene(this.rootScene,800,600);
		this.palcoPrincipal.setScene(scene);
		this.palcoPrincipal.show();
		
		this.openTelaInicial();
	}
	private void openTelaInicial(){
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/view/TelaInicial.fxml"));
			Pane pane = (Pane) loader.load();
			
			this.rootScene.getChildren().add(pane);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public void changeStage(Stage stage){
		this.palcoPrincipal = stage;
	}
	public Stage getPalcoPrincipal(){
		return this.palcoPrincipal;
	}
	public Pane getRootScene(){
		return this.rootScene;
	}

}
