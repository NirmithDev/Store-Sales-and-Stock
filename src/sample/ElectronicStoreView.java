package sample;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.text.Text;

public class ElectronicStoreView extends Pane {
    private ListView<String> electronicStore;
    private Button addbutton, removebutton, reset_salebutton, complete_salebutton;
    ElectronicStore model;
    private Label label, label1, sale, stock, cart, number, revenue;
    private TextField Sales_number_field, Revenuefield, Sale_cost_field;
    private ListView Current_Cart_display, Stock_display, Popular_items;
    //private TextField Revenuefield;

    public ElectronicStoreView(ElectronicStore initmodel) {
        model = initmodel;
        //this.model=initmodel;
        label1 = new Label("Store Summary:");
        label1.relocate(30, 10);

        stock = new Label("Store Stock:");
        stock.relocate(320, 10);

        cart = new Label("Current Cart");
        cart.relocate(620, 10);

        number = new Label("# Sales:");
        number.relocate(30, 40);

        Sales_number_field = new TextField();
        Sales_number_field.relocate(77, 38);
        Sales_number_field.setPrefSize(100, 25);

        revenue = new Label("Revenue:");
        revenue.relocate(30, 75);

        Revenuefield = new TextField();
        Revenuefield.relocate(77, 75);
        Revenuefield.setPrefSize(100, 25);

        sale = new Label("$/Sale:");
        sale.relocate(30, 110);

        Sale_cost_field = new TextField();
        Sale_cost_field.relocate(77, 110);
        Sale_cost_field.setPrefSize(100, 25);

        Stock_display = new ListView<String>();
        Stock_display.relocate(190, 35);
        Stock_display.setPrefSize(300, 300);

        Current_Cart_display = new ListView<String>();
        Current_Cart_display.relocate(495, 35);
        Current_Cart_display.setPrefSize(300, 300);

        label = new Label("Most Popular Items:");
        label.relocate(30, 175);

        Popular_items = new ListView<String>();
        Popular_items.relocate(20, 190);
        Popular_items.setPrefSize(140, 150);

        //button Time
        addbutton = new Button("Add To Cart");
        addbutton.relocate(210, 350);
        addbutton.setPrefSize(130, 30);

        removebutton = new Button("Remove From Cart");
        removebutton.relocate(495, 350);
        removebutton.setPrefSize(150, 30);

        complete_salebutton = new Button("Complete Sale");
        complete_salebutton.relocate(650, 350);
        complete_salebutton.setPrefSize(140, 30);

        reset_salebutton = new Button("Reset Stores");
        reset_salebutton.relocate(25, 350);
        reset_salebutton.setPrefSize(120, 30);
        getChildren().addAll(label, label1, sale, stock, cart, number, revenue, addbutton, removebutton, reset_salebutton, complete_salebutton, Sales_number_field, Revenuefield, Sale_cost_field, Current_Cart_display, Stock_display, Popular_items);
    }

    public Button getAddbutton() {
        return addbutton;
    }

    public Button getRemovebutton() {
        return removebutton;
    }

    public Button getReset_salebutton() {
        return reset_salebutton;
    }

    public Button getComplete_salebutton() {
        return complete_salebutton;
    }

    public ListView getPopular_items() {
        return Popular_items;
    }

    public ListView getCurrent_Cart_display() {
        return Current_Cart_display;
    }

    public ListView getStock_display() {
        return Stock_display;
    }

    public ListView<String> getList() {
        return electronicStore;
    }

    public TextField getSales_number_field(){return Sales_number_field;}
    public TextField getRevenuefield(){return Revenuefield;}
    public TextField getSale_cost_field(){return Sale_cost_field;}


    //For The Button And To Enter The Data Into It
    public void update() {

        ObservableList<String> list = FXCollections.observableArrayList(model.printStock());
        Stock_display.setItems(list);
        ObservableList<String> list1 = FXCollections.observableArrayList(model.printCart());
        Current_Cart_display.setItems(list1);
        Sales_number_field.setText(Integer.toString(model.getSales()));
        Revenuefield.setText(Double.toString(model.getRevenue()));
        ObservableList<Product> popular=FXCollections.observableArrayList(model.getFamous1());
        Popular_items.setItems(popular);
        ObservableList<Product> popular1=FXCollections.observableArrayList(model.getFamous1());
        //Popular_items.add(popular1);
        //ObservableList<Product> popular=FXCollections.observableArrayList(model.getFamous1());
        //Popular_items.

        if(model.getSales()==0){
            Sale_cost_field.setText("N/A");
        }else {
            Sale_cost_field.setText(Double.toString(model.getDollar_per_Sale()));
        }
        //to disable the add and the remove button
        if(model.Cart.size()==0){
            removebutton.setDisable(true);
            addbutton.setDisable(false);
            complete_salebutton.setDisable(true);
        }else{
            addbutton.setDisable(false);
            removebutton.setDisable(false);
            complete_salebutton.setDisable(false);
        }
    }
}

