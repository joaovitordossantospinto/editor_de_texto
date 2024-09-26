import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.File;

import java.io.PrintWriter;
import javafx.scene.control.ToolBar;
import javafx.stage.FileChooser;

public class ProjetoEditorDeTextoBasico extends Application{
	@Override
	public void start(Stage palco){
		TextArea areaEditavel = new TextArea();

		Button botaoSalvar = new Button("Salvar");
		botaoSalvar.setOnAction(e -> salvarTexto(areaEditavel));

		ToolBar  barraDeFerramentas = new ToolBar(botaoSalvar);

		BorderPane borderPane = new BorderPane();
		borderPane.setTop(barraDeFerramentas);
		borderPane.setCenter(areaEditavel);

		Scene cena = new Scene(borderPane, 800, 600);
		palco.setTitle("Editor de Texto Básico");
		palco.setScene(cena);
		palco.show();
	}

	private void salvarTexto(TextArea textArea){
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Salvar Arquivo de Texto");
		File file = fileChooser.showSaveDialog(null);
		if (file != null){
			try(PrintWriter writer = new PrintWriter(file)){
				writer.println(textArea.getText());
			} catch (Exception e){
				System.out.println(e.getMessage());
			}
		}
	}
	public static void main (String[] args){
		launch(args);
	}
}