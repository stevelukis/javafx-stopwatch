package gui.label;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class AdditionalLabel extends Label {

    public AdditionalLabel(String text) {
        super(text);
        setFont(new Font("Arial", 18));
        setAlignment(Pos.BOTTOM_CENTER);
    }
}
