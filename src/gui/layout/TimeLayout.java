package gui.layout;

import gui.label.TimeLabel;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import time.Time;

/**
 * Parent layout
 */
public abstract class TimeLayout extends VBox {

    //Label yang akan digunakan untuk menampilkan waktu
    protected TimeLabel secondLabel = new TimeLabel();
    protected TimeLabel minuteLabel = new TimeLabel();
    protected TimeLabel hourLabel = new TimeLabel();

    //Digunakan sebagai timer untuk mengeksekusi perintah setiap waktu
    protected Timeline timeline;

    protected Time time;

    public TimeLayout(Time time) {

        //Mengatur spacing sebesar 10.
        super(10);

        //Mengatur peletakan elemen agar berada di tengah.
        setAlignment(Pos.CENTER);
        this.time = time;
        timeline = new Timeline(

                //Menggunakan anonymous class.
                new KeyFrame(
                        Duration.seconds(1),
                        new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                time.updateTime();
                                updateTime(time);
                            }
                        }
                )
        );

        //Mengatur agar pemanggilan metode program tidak berhenti.
        timeline.setCycleCount(Timeline.INDEFINITE);
    }

    //Update teks pada label.
    public void updateTime(int hour, int minute, int second) {
        secondLabel.setTime(second);
        minuteLabel.setTime(minute);
        hourLabel.setTime(hour);
    }

    //Overriding dengan parameter yang berbeda.
    public void updateTime(Time time) {
        updateTime(time.getHour(), time.getMinute(), time.getSecond());
    }
}
