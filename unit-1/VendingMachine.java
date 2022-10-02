public class VendingMachine {
    
    // Instance variables 
    private String productName; 
    private double price; 
    private static final int MAX_QUANTITY = 50; 
    private int currentStock;

    // no-arg constructor (default product)
    public VendingMachine() {
        this("Granola-bar", 2, 12);
    }

    // (String, double, int) constructor set's arguments equal to instance variables
    public VendingMachine(String productName, double price, int currentStock) {
        this.productName = productName; 
        this.price = price; 
        this.currentStock = currentStock; 
    }

    // returns price
    public double getPrice() {
        return price; 
    }

    // sets argument passed in equal to price Instance variable
    public void setPrice(double price) {
        this.price = price;
    }

    // returns currentStock
    public int getCurrentStock() {
        return currentStock; 
    }

    // returns the total sales
    public double checkTotalSales() {
        return price * (50 - currentStock); 
    }
}