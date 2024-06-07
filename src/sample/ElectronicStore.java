package sample;

//Class representing an electronic store
//Has an array of products that represent the items the store can sell
import java.util.*;
public class ElectronicStore extends Product {
    public final int MAX_PRODUCTS = 10; //Maximum number of products the store can have
    private int curProducts;
    private String name;
    private int sales=0;
    Product[] stock; //Array to hold all products
    ArrayList <Product> Cart=new ArrayList<Product>();
    private double revenue,costProducts,Dollar_per_Sale;
    Product famous1,famous2,famous3;

    public ElectronicStore(String initName){
        super(0,0);
        revenue = 0.0;
        name = initName;
        stock = new Product[MAX_PRODUCTS];
        curProducts = 0;
    }

    public String getName(){
        return name;
    }

    public String[] getItems(){
        if(curProducts <= 0){
            return new String[0];
        }

        String[] temp = new String[curProducts];
        for(int i = 0; i < temp.length; i++){
            temp[i] = stock[i].toString();
        }
        return temp;
    }

    //Adds a product and returns true if there is space in the array
    //Returns false otherwise
    public boolean addProduct(Product newProduct){
        if(curProducts <= MAX_PRODUCTS){
            stock[curProducts] = newProduct;
            curProducts++;
            return true;
        }
        return false;
    }

    public void add_to_cart(Product item){
        if(item != null){
        Cart.add(item);
    }
    }

    public void remove_from_cart(Product item){
        if(item!=null){
            Cart.remove(item);
        }
    }

    public void reset(){

        //System.out.println(createStore());
        ElectronicStore store1 = new ElectronicStore("Watts Up Electronics");
        Desktop d1 = new Desktop(100, 10, 3.0, 16, false, 250, "Compact");
        Desktop d2 = new Desktop(200, 10, 4.0, 32, true, 500, "Server");
        Laptop l1 = new Laptop(150, 10, 2.5, 16, true, 250, 15);
        Laptop l2 = new Laptop(250, 10, 3.5, 24, true, 500, 16);
        Fridge f1 = new Fridge(500, 10, 250, "White", "Sub Zero", 15.5, false);
        Fridge f2 = new Fridge(750, 10, 125, "Stainless Steel", "Sub Zero", 23, true);
        ToasterOven t1 = new ToasterOven(25, 10, 50, "Black", "Danby", 8, false);
        ToasterOven t2 = new ToasterOven(75, 10, 50, "Silver", "Toasty", 12, true);
        store1.addProduct(d1);
        store1.addProduct(d2);
        store1.addProduct(l1);
        store1.addProduct(l2);
        store1.addProduct(f1);
        store1.addProduct(f2);
        store1.addProduct(t1);
        store1.addProduct(t2);
        Cart.clear();
        revenue=0.0;
        sales=0;
        Dollar_per_Sale=0;
    }

    public void completesale(){
        //iterate through the list using the for loops and increment the number of sales each time
    for(Product prod:Cart){
        for(int i=0;i<curProducts;i++) {
            if (stock[i]==prod) {
                sellProducts(i, 1);
            }
            //costProducts=stock[i].getPrice();
            //revenue+=costProducts;
        }
    }
    sales++;
    Dollar_per_Sale=revenue/sales;
    Cart.clear();
    }

    public String[] printCart() {
        String[] temp = new String[Cart.size()];
        if (Cart.size() == 0) {
            return new String[0];
        } else {
            for (int i = 0; i < Cart.size(); i++) {
                if(temp[i]==null){ }
                temp[i] = Cart.get(i).toString();

            }
        }
        return temp;
    }

    public void Sale_number_increment(){
        //int a=getSales_number_field();
        sales++;

    }

    public double getDollar_per_Sale() {
        return Dollar_per_Sale;
    }

    public int getSales() {
        return sales;
    }

    //Sells 'amount' of the product at 'index' in the stock array
    //Updates the revenue of the store
    //If no sale occurs, the revenue is not modified
    //If the index is invalid, the revenue is not modified
    public void sellProducts(int index, int amount){
        if(index >= 0 && index < curProducts){
            revenue += stock[index].sellUnits(amount);
        }
    }

    public double getRevenue(){
        return revenue;
    }

    //Prints the stock of the store
    public String[] printStock(){
        String[] temp = new String[curProducts];
        for(int i = 0; i < temp.length; i++){
            temp[i]=stock[i].toString();
        }
        return temp;
    }

    public static ElectronicStore createStore(){
        ElectronicStore store1 = new ElectronicStore("Watts Up Electronics");
        Desktop d1 = new Desktop(100, 10, 3.0, 16, false, 250, "Compact");
        Desktop d2 = new Desktop(200, 10, 4.0, 32, true, 500, "Server");
        Laptop l1 = new Laptop(150, 10, 2.5, 16, true, 250, 15);
        Laptop l2 = new Laptop(250, 10, 3.5, 24, true, 500, 16);
        Fridge f1 = new Fridge(500, 10, 250, "White", "Sub Zero", 15.5, false);
        Fridge f2 = new Fridge(750, 10, 125, "Stainless Steel", "Sub Zero", 23, true);
        ToasterOven t1 = new ToasterOven(25, 10, 50, "Black", "Danby", 8, false);
        ToasterOven t2 = new ToasterOven(75, 10, 50, "Silver", "Toasty", 12, true);
        store1.addProduct(d1);
        store1.addProduct(d2);
        store1.addProduct(l1);
        store1.addProduct(l2);
        store1.addProduct(f1);
        store1.addProduct(f2);
        store1.addProduct(t1);
        store1.addProduct(t2);
        return store1;
    }

  //The Most Popular Items
  //private Product[] products;
  public void inPopularItems(Product[] products) {
      ArrayList<Product> most_popular = new ArrayList<Product>();

      int greatest = 0;
      for (int i = 0; i < products.length; i++) {
          if (products[i] != null) {
              if (products[i].getSoldQuantity() > products[greatest].getSoldQuantity()) {
                  greatest = i;
              }
          }
      }
      famous1 = products[greatest];
      most_popular.add(famous1);

      int greatest2 = 0;
      for (int i = 0; i < products.length; i++) {
          if (products[i] != null) {
              if (products[i].getSoldQuantity() > products[greatest2].getSoldQuantity() && !most_popular.contains(products[i])) {
                  greatest2 = i;
              }
          }
      }
      famous2 = products[greatest2];
      most_popular.add(famous2);

      int greatest3 = 0;
      for (int i = 0; i < products.length; i++) {
          if (products[i] != null) {
              if (products[i].getSoldQuantity() > products[greatest3].getSoldQuantity() && !most_popular.contains(products[i])) {
                  greatest3 = i;
              }
          }
      }
      famous3 = products[greatest3];
      most_popular.add(famous3);
  }
  public Product getFamous1(){
      return famous1;
  }
  public Product getFamous2(){
      return famous2;
  }
  public Product getFamous3(){
      return famous3;
  }
}
