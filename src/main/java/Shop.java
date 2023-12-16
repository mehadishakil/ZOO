import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public abstract class Shop {
    protected List<Observer> observers = new ArrayList<>();
    protected String name;
    protected Vendor vendor;
    protected int inventory;
    protected double price;
    protected double likelihoodOfSale;
    protected double cash;

    protected SalesEvent shopSummary;

    // Add an observer (SalesTracker) to the list of observers
    public void addSalesTracker(Observer observer) {
        observers.add(observer);
    }

    // Remove an observer (SalesTracker) from the list of observers
    public void removeSalesTracker(Observer observer) {
        observers.remove(observer);
    }

    // Simulate a sale in the shop
    abstract public void sale();

    public void visit() {
        for (Observer observer : observers) {
            observer.onVisit(this);
        }
    }

    public void exit() {
        for (Observer observer : observers) {
            observer.onExit(this);
        }
    }

    public List<Observer> getObservers() {
        return observers;
    }
}

class Gift extends Shop {

    Gift(String name, double price, double likelihoodOfSale, Vendor vendor) {
        this.name = name;
        this.inventory = new Random().nextInt(101) + 100; // Inventory between 100 and 200
        this.price = price;
        this.likelihoodOfSale = likelihoodOfSale;
        this.cash = this.inventory * (this.price / 2);
        this.observers = new ArrayList<>();
        this.observers.add(SalesTracker.getInstance());
        this.vendor = vendor;
        this.shopSummary = new SalesEvent();
    }

    @Override
    public void sale() {
        double saleLikelihood = vendor.getSaleLikelihood();
        double exitLikelihood = vendor.getExitLikelihood();

        Random random = new Random();
        boolean saleOccurred = random.nextDouble() < saleLikelihood;

        if (saleOccurred) {
            // A sale occurred for the specified quantity
            System.out.println("Visitor bought an item from " + name + " shop.");
            shopSummary.sale();
        } else {
            System.out.println("Visitor did not buy any item from " + name + " shop.");
        }

        boolean exitOccurred = random.nextDouble() < exitLikelihood;

        if (exitOccurred) {
            // Customer exited the shop
            System.out.println("Customer exited from " + name + " shop.");
        }
        for (Observer observer : observers) {
            observer.onSale(this);
        }
    }
}

class Maps extends Shop {
    Maps(String name, double price, double likelihoodOfSale, Vendor vendor) {
        this.name = name;
        this.inventory = new Random().nextInt(101) + 100; // Inventory between 100 and 200
        this.price = price;
        this.likelihoodOfSale = likelihoodOfSale;
        this.cash = this.inventory * (this.price / 2);
        this.observers = new ArrayList<>();
        this.observers.add(SalesTracker.getInstance());
        this.vendor = vendor;
        this.shopSummary = new SalesEvent();
    }

    @Override
    public void sale() {
        double saleLikelihood = vendor.getSaleLikelihood();
        double exitLikelihood = vendor.getExitLikelihood();

        Random random = new Random();
        boolean saleOccurred = random.nextDouble() < saleLikelihood;

        if (saleOccurred) {
            // A sale occurred for the specified quantity
            System.out.println("Visitor bought an item from " + name + " shop.");
            shopSummary.sale();
        } else {
            System.out.println("Visitor did not buy any item from " + name + " shop.");
        }

        boolean exitOccurred = random.nextDouble() < exitLikelihood;

        if (exitOccurred) {
            // Customer exited the shop
            System.out.println("Customer exited from " + name + " shop.");
        }
        for (Observer observer : observers) {
            observer.onSale(this);
        }
    }
}

class Drinks extends Shop {

    Drinks(String name, double price, double likelihoodOfSale, Vendor vendor) {
        this.name = name;
        this.inventory = new Random().nextInt(101) + 100; // Inventory between 100 and 200
        this.price = price;
        this.likelihoodOfSale = likelihoodOfSale;
        this.cash = this.inventory * (this.price / 2);
        this.observers = new ArrayList<>();
        this.observers.add(SalesTracker.getInstance());
        this.vendor = vendor;
        this.shopSummary = new SalesEvent();
    }

    @Override
    public void sale() {
        double saleLikelihood = vendor.getSaleLikelihood();
        double exitLikelihood = vendor.getExitLikelihood();

        Random random = new Random();
        boolean saleOccurred = random.nextDouble() < saleLikelihood;

        if (saleOccurred) {
            // A sale occurred for the specified quantity
            System.out.println("Visitor bought an item from " + name + " shop.");
            shopSummary.sale();
        } else {
            System.out.println("Visitor did not buy any item from " + name + " shop.");
        }

        boolean exitOccurred = random.nextDouble() < exitLikelihood;

        if (exitOccurred) {
            // Customer exited the shop
            System.out.println("Customer exited from " + name + " shop.");
        }
        for (Observer observer : observers) {
            observer.onSale(this);
        }
    }

}

class Food extends Shop {

    Food(String name, double price, double likelihoodOfSale, Vendor vendor) {
        this.name = name;
        this.inventory = new Random().nextInt(101) + 100; // Inventory between 100 and 200
        this.price = price;
        this.likelihoodOfSale = likelihoodOfSale;
        this.cash = this.inventory * (this.price / 2);
        this.observers = new ArrayList<>();
        this.observers.add(SalesTracker.getInstance());
        this.vendor = vendor;
        this.shopSummary = new SalesEvent();
    }

    @Override
    public void sale() {
        double saleLikelihood = vendor.getSaleLikelihood();
        double exitLikelihood = vendor.getExitLikelihood();

        Random random = new Random();
        boolean saleOccurred = random.nextDouble() < saleLikelihood;

        if (saleOccurred) {
            // A sale occurred for the specified quantity
            System.out.println("Visitor bought an item from " + name + " shop.");
            shopSummary.sale();
        } else {
            System.out.println("Visitor did not buy any item from " + name + " shop.");
        }

        boolean exitOccurred = random.nextDouble() < exitLikelihood;

        if (exitOccurred) {
            // Customer exited the shop
            System.out.println("Customer exited from " + name + " shop.");
        }
        for (Observer observer : observers) {
            observer.onSale(this);
        }
    }
}

class Toy extends Shop {


    Toy(String name, double price, double likelihoodOfSale, Vendor vendor) {
        this.name = name;
        this.inventory = new Random().nextInt(101) + 100; // Inventory between 100 and 200
        this.price = price;
        this.likelihoodOfSale = likelihoodOfSale;
        this.cash = this.inventory * (this.price / 2);
        this.observers = new ArrayList<>();
        this.observers.add(SalesTracker.getInstance());
        this.vendor = vendor;
        this.shopSummary = new SalesEvent();
    }

    @Override
    public void sale() {
        double saleLikelihood = vendor.getSaleLikelihood();
        double exitLikelihood = vendor.getExitLikelihood();

        Random random = new Random();
        boolean saleOccurred = random.nextDouble() < saleLikelihood;

        if (saleOccurred) {
            // A sale occurred for the specified quantity
            System.out.println("Visitor bought an item from " + name + " shop.");
            shopSummary.sale();
        } else {
            System.out.println("Visitor did not buy any item from " + name + " shop.");
        }

        boolean exitOccurred = random.nextDouble() < exitLikelihood;

        if (exitOccurred) {
            // Customer exited the shop
            System.out.println("Customer exited from " + name + " shop.");
        }
        for (Observer observer : observers) {
            observer.onSale(this);
        }
    }

}




// AdditionalSalesItem interface representing extra sales items
abstract class AdditionalSalesItem extends Shop{
    abstract void addExtrasale();

}


// Concrete decorator class for Gift Wrapping
class GiftWrappingDecorator extends AdditionalSalesItem {

    private Shop shop;

    public GiftWrappingDecorator(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void sale() {
        System.out.println("Sell Gift Wrapping.");
        addExtrasale();
    }

    @Override
    void addExtrasale() {
        shop.shopSummary.extraSale();
    }
}

// Concrete decorator class for Gift Bag
class GiftBagDecorator extends AdditionalSalesItem {

    private Shop shop;

    public GiftBagDecorator(Shop shop) {
        this.shop = shop;
    }

    @Override
    void addExtrasale() {
        shop.shopSummary.extraSale();
    }

    @Override
    public void sale() {
        System.out.println("Gift Bag(s) sold ");
        addExtrasale();
    }
}

// Concrete decorator class for Gift Cards
class GiftCardDecorator extends AdditionalSalesItem {
    private Shop shop;

    public GiftCardDecorator(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void sale() {
        System.out.println("Gift Cards sold");
        addExtrasale();
    }

    @Override
    void addExtrasale() {
        shop.shopSummary.extraSale();
    }
}


class DecoratorImplementor {
    private Shop shop;

    public DecoratorImplementor(Shop shop) {
        this.shop = shop;
    }

    public void sale() {

        if (shop.name == "Toys") {
            shop.sale();
            // Decorate with Gift Wrapping (25% chance)
            if (new Random().nextDouble() < 0.25) {
                GiftWrappingDecorator giftWrappingDecorator = new GiftWrappingDecorator(shop);
                giftWrappingDecorator.sale();
            }

            // Decorate with Gift Bag(s) (10% chance of 1 bag, 10% chance of 2 bags)
            if (new Random().nextDouble() < 0.10) {
                // int quantity = new Random().nextInt(2) + 1; // 1 or 2 bags
                GiftBagDecorator giftBagDecorator = new GiftBagDecorator(shop);
                giftBagDecorator.sale();
            }

            // Decorate with Gift Card(s) (20% chance of 1-3 cards)
            if (new Random().nextDouble() < 0.20) {
                //int quantity = new Random().nextInt(3) + 1; // 1 to 3 cards
                GiftCardDecorator giftCardDecorator = new GiftCardDecorator(shop);
                giftCardDecorator.sale();
            }
        } else {
            shop.sale();
        }
    }


}