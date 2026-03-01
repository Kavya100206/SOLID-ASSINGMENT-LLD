public class SecretaryTool implements MinutesOperations {

    private int minutesCount = 0;

    @Override
    public void addMinutes(String text) {
        minutesCount++;
        System.out.println("Minutes added: \"" + text + "\"");
    }

    @Override
    public int getMinutesCount() {
        return minutesCount;
    }
}