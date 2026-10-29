package codeAlong52026;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class Leaf {

    private Ellipse leafBody;
    private Ellipse leafLeft;
    private Ellipse leafRight;
    private Rectangle leafStem;

    private Pane gamePane;
    private Color color;

    public Leaf(Pane pane, Color color, int x, int y) {
        this.gamePane = pane;
        this.color = color;
        this.setUpLeaf(x, y);
    }

    private void setUpLeaf(int x, int y) {
        this.leafBody = new Ellipse(x, y, 10.0, 20.0);
        this.leafLeft = new Ellipse(x - 10, y + 5, 10.0, 15.0);
        this.leafRight = new Ellipse(x + 10, y + 5, 10.0, 15.0);

        this.leafLeft.setRotate(-40.0);
        this.leafRight.setRotate(40.0);

        this.leafStem = new Rectangle(6, 10);
        this.leafStem.setX(x - 3.0);
        this.leafStem.setY(y + 19.0);

        this.leafBody.setFill(this.color);
        this.leafStem.setFill(this.color);
        this.leafLeft.setFill(this.color);
        this.leafRight.setFill(this.color);

        this.gamePane.getChildren().addAll(this.leafBody, this.leafLeft, this.leafRight,
                this.leafStem);
    }

    public void turnGreen() {
        this.leafBody.setFill(Color.FORESTGREEN);
        this.leafStem.setFill(Color.FORESTGREEN);
        this.leafLeft.setFill(Color.FORESTGREEN);
        this.leafRight.setFill(Color.FORESTGREEN);
    }

    public Color getColor() {
        return this.color;
    }

    public void removeGraphically() {
        this.gamePane.getChildren().removeAll(this.leafBody, this.leafStem,
                this.leafLeft, this.leafRight);
    }

    public void lowerY(double offset) {
        this.leafBody.setCenterY(this.leafBody.getCenterY() + offset);
        this.leafLeft.setCenterY(this.leafLeft.getCenterY() + offset);
        this.leafRight.setCenterY(this.leafRight.getCenterY() + offset);
        this.leafStem.setY(this.leafStem.getY() + offset);
    }

    public double getY() {
        return this.leafStem.getY();
    }
}