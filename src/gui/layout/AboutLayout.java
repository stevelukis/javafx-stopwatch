package gui.layout;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

/**
 * Info program
 *
 * @author Steve Lukis - D42116006
 */
public class AboutLayout extends VBox {

    public AboutLayout() {
        super();
        setAlignment(Pos.CENTER);

        Label programTitleLabel = new Label();
        programTitleLabel.setFont(new Font(26));
        programTitleLabel.setText(
                "Program Stopwatch dan Countdown"
        );

        Label additionalInfoLabel = new Label();
        additionalInfoLabel.setFont(new Font(16));
        additionalInfoLabel.setTextAlignment(TextAlignment.CENTER);
        additionalInfoLabel.setText(
                "Proyek mata kuliah pemograman berorientasi obyek.\n" +
                        "Oleh : Steve Lukis - D42116006\n" +
                        "Kelas B"
        );

        getChildren().addAll(
                programTitleLabel,
                additionalInfoLabel
        );

    }
}
