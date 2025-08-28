package behavioral.strategy.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class StockFilters {
    public static List<Stock> filter(List<Stock> list, Predicate<Stock> p) {
        List<Stock> result = new ArrayList<>();
        for (Stock stock : list) {
            if (p.test(stock)) {
                result.add(stock);
            }
        }
        return result;
    }
}
