package com.example.tickets;

import java.util.List;

public class TicketService {

    public IncidentTicket createTicket(String id, String reporterEmail, String title) {

        // No validation here — Builder will handle it

        return IncidentTicket.builder()
                .id(id)
                .reporterEmail(reporterEmail)
                .title(title)
                .priority("MEDIUM")
                .source("CLI")
                .customerVisible(false)
                .tags(List.of("NEW"))
                .build();
    }

    public IncidentTicket escalateToCritical(IncidentTicket t) {

        // Create NEW ticket instead of modifying
        return t.toBuilder()
                .priority("CRITICAL")
                .addTag("ESCALATED")
                .build();
    }

    public IncidentTicket assign(IncidentTicket t, String assigneeEmail) {

        // Builder validation will check email
        return t.toBuilder()
                .assigneeEmail(assigneeEmail)
                .build();
    }
}