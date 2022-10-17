package sample;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Getter
public class Bill {

    private final List<String> selectedMenuItems;
    private final int customerId;
    private final LocalDateTime dateTime;
    private final Menu menu;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public Bill(Menu menu, List<String> selectedMenuItems, int customerId, LocalDateTime dateTime) {
        this.menu = menu;
        this.selectedMenuItems = selectedMenuItems;
        this.customerId = customerId;
        this.dateTime = dateTime;
    }

    BigDecimal finalAmount() {
        var selectedMenu = menu.selectedItems(selectedMenuItems);
        return selectedMenu.values().stream().reduce(BigDecimal.ONE, BigDecimal::add);
    }

    String commandDate() {
        return dateTime.format(formatter);
    }

    void printBill() {
        // Print the bill
    }

    void saveBill() {
        // Save the bill in FileStore or Database Store
    }
}
