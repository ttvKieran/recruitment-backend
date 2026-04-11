package com.example.workflow_service.config;

import com.example.workflow_service.model.ApprovalTracking;
import com.example.workflow_service.model.Workflow;
import com.example.workflow_service.model.WorkflowStep;
import com.example.workflow_service.repository.ApprovalTrackingRepository;
import com.example.workflow_service.repository.WorkflowRepository;
import com.example.workflow_service.repository.WorkflowStepRepository;
import com.example.workflow_service.utils.enums.ApprovalStatus;
import com.example.workflow_service.utils.enums.WorkflowType;
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

    private final WorkflowRepository workflowRepository;
    private final WorkflowStepRepository workflowStepRepository;
    private final ApprovalTrackingRepository approvalTrackingRepository;

    @Override
    @Transactional
    public void run(String... args) {
        seedWorkflows();
    }

    private void seedWorkflows() {
        if (workflowRepository.count() > 0) {
            log.info("Workflow data already seeded. Skipping...");
            return;
        }

        log.info("Seeding workflow-service data...");

        Workflow requestWorkflow = new Workflow();
        requestWorkflow.setName("Default Request Workflow");
        requestWorkflow.setDescription("Default approval flow for recruitment request");
        requestWorkflow.setType(WorkflowType.REQUEST);
        requestWorkflow.setDepartmentId(1L);
        requestWorkflow.setIsActive(true);
        requestWorkflow.setCreatedBy(1L);

        Workflow offerWorkflow = new Workflow();
        offerWorkflow.setName("Default Offer Workflow");
        offerWorkflow.setDescription("Default approval flow for offers");
        offerWorkflow.setType(WorkflowType.OFFER);
        offerWorkflow.setDepartmentId(1L);
        offerWorkflow.setIsActive(true);
        offerWorkflow.setCreatedBy(1L);

        List<Workflow> workflows = workflowRepository.saveAll(List.of(requestWorkflow, offerWorkflow));

        // Insert steps after workflow creation because workflow_id is FK.
        List<WorkflowStep> steps = seedWorkflowSteps(workflows);

        // Insert tracking after steps because step_id is FK.
        seedApprovalTrackings(steps);
    }

    private List<WorkflowStep> seedWorkflowSteps(List<Workflow> workflows) {
        if (workflowStepRepository.count() > 0) {
            log.info("WorkflowStep data already seeded. Skipping...");
            return workflowStepRepository.findAll();
        }

        WorkflowStep reqStep1 = new WorkflowStep();
        reqStep1.setWorkflow(workflows.get(0));
        reqStep1.setStepOrder(1);
        reqStep1.setApproverPositionId(2L);
        reqStep1.setIsActive(true);

        WorkflowStep reqStep2 = new WorkflowStep();
        reqStep2.setWorkflow(workflows.get(0));
        reqStep2.setStepOrder(2);
        reqStep2.setApproverPositionId(1L);
        reqStep2.setIsActive(true);

        WorkflowStep offerStep1 = new WorkflowStep();
        offerStep1.setWorkflow(workflows.get(1));
        offerStep1.setStepOrder(1);
        offerStep1.setApproverPositionId(2L);
        offerStep1.setIsActive(true);

        return workflowStepRepository.saveAll(List.of(reqStep1, reqStep2, offerStep1));
    }

    private void seedApprovalTrackings(List<WorkflowStep> steps) {
        if (approvalTrackingRepository.count() > 0) {
            log.info("ApprovalTracking data already seeded. Skipping...");
            return;
        }

        ApprovalTracking tracking = new ApprovalTracking();
        tracking.setRequestId(1L);
        tracking.setStep(steps.get(0));
        tracking.setStatus(ApprovalStatus.PENDING);
        tracking.setActionType("SUBMIT");
        tracking.setApproverPositionId(steps.get(0).getApproverPositionId());
        tracking.setActionUserId(2L);
        tracking.setActionAt(LocalDateTime.now().minusDays(1));
        tracking.setNotes("Initial submit for approval");

        approvalTrackingRepository.save(tracking);
    }
}
