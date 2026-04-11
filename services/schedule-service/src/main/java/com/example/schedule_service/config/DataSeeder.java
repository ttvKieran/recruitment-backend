package com.example.schedule_service.config;

import com.example.schedule_service.model.Schedule;
import com.example.schedule_service.model.ScheduleParticipant;
import com.example.schedule_service.repository.ScheduleParticipantRepository;
import com.example.schedule_service.repository.ScheduleRepository;
import com.example.schedule_service.utils.enums.MeetingType;
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

    private final ScheduleRepository scheduleRepository;
    private final ScheduleParticipantRepository scheduleParticipantRepository;

    @Override
    @Transactional
    public void run(String... args) {
        seedSchedules();
    }

    private void seedSchedules() {
        if (scheduleRepository.count() > 0) {
            log.info("Schedule data already seeded. Skipping...");
            return;
        }

        log.info("Seeding schedule-service data...");

        Schedule interview = new Schedule();
        interview.setTitle("Interview Candidate #1");
        interview.setDescription("Round 2 interview");
        interview.setFormat("ONLINE");
        interview.setMeetingType(MeetingType.INTERVIEW);
        interview.setStatus("SCHEDULED");
        interview.setLocation("Google Meet");
        interview.setStartTime(LocalDateTime.now().plusDays(1));
        interview.setEndTime(LocalDateTime.now().plusDays(1).plusHours(1));
        interview.setReminderTime(30);
        interview.setReminderSent(false);
        interview.setRoomId(201L);
        interview.setCreatedById(2L);

        Schedule training = new Schedule();
        training.setTitle("Onboarding Training");
        training.setDescription("Training for new hires");
        training.setFormat("OFFLINE");
        training.setMeetingType(MeetingType.TRAINING);
        training.setStatus("SCHEDULED");
        training.setLocation("Room B");
        training.setStartTime(LocalDateTime.now().plusDays(3));
        training.setEndTime(LocalDateTime.now().plusDays(3).plusHours(2));
        training.setReminderTime(60);
        training.setReminderSent(false);
        training.setRoomId(202L);
        training.setCreatedById(3L);

        List<Schedule> schedules = scheduleRepository.saveAll(List.of(interview, training));

        // Insert participants after schedules to satisfy FK schedule_id.
        seedParticipants(schedules);
    }

    private void seedParticipants(List<Schedule> schedules) {
        if (scheduleParticipantRepository.count() > 0) {
            log.info("ScheduleParticipant data already seeded. Skipping...");
            return;
        }

        ScheduleParticipant p1 = new ScheduleParticipant();
        p1.setParticipantType("USER");
        p1.setParticipantId(2L);
        p1.setResponseStatus("ACCEPTED");
        p1.setSchedule(schedules.get(0));

        ScheduleParticipant p2 = new ScheduleParticipant();
        p2.setParticipantType("CANDIDATE");
        p2.setParticipantId(1L);
        p2.setResponseStatus("PENDING");
        p2.setSchedule(schedules.get(0));

        ScheduleParticipant p3 = new ScheduleParticipant();
        p3.setParticipantType("USER");
        p3.setParticipantId(3L);
        p3.setResponseStatus("ACCEPTED");
        p3.setSchedule(schedules.get(1));

        scheduleParticipantRepository.saveAll(List.of(p1, p2, p3));
    }
}
