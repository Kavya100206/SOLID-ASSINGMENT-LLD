import java.util.*;

public class CafeteriaSystem {
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private final FileStore store = new FileStore();
    private int invoiceSeq = 1000;

    // new components
    private final BillingCalculator calculator = new BillingCalculator();
    private final InvoiceBuilder builder = new InvoiceBuilder();

    public void addToMenu(MenuItem i) {
        menu.put(i.id, i);
    }

    public void checkout(String customerType, List<OrderLine> lines) {
        String invId = "INV-" + (++invoiceSeq);

        // 1. Calculations
        double subtotal = calculator.calculateSubtotal(menu, lines);

        double taxPct = TaxRules.taxPercent(customerType);
        double tax = calculator.calculateTax(customerType, subtotal);

        double discount = calculator.calculateDiscount(
                customerType, subtotal, lines.size()
        );

        double total = subtotal + tax - discount;

        // 2. Build invoice text
        String printable = builder.build(
                invId,
                menu,
                lines,
                subtotal,
                tax,
                taxPct,
                discount,
                total
        );

        // 3. Output
        System.out.print(printable);

        // 4. Persistence
        store.save(invId, printable);
        System.out.println(
                "Saved invoice: " + invId + " (lines=" + store.countLines(invId) + ")"
        );
    }
}