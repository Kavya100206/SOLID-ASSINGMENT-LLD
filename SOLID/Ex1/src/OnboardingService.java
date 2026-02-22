import java.util.*;

public class OnboardingService {

    private final StudentRepository db;
    private final StudentParser parser = new StudentParser();
    private final StudentValidator validator = new StudentValidator();
    private final StudentPrinter printer = new StudentPrinter();

    public OnboardingService(StudentRepository db) {
        this.db = db;
    }

    public void registerFromRawInput(String raw) {

        printer.printInput(raw);

        // 1. Parse
        Map<String, String> kv = parser.parse(raw);

        // 2. Validate
        List<String> errors = validator.validate(kv);
        if (!errors.isEmpty()) {
            printer.printErrors(errors);
            return;
        }

        // 3. Create student
        String name = kv.get("name");
        String email = kv.get("email");
        String phone = kv.get("phone");
        String program = kv.get("program");

        String id = IdUtil.nextStudentId(db.count());
        StudentRecord rec = new StudentRecord(id, name, email, phone, program);

        // 4. Save
        db.save(rec);

        // 5. Print success
        printer.printSuccess(rec, db.count());
    }
}