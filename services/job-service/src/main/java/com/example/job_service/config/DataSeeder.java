package com.example.job_service.config;

import com.example.job_service.model.JobPosition;
import com.example.job_service.model.Offer;
import com.example.job_service.model.RecruitmentRequest;
import com.example.job_service.repository.JobPositionRepository;
import com.example.job_service.repository.OfferRepository;
import com.example.job_service.repository.RecruitmentRequestRepository;
import com.example.job_service.utils.enums.JobPositionStatus;
import com.example.job_service.utils.enums.OfferStatus;
import com.example.job_service.utils.enums.RecruitmentRequestStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataSeeder implements CommandLineRunner {

    private final RecruitmentRequestRepository recruitmentRequestRepository;
    private final JobPositionRepository jobPositionRepository;
    private final OfferRepository offerRepository;

    @Override
    @Transactional
    public void run(String... args) {
        seedRecruitmentRequests();
    }

    private void seedRecruitmentRequests() {
        if (recruitmentRequestRepository.count() > 0) {
            log.info("RecruitmentRequest data already seeded. Skipping...");
            return;
        }

        log.info("Seeding job-service data...");

        RecruitmentRequest request1 = new RecruitmentRequest();
        request1.setTitle("Recruit Java Backend Engineers");
        request1.setQuantity(2);
        request1.setReason("Expand product team");
        request1.setSalaryMin(new BigDecimal("18000000"));
        request1.setSalaryMax(new BigDecimal("30000000"));
        request1.setStatus(RecruitmentRequestStatus.APPROVED);
        request1.setRequesterId(2L);
        request1.setOwnerUserId(2L);
        request1.setDepartmentId(1L);
        request1.setWorkflowId(1L);
        request1.setSubmittedAt(LocalDateTime.now().minusDays(10));
        request1.setActive(true);

        RecruitmentRequest request2 = new RecruitmentRequest();
        request2.setTitle("Recruit QA Engineers");
        request2.setQuantity(1);
        request2.setReason("Increase testing capacity");
        request2.setSalaryMin(new BigDecimal("14000000"));
        request2.setSalaryMax(new BigDecimal("22000000"));
        request2.setStatus(RecruitmentRequestStatus.SUBMITTED);
        request2.setRequesterId(3L);
        request2.setOwnerUserId(3L);
        request2.setDepartmentId(1L);
        request2.setWorkflowId(1L);
        request2.setSubmittedAt(LocalDateTime.now().minusDays(3));
        request2.setActive(true);

        List<RecruitmentRequest> savedRequests = recruitmentRequestRepository.saveAll(List.of(request1, request2));

        // Insert JobPosition after RecruitmentRequest because recruitment_request_id is FK.
        List<JobPosition> savedPositions = seedJobPositions(savedRequests);

        // Insert Offer after request data to provide test records for offer APIs.
        seedOffers(savedPositions);

        log.info("Job-service seeding completed.");
    }

    private List<JobPosition> seedJobPositions(List<RecruitmentRequest> requests) {
        if (jobPositionRepository.count() > 0) {
            log.info("JobPosition data already seeded. Skipping...");
            return jobPositionRepository.findAll();
        }

        JobPosition backend = new JobPosition();
        backend.setTitle("Backend Developer");
        backend.setDescription("Build microservices with Spring Boot");
        backend.setRequirements("Spring Boot, JPA, PostgreSQL");
        backend.setBenefits("13th month salary, health insurance");
        backend.setSalaryMin(new BigDecimal("18000000"));
        backend.setSalaryMax(new BigDecimal("30000000"));
        backend.setEmploymentType("FULL_TIME");
        backend.setExperienceLevel("MID");
        backend.setLocation("Ho Chi Minh City");
        backend.setRemote(false);
        backend.setQuantity(2);
        backend.setDeadline(LocalDate.now().plusDays(30));
        backend.setYearsOfExperience("2+");
        backend.setPublishedAt(LocalDateTime.now().minusDays(2));
        backend.setStatus(JobPositionStatus.PUBLISHED);
        backend.setRecruitmentRequest(requests.get(0));

        JobPosition qa = new JobPosition();
        qa.setTitle("QA Engineer");
        qa.setDescription("Design and execute test cases");
        qa.setRequirements("Manual testing, API testing");
        qa.setBenefits("Hybrid working model");
        qa.setSalaryMin(new BigDecimal("14000000"));
        qa.setSalaryMax(new BigDecimal("22000000"));
        qa.setEmploymentType("FULL_TIME");
        qa.setExperienceLevel("JUNIOR");
        qa.setLocation("Ha Noi");
        qa.setRemote(true);
        qa.setQuantity(1);
        qa.setDeadline(LocalDate.now().plusDays(20));
        qa.setYearsOfExperience("1+");
        qa.setPublishedAt(LocalDateTime.now().minusDays(1));
        qa.setStatus(JobPositionStatus.DRAFT);
        qa.setRecruitmentRequest(requests.get(1));

        return jobPositionRepository.saveAll(List.of(backend, qa));
    }

    private void seedOffers(List<JobPosition> positions) {
        if (offerRepository.count() > 0) {
            log.info("Offer data already seeded. Skipping...");
            return;
        }

        Offer offer = new Offer();
        offer.setCandidateId(1L);
        offer.setBasicSalary(22000000L);
        offer.setProbationSalaryRate(85);
        offer.setOnboardingDate(LocalDate.now().plusDays(14));
        offer.setProbationPeriod(2);
        offer.setNotes("Offer for backend role");
        offer.setStatus(OfferStatus.PENDING);
        offer.setRequesterId(2L);
        offer.setOwnerUserId(2L);
        offer.setWorkflowId(1L);
        offer.setSubmittedAt(LocalDateTime.now().minusDays(1));
        offer.setIsActive(true);

        offerRepository.save(offer);
    }
}
