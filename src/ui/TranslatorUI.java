package ui;

import domain.*;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TranslatorUI extends Application {

    public TranslatorContext context;
    private Button encode;
    private Button decode;
    private String text;
    private TextField input;
    private TextField output;
    private TextField offsetinput;
    private TextField autokey;
    private ComboBox combobox;
    private CodingStrategy codingStrategy;

    public void start(Stage primaryStage) {
        setup(primaryStage);
        combobox.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                // every time you change something in the dropdown it will change here
                codingStrategy = (CodingStrategy) newValue;
                if (codingStrategy.getClass() == CeasarStrategy.class){
                    offsetinput.setVisible(true);
                }else{
                    offsetinput.setVisible(false);
                }
                if (codingStrategy.getClass() == AutokeyStrategy.class){
                    autokey.setVisible(true);
                }else{
                    autokey.setVisible(false);
                }
            }
        });
        input.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                // every time you change the value of the textfield the text variable will change as well
                text = newValue;
            }
        });
        offsetinput.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                // again every time you change the value in the textfield it will get changed here
                try {
                    int offset = Integer.parseInt(newValue);
                    CeasarStrategy ceaser = (CeasarStrategy) codingStrategy;
                    ceaser.setOffset(offset);
                }catch (NumberFormatException e){
                    offsetinput.setText("");
                }
            }
        });
        autokey.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                // again every time you change the value in the textfield it will get changed here
                try {
                    AutokeyStrategy autokeyStrategy = (AutokeyStrategy) codingStrategy;
                    autokeyStrategy.setKey(newValue);
                }catch (Exception e){
                    autokey.setText("");
                }
            }
        });
        if (text == null || !text.isEmpty()){
            System.out.println("error put in text");
        }
        if (codingStrategy == null){
            System.out.println("please choose a codingStrategy with the dropdown menu");
        }
        context = new TranslatorContext(codingStrategy,text);
        encode.setOnMouseClicked(event -> {
           context.setInput(text);
           context.setCodingStrategy(codingStrategy);
           output.setText(context.encode());
        });
        decode.setOnMouseClicked(event -> {
            context.setInput(text);
            context.setCodingStrategy(codingStrategy);
            output.setText(context.decode());
        });
    }

    private void setup(Stage primaryStage) {
        GridPane root = new GridPane();
        Scene scene = new Scene(root, 800, 500);
        encode = new Button("Encode");
        decode = new Button("Decode");
        CeasarStrategy cs = new CeasarStrategy(1);
        MirrorStrategy mirror = new MirrorStrategy();
        AutokeyStrategy autoKey = new AutokeyStrategy("a");
        ObservableList<CodingStrategy> options = FXCollections.observableArrayList(
                cs,
                mirror,
                autoKey
        );
        combobox = new ComboBox(options);
        input = new TextField();
        output = new TextField();
        offsetinput = new TextField("offset number for ceasarcipher (number)");
        offsetinput.setVisible(false);
        autokey = new TextField("key value");
        autokey.setVisible(false);
        output.setDisable(true);
        root.add(encode,1,1);
        root.add(decode,2,1);
        root.add(combobox,3,1);
        root.add(offsetinput,3,2);
        root.add(autokey, 6, 1);
        root.add(input,4,1);
        root.add(output,5,1);
        primaryStage.setScene(scene);
        primaryStage.setTitle("");
        primaryStage.show();
    }


    public void encode(String stringToEncode) {

    }

    public void decode(String stringToDecode) {

    }
}