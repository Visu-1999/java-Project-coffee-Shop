import java.util.Scanner;

public class Coffeeshop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Beverage order = new Coffee(); // Start with plain coffee

        System.out.println("Welcome to Java Coffee Shop!");
        System.out.println("Base: Plain Coffee ($2.00)");

        // Ask if user wants milk
        System.out.print("Add milk for $0.50? (y/n): ");
        String milkChoice = scanner.nextLine();
        if (milkChoice.equalsIgnoreCase("y")) {
            order = new Milk(order);
        }

        // Ask if user wants sugar
        System.out.print("Add sugar for $0.30? (y/n): ");
        String sugarChoice = scanner.nextLine();
        if (sugarChoice.equalsIgnoreCase("y")) {
            order = new Sugar(order);
        }

        // Output the final order
        System.out.println("\nYour order: " + order.getDescription());
        System.out.printf("Total cost: $%.2f\n", order.getCost());

        scanner.close();
    }
}

interface Beverage {
    String getDescription();

    double getCost();
}

// Step 2: Base Coffee class
class Coffee implements Beverage {
    public String getDescription() {
        return "Plain Coffee";
    }

    public double getCost() {
        return 2.00;
    }
}

// Step 3: Add-ons using the Decorator pattern
class Milk implements Beverage {
    private Beverage beverage;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }

    public double getCost() {
        return beverage.getCost() + 0.50;
    }
}

class Sugar implements Beverage {
    private Beverage beverage;

    public Sugar(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Sugar";
    }

    public double getCost() {
        return beverage.getCost() + 0.30;
    }
}

// Step 4: Simulate an order
class Billing {
    public static void main(String[] args) {
        Beverage myOrder = new Sugar(new Milk(new Coffee()));
        System.out.println("Your order: " + myOrder.getDescription());
        System.out.println("Total cost: $" + myOrder.getCost());
    }
}
