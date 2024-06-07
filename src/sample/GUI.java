package sample;

import javafx.scene.Scene;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;

public class GUI extends Application {
    private ListView<String> ElectronicStore;
    private Button reset_salebutton,addbutton,removebutton,complete_salebutton;
    ElectronicStore model;
    private Label label1,label,sale,stock,cart,number,revenue;
    //private TextField Sales_number_field,Revenuefield,Sale_cost_field;
    private ListView Sales_number_field,Revenuefield,Sale_cost_field,Popular_items,Stock_display,Current_Cart_display;
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        //model=initmodel;
        Pane apane=new Pane();
        //this.model=initmodel;
        label1=new Label("Store Summary:");
        label1.relocate(30,10);

        stock=new Label("Store Stock:");
        stock.relocate(320,10);

        cart=new Label("Current Cart");
        cart.relocate(620,10);

        number=new Label("# Sales:");
        number.relocate(30,40);

        Sales_number_field=new ListView();
        Sales_number_field.relocate(77,38);
        Sales_number_field.setPrefSize(100,25);

        revenue=new Label("Revenue:");
        revenue.relocate(30,75);

        Revenuefield=new ListView();
        Revenuefield.relocate(77,75);
        Revenuefield.setPrefSize(100,25);

        sale=new Label("$/Sale:");
        sale.relocate(30,110);

        Sale_cost_field=new ListView();
        Sale_cost_field.relocate(77,110);
        Sale_cost_field.setPrefSize(100,25);

        Stock_display=new ListView<String>();
        Stock_display.relocate(190,35);
        Stock_display.setPrefSize(300,300);

        Current_Cart_display=new ListView<String>();
        Current_Cart_display.relocate(495,35);
        Current_Cart_display.setPrefSize(300,300);

        label=new Label("Most Popular Items:");
        label.relocate(30,175);

        Popular_items=new ListView<String>();
        Popular_items.relocate(20,190);
        Popular_items.setPrefSize(140,150);

        //button Time
        addbutton=new Button("Add To Cart");
        addbutton.relocate(210,350);
        addbutton.setPrefSize(130,30);

        removebutton=new Button("Remove From Cart");
        removebutton.relocate(495,350);
        removebutton.setPrefSize(150,30);

        complete_salebutton=new Button("Complete Sale");
        complete_salebutton.relocate(650,350);
        complete_salebutton.setPrefSize(140,30);

        reset_salebutton=new Button("Reset Stores");
        reset_salebutton.relocate(25,350);
        reset_salebutton.setPrefSize(120,30);

        apane.getChildren().addAll(reset_salebutton,complete_salebutton,addbutton,removebutton,Sale_cost_field,Popular_items,Sales_number_field,Revenuefield,Stock_display,Current_Cart_display,label1,label,sale,stock,cart,number,revenue);
        primaryStage.setTitle("GUI_Test");
        primaryStage.setScene(new Scene(apane,800,400));
        primaryStage.show();

    }
}
