import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// An interface representing an Observer for tracking shop-related events
interface Observer {
    // Method to handle when a visitor visits a shop
    void onVisit(Shop shop);

    // Method to handle when a sale occurs in a shop
    void onSale(Shop shop);

    // Method to handle when a visitor exits a shop
    void onExit(Shop shop);
}


// This one is a singleton class with lazy instantiation
// Class representing a Sales Tracker that keeps track of shop-related statistics
class SalesTracker implements Observer {

    private ArrayList<Map<String, Double>> salesActivity = new ArrayList<>();

    // Private static instance of the SalesTracker class (Singleton pattern)
    private static SalesTracker instance;

    // Private map to store shop summaries using Shop objects as keys
    private static Map<Shop, SalesEvent> shopSummaries = new HashMap<>();

    // Private constructor to prevent instantiation from outside the class
    private SalesTracker() {
    }

    // Public static method to get the single instance of the class (Singleton pattern)
    public static SalesTracker getInstance() {
        if (instance == null) {
            instance = new SalesTracker();
        }
        return instance;
    }

    // Implementation of the onVisit method from the Observer interface
    @Override
    public void onVisit(Shop shop) {
        // Increment the visit count for the specified shop
        getShopSummary(shop).visit();
    }

    // Implementation of the onSale method from the Observer interface
    @Override
    public void onSale(Shop shop) {
        // Increment the sale count for the specified shop
        getShopSummary(shop).sale();
    }

    // Implementation of the onExit method from the Observer interface
    @Override
    public void onExit(Shop shop) {
        // Increment the exit count for the specified shop
        getShopSummary(shop).exit();
    }

    // Method to get the number of visits for a shop by shop name
    public int getVisits(String shopName) {
        return shopSummaries.get(shopName).getVisits();
    }

    // Method to get the shop summary for a specific shop
    public SalesEvent getShopSummary(Shop shop) {
        // Compute and return the shop summary, initializing if it doesn't exist
        return shopSummaries.computeIfAbsent(shop, k -> new SalesEvent());
    }


    public ArrayList<Map<String, Double>> getSalesActivity(){
        return salesActivity;
    }


    // Static method to print a summary of shop-related statistics
    public void PrintShopStatus() {

        System.out.println("---------------------------------------------------------Shop Status---------------------------------------------------------");
        int totalSales = 0;
        for (Map.Entry<Shop, SalesEvent> entry : shopSummaries.entrySet()) {
            System.out.println("\nShop name: " + entry.getKey().name);
            System.out.println("Vendor name: " + entry.getKey().vendor.getName());
            System.out.println("Number of visits: " + entry.getValue().getVisits());
            System.out.println("Number of sales: " + entry.getValue().getSales());
            System.out.println("Number of extra-sales: " + entry.getKey().shopSummary.getExtraSales());
            entry.getKey().shopSummary.setExtraSales(0);
            System.out.println("Number of exits: " + entry.getValue().getExits());
            totalSales = totalSales + entry.getValue().getSales() + entry.getValue().getExtraSales();
            Map<String, Double> lineGraph = new HashMap<>();
            lineGraph.put(entry.getKey().name, entry.getValue().getSales()*entry.getKey().price);
            salesActivity.add(lineGraph);
        }
        System.out.println("Total Sales of the day: " + totalSales);
        System.out.println("\n----------------------------------------------------------------------------------------------------------------------------");

    }

    public void resetValue() {
        for (Map.Entry<Shop, SalesEvent> entry : shopSummaries.entrySet()) {
            entry.getValue().setSales(0);
            entry.getValue().setVisits(0);
            entry.getValue().setExits(0);
        }
    }
}


// Class representing a summary of shop-related statistics
class SalesEvent {
    private int visits = 0;
    private int sales = 0;
    private int exits = 0;
    private int extraSales = 0;


    public void setExtraSales(int setValue) {
        extraSales = setValue;
    }

    public int getExtraSales() {
        return extraSales;
    }

    public void extraSale() {
        extraSales++;
    }

    // Method to increment the count of visits
    public void visit() {
        visits++;
    }

    // Method to increment the count of sales
    public void sale() {
        sales++;
    }

    // Method to increment the count of exits
    public void exit() {
        exits++;
    }

    // Getter method to retrieve the count of visits
    public int getVisits() {
        return visits;
    }

    // Getter method to retrieve the count of sales
    public int getSales() {
        return sales;
    }

    // Getter method to retrieve the count of exits
    public int getExits() {
        return exits;
    }

    public void setVisits(int visits) {
        this.visits = visits;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public void setExits(int exits) {
        this.exits = exits;
    }


}
