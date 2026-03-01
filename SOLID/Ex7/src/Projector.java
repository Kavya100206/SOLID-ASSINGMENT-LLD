public class Projector implements PowerControl, InputConnectable {

    @Override
    public void powerOn() {
        System.out.println("Projector ON (HDMI-1)");
    }

    @Override
    public void powerOff() {
        System.out.println("Projector OFF");
    }

    @Override
    public void connectInput(String port) {
        System.out.println("Projector input: " + port);
    }
}