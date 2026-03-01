public class AirConditioner implements PowerControl, TemperatureControl {

    @Override
    public void powerOn() {
        System.out.println("AC ON");
    }

    @Override
    public void powerOff() {
        System.out.println("AC OFF");
    }

    @Override
    public void setTemperature(int c) {
        System.out.println("AC set to " + c + "C");
    }
}