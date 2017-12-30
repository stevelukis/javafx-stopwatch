import gui.layout.AboutLayout;
import gui.layout.CountdownInputLayout;
import gui.layout.CountdownLayout;
import gui.layout.StopwatchLayout;
import gui.util.CustomRunnable;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author Steve Lukis - D42116006
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane layout = new BorderPane();

        Button stopwatchButton = new Button("Stopwatch");
        stopwatchButton.setMinWidth(200);

        Button countdownButton = new Button("Countdown");
        countdownButton.setMinWidth(200);

        stopwatchButton.setOnMouseClicked(
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        layout.setCenter(new StopwatchLayout());
                        stopwatchButton.setDisable(true);
                        countdownButton.setDisable(false);
                    }
                }
        );

        countdownButton.setOnMouseClicked(
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        CountdownInputLayout countdownInputLayout = new CountdownInputLayout();
                        countdownInputLayout.setOnSubmitButtonClicked(
                                new CustomRunnable<Integer>() {
                                    @Override
                                    public void run(Integer... params) {
                                        layout.setCenter(new CountdownLayout(
                                                params[0] * 3600 + params[1] * 60 + params[2]
                                        ));
                                    }
                                }
                        );
                        layout.setCenter(countdownInputLayout);

                        stopwatchButton.setDisable(false);
                        countdownButton.setDisable(true);
                    }
                });

        VBox menuLayout = new VBox(10);
        menuLayout.setPadding(new Insets(10));
        menuLayout.setAlignment(Pos.CENTER);
        menuLayout.getChildren().addAll(
                stopwatchButton,
                countdownButton
        );

        layout.setLeft(menuLayout);
        layout.setCenter(new AboutLayout());

        Scene scene = new Scene(layout, 800, 300);

        primaryStage.setTitle("Program Stopwatch dan Countdown");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

}
