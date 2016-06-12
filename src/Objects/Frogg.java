package Objects;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Created by kriss on 11.6.2016 г..
 */
public class Frogg extends Application {


    private Pane root;
    private Node frog;

    public Parent createContent(){
        root = new Pane();
        root.setPrefSize(800,600);

        frog = initFrog();
        root.getChildren().add(frog);

        return root;
    }

    public Node initFrog(){
        Rectangle rect = new Rectangle(38,38, Color.GREEN);
        rect.setTranslateY(600 - 39);

        return rect;
    }
    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(createContent()));

        stage.getScene().setOnKeyPressed(event -> {
                switch (event.getCode()){
                    case W:
                        frog.setTranslateY(frog.getTranslateY() - 40);
                        break;
                    case S:
                        frog.setTranslateY(frog.getTranslateY() + 40);
                        break;
                    case A:
                        frog.setTranslateX(frog.getTranslateX() - 40);
                        break;
                    case D:
                        frog.setTranslateX(frog.getTranslateX() + 40);
                        break;
                    default:
                        break;
                }
        });
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
