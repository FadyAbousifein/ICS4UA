public class VendingMachine {
    
    private String productName; 
    private double price; 
    private static final int MAX_QUANTITY = 50; 
    private int currentStock;

    public VendingMachine() {

    }

    public VendingMachine(String productName, double price, int currentStock) {
        
    }

    public double getPrice() {
        return price; 
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCurrentStock() {
        return currentStock; 
    }

    public double checkTotalSales() {
        return price; // TODO: Idk what to do here
    }
}