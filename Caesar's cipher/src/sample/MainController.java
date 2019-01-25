package sample;

import com.jfoenix.controls.JFXButton;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextArea;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MainController {

    String textFromFile = "";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane contentPane;

    @FXML
    private ImageView image;

    @FXML
    private TextField keyTextField;

    @FXML
    private JFXTextArea editedTextArea;

    @FXML
    private JFXButton decryptButton;

    @FXML
    private JFXButton cryptButton;

    @FXML
    private JFXButton chooseFileButton;

    @FXML
    private JFXTextArea enterTextArea;

    @FXML
    void chooseFileButton(MouseEvent event) {
        Stage stage = (Stage)this.contentPane.getScene().getWindow();

        final FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose File To Crypt");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")  + "/Documents"));

        setExtFilters(fileChooser);
        File fileName = fileChooser.showOpenDialog(stage);
        if (fileName != null) {
            try {
                BufferedReader read = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.US_ASCII));
                String forTime;
                while((forTime = read.readLine()) != null){
                    textFromFile += forTime;
                }
                read.close();
                if (textFromFile != null || !textFromFile.isEmpty()) enterTextArea.setText(textFromFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void setExtFilters(FileChooser chooser){
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Files", "*.*"),
                new FileChooser.ExtensionFilter("TXT", "*.txt"),
                new FileChooser.ExtensionFilter("DOC", "*.doc"),
                new FileChooser.ExtensionFilter("DOCX", "*.docx")
        );
    }

    @FXML
    void cryptButton(MouseEvent event) throws NullPointerException{
        Crypt crypt = new Crypt();

        if ((textFromFile != null && !textFromFile.isEmpty()) && (enterTextArea.getText() != null && !enterTextArea.getText().isEmpty()) ){
            if (!keyTextField.getText().isEmpty()) editedTextArea.setText(crypt.crypt(Integer.parseInt(keyTextField.getText()), enterTextArea.getText()));
        }
        else if ((textFromFile.isEmpty()) && (!enterTextArea.getText().isEmpty())){
            if (!keyTextField.getText().isEmpty()) editedTextArea.setText(crypt.crypt(Integer.parseInt(keyTextField.getText()), enterTextArea.getText()));
        }
        else if((textFromFile != null && !textFromFile.isEmpty()) && (enterTextArea.getText() == null && enterTextArea.getText().isEmpty())){
            if (!keyTextField.getText().isEmpty()) editedTextArea.setText(crypt.crypt(Integer.parseInt(keyTextField.getText()), textFromFile));
        }
    }

    @FXML
    void decryptButton(MouseEvent event) {
        Decrypt decrypt = new Decrypt();

        if ((textFromFile != null && !textFromFile.isEmpty()) && (enterTextArea.getText() != null && !enterTextArea.getText().isEmpty()) ){
            if (!keyTextField.getText().isEmpty()) editedTextArea.setText(decrypt.decrypt(Integer.parseInt(keyTextField.getText()), enterTextArea.getText()));
        }
        else if ((textFromFile.isEmpty()) && (!enterTextArea.getText().isEmpty())){
            if (!keyTextField.getText().isEmpty()) editedTextArea.setText(decrypt.decrypt(Integer.parseInt(keyTextField.getText()), enterTextArea.getText()));
        }
        else if((textFromFile != null && !textFromFile.isEmpty()) && (enterTextArea.getText() == null && enterTextArea.getText().isEmpty())){
            if (!keyTextField.getText().isEmpty()) editedTextArea.setText(decrypt.decrypt(Integer.parseInt(keyTextField.getText()), textFromFile));
        }
    }

    @FXML
    void initialize() {
        assert contentPane != null : "fx:id=\"contentPane\" was not injected: check your FXML file 'mainUI.fxml'.";
        assert image != null : "fx:id=\"image\" was not injected: check your FXML file 'mainUI.fxml'.";
        assert keyTextField != null : "fx:id=\"keyTextField\" was not injected: check your FXML file 'mainUI.fxml'.";
        assert editedTextArea != null : "fx:id=\"editedTextArea\" was not injected: check your FXML file 'mainUI.fxml'.";
        assert decryptButton != null : "fx:id=\"decryptButton\" was not injected: check your FXML file 'mainUI.fxml'.";
        assert cryptButton != null : "fx:id=\"cryptButton\" was not injected: check your FXML file 'mainUI.fxml'.";
        assert chooseFileButton != null : "fx:id=\"chooseFileButton\" was not injected: check your FXML file 'mainUI.fxml'.";
        assert enterTextArea != null : "fx:id=\"enterTextArea\" was not injected: check your FXML file 'mainUI.fxml'.";

        image.fitWidthProperty().bind(contentPane.widthProperty());
        image.fitHeightProperty().bind(contentPane.heightProperty());
    }


}
