import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] items = { "Cola", "Potato Chips", "Energy Drink", "Chocolate Bar" };
        double[] prices = { 1.50, 1.25, 2.50, 1.00 };
        int[] stock = { 3, 2, 1, 5 };

        boolean running = true;

        System.out.println("=== WELCOME TO THE SMART VENDING MACHINE ===");

        while (running) {
            System.out.println("\n--- Current Inventory ---");
            for (int i = 0; i < items.length; i++) {
                String stockStatus = (stock[i] > 0) ? stock[i] + " left" : "OUT OF STOCK";
                System.out.printf("%d. %s - $%.2f [%s]\n", (i + 1), items[i], prices[i], stockStatus);
            }
            System.out.println("5. Walk Away (Exit)");
            System.out.print("\nPlease select an option (1-5): ");
            
            String choiceInput = scanner.nextLine();
            
            if (choiceInput.equals("5")) {
                System.out.println("\nThank you for visiting! Have a great day.");
                running = false;
                break;
            }

            int selection = -1;
            try {
                selection = Integer.parseInt(choiceInput) - 1;
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input. Please enter a number between 1 and 5.");
                continue;
            }

            if (selection < 0 || selection >= items.length) {
                System.out.println("❌ Invalid selection. Please pick a valid item from the list.");
                continue;
            }

            if (stock[selection] == 0) {
                System.out.println("❌ Sorry, " + items[selection] + " is currently out of stock!");
                continue;
            }

            double itemPrice = prices[selection];
            System.out.printf("\nYou selected: %s ($%.2f)\n", items[selection], itemPrice);
            
            System.out.print("Insert cash (e.g., 2.00 or 5.00): $");
            String cashInput = scanner.nextLine();
            double userFunds = 0;
            
            try {
                userFunds = Double.parseDouble(cashInput);
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid money formatting. Transaction canceled.");
                continue;
            }

            if (userFunds < itemPrice) {
                System.out.printf("❌ Insufficient funds! You need $%.2f more. Transaction canceled.\n", (itemPrice - userFunds));
                continue;
            }

            stock[selection]--;
            double changeDue = userFunds - itemPrice;
            System.out.printf("\n✔ Dispensing %s...\n", items[selection]);
            System.out.printf("Total Change Due: $%.2f\n", changeDue);

            int changeInCents = (int) Math.round(changeDue * 100);

            int quarters = changeInCents / 25;
            changeInCents %= 25;

            int dimes = changeInCents / 10;
            changeInCents %= 10;

            int nickels = changeInCents / 5;
            changeInCents %= 5;
            
            int pennies = changeInCents;

            System.out.println("Dispensing coins:");
            if (quarters > 0) System.out.println("  - Quarters (25¢): " + quarters);
            if (dimes > 0)    System.out.println("  - Dimes (10¢): " + dimes);
            if (nickels > 0)  System.out.println("  - Nickels (5¢): " + nickels);
            if (pennies > 0)  System.out.println("  - Pennies (1¢): " + pennies);
            if (quarters == 0 && dimes == 0 && nickels == 0 && pennies == 0) {
                System.out.println("  - No change needed (Exact change given).");
            }
        }

        scanner.close();
    }
}