public class AttendanceScanner implements AttendanceControl {

    @Override
    public int scanAttendance() {
        System.out.println("Attendance scanned: present=3");
        return 3;
    }
}