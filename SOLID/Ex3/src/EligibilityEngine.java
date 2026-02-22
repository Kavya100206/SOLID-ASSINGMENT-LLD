import java.util.*;

public class EligibilityEngine {
    private final FakeEligibilityStore store;
    private final List<EligibilityRule> rules = new ArrayList<>();

    public EligibilityEngine(FakeEligibilityStore store) {
        this.store = store;

        // Register rules (order matters!)
        rules.add(new DisciplineRule());
        rules.add(new CGRRule());
        rules.add(new AttendanceRule());
        rules.add(new CreditsRule());
    }

    public void runAndPrint(StudentProfile s) {
        ReportPrinter p = new ReportPrinter();
        EligibilityEngineResult r = evaluate(s);
        p.print(s, r);
        store.save(s.rollNo, r.status);
    }

    public EligibilityEngineResult evaluate(StudentProfile s) {
        List<String> reasons = new ArrayList<>();
        String status = "ELIGIBLE";

        for (EligibilityRule rule : rules) {
            String reason = rule.check(s);
            if (reason != null) {
                status = "NOT_ELIGIBLE";
                reasons.add(reason);
                break; // keep same behavior as else-if chain
            }
        }

        return new EligibilityEngineResult(status, reasons);
    }
}

class EligibilityEngineResult {
    public final String status;
    public final List<String> reasons;

    public EligibilityEngineResult(String status, List<String> reasons) {
        this.status = status;
        this.reasons = reasons;
    }
}