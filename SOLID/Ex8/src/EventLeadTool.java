public class EventLeadTool implements EventOperations {

    private int eventCount = 0;

    @Override
    public void createEvent(String name, int budget) {
        eventCount++;
        System.out.println("Event created: " + name + " (budget=" + budget + ")");
    }

    @Override
    public int getEventCount() {
        return eventCount;
    }
}