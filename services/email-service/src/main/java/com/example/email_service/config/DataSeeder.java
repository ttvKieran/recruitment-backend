package com.example.email_service.config;

import com.example.email_service.model.MailMessage;
import com.example.email_service.repository.MailMessageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataSeeder implements CommandLineRunner {

    private final MailMessageRepository mailMessageRepository;

    @Override
    @Transactional
    public void run(String... args) {
        seedMailMessages();
    }

    private void seedMailMessages() {
        if (mailMessageRepository.count() > 0) {
            log.info("MailMessage data already seeded. Skipping...");
            return;
        }

        log.info("Seeding email-service data...");

        MailMessage sentMail = new MailMessage();
        sentMail.setFromEmail("noreply@company.com");
        sentMail.setToEmail("candidate.a@example.com");
        sentMail.setSent(true);
        sentMail.setSubject("Welcome to Recruitment Portal");
        sentMail.setContent("Your application has been received.");
        sentMail.setRead(true);
        sentMail.setDeleted(false);
        sentMail.setGmailMessageId("email-seed-1");

        MailMessage inboxMail = new MailMessage();
        inboxMail.setFromEmail("candidate.b@example.com");
        inboxMail.setToEmail("hr@company.com");
        inboxMail.setSent(false);
        inboxMail.setSubject("Question about Job Description");
        inboxMail.setContent("Could you clarify probation period details?");
        inboxMail.setRead(false);
        inboxMail.setDeleted(false);
        inboxMail.setGmailMessageId("email-seed-2");

        mailMessageRepository.saveAll(List.of(sentMail, inboxMail));
    }
}
