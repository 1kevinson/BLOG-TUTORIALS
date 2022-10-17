package sample;

import java.time.LocalDateTime;
import java.util.List;

public class Restaurant {

    public static void main(String[] args) {
        var menu = new Menu();
        var bill = new Bill(menu, List.of("🍗 - Chicken Fries", "🍦 - Vanilla Cream"), 12467, LocalDateTime.now());

        System.out.println(bill.commandDate() + " :: Amount " + bill.finalAmount() + " for customer " + bill.getCustomerId());
    }
}
