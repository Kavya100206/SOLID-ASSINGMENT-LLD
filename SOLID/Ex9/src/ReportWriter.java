public class ReportWriter implements ReportService {

    @Override
    public void writeReport(Submission submission, int plagiarismScore, int codeScore) {
        System.out.println("Report written: report-" + submission.roll + ".txt");
    }
}