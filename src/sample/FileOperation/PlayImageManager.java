package sample.FileOperation;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PlayImageManager
{

    @FXML
    public ImageView imageView;

    public void setImage(Image image)
    {
        imageView.setImage(image);
    }
}
