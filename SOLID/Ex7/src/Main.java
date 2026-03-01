public class Main {
    public static void main(String[] args) {

        Projector projector = new Projector();
        LightsPanel lights = new LightsPanel();
        AirConditioner ac = new AirConditioner();
        AttendanceScanner scanner = new AttendanceScanner();

        ClassroomController controller =
                new ClassroomController(projector, lights, ac, scanner);

        controller.startClass();
        controller.shutdown();
    }
}