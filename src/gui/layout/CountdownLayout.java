package gui.layout;

import gui.label.AdditionalLabel;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import time.Countdown;
import time.Time;

/**
 * Layout untuk countdown
 * @author Steve Lukis - D42116006
 */
public class CountdownLayout extends TimeLayout {

    //flag jika countdown dipause
    private boolean isPaused = false;
    private Button startButton;
    private Button resetButton;

    //Overloading
    public CountdownLayout() {
        this(10);
    }

    public CountdownLayout(int totalSeconds) {
        super(new Countdown());

        //Layout untuk waktu
        HBox timeLayout = new HBox(10);
        timeLayout.setAlignment(Pos.CENTER);
        timeLayout.getChildren().addAll(
                hourLabel,
                new AdditionalLabel("jam"),
                minuteLabel,
                new AdditionalLabel("menit"),
                secondLabel,
                new AdditionalLabel("detik")
        );

        //Tombol mulai
        startButton = new Button("Start");
        startButton.setMinWidth(100);
        startButton.setOnMouseClicked(
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if (isPaused) {
                            isPaused = false;
                            startButton.setText("Resume");
                            timeline.pause();
                        } else {
                            isPaused = true;
                            startButton.setText("Pause");
                            timeline.play();
                        }
                    }
                }
        );

        //Tombol reset
        resetButton = new Button("Reset");
        resetButton.setMinWidth(100);
        resetButton.setOnMouseClicked(
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        isPaused = false;
                        startButton.setText("Start");
                        startButton.setDisable(false);
                        timeline.stop();
                        time.setTime(totalSeconds);
                        updateTime(time);
                    }
                }
        );

        //Layout untuk tombol
        HBox buttonLayout = new HBox(10);
        buttonLayout.setAlignment(Pos.CENTER);
        buttonLayout.getChildren().addAll(startButton, resetButton);

        getChildren().addAll(timeLayout, buttonLayout);

        time.setTime(totalSeconds);
        updateTime(time);
    }

    //override metode dari kelas parent
    public void updateTime(int hour, int minute, int second) {
        super.updateTime(hour, minute, second);
        if (hour == 0 && minute == 0 && second == 0) {
            startButton.setText("Start");
            startButton.setDisable(true);
            timeline.stop();
        }
    }

    //overload untuk argumen yang berbeda
    public void updateTime(Time time) {
        updateTime(time.getHour(), time.getMinute(), time.getSecond());
    }
}
