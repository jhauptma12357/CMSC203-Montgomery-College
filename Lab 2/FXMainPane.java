


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.
 * Before beginning to implement, design the structure of your GUI in order to
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

    //student Task #2:
    //  declare five buttons, a label, and a textfield
    private Button button1, button2, button3, button4, button5, optionalButton;
    private TextField textfield;
    private Label label;
    private HBox hBox1, hBox2;
    //  declare two HBoxes
    HBox hbox1 = new HBox();
    HBox hbox2 = new HBox();
    //student Task #4:
    //  declare an instance of DataManager
    private DataManager dataManager;
    /**
     * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
     * wait to add a component to its containing component until the container has
     * been created.  This is the only constraint on the order in which the following
     * statements appear.
     */
    FXMainPane() {
        //student Task #2:
        //  instantiate the buttons, label, and textfield
        button1 = new Button("Hello");
        button2 = new Button("Howdy");
        button3 = new Button("Chinese");
        button4 = new Button("Clear");
        button5 = new Button("Exit");
        optionalButton = new Button("Japanese");
        label = new Label("Feedback");
        textfield = new TextField();
        //  instantiate the HBoxes
        hBox1 = new HBox();
        hBox2 = new HBox();
        //student Task #4:
        //  instantiate the DataManager instance
        dataManager = new DataManager();
        //  set margins and set alignment of the components
        Insets inset = new Insets(10);
        HBox.setMargin(button1, inset);
        HBox.setMargin(button2, inset);
        HBox.setMargin(button3, inset);
        HBox.setMargin(button4, inset);
        HBox.setMargin(button5, inset);
        hBox1.setAlignment(Pos.CENTER);
        hBox2.setAlignment(Pos.CENTER);

        //student Task #3:
        //  add the label and textfield to one of the HBoxes
        hBox1.getChildren().addAll(label, textfield);
        //  add the buttons to the other HBox
        hBox2.getChildren().addAll(button1, button2, button3,optionalButton, button4, button5);
        //  add the HBoxes to this FXMainPanel (a VBox)
        getChildren().addAll(hBox1, hBox2);

        button1.setOnAction(new ButtonHandler());
        button2.setOnAction(new ButtonHandler());
        button3.setOnAction(new ButtonHandler());
        button4.setOnAction(new ButtonHandler());
        button5.setOnAction(new ButtonHandler());
        optionalButton.setOnAction(new ButtonHandler());
    }

    //Task #4:
    //  create a private inner class to handle the button clicks
    private class ButtonHandler implements EventHandler<ActionEvent> {

        public void handle(ActionEvent event){
            if(event.getTarget() == button1){
                textfield.setText(dataManager.getHello());
            }else if(event.getTarget() == button2){
                textfield.setText(dataManager.getHowdy());
            }else if(event.getTarget() == button3){
                textfield.setText(dataManager.getChinese());
            }else if(event.getTarget() == button4){
                textfield.setText("");
            }else if(event.getTarget() == optionalButton) {
                textfield.setText(dataManager.getJapanese());
            }else{
                Platform.exit();
            }
        }





    }
}

