package gui.layout;

import gui.label.AdditionalLabel;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import time.Stopwatch;

public class StopwatchLayout extends TimeLayout {

    //Flag yang digunakan untuk memeriksa jika stopwatch dipause
    private boolean isPaused = false;

    public StopwatchLayout() {
        super(new Stopwatch());

        //Nilai default pada label adalah 0
        secondLabel.setTime(0);
        minuteLabel.setTime(0);
        hourLabel.setTime(0);

        //Layout bagian atas
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

        //Tombol start
        Button startButton = new Button("Start");
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
        Button resetButton = new Button("Reset");
        resetButton.setMinWidth(100);
        resetButton.setOnMouseClicked(
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        isPaused = false;
                        startButton.setText("Start");
                        timeline.stop();
                        time.setTime(0);
                        updateTime(0, 0, 0);
                    }
                }
        );

        //Layout untuk tombol
        HBox buttonLayout = new HBox(10);
        buttonLayout.setAlignment(Pos.CENTER);
        buttonLayout.getChildren().addAll(startButton, resetButton);

        getChildren().addAll(timeLayout, buttonLayout);
    }



}
