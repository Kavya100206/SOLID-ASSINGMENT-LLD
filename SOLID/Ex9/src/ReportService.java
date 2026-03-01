public interface ReportService {
    void writeReport(Submission submission, int plagiarismScore, int codeScore);
}