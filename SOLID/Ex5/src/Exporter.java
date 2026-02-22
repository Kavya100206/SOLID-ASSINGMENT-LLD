import java.nio.charset.StandardCharsets;

public abstract class Exporter {

    // Template method (LSP safe)
    public final ExportResult export(ExportRequest req) {
        if (req == null) {
            return error("application/octet-stream", "ERROR: Request cannot be null");
        }
        return doExport(req);
    }

    protected abstract ExportResult doExport(ExportRequest req);

    protected ExportResult error(String type, String message) {
        return new ExportResult(
                type,
                message.getBytes(StandardCharsets.UTF_8)
        );
    }
}