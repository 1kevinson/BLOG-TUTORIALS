package sample;

import java.util.List;

public class Restaurant {

    public static void main(String[] args) {
        var bill = new Bill(List.of("Chicken Fries", "Vanilla Cream"), 12467);

        System.out.println(bill.commandDate() + " :: Amount " + bill.finalAmount() + " for customer " + bill.getCustomerId());
    }
}
