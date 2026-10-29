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
        this.leafBody = new Ellipse(x, y, Constants.X_RAD, Constants.Y_RAD_BODY);
        this.leafLeft = new Ellipse(x - Constants.X_OFFSET,
                y + Constants.Y_OFFSET, Constants.X_RAD, Constants.Y_RAD);
        this.leafRight = new Ellipse(x + Constants.X_OFFSET,
                y + Constants.Y_OFFSET, Constants.X_RAD, Constants.Y_RAD);

        this.leafLeft.setRotate(-Constants.ROTATE);
        this.leafRight.setRotate(Constants.ROTATE);

        this.leafStem = new Rectangle(Constants.STEM_WIDTH, Constants.STEM_HEIGHT);
        this.leafStem.setX(x - Constants.STEM_X_OFFSET);
        this.leafStem.setY(y + Constants.STEM_Y_OFFSET);

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