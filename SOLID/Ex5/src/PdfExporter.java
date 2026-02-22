import java.nio.charset.StandardCharsets;

public class PdfExporter extends Exporter {

    @Override
    protected ExportResult doExport(ExportRequest req) {

        if (req.body != null && req.body.length() > 20) {
            return error("application/pdf",
                    "ERROR: PDF cannot handle content > 20 chars");
        }

        String body = req.body == null ? "" : req.body;
        String title = req.title == null ? "" : req.title;

        String fakePdf = "PDF(" + title + "):" + body;

        return new ExportResult(
                "application/pdf",
                fakePdf.getBytes(StandardCharsets.UTF_8)
        );
    }
}