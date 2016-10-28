
package sample.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChangeSceneTo {

    //bruges til at ændre til nu scene
    public void changeToScene(String fxmlFile, String title) throws Exception {
        Stage stage = new Stage();

        Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
        Scene scene = new Scene(root, 800, 600);

        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }
}
