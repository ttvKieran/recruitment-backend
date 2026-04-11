package com.example.candidate_service.config;

import com.example.candidate_service.model.Candidate;
import com.example.candidate_service.model.Comment;
import com.example.candidate_service.model.ReviewCandidate;
import com.example.candidate_service.repository.CandidateRepository;
import com.example.candidate_service.repository.CommentRepository;
import com.example.candidate_service.repository.ReviewCandidateRepository;
import com.example.candidate_service.utils.enums.CandidateStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataSeeder implements CommandLineRunner {

    private final CandidateRepository candidateRepository;
    private final CommentRepository commentRepository;
    private final ReviewCandidateRepository reviewCandidateRepository;

    @Override
    @Transactional
    public void run(String... args) {
        seedCandidates();
    }

    private void seedCandidates() {
        if (candidateRepository.count() > 0) {
            log.info("Candidate data already seeded. Skipping...");
            return;
        }

        log.info("Seeding candidate-service data...");

        Candidate candidate1 = new Candidate();
        candidate1.setName("Nguyen Van A");
        candidate1.setEmail("candidate.a@example.com");
        candidate1.setPhone("0900000001");
        candidate1.setDateOfBirth(LocalDate.of(2000, 1, 10));
        candidate1.setGender("MALE");
        candidate1.setNationality("VN");
        candidate1.setIdNumber("CAND000001");
        candidate1.setAddress("Ho Chi Minh City");
        candidate1.setHighestEducation("Bachelor");
        candidate1.setUniversity("HCMUT");
        candidate1.setGraduationYear("2022");
        candidate1.setGpa(new BigDecimal("3.45"));
        candidate1.setNotes("Strong Java background");
        candidate1.setAppliedDate(LocalDate.now().minusDays(5));
        candidate1.setStatus(CandidateStatus.REVIEWING);
        candidate1.setResumeUrl("https://example.com/resume-a.pdf");
        candidate1.setJobPositionId(1L);

        Candidate candidate2 = new Candidate();
        candidate2.setName("Tran Thi B");
        candidate2.setEmail("candidate.b@example.com");
        candidate2.setPhone("0900000002");
        candidate2.setDateOfBirth(LocalDate.of(1999, 8, 20));
        candidate2.setGender("FEMALE");
        candidate2.setNationality("VN");
        candidate2.setIdNumber("CAND000002");
        candidate2.setAddress("Ha Noi");
        candidate2.setHighestEducation("Bachelor");
        candidate2.setUniversity("NEU");
        candidate2.setGraduationYear("2021");
        candidate2.setGpa(new BigDecimal("3.70"));
        candidate2.setNotes("Good communication skills");
        candidate2.setAppliedDate(LocalDate.now().minusDays(2));
        candidate2.setStatus(CandidateStatus.INTERVIEW);
        candidate2.setResumeUrl("https://example.com/resume-b.pdf");
        candidate2.setJobPositionId(2L);

        List<Candidate> savedCandidates = candidateRepository.saveAll(List.of(candidate1, candidate2));

        // Insert child tables after candidates to satisfy FK candidate_id.
        seedComments(savedCandidates);
        seedReviews(savedCandidates);

        log.info("Candidate-service seeding completed.");
    }

    private void seedComments(List<Candidate> candidates) {
        if (commentRepository.count() > 0) {
            log.info("Comment data already seeded. Skipping...");
            return;
        }

        Comment comment1 = new Comment();
        comment1.setCandidate(candidates.get(0));
        comment1.setEmployeeId(1L);
        comment1.setContent("Candidate profile looks promising.");

        Comment comment2 = new Comment();
        comment2.setCandidate(candidates.get(1));
        comment2.setEmployeeId(2L);
        comment2.setContent("Please arrange technical interview.");

        commentRepository.saveAll(List.of(comment1, comment2));
    }

    private void seedReviews(List<Candidate> candidates) {
        if (reviewCandidateRepository.count() > 0) {
            log.info("ReviewCandidate data already seeded. Skipping...");
            return;
        }

        ReviewCandidate review = new ReviewCandidate();
        review.setCandidate(candidates.get(1));
        review.setReviewerId(2L);
        review.setProfessionalSkillScore(4);
        review.setCommunicationSkillScore(5);
        review.setWorkExperienceScore(4);
        review.setStrengths("Fast learner and clear communication");
        review.setWeaknesses("Needs deeper Spring Security knowledge");
        review.setConclusion(Boolean.TRUE);

        reviewCandidateRepository.save(review);
    }
}
