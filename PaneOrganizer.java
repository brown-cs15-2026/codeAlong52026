package codeAlong52026;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class PaneOrganizer {

    private BorderPane rootPane;

    public PaneOrganizer() {
        this.rootPane = new BorderPane();
        this.setUpGame();
    }

    public Pane getRoot() {
        return this.rootPane;
    }

    private void setUpGame() {
        Pane gamePane = new Pane();
        gamePane.setFocusTraversable(true);
        gamePane.setPrefSize(Constants.SCENE_SIZE, Constants.SCENE_SIZE);
        gamePane.setStyle(Constants.PANE_COLOR);

        this.rootPane.setCenter(gamePane);
        new Game(gamePane);
    }
}