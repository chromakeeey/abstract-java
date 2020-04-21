package sample.FileOperation;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class PlayVideoManager
{

    @FXML public MediaView mediaView;

    public void setVideo(MediaPlayer mediaPlayer)
    {
        mediaView.setMediaPlayer(mediaPlayer);

        DoubleProperty mvw = mediaView.fitWidthProperty();
        DoubleProperty mvh = mediaView.fitHeightProperty();
        mvw.bind(Bindings.selectDouble(mediaView.sceneProperty(), "width"));
        mvh.bind(Bindings.selectDouble(mediaView.sceneProperty(), "height"));

        mediaPlayer.setVolume(0.1);
        mediaPlayer.play();
    }
}
