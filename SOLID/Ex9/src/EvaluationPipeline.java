public class EvaluationPipeline {

    private Grader grader;
    private PlagiarismService plagiarismService;
    private ReportService reportService;

    // Dependency Injection via constructor
    public EvaluationPipeline(
            Grader grader,
            PlagiarismService plagiarismService,
            ReportService reportService) {

        this.grader = grader;
        this.plagiarismService = plagiarismService;
        this.reportService = reportService;
    }

    public void evaluate(Submission submission) {

        System.out.println("=== Evaluation Pipeline ===");

        int plagiarismScore = plagiarismService.check(submission);
        System.out.println("PlagiarismScore=" + plagiarismScore);

        int codeScore = grader.grade(submission);
        System.out.println("CodeScore=" + codeScore);

        reportService.writeReport(submission, plagiarismScore, codeScore);

        int total = plagiarismScore + codeScore;
        String result = total >= 50 ? "PASS" : "FAIL";

        System.out.println("FINAL: " + result + " (total=" + total + ")");
    }
}