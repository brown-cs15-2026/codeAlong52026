package codeAlong52026;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Game {

    private Pane gamePane;

    public Game (Pane gamePane) {
        this.gamePane = gamePane;
        Leaf firstLeaf = new Leaf(this.gamePane, Color.RED, Constants.FIRST_LEAF_X, Constants.FIRST_LEAF_Y);
    }

}