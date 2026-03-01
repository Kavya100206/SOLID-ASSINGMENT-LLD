public class Main {
    public static void main(String[] args) {

        TreasurerTool treasurer = new TreasurerTool();
        SecretaryTool secretary = new SecretaryTool();
        EventLeadTool eventLead = new EventLeadTool();

        ClubConsole console =
                new ClubConsole(treasurer, secretary, eventLead);

        console.run();
    }
}