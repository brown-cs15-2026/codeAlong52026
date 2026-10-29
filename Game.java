package codeAlong52026;

import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Game {

    private Pane gamePane;
    private ArrayList<Leaf> leafArrayList;

    public Game (Pane gamePane) {
        this.gamePane = gamePane;
        this.gamePane.setOnKeyPressed((KeyEvent e) -> this.handleKeyPress(e));
        Leaf firstLeaf = new Leaf(this.gamePane, Color.RED, 50, 50);

        this.leafArrayList = new ArrayList<>();
        this.leafArrayList.add(firstLeaf);
    }

    private void addLeaf() {
        int x = this.generateRandomCoordinates(30, 470);
        int y = this.generateRandomCoordinates(30, 470);
        Leaf newLeaf;

        int rand = (int)(Math.random() * 4);
        switch(rand) {
            case 0:
                newLeaf = new Leaf(this.gamePane, Color.RED, x, y);
                break;
            case 1:
                newLeaf = new Leaf(this.gamePane, Color.DARKORANGE, x, y);
                break;
            case 2:
                newLeaf = new Leaf(this.gamePane, Color.GOLD, x, y);
                break;
            default:
                newLeaf = new Leaf(this.gamePane, Color.MAROON, x, y);
                break;
        }

        //emphasize the importance of ADDING LEAF TO ARRAYLIST!!

        /*
        do this at the end; first try turnLeavesGreen - only the first leaf will turn green;
        ask students why (it's because they haven't been added to the arraylist yet!), then
        add this line of code
         */
        this.leafArrayList.add(newLeaf);
    }

    private int generateRandomCoordinates(int low, int high) {
        return low + (int)((high - low) * Math.random());
    }

    private void handleKeyPress(KeyEvent event) {
        switch(event.getCode()) {
            case SPACE:
                this.addLeaf();
                break;
            case G:
                this.turnLeavesGreen();
                break;
            case R:
                this.removeColorfulLeaves();
                break;
            case DOWN:
                this.scrollDown();
                break;
            default:
                break;
        }
    }

    private void turnLeavesGreen() {
        for (Leaf leaf: this.leafArrayList) {
            leaf.turnGreen();
        }
    }

    private void removeColorfulLeaves() {
//        for (Leaf leaf: this.leafArrayList) {
//            if (leaf.getColor() != Color.FORESTGREEN) {
//                this.leafArrayList.remove(leaf);
//            }
//        }

        for (int i = 0; i < this.leafArrayList.size(); i++) {
            Leaf leaf = this.leafArrayList.get(i);
            if (leaf.getColor() != Color.FORESTGREEN) {
                this.leafArrayList.remove(i);
                leaf.removeGraphically();

                // why aren't all of the leaves being removed?
                // something is going wrong with our indexing...
                i--;
            }
        }
    }

    private void scrollDown() {
        int offset = 50;
        for (int i = 0; i < this.leafArrayList.size(); i++) {
            Leaf currLeaf = this.leafArrayList.get(i);
            currLeaf.lowerY(offset);

            if (currLeaf.getY() > 500) {
                this.leafArrayList.remove(i);
                currLeaf.removeGraphically();
                i--;
            }
        }
    }
}