package sample;

import javafx.scene.image.Image;

import java.io.File;
import java.net.MalformedURLException;

public class ImageFile extends FileInfo
{
    int width;
    int heigth;

    public void readFile(File file) throws MalformedURLException, InterruptedException {


        this.file = file;
        filename = file.getName();
        filepath = file.getPath();
        length = file.length();

        Image image = new Image(file.toURI().toString());

        width = (int)image.getWidth();
        heigth = (int)image.getHeight();


    }

    public String sendFileInfo()
    {
        return "Путь: " + filepath + "\nИмя: " + filename + "\nРазмер: " + Long.toString(length) + "\nКол-во пикселей: " + Integer.toString(width * heigth);
    }

    public Image sendImage()
    {
        return new Image(file.toURI().toString());
    }

}
