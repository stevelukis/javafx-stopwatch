package gui.layout;

import gui.util.CustomRunnable;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;

/**
 * Layout untuk input parameter pada countdown
 *
 * @author Steve Lukis - D42116006
 */
public class CountdownInputLayout extends VBox {

    private TextField hourField = new TextField();
    private TextField minuteField = new TextField();
    private TextField secondField = new TextField();

    private Button submitButton = new Button("Submit");

    private Label wrongInputLabel = new Label("Wrong input!");

    public CountdownInputLayout() {
        super(10);
        setAlignment(Pos.CENTER);

        hourField.setPromptText("hour");
        hourField.setMaxWidth(180);

        minuteField.setPromptText("minute");
        minuteField.setMaxWidth(180);

        secondField.setPromptText("second");
        secondField.setMaxWidth(180);

        wrongInputLabel.setTextFill(Paint.valueOf("red"));
        wrongInputLabel.setVisible(false);

        submitButton.setMaxWidth(180);

        getChildren().addAll(
                hourField,
                minuteField,
                secondField,
                submitButton,
                wrongInputLabel
        );
    }

    //To connect two layout
    public void setOnSubmitButtonClicked(CustomRunnable<Integer> runnable) {
        submitButton.setOnMouseClicked(
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        int hour, minute, second;
                        try {
                            hour = Integer.parseInt(hourField.getText());
                            minute = Integer.parseInt(minuteField.getText());
                            second = Integer.parseInt(secondField.getText());

                            if (second >= 60 || minute >= 60) {
                                throw new NumberFormatException();
                            }

                            runnable.run(hour, minute, second);
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                            wrongInputLabel.setVisible(true);
                        }
                    }
                }
        );
    }
}
