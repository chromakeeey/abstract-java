package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;

public class TextFile extends FileInfo
{
    public int charcount;
    public int linecount;

    public String sendFileInfo()
    {
        return "Путь: " + filepath + "\nИмя: " + filename + "\nРазмер: " + Long.toString(length) + "\nКол-во символов: " + Integer.toString(charcount)
                + "\nКол-во строк: " + Integer.toString(linecount);
    }

    public String sendStringFile() throws IOException {
        String value = "";
        String line;

        BufferedReader reader = new BufferedReader(new FileReader(file));

        if (file != null)
        {
            while((line = reader.readLine()) != null)
            {
                value += line + "\n";
            }
        }

        return value;
    }

    public void readFile(File file) throws IOException
    {
        this.file = file;
        filename = file.getName();
        filepath = file.getPath();
        length = file.length();

        int count = 0;
        int _linecount = 0;
        String line;

        BufferedReader reader = new BufferedReader(new FileReader(file));

        while((line = reader.readLine()) != null)
        {
            count += line.length();
            _linecount ++;
        }

        charcount = count;
        linecount = _linecount;
    }
}
