package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.util.Map;

public class VideoFile extends FileInfo
{
    public Duration duration;

    private String durationToString(javafx.util.Duration time)
    {
        return String.format("%4d:%02d:%04.1f",
                (int) time.toHours(),
                (int) time.toMinutes() % 60,
                time.toSeconds() % 3600);
    }

    public void readFile(File file) throws MalformedURLException, InterruptedException {


        this.file = file;
        filename = file.getName();
        filepath = file.getPath();
        length = file.length();

        Media media = new Media(file.toURI().toURL().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);

        mediaPlayer.setOnReady(new Runnable() {
            @Override
            public void run() {
                duration = media.getDuration();
            }
        });

        duration = media.getDuration();

    }

    public String sendFileInfo()
    {
        return "Путь: " + filepath + "\nИмя: " + filename + "\nРазмер: " + Long.toString(length) + "\nДлительность: " ;
    }

    public MediaPlayer sendMedia() throws MalformedURLException {


        return new MediaPlayer(new Media(file.toURI().toURL().toString()));
    }
}
