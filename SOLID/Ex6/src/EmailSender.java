public class EmailSender extends NotificationSender {

    public EmailSender(AuditLog audit) {
        super(audit);
    }

    @Override
    public void send(Notification n) {
        String body = n.body == null ? "" : n.body;

        // Keep existing behavior (truncate if long)
        if (body.length() > 40) {
            body = body.substring(0, 40);
        }

        System.out.println("EMAIL -> to=" + n.email +
                " subject=" + n.subject +
                " body=" + body);

        audit.add("email sent");
    }
}