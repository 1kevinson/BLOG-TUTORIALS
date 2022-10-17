package sample;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Menu {

    private final Map<String, BigDecimal> itemsWithPrice = Map.of(
            "🍗 - Chicken Fries", BigDecimal.valueOf(19.0),
            "🌭 - Hot Dog", BigDecimal.valueOf(7.5),
            "🍝 - Pasta Pello", BigDecimal.valueOf(17.0),
            "🍕 - Pizza King", BigDecimal.valueOf(8.0),
            "🍔 - Burger Muze", BigDecimal.valueOf(7.5),
            "🍦 - Vanilla Cream", BigDecimal.valueOf(7.5)
    );

    Map<String, BigDecimal> selectedItems(List<String> items) {
        return itemsWithPrice.entrySet()
                .stream()
                .filter(item -> items.contains(item.getKey()))
                .collect(Collectors.toUnmodifiableMap(Map.Entry::getKey, Map.Entry::getValue));
    }

}
