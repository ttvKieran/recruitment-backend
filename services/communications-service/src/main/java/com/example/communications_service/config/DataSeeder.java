package com.example.communications_service.config;

import com.example.communications_service.model.MailMessage;
import com.example.communications_service.model.Schedule;
import com.example.communications_service.model.ScheduleParticipant;
import com.example.communications_service.repository.MailMessageRepository;
import com.example.communications_service.repository.ScheduleParticipantRepository;
import com.example.communications_service.repository.ScheduleRepository;
import com.example.communications_service.utils.enums.MeetingType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataSeeder implements CommandLineRunner {

    private final ScheduleRepository scheduleRepository;
    private final ScheduleParticipantRepository scheduleParticipantRepository;
    private final MailMessageRepository mailMessageRepository;

    @Override
    @Transactional
    public void run(String... args) {
        seedSchedules();
        seedMailMessages();
    }

    private void seedSchedules() {
        if (scheduleRepository.count() > 0) {
            log.info("Schedule data already seeded. Skipping...");
            return;
        }

        log.info("Seeding communications-service schedules...");

        Schedule interview = new Schedule();
        interview.setTitle("Backend Interview Round 1");
        interview.setDescription("Technical interview for candidate #1");
        interview.setFormat("ONLINE");
        interview.setMeetingType(MeetingType.INTERVIEW);
        interview.setStatus("SCHEDULED");
        interview.setLocation("Google Meet");
        interview.setStartTime(LocalDateTime.now().plusDays(1));
        interview.setEndTime(LocalDateTime.now().plusDays(1).plusHours(1));
        interview.setTimezone("Asia/Ho_Chi_Minh");
        interview.setReminderTime(30);
        interview.setRoomId(101L);
        interview.setCreatedById(2L);

        Schedule teamMeeting = new Schedule();
        teamMeeting.setTitle("Weekly Hiring Sync");
        teamMeeting.setDescription("Update hiring pipeline status");
        teamMeeting.setFormat("OFFLINE");
        teamMeeting.setMeetingType(MeetingType.MEETING);
        teamMeeting.setStatus("SCHEDULED");
        teamMeeting.setLocation("Meeting Room A");
        teamMeeting.setStartTime(LocalDateTime.now().plusDays(2));
        teamMeeting.setEndTime(LocalDateTime.now().plusDays(2).plusHours(1));
        teamMeeting.setTimezone("Asia/Ho_Chi_Minh");
        teamMeeting.setReminderTime(15);
        teamMeeting.setRoomId(102L);
        teamMeeting.setCreatedById(3L);

        List<Schedule> schedules = scheduleRepository.saveAll(List.of(interview, teamMeeting));

        // Insert participants after schedule because schedule_id is FK.
        seedScheduleParticipants(schedules);
    }

    private void seedScheduleParticipants(List<Schedule> schedules) {
        if (scheduleParticipantRepository.count() > 0) {
            log.info("ScheduleParticipant data already seeded. Skipping...");
            return;
        }

        ScheduleParticipant interviewer = new ScheduleParticipant();
        interviewer.setParticipantType("USER");
        interviewer.setParticipantId(2L);
        interviewer.setResponseStatus("ACCEPTED");
        interviewer.setSchedule(schedules.get(0));

        ScheduleParticipant candidate = new ScheduleParticipant();
        candidate.setParticipantType("CANDIDATE");
        candidate.setParticipantId(1L);
        candidate.setResponseStatus("PENDING");
        candidate.setSchedule(schedules.get(0));

        ScheduleParticipant manager = new ScheduleParticipant();
        manager.setParticipantType("USER");
        manager.setParticipantId(3L);
        manager.setResponseStatus("ACCEPTED");
        manager.setSchedule(schedules.get(1));

        scheduleParticipantRepository.saveAll(List.of(interviewer, candidate, manager));

        Set<ScheduleParticipant> firstParticipants = new HashSet<>(List.of(interviewer, candidate));
        Set<ScheduleParticipant> secondParticipants = new HashSet<>(List.of(manager));
        schedules.get(0).setParticipants(firstParticipants);
        schedules.get(1).setParticipants(secondParticipants);
    }

    private void seedMailMessages() {
        if (mailMessageRepository.count() > 0) {
            log.info("MailMessage data already seeded. Skipping...");
            return;
        }

        log.info("Seeding communications-service mail messages...");

        MailMessage mail1 = new MailMessage();
        mail1.setFromEmail("hr@example.com");
        mail1.setToEmail("candidate.a@example.com");
        mail1.setSent(true);
        mail1.setSubject("Interview Invitation");
        mail1.setContent("Please join interview tomorrow at 9:00 AM.");
        mail1.setRead(true);
        mail1.setDeleted(false);
        mail1.setGmailMessageId("comm-seed-1");

        MailMessage mail2 = new MailMessage();
        mail2.setFromEmail("candidate.a@example.com");
        mail2.setToEmail("hr@example.com");
        mail2.setSent(false);
        mail2.setSubject("Re: Interview Invitation");
        mail2.setContent("Thank you, I confirm attendance.");
        mail2.setRead(false);
        mail2.setDeleted(false);
        mail2.setGmailMessageId("comm-seed-2");

        mailMessageRepository.saveAll(List.of(mail1, mail2));
    }
}
