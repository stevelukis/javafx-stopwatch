package gui.label;

import javafx.scene.control.Label;
import javafx.scene.text.Font;

//Membuat child dari label
public class TimeLabel extends Label {

    public TimeLabel() {
        super();
        setFont(new Font("Arial", 100));
    }

    public void setTime(int time) {
        if (time == 0) {
            setText("00");
        } else if (time < 10) {
            setText("0" + Long.toString(time));
        } else {
            setText(Long.toString(time));
        }
    }
}
