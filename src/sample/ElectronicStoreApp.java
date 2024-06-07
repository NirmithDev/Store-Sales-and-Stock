package sample;

//I Did The Code For Popular Items But Am Tooo Tired To Add It To The Display Screen SO RIP MARKS :(
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import static sample.ElectronicStore.createStore;

public class ElectronicStoreApp extends Application {
ElectronicStore model;
ElectronicStoreView view;
    public void start(Stage primaryStage) {
        model=new ElectronicStore("Watts-Up Electronic Store");
        model = createStore();
        //model.addProduct(a);
        view=new ElectronicStoreView(model);
        view.getRemovebutton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                handleRemove();}});
        view.getAddbutton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                handleAdd(); }});
        view.getReset_salebutton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                handleReset(); }});
        //complete Sale Button
        view.getComplete_salebutton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                handleComplete_sale(); }});
        primaryStage.setTitle("Watts Up Electronic Store"); // Set title of window
        primaryStage.setScene(new Scene(view, 800,400)); // Set size of window
        primaryStage.show();
        primaryStage.setResizable(false);
        view.update();
        //view.getSales_number_field().setText("0");
        //view.getRevenuefield().setText("0.0");
        //view.getSale_cost_field().setText("N/A");
//        view.update();
    }
public void handleAdd() {
    //Gets The Item From The List
    //And Calls The Add Functions
    int select = view.getStock_display().getSelectionModel().getSelectedIndex();
    if (select >= 0) {

        model.add_to_cart(model.stock[select]);
        view.update();
    }
}

public void handleRemove(){

        int select=view.getCurrent_Cart_display().getSelectionModel().getSelectedIndex();
    if (select >= 0) {
        model.remove_from_cart(model.Cart.get(select));
        view.update();
    }
}

public void handleReset(){
    model.reset();
    view.update();
        }
//HERE IS THE HANDLER FOR COMPLETE SALE
     public void handleComplete_sale(){
        model.completesale();
        view.update();
     }

    public static void main(String[] args) {
        launch(args);
    }

}
