public class Main {
    public static void main(String[] args) {

        Submission submission =
                new Submission("23BCS1007", "public class Test{}", "Test.java");

        Grader grader = new CodeGrader();
        PlagiarismService checker = new PlagiarismChecker();
        ReportService writer = new ReportWriter();

        EvaluationPipeline pipeline =
                new EvaluationPipeline(grader, checker, writer);

        pipeline.evaluate(submission);
    }
}