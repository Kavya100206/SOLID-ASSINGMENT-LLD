import java.util.*;

public class BillingCalculator {

    public double calculateSubtotal(Map<String, MenuItem> menu, List<OrderLine> lines) {
        double subtotal = 0.0;
        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            subtotal += item.price * l.qty;
        }
        return subtotal;
    }

    public double calculateTax(String customerType, double subtotal) {
        double taxPct = TaxRules.taxPercent(customerType);
        return subtotal * (taxPct / 100.0);
    }

    public double calculateDiscount(String customerType, double subtotal, int lineCount) {
        return DiscountRules.discountAmount(customerType, subtotal, lineCount);
    }
}