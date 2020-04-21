package sample.FileOperation;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class ReadTextManager
{

    @FXML public TextArea textArea;

    public void setText(String value)
    {
        textArea.setText(value);
    }
}
