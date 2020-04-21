package sample;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sample.FileOperation.PlayImageManager;
import sample.FileOperation.PlayVideoManager;
import sample.FileOperation.ReadTextManager;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class Controller
{
    @FXML public TextArea areaText;
    @FXML public TextArea videoArea;
    @FXML public TextArea imageArea;
    private Stage stage;



    @FXML public AnchorPane ap;
    private ImageFile imageFile = new ImageFile();
    private VideoFile videoFile = new VideoFile();
    private TextFile textFile = new TextFile();

    public void text_OpenClick(MouseEvent mouseEvent) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FileOperation/ReadTextFXML.fxml"));
        Parent root = loader.load();

        ReadTextManager controller = loader.getController();
        controller.setText(textFile.sendStringFile());

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Second Window");
        stage.show();
    }

    public void video_OpenClick(MouseEvent mouseEvent) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FileOperation/PlayVideoFXML.fxml"));
        Parent root = loader.load();

        PlayVideoManager controller = loader.getController();
        controller.setVideo(videoFile.sendMedia());

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Second Window");
        stage.show();
    }

    public void image_OpenClick(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FileOperation/PlayImageFXML.fxml"));
        Parent root = loader.load();

        PlayImageManager controller = loader.getController();
        controller.setImage(imageFile.sendImage());

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Second Window");
        stage.show();
    }

    public void text_DialogClick(MouseEvent mouseEvent) throws IOException {
        stage = (Stage) ap.getScene().getWindow();

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll( new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null)
        {
            textFile.readFile(selectedFile);
            areaText.setText(textFile.sendFileInfo());
        }
    }

    public void video_DialogClick(MouseEvent mouseEvent) throws MalformedURLException, InterruptedException {
        stage = (Stage) ap.getScene().getWindow();

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll( new FileChooser.ExtensionFilter("MP4 files", "*.mp4"));
        File selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null)
        {
            videoFile.readFile(selectedFile);
            videoArea.setText(videoFile.sendFileInfo());
        }
    }

    public void image_DialogClick(MouseEvent mouseEvent) throws MalformedURLException, InterruptedException {
        stage = (Stage) ap.getScene().getWindow();

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png"),
                new FileChooser.ExtensionFilter("Image Files", "*.jpeg"),
                new FileChooser.ExtensionFilter("Image Files", "*.jpg"));
        File selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null)
        {
            imageFile.readFile(selectedFile);
            imageArea.setText(imageFile.sendFileInfo());
        }
    }


}
