public class ClassroomController {

    private PowerControl projector;
    private BrightnessControl lights;
    private TemperatureControl ac;
    private AttendanceScanner scanner;

    public ClassroomController(
            PowerControl projector,
            BrightnessControl lights,
            TemperatureControl ac,
            AttendanceScanner scanner) {

        this.projector = projector;
        this.lights = lights;
        this.ac = ac;
        this.scanner = scanner;
    }

    public void startClass() {
        System.out.println("=== Smart Classroom ===");

        projector.powerOn();
        lights.setBrightness(60);
        ac.setTemperature(24);
        scanner.scanAttendance();
    }

    public void shutdown() {
        System.out.println("Shutdown sequence:");
        projector.powerOff();
        ((PowerControl) lights).powerOff();
        ((PowerControl) ac).powerOff();
    }
}