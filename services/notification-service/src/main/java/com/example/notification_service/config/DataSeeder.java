package com.example.notification_service.config;

import com.example.notification_service.model.Notification;
import com.example.notification_service.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataSeeder implements CommandLineRunner {

    private final NotificationRepository notificationRepository;

    @Override
    @Transactional
    public void run(String... args) {
        seedNotifications();
    }

    private void seedNotifications() {
        if (notificationRepository.count() > 0) {
            log.info("Notification data already seeded. Skipping...");
            return;
        }

        log.info("Seeding notification-service data...");

        Notification notification1 = new Notification();
        notification1.setTitle("Interview Scheduled");
        notification1.setMessage("Interview for candidate #1 is scheduled tomorrow.");
        notification1.setRecipientId(2L);
        notification1.setSentAt(LocalDateTime.now().minusHours(5));
        notification1.setRead(false);
        notification1.setDelivered(true);
        notification1.setDeliveryStatus("DELIVERED");
        notification1.setExternalId("notif-seed-1");

        Notification notification2 = new Notification();
        notification2.setTitle("Offer Pending Approval");
        notification2.setMessage("Offer #1 is waiting for manager approval.");
        notification2.setRecipientId(3L);
        notification2.setSentAt(LocalDateTime.now().minusHours(2));
        notification2.setReadAt(LocalDateTime.now().minusHours(1));
        notification2.setRead(true);
        notification2.setDelivered(true);
        notification2.setDeliveryStatus("DELIVERED");
        notification2.setExternalId("notif-seed-2");

        notificationRepository.saveAll(List.of(notification1, notification2));
    }
}
