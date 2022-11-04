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
    private final Menu menu;

    public Bill(List<String> selectedItems, int customerId) {
        menu = new Menu();
        selectedMenuItems = selectedItems;
        this.customerId = customerId;
    }

    BigDecimal finalAmount() {
        var selectedMenu = menu.selectedItems(selectedMenuItems);
        return selectedMenu.values().stream().reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    String commandDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }
}
