// Strategy design pattern is implemented in for the Sales Behavior
// An interface representing the sales behavior of a shop
interface SalesBehavior {
    double getSaleLikelihood();  // Method to get the likelihood of making a sale

    double getExitLikelihood();  // Method to get the likelihood of a visitor exiting after visiting the shop
}

// A class implementing the SalesBehavior interface for a shop with no sales or exits
class NoSell implements SalesBehavior {
    public double getSaleLikelihood() {
        return 0;  // No likelihood of making a sale
    }

    public double getExitLikelihood() {
        return 0;  // No likelihood of a visitor exiting
    }
}

// A class implementing the SalesBehavior interface for a shop with soft sales behavior
class SoftSell implements SalesBehavior {
    public double getSaleLikelihood() {
        return 0.10;  // Likelihood of making a sale is 10%
    }

    public double getExitLikelihood() {
        return 0;  // No likelihood of a visitor exiting
    }
}

// A class implementing the SalesBehavior interface for a shop with normal sales behavior
class NormalSell implements SalesBehavior {
    public double getSaleLikelihood() {
        return 0.20;  // Likelihood of making a sale is 20%
    }

    public double getExitLikelihood() {
        return 0.10;  // Likelihood of a visitor exiting is 10%
    }
}

// A class implementing the SalesBehavior interface for a shop with hard sales behavior
class HardSell implements SalesBehavior {
    public double getSaleLikelihood() {
        return 0.25;  // Likelihood of making a sale is 25%
    }

    public double getExitLikelihood() {
        return 0.25;  // Likelihood of a visitor exiting is 25%
    }
}
