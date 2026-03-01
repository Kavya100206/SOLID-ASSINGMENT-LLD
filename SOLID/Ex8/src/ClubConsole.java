public class ClubConsole {

    private FinanceOperations finance;
    private MinutesOperations minutes;
    private EventOperations events;

    public ClubConsole(
            FinanceOperations finance,
            MinutesOperations minutes,
            EventOperations events) {
        this.finance = finance;
        this.minutes = minutes;
        this.events = events;
    }

    public void run() {
        System.out.println("=== Club Admin ===");

        finance.addFunds(5000, "sponsor");
        minutes.addMinutes("Meeting at 5pm");
        events.createEvent("HackNight", 2000);

        System.out.println(
            "Summary: ledgerBalance=" + finance.getBalance() +
            ", minutes=" + minutes.getMinutesCount() +
            ", events=" + events.getEventCount()
        );
    }
}