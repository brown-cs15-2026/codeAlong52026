package codeAlong52026;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage myStage) {
        PaneOrganizer organizer = new PaneOrganizer();
        Scene myScene = new Scene(organizer.getRoot());
        myStage.setScene(myScene);
        myStage.setTitle("Loops and Arrays CodeAlong!");
        myStage.show();
    }

    public static void main(String[] argv) {
        launch(argv);
    }
}