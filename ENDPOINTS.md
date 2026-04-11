# Recruitment Backend — Full Endpoints List

Phiên bản: 1.0 — danh sách đầy đủ các endpoint (HTTP method + path) được trích xuất trực tiếp từ các controller trong `recruitment-backend`.

Lưu ý: tất cả đường dẫn có tiền tố base được ghi đầy đủ theo `RequestMapping` lớp; gateway định tuyến theo `/api/v1/{service-name}/...`.

---

## communications-service

Base: `/api/v1/communications-service`

### Schedules (`/schedules`)
- POST `/api/v1/communications-service/schedules` — create schedule
- PUT `/api/v1/communications-service/schedules/{id}` — update schedule
- DELETE `/api/v1/communications-service/schedules/{id}` — delete schedule
- GET `/api/v1/communications-service/schedules/{id}` — get schedule by id
- GET `/api/v1/communications-service/schedules` — get all schedules (filters: day/week/month/year/status/meetingType/participantId/participantType/startDate/endDate)
- PUT `/api/v1/communications-service/schedules/{id}/status` — update schedule status
- GET `/api/v1/communications-service/schedules/calendar` — calendar view (startDate, endDate, participantId, participantType)
- GET `/api/v1/communications-service/schedules/available-participants` — available participants (startTime, endTime)

### Mail (`/mail`)
- POST `/api/v1/communications-service/mail/send/gmail` — send gmail
- GET `/api/v1/communications-service/mail/inbox` — inbox (page, limit)
- GET `/api/v1/communications-service/mail/sent` — sent (page, limit)
- PUT `/api/v1/communications-service/mail/{id}/read` — mark read
- DELETE `/api/v1/communications-service/mail/{id}/permanent` — permanent delete
- GET `/api/v1/communications-service/mail` — list emails (folder/read/keyword/sortBy/sortOrder/page/limit)

---

## job-service

Base: `/api/v1/job-service`

### Recruitment requests (`/recruitment-requests`)
- POST `/api/v1/job-service/recruitment-requests` — create
- POST `/api/v1/job-service/recruitment-requests/submit/{id}` — submit
- POST `/api/v1/job-service/recruitment-requests/approve/{id}` — approve current step
- POST `/api/v1/job-service/recruitment-requests/reject/{id}` — reject current step
- POST `/api/v1/job-service/recruitment-requests/return/{id}` — return request
- POST `/api/v1/job-service/recruitment-requests/cancel/{id}` — cancel request
- GET `/api/v1/job-service/recruitment-requests/{id}` — get by id
- GET `/api/v1/job-service/recruitment-requests` — list (filters: departmentId/status/createdBy/keyword/page/limit/sortBy/sortOrder)
- GET `/api/v1/job-service/recruitment-requests/simple` — simple list
- PUT `/api/v1/job-service/recruitment-requests/{id}` — update
- DELETE `/api/v1/job-service/recruitment-requests/{id}` — delete
- POST `/api/v1/job-service/recruitment-requests/withdraw/{id}` — withdraw

### Offers (`/offers`)
- POST `/api/v1/job-service/offers` — create
- POST `/api/v1/job-service/offers/submit/{id}` — submit
- POST `/api/v1/job-service/offers/approve/{id}` — approve
- POST `/api/v1/job-service/offers/reject/{id}` — reject
- POST `/api/v1/job-service/offers/return/{id}` — return
- POST `/api/v1/job-service/offers/cancel/{id}` — cancel
- POST `/api/v1/job-service/offers/withdraw/{id}` — withdraw
- GET `/api/v1/job-service/offers/{id}` — get offer detail
- GET `/api/v1/job-service/offers` — list (filters)
- GET `/api/v1/job-service/offers/simple` — simple list
- PUT `/api/v1/job-service/offers/{id}` — update
- DELETE `/api/v1/job-service/offers/{id}` — delete

### Job positions (`/job-positions`)
- POST `/api/v1/job-service/job-positions` — create job position
- GET `/api/v1/job-service/job-positions/{id}` — get by id (detailed)
- GET `/api/v1/job-service/job-positions/simple/{id}` — get by id simple
- GET `/api/v1/job-service/job-positions` — list (filters)
- GET `/api/v1/job-service/job-positions/simple` — simple list (paged)
- GET `/api/v1/job-service/job-positions?ids=...` — get by ids
- GET `/api/v1/job-service/job-positions/published` — published (paged)
- GET `/api/v1/job-service/job-positions/published/{id}` — published by id
- PUT `/api/v1/job-service/job-positions/{id}` — update
- DELETE `/api/v1/job-service/job-positions/{id}` — delete
- POST `/api/v1/job-service/job-positions/{id}/publish` — publish
- POST `/api/v1/job-service/job-positions/{id}/close` — close
- POST `/api/v1/job-service/job-positions/{id}/reopen` — reopen

---

## workflow-service

Base: `/api/v1/workflow-service`

### Workflows (`/workflows`)
- GET `/api/v1/workflow-service/workflows` — list (type/isActive/keyword/departmentId/page/limit/sort)
- GET `/api/v1/workflow-service/workflows/{id}` — get by id
- POST `/api/v1/workflow-service/workflows` — create
- PUT `/api/v1/workflow-service/workflows/{id}` — update
- DELETE `/api/v1/workflow-service/workflows/{id}` — delete

### Approval trackings (`/approval-trackings`)
- GET `/api/v1/workflow-service/approval-trackings` — list
- GET `/api/v1/workflow-service/approval-trackings/{id}` — get by id
- GET `/api/v1/workflow-service/approval-trackings/pending/{userId}` — pending approvals for user
- POST `/api/v1/workflow-service/approval-trackings/initialize` — initialize approval tracking
- POST `/api/v1/workflow-service/approval-trackings/{id}/approve` — approve step
- GET `/api/v1/workflow-service/approval-trackings/by-request/{requestId}` — get workflow info by requestId

---

## schedule-service

Base: `/api/v1/schedule-service/schedules`
- POST `/api/v1/schedule-service/schedules` — create schedule
- PUT `/api/v1/schedule-service/schedules/{id}` — update schedule
- DELETE `/api/v1/schedule-service/schedules/{id}` — delete schedule
- GET `/api/v1/schedule-service/schedules/{id}` — get by id
- GET `/api/v1/schedule-service/schedules` — get all (filters)
- PUT `/api/v1/schedule-service/schedules/status/{id}` — update schedule status (note: path differs from communications-service)
- GET `/api/v1/schedule-service/schedules/calendar` — calendar view
- GET `/api/v1/schedule-service/schedules/available-participants` — available participants
- GET `/api/v1/schedule-service/schedules/statistics` — schedules for statistics
- GET `/api/v1/schedule-service/schedules/candidates-by-interviewer/{employeeId}` — candidate IDs by interviewer

---

## user-service

Base: `/api/v1/user-service`

### Auth (`/auth`)
- POST `/api/v1/user-service/auth/login` — login
- GET `/api/v1/user-service/auth/account` — fetch account
- GET `/api/v1/user-service/auth/refresh` — refresh token (cookie)
- POST `/api/v1/user-service/auth/logout` — logout
- GET `/api/v1/user-service/auth/check` — check permission (query param `name`)

### Users (`/users`)
- GET `/api/v1/user-service/users` — list users (filters)
- POST `/api/v1/user-service/users` — create user
- PUT `/api/v1/user-service/users/{id}` — update user
- DELETE `/api/v1/user-service/users/{id}` — delete user
- GET `/api/v1/user-service/users/{id}` — get user by id
- GET `/api/v1/user-service/users?ids=...` — get users by ids
- GET `/api/v1/user-service/users?departmentIds=...` — get by departmentIds

### Roles (`/roles`)
- GET `/api/v1/user-service/roles` — list roles
- POST `/api/v1/user-service/roles` — create role
- PUT `/api/v1/user-service/roles/{id}` — update role
- DELETE `/api/v1/user-service/roles/{id}` — delete role
- GET `/api/v1/user-service/roles/{id}` — get role by id
- GET `/api/v1/user-service/roles?ids=...` — get roles by ids

### Reviews, Positions, Permissions, Employees, Departments
- Reviews: `/api/v1/user-service/reviews` — GET/POST/PUT/DELETE endpoints
- Positions: `/api/v1/user-service/positions` — GET/POST/PUT/DELETE/GET by id/GET?ids=
- Permissions: `/api/v1/user-service/permissions` — GET/POST/PUT/DELETE
- Employees: `/api/v1/user-service/employees` — GET/POST/PUT/DELETE/GET by id/GET?ids/GET?departmentIds, POST `/upload-avatar`, POST `/from-candidate`
- Departments: `/api/v1/user-service/departments` — GET/POST/PUT/DELETE/GET/{id}/GET/public/{id}/GET?ids=

---

## upload-service

Base: `/api/v1/upload`
- POST `/api/v1/upload` — upload file (form multipart `file`)

---

## notification-service

Base: `/api/v1/notification-service/notifications`
- POST `/api/v1/notification-service/notifications` — create notification
- POST `/api/v1/notification-service/notifications/bulk` — create bulk notifications
- POST `/api/v1/notification-service/notifications/bulk-by-conditions` — bulk by conditions
- GET `/api/v1/notification-service/notifications` — list notifications (filters)
- GET `/api/v1/notification-service/notifications/recipient/{recipientId}` — get by recipient
- PUT `/api/v1/notification-service/notifications/{notificationId}/read` — mark read
- PUT `/api/v1/notification-service/notifications/read-all` — mark all read for current user
- GET `/api/v1/notification-service/notifications/stats/{recipientId}` — stats

---

## candidate-service

Base: `/api/v1/candidate-service`

### Public upload
- POST `/api/v1/candidate-service/public/upload-cv` — upload CV (public)

### Candidates (`/candidates`)
- GET `/api/v1/candidate-service/candidates` — list (filters)
- GET `/api/v1/candidate-service/candidates/{id}` — detail
- GET `/api/v1/candidate-service/candidates/{id}/department` — departmentId
- GET `/api/v1/candidate-service/candidates/{id}/reviews` — reviews
- POST `/api/v1/candidate-service/candidates` — create
- PUT `/api/v1/candidate-service/candidates/{id}` — update
- DELETE `/api/v1/candidate-service/candidates/{id}` — delete
- GET `/api/v1/candidate-service/candidates?ids=...` — get by ids
- PUT `/api/v1/candidate-service/candidates/status/{id}` — update status (status, feedback)
- GET `/api/v1/candidate-service/candidates/count` — count by jobPositionId
- GET `/api/v1/candidate-service/candidates/statistics` — stats
- GET `/api/v1/candidate-service/candidates/interviewed` — interviewed by requester
- POST `/api/v1/candidate-service/candidates/convert/{id}` — convert to employee

### Comments (`/comments`)
- GET `/api/v1/candidate-service/comments` — list by candidateId
- GET `/api/v1/candidate-service/comments/{id}` — detail
- POST `/api/v1/candidate-service/comments` — create
- PUT `/api/v1/candidate-service/comments/{id}` — update
- DELETE `/api/v1/candidate-service/comments/{id}` — delete

### Reviews (`/reviews`)
- GET `/api/v1/candidate-service/reviews` — list
- GET `/api/v1/candidate-service/reviews/{id}` — detail
- POST `/api/v1/candidate-service/reviews` — create
- PUT `/api/v1/candidate-service/reviews/{id}` — update
- DELETE `/api/v1/candidate-service/reviews/{id}` — delete

---

## statistics-service

Base: `/api/v1/statistics-service/statistics`
- GET `/api/v1/statistics-service/statistics/summary` — summary statistics
- GET `/api/v1/statistics-service/statistics/job-openings` — job openings
- GET `/api/v1/statistics-service/statistics/upcoming-schedules` — upcoming schedules

---

## email-service

Base: `/api/v1/email-service/mail` (similar to communications mail):
- POST `/api/v1/email-service/mail/send/gmail`
- GET `/api/v1/email-service/mail/inbox`
- GET `/api/v1/email-service/mail/sent`
- PUT `/api/v1/email-service/mail/{id}/read`
- DELETE `/api/v1/email-service/mail/{id}/permanent`
- GET `/api/v1/email-service/mail`

---

## How to get more details
- This file was generated by scanning `*Controller.java` files. If you want request/response schemas and example payloads, I can:
  - Option A: automatically generate OpenAPI (springdoc) annotations and produce `openapi.json`/`swagger-ui`.
  - Option B: produce a detailed markdown doc per endpoint including request DTO fields and response DTO fields by scanning DTO classes.

---

File: `ENDPOINTS.md` in repository root of `recruitment-backend`.
# API ENDPOINTS DETAILS WITH PAYLOADS

> This section contains auto-generated payload structures for requests and responses for all controllers.


## com

### `GET` /api/v1/candidate-service/candidates
**Response:**
```json
{
  "meta": {
    "page": "int",
    "pageSize": "int",
    "pages": "int",
    "total": "long"
  },
  "result": "Object"
}
```

---

### `GET` /api/v1/candidate-service/candidates/{id}
**Response:**
```json
{
  "id": "Long",
  "name": "String",
  "email": "String",
  "phone": "String",
  "dateOfBirth": "LocalDate",
  "gender": "String",
  "nationality": "String",
  "idNumber": "String",
  "address": "String",
  "avatarUrl": "String",
  "highestEducation": "String",
  "university": "String",
  "graduationYear": "String",
  "gpa": "BigDecimal",
  "notes": "String",
  "appliedDate": "LocalDate",
  "status": "CandidateStatus",
  "rejectionReason": "String",
  "resumeUrl": "String",
  "jobPositionId": "Long",
  "reviews": [
    {
      "id": "Long",
      "candidateId": "Long",
      "reviewerId": "Long",
      "reviewerName": "String",
      "professionalSkillScore": "Integer",
      "communicationSkillScore": "Integer",
      "workExperienceScore": "Integer",
      "averageScore": "Double",
      "strengths": "String",
      "weaknesses": "String",
      "conclusion": "Boolean",
      "createdAt": "LocalDateTime",
      "updatedAt": "LocalDateTime"
    }
  ],
  "comments": [
    {
      "id": "Long",
      "employeeId": "Long",
      "employeeName": "String",
      "content": "String",
      "createdAt": "LocalDateTime"
    }
  ],
  "jobPosition": "Object",
  "upcomingSchedules": [
    "Object"
  ]
}
```

---

### `GET` /api/v1/candidate-service/candidates/{id}/department
**Response:**
```json
"Long"
```

---

### `GET` /api/v1/candidate-service/candidates/{id}/reviews
**Response:**
```json
[
  {
    "id": "Long",
    "candidateId": "Long",
    "reviewerId": "Long",
    "reviewerName": "String",
    "professionalSkillScore": "Integer",
    "communicationSkillScore": "Integer",
    "workExperienceScore": "Integer",
    "averageScore": "Double",
    "strengths": "String",
    "weaknesses": "String",
    "conclusion": "Boolean",
    "createdAt": "LocalDateTime",
    "updatedAt": "LocalDateTime"
  }
]
```

---

### `POST` /api/v1/candidate-service/candidates
**Request Body:**
```json
{
  "name": "String",
  "email": "String",
  "phone": "String",
  "jobPositionId": "Long",
  "cvUrl": "String",
  "notes": "String",
  "createdBy": "Long"
}
```
**Response:**
```json
{
  "id": "Long",
  "name": "String",
  "email": "String",
  "phone": "String",
  "dateOfBirth": "LocalDate",
  "gender": "String",
  "nationality": "String",
  "idNumber": "String",
  "address": "String",
  "avatarUrl": "String",
  "highestEducation": "String",
  "university": "String",
  "graduationYear": "String",
  "gpa": "BigDecimal",
  "notes": "String",
  "appliedDate": "LocalDate",
  "status": "CandidateStatus",
  "rejectionReason": "String",
  "resumeUrl": "String",
  "jobPositionId": "Long",
  "createdBy": "Long",
  "updatedBy": "Long",
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime",
  "comments": [
    {
      "id": "Long",
      "candidate": "Candidate",
      "employeeId": "Long",
      "content": "String",
      "createdAt": "LocalDateTime",
      "updatedAt": "LocalDateTime"
    }
  ],
  "reviews": [
    {
      "id": "Long",
      "candidate": "Candidate",
      "reviewerId": "Long",
      "professionalSkillScore": "Integer",
      "communicationSkillScore": "Integer",
      "workExperienceScore": "Integer",
      "strengths": "String",
      "weaknesses": "String",
      "conclusion": "Boolean",
      "createdAt": "LocalDateTime",
      "updatedAt": "LocalDateTime"
    }
  ]
}
```

---

### `PUT` /api/v1/candidate-service/candidates/{id}
**Request Body:**
```json
{
  "name": "String",
  "email": "String",
  "phone": "String",
  "dateOfBirth": "String",
  "gender": "String",
  "nationality": "String",
  "idNumber": "String",
  "address": "String",
  "avatarUrl": "String",
  "highestEducation": "String",
  "university": "String",
  "graduationYear": "String",
  "gpa": "BigDecimal",
  "notes": "String",
  "status": "CandidateStatus"
}
```
**Response:**
```json
{
  "id": "Long",
  "name": "String",
  "email": "String",
  "phone": "String",
  "dateOfBirth": "LocalDate",
  "gender": "String",
  "nationality": "String",
  "idNumber": "String",
  "address": "String",
  "avatarUrl": "String",
  "highestEducation": "String",
  "university": "String",
  "graduationYear": "String",
  "gpa": "BigDecimal",
  "notes": "String",
  "appliedDate": "LocalDate",
  "status": "CandidateStatus",
  "rejectionReason": "String",
  "resumeUrl": "String",
  "jobPositionId": "Long",
  "reviews": [
    {
      "id": "Long",
      "candidateId": "Long",
      "reviewerId": "Long",
      "reviewerName": "String",
      "professionalSkillScore": "Integer",
      "communicationSkillScore": "Integer",
      "workExperienceScore": "Integer",
      "averageScore": "Double",
      "strengths": "String",
      "weaknesses": "String",
      "conclusion": "Boolean",
      "createdAt": "LocalDateTime",
      "updatedAt": "LocalDateTime"
    }
  ],
  "comments": [
    {
      "id": "Long",
      "employeeId": "Long",
      "employeeName": "String",
      "content": "String",
      "createdAt": "LocalDateTime"
    }
  ],
  "jobPosition": "Object",
  "upcomingSchedules": [
    "Object"
  ]
}
```

---

### `DELETE` /api/v1/candidate-service/candidates/{id}

---

### `GET` /api/v1/candidate-service/candidates
**Response:**
```json
[
  {
    "id": "Long",
    "name": "String",
    "email": "String",
    "phone": "String",
    "dateOfBirth": "LocalDate",
    "gender": "String",
    "nationality": "String",
    "idNumber": "String",
    "address": "String",
    "avatarUrl": "String",
    "highestEducation": "String",
    "university": "String",
    "graduationYear": "String",
    "gpa": "BigDecimal",
    "notes": "String",
    "appliedDate": "LocalDate",
    "status": "CandidateStatus",
    "rejectionReason": "String",
    "resumeUrl": "String",
    "jobPositionId": "Long",
    "reviews": [
      "ReviewCandidateResponseDTO"
    ],
    "comments": [
      "CommentResponseDTO"
    ],
    "jobPosition": "Object",
    "upcomingSchedules": [
      "Object"
    ]
  }
]
```

---

### `PUT` /api/v1/candidate-service/candidates/status/{id}
**Response:**
```json
{
  "id": "Long",
  "name": "String",
  "email": "String",
  "phone": "String",
  "dateOfBirth": "LocalDate",
  "gender": "String",
  "nationality": "String",
  "idNumber": "String",
  "address": "String",
  "avatarUrl": "String",
  "highestEducation": "String",
  "university": "String",
  "graduationYear": "String",
  "gpa": "BigDecimal",
  "notes": "String",
  "appliedDate": "LocalDate",
  "status": "CandidateStatus",
  "rejectionReason": "String",
  "resumeUrl": "String",
  "jobPositionId": "Long",
  "reviews": [
    {
      "id": "Long",
      "candidateId": "Long",
      "reviewerId": "Long",
      "reviewerName": "String",
      "professionalSkillScore": "Integer",
      "communicationSkillScore": "Integer",
      "workExperienceScore": "Integer",
      "averageScore": "Double",
      "strengths": "String",
      "weaknesses": "String",
      "conclusion": "Boolean",
      "createdAt": "LocalDateTime",
      "updatedAt": "LocalDateTime"
    }
  ],
  "comments": [
    {
      "id": "Long",
      "employeeId": "Long",
      "employeeName": "String",
      "content": "String",
      "createdAt": "LocalDateTime"
    }
  ],
  "jobPosition": "Object",
  "upcomingSchedules": [
    "Object"
  ]
}
```

---

### `GET` /api/v1/candidate-service/candidates/count
**Response:**
```json
"Long"
```

---

### `GET` /api/v1/candidate-service/candidates/statistics
**Response:**
```json
[
  {
    "id": "Long",
    "appliedDate": "LocalDate",
    "status": "CandidateStatus",
    "jobPositionId": "Long",
    "departmentId": "Long",
    "candidateId": "Long"
  }
]
```

---

### `GET` /api/v1/candidate-service/candidates/interviewed
**Response:**
```json
[
  {
    "id": "Long",
    "name": "String",
    "email": "String",
    "phone": "String",
    "dateOfBirth": "LocalDate",
    "gender": "String",
    "nationality": "String",
    "idNumber": "String",
    "address": "String",
    "avatarUrl": "String",
    "highestEducation": "String",
    "university": "String",
    "graduationYear": "String",
    "gpa": "BigDecimal",
    "notes": "String",
    "appliedDate": "LocalDate",
    "status": "CandidateStatus",
    "resumeUrl": "String",
    "jobPositionId": "Long",
    "jobPositionTitle": "String",
    "departmentId": "Long"
  }
]
```

---

### `POST` /api/v1/candidate-service/candidates/convert/{id}
**Response:**
```json
"JsonNode"
```

---

### `GET` /api/v1/candidate-service/comments
**Response:**
```json
[
  {
    "id": "Long",
    "employeeId": "Long",
    "employeeName": "String",
    "content": "String",
    "createdAt": "LocalDateTime"
  }
]
```

---

### `GET` /api/v1/candidate-service/comments/{id}
**Response:**
```json
{
  "id": "Long",
  "employeeId": "Long",
  "employeeName": "String",
  "content": "String",
  "createdAt": "LocalDateTime"
}
```

---

### `POST` /api/v1/candidate-service/comments
**Request Body:**
```json
{
  "candidateId": "Long",
  "content": "String"
}
```
**Response:**
```json
{
  "id": "Long",
  "employeeId": "Long",
  "employeeName": "String",
  "content": "String",
  "createdAt": "LocalDateTime"
}
```

---

### `PUT` /api/v1/candidate-service/comments/{id}
**Request Body:**
```json
{
  "content": "String"
}
```
**Response:**
```json
{
  "id": "Long",
  "employeeId": "Long",
  "employeeName": "String",
  "content": "String",
  "createdAt": "LocalDateTime"
}
```

---

### `DELETE` /api/v1/candidate-service/comments/{id}

---

### `GET` /api/v1/candidate-service/reviews
**Response:**
```json
{
  "meta": {
    "page": "int",
    "pageSize": "int",
    "pages": "int",
    "total": "long"
  },
  "result": "Object"
}
```

---

### `GET` /api/v1/candidate-service/reviews/{id}
**Response:**
```json
{
  "id": "Long",
  "candidateId": "Long",
  "reviewerId": "Long",
  "reviewerName": "String",
  "professionalSkillScore": "Integer",
  "communicationSkillScore": "Integer",
  "workExperienceScore": "Integer",
  "averageScore": "Double",
  "strengths": "String",
  "weaknesses": "String",
  "conclusion": "Boolean",
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime"
}
```

---

### `POST` /api/v1/candidate-service/reviews
**Request Body:**
```json
{
  "candidateId": "Long",
  "professionalSkillScore": "Integer",
  "communicationSkillScore": "Integer",
  "workExperienceScore": "Integer",
  "strengths": "String",
  "weaknesses": "String",
  "conclusion": "Boolean"
}
```
**Response:**
```json
{
  "id": "Long",
  "candidateId": "Long",
  "reviewerId": "Long",
  "reviewerName": "String",
  "professionalSkillScore": "Integer",
  "communicationSkillScore": "Integer",
  "workExperienceScore": "Integer",
  "averageScore": "Double",
  "strengths": "String",
  "weaknesses": "String",
  "conclusion": "Boolean",
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime"
}
```

---

### `PUT` /api/v1/candidate-service/reviews/{id}
**Request Body:**
```json
{
  "professionalSkillScore": "Integer",
  "communicationSkillScore": "Integer",
  "workExperienceScore": "Integer",
  "strengths": "String",
  "weaknesses": "String",
  "conclusion": "Boolean"
}
```
**Response:**
```json
{
  "id": "Long",
  "candidateId": "Long",
  "reviewerId": "Long",
  "reviewerName": "String",
  "professionalSkillScore": "Integer",
  "communicationSkillScore": "Integer",
  "workExperienceScore": "Integer",
  "averageScore": "Double",
  "strengths": "String",
  "weaknesses": "String",
  "conclusion": "Boolean",
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime"
}
```

---

### `DELETE` /api/v1/candidate-service/reviews/{id}

---

### `POST` /api/v1/communications-service/mail/send/gmail
**Request Body:**
```json
{
  "toEmail": "String",
  "subject": "String",
  "content": "String"
}
```
**Response:**
```json
{
  "id": "Long",
  "fromEmail": "String",
  "toEmail": "String",
  "sent": "boolean",
  "subject": "String",
  "content": "String",
  "read": "boolean",
  "deleted": "boolean",
  "gmailMessageId": "String",
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime"
}
```

---

### `GET` /api/v1/communications-service/mail/inbox
**Response:**
```json
{
  "meta": {
    "page": "int",
    "pageSize": "int",
    "pages": "int",
    "total": "long"
  },
  "result": "Object"
}
```

---

### `GET` /api/v1/communications-service/mail/sent
**Response:**
```json
{
  "meta": {
    "page": "int",
    "pageSize": "int",
    "pages": "int",
    "total": "long"
  },
  "result": "Object"
}
```

---

### `PUT` /api/v1/communications-service/mail/{id}/read

---

### `DELETE` /api/v1/communications-service/mail/{id}/permanent

---

### `GET` /api/v1/communications-service/mail
**Response:**
```json
{
  "meta": {
    "page": "int",
    "pageSize": "int",
    "pages": "int",
    "total": "long"
  },
  "result": "Object"
}
```

---

### `POST` /api/v1/communications-service/schedules
**Request Body:**
```json
{
  "title": "String",
  "description": "String",
  "format": "String",
  "meetingType": "MeetingType",
  "status": "String",
  "location": "String",
  "startTime": "LocalDateTime",
  "endTime": "LocalDateTime",
  "timezone": "String",
  "reminderTime": "Integer",
  "createdById": "Long",
  "candidateId": "Long",
  "employeeIds": [
    "Long"
  ]
}
```
**Response:**
```json
{
  "id": "Long",
  "title": "String",
  "description": "String",
  "format": "String",
  "meetingType": "MeetingType",
  "status": "String",
  "location": "String",
  "startTime": "LocalDateTime",
  "endTime": "LocalDateTime",
  "reminderTime": "Integer",
  "reminderSent": "Boolean",
  "roomId": "Long",
  "participants": [
    {
      "id": "Long",
      "participantType": "String",
      "responseStatus": "String",
      "participantId": "Long",
      "schedule": "Schedule"
    }
  ],
  "createdById": "Long",
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime"
}
```

---

### `PUT` /api/v1/communications-service/schedules/{id}
**Request Body:**
```json
{
  "title": "String",
  "description": "String",
  "format": "String",
  "meetingType": "MeetingType",
  "status": "String",
  "location": "String",
  "startTime": "LocalDateTime",
  "endTime": "LocalDateTime",
  "timezone": "String",
  "reminderTime": "Integer",
  "createdById": "Long",
  "candidateId": "Long",
  "employeeIds": [
    "Long"
  ]
}
```
**Response:**
```json
{
  "id": "Long",
  "title": "String",
  "description": "String",
  "format": "String",
  "meetingType": "MeetingType",
  "status": "String",
  "location": "String",
  "startTime": "LocalDateTime",
  "endTime": "LocalDateTime",
  "reminderTime": "Integer",
  "reminderSent": "Boolean",
  "roomId": "Long",
  "participants": [
    {
      "id": "Long",
      "participantType": "String",
      "responseStatus": "String",
      "participantId": "Long",
      "schedule": "Schedule"
    }
  ],
  "createdById": "Long",
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime"
}
```

---

### `DELETE` /api/v1/communications-service/schedules/{id}
**Response:**
```json
"String"
```

---

### `GET` /api/v1/communications-service/schedules/{id}
**Response:**
```json
{
  "id": "Long",
  "title": "String",
  "description": "String",
  "format": "String",
  "meetingType": "MeetingType",
  "status": "String",
  "location": "String",
  "startTime": "LocalDateTime",
  "endTime": "LocalDateTime",
  "reminderTime": "Integer",
  "roomId": "Long",
  "createdById": "Long",
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime",
  "participants": [
    {
      "id": "Long",
      "participantType": "String",
      "responseStatus": "String",
      "participantId": "Long",
      "name": "String"
    }
  ]
}
```

---

### `GET` /api/v1/communications-service/schedules
**Response:**
```json
[
  {
    "id": "Long",
    "title": "String",
    "description": "String",
    "format": "String",
    "meetingType": "MeetingType",
    "status": "String",
    "location": "String",
    "startTime": "LocalDateTime",
    "endTime": "LocalDateTime",
    "reminderTime": "Integer",
    "roomId": "Long",
    "createdById": "Long",
    "createdAt": "LocalDateTime",
    "updatedAt": "LocalDateTime",
    "participants": [
      "ScheduleParticipantDTO"
    ]
  }
]
```

---

### `PUT` /api/v1/communications-service/schedules/{id}/status
**Request Body:**
```json
"Map<String, String>"
```
**Response:**
```json
{
  "id": "Long",
  "title": "String",
  "description": "String",
  "format": "String",
  "meetingType": "MeetingType",
  "status": "String",
  "location": "String",
  "startTime": "LocalDateTime",
  "endTime": "LocalDateTime",
  "reminderTime": "Integer",
  "reminderSent": "Boolean",
  "roomId": "Long",
  "participants": [
    {
      "id": "Long",
      "participantType": "String",
      "responseStatus": "String",
      "participantId": "Long",
      "schedule": "Schedule"
    }
  ],
  "createdById": "Long",
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime"
}
```

---

### `GET` /api/v1/communications-service/schedules/calendar
**Response:**
```json
"Map<String, Object>"
```

---

### `GET` /api/v1/communications-service/schedules/available-participants
**Response:**
```json
[
  {
    "id": "Long",
    "name": "String",
    "departmentName": "String"
  }
]
```

---

### `POST` /api/v1/email-service/mail/send/gmail
**Request Body:**
```json
{
  "toEmail": "String",
  "subject": "String",
  "content": "String"
}
```
**Response:**
```json
{
  "id": "Long",
  "fromEmail": "String",
  "toEmail": "String",
  "sent": "boolean",
  "subject": "String",
  "content": "String",
  "read": "boolean",
  "deleted": "boolean",
  "gmailMessageId": "String",
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime"
}
```

---

### `GET` /api/v1/email-service/mail/inbox
**Response:**
```json
{
  "meta": {
    "page": "int",
    "pageSize": "int",
    "pages": "int",
    "total": "long"
  },
  "result": "Object"
}
```

---

### `GET` /api/v1/email-service/mail/sent
**Response:**
```json
{
  "meta": {
    "page": "int",
    "pageSize": "int",
    "pages": "int",
    "total": "long"
  },
  "result": "Object"
}
```

---

### `PUT` /api/v1/email-service/mail/{id}/read

---

### `DELETE` /api/v1/email-service/mail/{id}/permanent

---

### `GET` /api/v1/email-service/mail
**Response:**
```json
{
  "meta": {
    "page": "int",
    "pageSize": "int",
    "pages": "int",
    "total": "long"
  },
  "result": "Object"
}
```

---

### `POST` /api/v1/job-service/job-positions
**Request Body:**
```json
{
  "title": "String",
  "description": "String",
  "requirements": "String",
  "benefits": "String",
  "salaryMin": "BigDecimal",
  "salaryMax": "BigDecimal",
  "employmentType": "String",
  "experienceLevel": "String",
  "location": "String",
  "isRemote": "Boolean",
  "quantity": "int",
  "deadline": "LocalDate",
  "yearsOfExperience": "String",
  "recruitmentRequestId": "Long"
}
```
**Response:**
```json
{
  "id": "Long",
  "title": "String",
  "description": "String",
  "requirements": "String",
  "benefits": "String",
  "salaryMin": "BigDecimal",
  "salaryMax": "BigDecimal",
  "employmentType": "String",
  "experienceLevel": "String",
  "location": "String",
  "isRemote": "boolean",
  "quantity": "int",
  "deadline": "LocalDate",
  "yearsOfExperience": "String",
  "publishedAt": "LocalDateTime",
  "status": "JobPositionStatus",
  "recruitmentRequest": {
    "id": "Long",
    "title": "String",
    "quantity": "int",
    "reason": "String",
    "salaryMin": "BigDecimal",
    "salaryMax": "BigDecimal",
    "status": "RecruitmentRequestStatus",
    "createdAt": "LocalDateTime",
    "updatedAt": "LocalDateTime",
    "requesterId": "Long",
    "ownerUserId": "Long",
    "submittedAt": "LocalDateTime",
    "workflowId": "Long",
    "isActive": "boolean",
    "departmentId": "Long"
  },
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime",
  "createBy": "String",
  "updateBy": "String"
}
```

---

### `GET` /api/v1/job-service/job-positions/{id}
**Response:**
```json
{
  "id": "Long",
  "title": "String",
  "description": "String",
  "requirements": "String",
  "benefits": "String",
  "salaryMin": "BigDecimal",
  "salaryMax": "BigDecimal",
  "employmentType": "String",
  "experienceLevel": "String",
  "location": "String",
  "isRemote": "boolean",
  "quantity": "int",
  "deadline": "LocalDate",
  "departmentId": "Long",
  "applicationCount": "Integer",
  "status": "JobPositionStatus",
  "recruitmentRequest": {
    "id": "Long",
    "title": "String",
    "quantity": "int",
    "reason": "String",
    "salaryMin": "BigDecimal",
    "salaryMax": "BigDecimal",
    "status": "RecruitmentRequestStatus",
    "createdAt": "LocalDateTime",
    "updatedAt": "LocalDateTime",
    "requesterId": "Long",
    "ownerUserId": "Long",
    "submittedAt": "LocalDateTime",
    "workflowId": "Long",
    "isActive": "boolean",
    "departmentId": "Long"
  },
  "departmentName": "String",
  "yearsOfExperience": "String",
  "publishedAt": "LocalDateTime"
}
```

---

### `GET` /api/v1/job-service/job-positions/simple/{id}
**Response:**
```json
{
  "id": "Long",
  "title": "String",
  "description": "String",
  "requirements": "String",
  "benefits": "String",
  "salaryMin": "BigDecimal",
  "salaryMax": "BigDecimal",
  "employmentType": "String",
  "experienceLevel": "String",
  "location": "String",
  "isRemote": "boolean",
  "quantity": "int",
  "deadline": "LocalDate",
  "yearsOfExperience": "String",
  "publishedAt": "LocalDateTime",
  "status": "JobPositionStatus",
  "recruitmentRequest": {
    "id": "Long",
    "title": "String",
    "quantity": "int",
    "reason": "String",
    "salaryMin": "BigDecimal",
    "salaryMax": "BigDecimal",
    "status": "RecruitmentRequestStatus",
    "createdAt": "LocalDateTime",
    "updatedAt": "LocalDateTime",
    "requesterId": "Long",
    "ownerUserId": "Long",
    "submittedAt": "LocalDateTime",
    "workflowId": "Long",
    "isActive": "boolean",
    "departmentId": "Long"
  },
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime",
  "createBy": "String",
  "updateBy": "String"
}
```

---

### `GET` /api/v1/job-service/job-positions
**Response:**
```json
{
  "meta": {
    "page": "int",
    "pageSize": "int",
    "pages": "int",
    "total": "long"
  },
  "result": "Object"
}
```

---

### `GET` /api/v1/job-service/job-positions/simple
**Response:**
```json
{
  "meta": {
    "page": "int",
    "pageSize": "int",
    "pages": "int",
    "total": "long"
  },
  "result": "Object"
}
```

---

### `GET` /api/v1/job-service/job-positions
**Response:**
```json
[
  {
    "id": "Long",
    "title": "String",
    "description": "String",
    "requirements": "String",
    "benefits": "String",
    "salaryMin": "BigDecimal",
    "salaryMax": "BigDecimal",
    "employmentType": "String",
    "experienceLevel": "String",
    "location": "String",
    "isRemote": "boolean",
    "quantity": "int",
    "deadline": "LocalDate",
    "departmentId": "Long",
    "applicationCount": "Integer",
    "status": "JobPositionStatus",
    "recruitmentRequest": {
      "id": "Long",
      "title": "String",
      "quantity": "int",
      "reason": "String",
      "salaryMin": "BigDecimal",
      "salaryMax": "BigDecimal",
      "status": "RecruitmentRequestStatus",
      "createdAt": "LocalDateTime",
      "updatedAt": "LocalDateTime",
      "requesterId": "Long",
      "ownerUserId": "Long",
      "submittedAt": "LocalDateTime",
      "workflowId": "Long",
      "isActive": "boolean",
      "departmentId": "Long"
    },
    "departmentName": "String",
    "yearsOfExperience": "String",
    "publishedAt": "LocalDateTime"
  }
]
```

---

### `GET` /api/v1/job-service/job-positions/published
**Response:**
```json
{
  "meta": {
    "page": "int",
    "pageSize": "int",
    "pages": "int",
    "total": "long"
  },
  "result": "Object"
}
```

---

### `GET` /api/v1/job-service/job-positions/published/{id}
**Response:**
```json
{
  "id": "Long",
  "title": "String",
  "description": "String",
  "requirements": "String",
  "benefits": "String",
  "salaryMin": "BigDecimal",
  "salaryMax": "BigDecimal",
  "employmentType": "String",
  "experienceLevel": "String",
  "location": "String",
  "isRemote": "boolean",
  "quantity": "int",
  "deadline": "LocalDate",
  "yearsOfExperience": "String",
  "publishedAt": "LocalDateTime",
  "status": "JobPositionStatus",
  "recruitmentRequest": {
    "id": "Long",
    "title": "String",
    "quantity": "int",
    "reason": "String",
    "salaryMin": "BigDecimal",
    "salaryMax": "BigDecimal",
    "status": "RecruitmentRequestStatus",
    "createdAt": "LocalDateTime",
    "updatedAt": "LocalDateTime",
    "requesterId": "Long",
    "ownerUserId": "Long",
    "submittedAt": "LocalDateTime",
    "workflowId": "Long",
    "isActive": "boolean",
    "departmentId": "Long"
  },
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime",
  "createBy": "String",
  "updateBy": "String"
}
```

---

### `PUT` /api/v1/job-service/job-positions/{id}
**Request Body:**
```json
{
  "title": "String",
  "description": "String",
  "requirements": "String",
  "benefits": "String",
  "salaryMin": "BigDecimal",
  "salaryMax": "BigDecimal",
  "employmentType": "String",
  "experienceLevel": "String",
  "location": "String",
  "isRemote": "Boolean",
  "quantity": "Integer",
  "deadline": "LocalDate",
  "yearsOfExperience": "String"
}
```
**Response:**
```json
{
  "id": "Long",
  "title": "String",
  "description": "String",
  "requirements": "String",
  "benefits": "String",
  "salaryMin": "BigDecimal",
  "salaryMax": "BigDecimal",
  "employmentType": "String",
  "experienceLevel": "String",
  "location": "String",
  "isRemote": "boolean",
  "quantity": "int",
  "deadline": "LocalDate",
  "departmentId": "Long",
  "applicationCount": "Integer",
  "status": "JobPositionStatus",
  "recruitmentRequest": {
    "id": "Long",
    "title": "String",
    "quantity": "int",
    "reason": "String",
    "salaryMin": "BigDecimal",
    "salaryMax": "BigDecimal",
    "status": "RecruitmentRequestStatus",
    "createdAt": "LocalDateTime",
    "updatedAt": "LocalDateTime",
    "requesterId": "Long",
    "ownerUserId": "Long",
    "submittedAt": "LocalDateTime",
    "workflowId": "Long",
    "isActive": "boolean",
    "departmentId": "Long"
  },
  "departmentName": "String",
  "yearsOfExperience": "String",
  "publishedAt": "LocalDateTime"
}
```

---

### `DELETE` /api/v1/job-service/job-positions/{id}

---

### `POST` /api/v1/job-service/job-positions/{id}/publish
**Response:**
```json
{
  "id": "Long",
  "title": "String",
  "description": "String",
  "requirements": "String",
  "benefits": "String",
  "salaryMin": "BigDecimal",
  "salaryMax": "BigDecimal",
  "employmentType": "String",
  "experienceLevel": "String",
  "location": "String",
  "isRemote": "boolean",
  "quantity": "int",
  "deadline": "LocalDate",
  "yearsOfExperience": "String",
  "publishedAt": "LocalDateTime",
  "status": "JobPositionStatus",
  "recruitmentRequest": {
    "id": "Long",
    "title": "String",
    "quantity": "int",
    "reason": "String",
    "salaryMin": "BigDecimal",
    "salaryMax": "BigDecimal",
    "status": "RecruitmentRequestStatus",
    "createdAt": "LocalDateTime",
    "updatedAt": "LocalDateTime",
    "requesterId": "Long",
    "ownerUserId": "Long",
    "submittedAt": "LocalDateTime",
    "workflowId": "Long",
    "isActive": "boolean",
    "departmentId": "Long"
  },
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime",
  "createBy": "String",
  "updateBy": "String"
}
```

---

### `POST` /api/v1/job-service/job-positions/{id}/close
**Response:**
```json
{
  "id": "Long",
  "title": "String",
  "description": "String",
  "requirements": "String",
  "benefits": "String",
  "salaryMin": "BigDecimal",
  "salaryMax": "BigDecimal",
  "employmentType": "String",
  "experienceLevel": "String",
  "location": "String",
  "isRemote": "boolean",
  "quantity": "int",
  "deadline": "LocalDate",
  "departmentId": "Long",
  "applicationCount": "Integer",
  "status": "JobPositionStatus",
  "recruitmentRequest": {
    "id": "Long",
    "title": "String",
    "quantity": "int",
    "reason": "String",
    "salaryMin": "BigDecimal",
    "salaryMax": "BigDecimal",
    "status": "RecruitmentRequestStatus",
    "createdAt": "LocalDateTime",
    "updatedAt": "LocalDateTime",
    "requesterId": "Long",
    "ownerUserId": "Long",
    "submittedAt": "LocalDateTime",
    "workflowId": "Long",
    "isActive": "boolean",
    "departmentId": "Long"
  },
  "departmentName": "String",
  "yearsOfExperience": "String",
  "publishedAt": "LocalDateTime"
}
```

---

### `POST` /api/v1/job-service/job-positions/{id}/reopen
**Response:**
```json
{
  "id": "Long",
  "title": "String",
  "description": "String",
  "requirements": "String",
  "benefits": "String",
  "salaryMin": "BigDecimal",
  "salaryMax": "BigDecimal",
  "employmentType": "String",
  "experienceLevel": "String",
  "location": "String",
  "isRemote": "boolean",
  "quantity": "int",
  "deadline": "LocalDate",
  "departmentId": "Long",
  "applicationCount": "Integer",
  "status": "JobPositionStatus",
  "recruitmentRequest": {
    "id": "Long",
    "title": "String",
    "quantity": "int",
    "reason": "String",
    "salaryMin": "BigDecimal",
    "salaryMax": "BigDecimal",
    "status": "RecruitmentRequestStatus",
    "createdAt": "LocalDateTime",
    "updatedAt": "LocalDateTime",
    "requesterId": "Long",
    "ownerUserId": "Long",
    "submittedAt": "LocalDateTime",
    "workflowId": "Long",
    "isActive": "boolean",
    "departmentId": "Long"
  },
  "departmentName": "String",
  "yearsOfExperience": "String",
  "publishedAt": "LocalDateTime"
}
```

---

### `POST` /api/v1/job-service/offers
**Request Body:**
```json
{
  "candidateId": "Long",
  "basicSalary": "Long",
  "probationSalaryRate": "Integer",
  "onboardingDate": "LocalDate",
  "probationPeriod": "Integer",
  "notes": "String",
  "workflowId": "Long"
}
```
**Response:**
```json
{
  "id": "Long",
  "candidateId": "Long",
  "basicSalary": "Long",
  "probationSalaryRate": "Integer",
  "onboardingDate": "LocalDate",
  "probationPeriod": "Integer",
  "notes": "String",
  "status": "OfferStatus",
  "requesterId": "Long",
  "ownerUserId": "Long",
  "workflowId": "Long",
  "submittedAt": "LocalDateTime",
  "isActive": "Boolean",
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime"
}
```

---

### `POST` /api/v1/job-service/offers/submit/{id}
**Response:**
```json
{
  "id": "Long",
  "candidateId": "Long",
  "basicSalary": "Long",
  "probationSalaryRate": "Integer",
  "onboardingDate": "LocalDate",
  "probationPeriod": "Integer",
  "notes": "String",
  "status": "OfferStatus",
  "requesterId": "Long",
  "ownerUserId": "Long",
  "workflowId": "Long",
  "submittedAt": "LocalDateTime",
  "isActive": "Boolean",
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime"
}
```

---

### `POST` /api/v1/job-service/offers/approve/{id}
**Request Body:**
```json
{
  "approvalNotes": "String"
}
```
**Response:**
```json
{
  "id": "Long",
  "candidateId": "Long",
  "basicSalary": "Long",
  "probationSalaryRate": "Integer",
  "onboardingDate": "LocalDate",
  "probationPeriod": "Integer",
  "notes": "String",
  "status": "OfferStatus",
  "requesterId": "Long",
  "ownerUserId": "Long",
  "workflowId": "Long",
  "submittedAt": "LocalDateTime",
  "isActive": "Boolean",
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime"
}
```

---

### `POST` /api/v1/job-service/offers/reject/{id}
**Request Body:**
```json
{
  "reason": "String"
}
```
**Response:**
```json
{
  "id": "Long",
  "candidateId": "Long",
  "basicSalary": "Long",
  "probationSalaryRate": "Integer",
  "onboardingDate": "LocalDate",
  "probationPeriod": "Integer",
  "notes": "String",
  "status": "OfferStatus",
  "requesterId": "Long",
  "ownerUserId": "Long",
  "workflowId": "Long",
  "submittedAt": "LocalDateTime",
  "isActive": "Boolean",
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime"
}
```

---

### `POST` /api/v1/job-service/offers/return/{id}
**Request Body:**
```json
{
  "reason": "String",
  "returnedToStepId": "Long"
}
```
**Response:**
```json
{
  "id": "Long",
  "candidateId": "Long",
  "basicSalary": "Long",
  "probationSalaryRate": "Integer",
  "onboardingDate": "LocalDate",
  "probationPeriod": "Integer",
  "notes": "String",
  "status": "OfferStatus",
  "requesterId": "Long",
  "ownerUserId": "Long",
  "workflowId": "Long",
  "submittedAt": "LocalDateTime",
  "isActive": "Boolean",
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime"
}
```

---

### `POST` /api/v1/job-service/offers/cancel/{id}
**Request Body:**
```json
{
  "reason": "String"
}
```
**Response:**
```json
{
  "id": "Long",
  "candidateId": "Long",
  "basicSalary": "Long",
  "probationSalaryRate": "Integer",
  "onboardingDate": "LocalDate",
  "probationPeriod": "Integer",
  "notes": "String",
  "status": "OfferStatus",
  "requesterId": "Long",
  "ownerUserId": "Long",
  "workflowId": "Long",
  "submittedAt": "LocalDateTime",
  "isActive": "Boolean",
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime"
}
```

---

### `POST` /api/v1/job-service/offers/withdraw/{id}
**Request Body:**
```json
{
  "reason": "String"
}
```
**Response:**
```json
{
  "id": "Long",
  "candidateId": "Long",
  "basicSalary": "Long",
  "probationSalaryRate": "Integer",
  "onboardingDate": "LocalDate",
  "probationPeriod": "Integer",
  "notes": "String",
  "status": "OfferStatus",
  "requesterId": "Long",
  "ownerUserId": "Long",
  "workflowId": "Long",
  "submittedAt": "LocalDateTime",
  "isActive": "Boolean",
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime"
}
```

---

### `GET` /api/v1/job-service/offers/{id}
**Response:**
```json
{
  "id": "Long",
  "candidateId": "Long",
  "basicSalary": "Long",
  "probationSalaryRate": "Integer",
  "onboardingDate": "LocalDate",
  "probationPeriod": "Integer",
  "notes": "String",
  "status": "OfferStatus",
  "requesterId": "Long",
  "requesterName": "String",
  "ownerUserId": "Long",
  "workflowId": "Long",
  "workflowInfo": "JsonNode",
  "submittedAt": "LocalDateTime",
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime",
  "candidateName": "String",
  "candidateEmail": "String",
  "candidatePhone": "String",
  "jobPositionTitle": "String",
  "departmentName": "String",
  "levelName": "String"
}
```

---

### `GET` /api/v1/job-service/offers
**Response:**
```json
{
  "meta": {
    "page": "int",
    "pageSize": "int",
    "pages": "int",
    "total": "long"
  },
  "result": "Object"
}
```

---

### `GET` /api/v1/job-service/offers/simple
**Response:**
```json
[
  {
    "id": "Long",
    "candidateId": "Long",
    "basicSalary": "Long",
    "probationSalaryRate": "Integer",
    "onboardingDate": "LocalDate",
    "probationPeriod": "Integer",
    "notes": "String",
    "status": "OfferStatus",
    "requesterId": "Long",
    "ownerUserId": "Long",
    "workflowId": "Long",
    "submittedAt": "LocalDateTime",
    "isActive": "Boolean",
    "createdAt": "LocalDateTime",
    "updatedAt": "LocalDateTime"
  }
]
```

---

### `PUT` /api/v1/job-service/offers/{id}
**Request Body:**
```json
{
  "candidateId": "Long",
  "basicSalary": "Long",
  "probationSalaryRate": "Integer",
  "onboardingDate": "LocalDate",
  "probationPeriod": "Integer",
  "notes": "String"
}
```
**Response:**
```json
{
  "id": "Long",
  "candidateId": "Long",
  "basicSalary": "Long",
  "probationSalaryRate": "Integer",
  "onboardingDate": "LocalDate",
  "probationPeriod": "Integer",
  "notes": "String",
  "status": "OfferStatus",
  "requesterId": "Long",
  "ownerUserId": "Long",
  "workflowId": "Long",
  "submittedAt": "LocalDateTime",
  "isActive": "Boolean",
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime"
}
```

---

### `DELETE` /api/v1/job-service/offers/{id}

---

### `POST` /api/v1/job-service/recruitment-requests
**Request Body:**
```json
{
  "title": "String",
  "quantity": "Integer",
  "reason": "String",
  "salaryMin": "BigDecimal",
  "salaryMax": "BigDecimal",
  "exceedBudget": "boolean",
  "requesterId": "Long",
  "departmentId": "Long",
  "workflowId": "Long"
}
```
**Response:**
```json
{
  "id": "Long",
  "title": "String",
  "quantity": "int",
  "reason": "String",
  "salaryMin": "BigDecimal",
  "salaryMax": "BigDecimal",
  "status": "RecruitmentRequestStatus",
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime",
  "requesterId": "Long",
  "ownerUserId": "Long",
  "submittedAt": "LocalDateTime",
  "workflowId": "Long",
  "isActive": "boolean",
  "departmentId": "Long"
}
```

---

### `POST` /api/v1/job-service/recruitment-requests/submit/{id}
**Response:**
```json
{
  "id": "Long",
  "title": "String",
  "quantity": "int",
  "reason": "String",
  "salaryMin": "BigDecimal",
  "salaryMax": "BigDecimal",
  "status": "RecruitmentRequestStatus",
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime",
  "requesterId": "Long",
  "ownerUserId": "Long",
  "submittedAt": "LocalDateTime",
  "workflowId": "Long",
  "isActive": "boolean",
  "departmentId": "Long"
}
```

---

### `POST` /api/v1/job-service/recruitment-requestsapprove/{id}
**Request Body:**
```json
{
  "approvalNotes": "String"
}
```
**Response:**
```json
{
  "id": "Long",
  "title": "String",
  "quantity": "int",
  "reason": "String",
  "salaryMin": "BigDecimal",
  "salaryMax": "BigDecimal",
  "status": "RecruitmentRequestStatus",
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime",
  "requesterId": "Long",
  "ownerUserId": "Long",
  "submittedAt": "LocalDateTime",
  "workflowId": "Long",
  "isActive": "boolean",
  "departmentId": "Long"
}
```

---

### `POST` /api/v1/job-service/recruitment-requestsreject/{id}
**Request Body:**
```json
{
  "reason": "String"
}
```
**Response:**
```json
{
  "id": "Long",
  "title": "String",
  "quantity": "int",
  "reason": "String",
  "salaryMin": "BigDecimal",
  "salaryMax": "BigDecimal",
  "status": "RecruitmentRequestStatus",
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime",
  "requesterId": "Long",
  "ownerUserId": "Long",
  "submittedAt": "LocalDateTime",
  "workflowId": "Long",
  "isActive": "boolean",
  "departmentId": "Long"
}
```

---

### `POST` /api/v1/job-service/recruitment-requests/return/{id}
**Request Body:**
```json
{
  "reason": "String",
  "returnedToStepId": "Long"
}
```
**Response:**
```json
{
  "id": "Long",
  "title": "String",
  "quantity": "int",
  "reason": "String",
  "salaryMin": "BigDecimal",
  "salaryMax": "BigDecimal",
  "status": "RecruitmentRequestStatus",
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime",
  "requesterId": "Long",
  "ownerUserId": "Long",
  "submittedAt": "LocalDateTime",
  "workflowId": "Long",
  "isActive": "boolean",
  "departmentId": "Long"
}
```

---

### `POST` /api/v1/job-service/recruitment-requests/cancel/{id}
**Request Body:**
```json
{
  "reason": "String"
}
```
**Response:**
```json
{
  "id": "Long",
  "title": "String",
  "quantity": "int",
  "reason": "String",
  "salaryMin": "BigDecimal",
  "salaryMax": "BigDecimal",
  "status": "RecruitmentRequestStatus",
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime",
  "requesterId": "Long",
  "ownerUserId": "Long",
  "submittedAt": "LocalDateTime",
  "workflowId": "Long",
  "isActive": "boolean",
  "departmentId": "Long"
}
```

---

### `GET` /api/v1/job-service/recruitment-requests/{id}
**Response:**
```json
{
  "id": "Long",
  "title": "String",
  "quantity": "Integer",
  "reason": "String",
  "salaryMin": "BigDecimal",
  "salaryMax": "BigDecimal",
  "status": "RecruitmentRequestStatus",
  "requesterId": "Long",
  "requester": "JsonNode",
  "departmentId": "Long",
  "department": "JsonNode",
  "active": "boolean",
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime",
  "ownerUserId": "Long",
  "submittedAt": "LocalDateTime",
  "workflowId": "Long",
  "workflowInfo": "JsonNode"
}
```

---

### `GET` /api/v1/job-service/recruitment-requests
**Response:**
```json
{
  "meta": {
    "page": "int",
    "pageSize": "int",
    "pages": "int",
    "total": "long"
  },
  "result": "Object"
}
```

---

### `GET` /api/v1/job-service/recruitment-requests/simple
**Response:**
```json
[
  {
    "id": "Long",
    "title": "String",
    "quantity": "int",
    "reason": "String",
    "salaryMin": "BigDecimal",
    "salaryMax": "BigDecimal",
    "status": "RecruitmentRequestStatus",
    "createdAt": "LocalDateTime",
    "updatedAt": "LocalDateTime",
    "requesterId": "Long",
    "ownerUserId": "Long",
    "submittedAt": "LocalDateTime",
    "workflowId": "Long",
    "isActive": "boolean",
    "departmentId": "Long"
  }
]
```

---

### `PUT` /api/v1/job-service/recruitment-requests/{id}
**Request Body:**
```json
{
  "title": "String",
  "quantity": "Integer",
  "reason": "String",
  "salaryMin": "BigDecimal",
  "salaryMax": "BigDecimal",
  "exceedBudget": "boolean",
  "requesterId": "Long",
  "departmentId": "Long",
  "workflowId": "Long"
}
```
**Response:**
```json
{
  "id": "Long",
  "title": "String",
  "quantity": "int",
  "reason": "String",
  "salaryMin": "BigDecimal",
  "salaryMax": "BigDecimal",
  "status": "RecruitmentRequestStatus",
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime",
  "requesterId": "Long",
  "ownerUserId": "Long",
  "submittedAt": "LocalDateTime",
  "workflowId": "Long",
  "isActive": "boolean",
  "departmentId": "Long"
}
```

---

### `DELETE` /api/v1/job-service/recruitment-requests/{id}

---

### `POST` /api/v1/job-service/recruitment-requests/withdraw/{id}
**Response:**
```json
{
  "id": "Long",
  "title": "String",
  "quantity": "int",
  "reason": "String",
  "salaryMin": "BigDecimal",
  "salaryMax": "BigDecimal",
  "status": "RecruitmentRequestStatus",
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime",
  "requesterId": "Long",
  "ownerUserId": "Long",
  "submittedAt": "LocalDateTime",
  "workflowId": "Long",
  "isActive": "boolean",
  "departmentId": "Long"
}
```

---

### `POST` /api/v1/notification-service/notifications
**Request Body:**
```json
{
  "recipientId": "Long",
  "title": "String",
  "message": "String"
}
```
**Response:**
```json
{
  "id": "Long",
  "title": "String",
  "message": "String",
  "recipientId": "Long",
  "sentAt": "LocalDateTime",
  "readAt": "LocalDateTime",
  "isRead": "boolean",
  "isDelivered": "boolean",
  "deliveryStatus": "String",
  "errorMessage": "String",
  "externalId": "String",
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime"
}
```

---

### `POST` /api/v1/notification-service/notifications/bulk
**Request Body:**
```json
[
  {
    "recipientId": "Long",
    "title": "String",
    "message": "String"
  }
]
```
**Response:**
```json
"String"
```

---

### `POST` /api/v1/notification-service/notifications/bulk-by-conditions
**Request Body:**
```json
{
  "title": "String",
  "message": "String",
  "includeAllEmployees": "Boolean",
  "departmentId": "Long",
  "positionId": "Long",
  "status": "String",
  "recipientIds": [
    "Long"
  ],
  "recipientId": "Long",
  "keyword": "String"
}
```
**Response:**
```json
"Map<String, Object>"
```

---

### `GET` /api/v1/notification-service/notifications
**Response:**
```json
{
  "meta": {
    "page": "int",
    "pageSize": "int",
    "pages": "int",
    "total": "long"
  },
  "result": "Object"
}
```

---

### `GET` /api/v1/notification-service/notifications/recipient/{recipientId}
**Response:**
```json
[
  {
    "id": "Long",
    "title": "String",
    "message": "String",
    "recipientId": "Long",
    "sentAt": "LocalDateTime",
    "readAt": "LocalDateTime",
    "isRead": "boolean",
    "isDelivered": "boolean",
    "deliveryStatus": "String",
    "errorMessage": "String",
    "externalId": "String",
    "createdAt": "LocalDateTime",
    "updatedAt": "LocalDateTime"
  }
]
```

---

### `PUT` /api/v1/notification-service/notifications/{notificationId}/read
**Response:**
```json
"String"
```

---

### `PUT` /api/v1/notification-service/notifications/read-all
**Response:**
```json
"Map<String, Object>"
```

---

### `GET` /api/v1/notification-service/notifications/stats/{recipientId}
**Response:**
```json
"Map<String, Object>"
```

---

### `POST` /api/v1/schedule-service/schedules
**Request Body:**
```json
{
  "title": "String",
  "description": "String",
  "format": "String",
  "meetingType": "MeetingType",
  "status": "String",
  "location": "String",
  "startTime": "LocalDateTime",
  "endTime": "LocalDateTime",
  "reminderTime": "Integer",
  "createdById": "Long",
  "candidateId": "Long",
  "userIds": [
    "Long"
  ]
}
```
**Response:**
```json
{
  "id": "Long",
  "title": "String",
  "description": "String",
  "format": "String",
  "meetingType": "MeetingType",
  "status": "String",
  "location": "String",
  "startTime": "LocalDateTime",
  "endTime": "LocalDateTime",
  "reminderTime": "Integer",
  "reminderSent": "Boolean",
  "roomId": "Long",
  "participants": [
    {
      "id": "Long",
      "participantType": "String",
      "responseStatus": "String",
      "participantId": "Long",
      "schedule": "Schedule"
    }
  ],
  "createdById": "Long",
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime"
}
```

---

### `PUT` /api/v1/schedule-service/schedules/{id}
**Request Body:**
```json
{
  "title": "String",
  "description": "String",
  "format": "String",
  "meetingType": "MeetingType",
  "status": "String",
  "location": "String",
  "startTime": "LocalDateTime",
  "endTime": "LocalDateTime",
  "reminderTime": "Integer",
  "createdById": "Long",
  "candidateId": "Long",
  "userIds": [
    "Long"
  ]
}
```
**Response:**
```json
{
  "id": "Long",
  "title": "String",
  "description": "String",
  "format": "String",
  "meetingType": "MeetingType",
  "status": "String",
  "location": "String",
  "startTime": "LocalDateTime",
  "endTime": "LocalDateTime",
  "reminderTime": "Integer",
  "reminderSent": "Boolean",
  "roomId": "Long",
  "participants": [
    {
      "id": "Long",
      "participantType": "String",
      "responseStatus": "String",
      "participantId": "Long",
      "schedule": "Schedule"
    }
  ],
  "createdById": "Long",
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime"
}
```

---

### `DELETE` /api/v1/schedule-service/schedules/{id}
**Response:**
```json
"String"
```

---

### `GET` /api/v1/schedule-service/schedules/{id}
**Response:**
```json
{
  "id": "Long",
  "title": "String",
  "description": "String",
  "format": "String",
  "meetingType": "MeetingType",
  "status": "String",
  "location": "String",
  "startTime": "LocalDateTime",
  "endTime": "LocalDateTime",
  "reminderTime": "Integer",
  "roomId": "Long",
  "createdById": "Long",
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime",
  "participants": [
    {
      "id": "Long",
      "participantType": "String",
      "responseStatus": "String",
      "participantId": "Long",
      "name": "String"
    }
  ]
}
```

---

### `GET` /api/v1/schedule-service/schedules
**Response:**
```json
[
  {
    "id": "Long",
    "title": "String",
    "description": "String",
    "format": "String",
    "meetingType": "MeetingType",
    "status": "String",
    "location": "String",
    "startTime": "LocalDateTime",
    "endTime": "LocalDateTime",
    "reminderTime": "Integer",
    "roomId": "Long",
    "createdById": "Long",
    "createdAt": "LocalDateTime",
    "updatedAt": "LocalDateTime",
    "participants": [
      "ScheduleParticipantDTO"
    ]
  }
]
```

---

### `PUT` /api/v1/schedule-service/schedules/status/{id}
**Response:**
```json
{
  "id": "Long",
  "title": "String",
  "description": "String",
  "format": "String",
  "meetingType": "MeetingType",
  "status": "String",
  "location": "String",
  "startTime": "LocalDateTime",
  "endTime": "LocalDateTime",
  "reminderTime": "Integer",
  "reminderSent": "Boolean",
  "roomId": "Long",
  "participants": [
    {
      "id": "Long",
      "participantType": "String",
      "responseStatus": "String",
      "participantId": "Long",
      "schedule": "Schedule"
    }
  ],
  "createdById": "Long",
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime"
}
```

---

### `GET` /api/v1/schedule-service/schedules/calendar
**Response:**
```json
"Map<String, Object>"
```

---

### `GET` /api/v1/schedule-service/schedules/available-participants
**Response:**
```json
[
  {
    "id": "Long",
    "name": "String",
    "departmentName": "String"
  }
]
```

---

### `GET` /api/v1/schedule-service/schedules/statistics
**Response:**
```json
[
  {
    "id": "Long",
    "startTime": "LocalDateTime",
    "status": "String",
    "meetingType": "String",
    "title": "String"
  }
]
```

---

### `GET` /api/v1/schedule-service/schedules/candidates-by-interviewer/{employeeId}
**Response:**
```json
[
  "Long"
]
```

---

### `GET` /api/v1/statistics-service/statistics/summary
**Response:**
```json
{
  "applications": "Long",
  "hired": "Long",
  "interviews": "Long",
  "rejected": "Long"
}
```

---

### `GET` /api/v1/statistics-service/statistics/job-openings
**Response:**
```json
[
  {
    "id": "Long",
    "title": "String",
    "employmentType": "String",
    "workLocation": "String",
    "applicantCount": "Integer",
    "salaryMin": "BigDecimal",
    "salaryMax": "BigDecimal",
    "salaryDisplay": "String"
  }
]
```

---

### `GET` /api/v1/statistics-service/statistics/upcoming-schedules
**Response:**
```json
{
  "schedules": [
    "ScheduleItem"
  ],
  "scheduleId": "Long",
  "time": "String",
  "jobTitle": "String",
  "candidateName": "String",
  "type": "String",
  "status": "String",
  "date": "String",
  "priority": "String"
}
```

---

### `POST` /api/v1/upload
**Response:**
```json
"String"
```

---

### `POST` /api/v1/user-service/auth/login
**Request Body:**
```json
{
  "username": "String",
  "password": "String"
}
```
**Response:**
```json
{
  "accessToken": "String",
  "user": "UserLogin",
  "userId": "long",
  "employeeId": "long",
  "email": "String",
  "name": "String",
  "role": "String",
  "department": {
    "id": "Long",
    "code": "String",
    "name": "String",
    "description": "String",
    "is_active": "boolean",
    "employees": [
      "Employee"
    ],
    "createdAt": "LocalDateTime",
    "updatedAt": "LocalDateTime",
    "createBy": "String",
    "updateBy": "String"
  },
  "departmentId": "Long",
  "departmentCode": "String"
}
```

---

### `GET` /api/v1/user-service/auth/account
**Response:**
```json
"ResponseLoginDTO.UserGetAccount"
```

---

### `GET` /api/v1/user-service/auth/refresh
**Response:**
```json
{
  "accessToken": "String",
  "user": "UserLogin",
  "userId": "long",
  "employeeId": "long",
  "email": "String",
  "name": "String",
  "role": "String",
  "department": {
    "id": "Long",
    "code": "String",
    "name": "String",
    "description": "String",
    "is_active": "boolean",
    "employees": [
      "Employee"
    ],
    "createdAt": "LocalDateTime",
    "updatedAt": "LocalDateTime",
    "createBy": "String",
    "updateBy": "String"
  },
  "departmentId": "Long",
  "departmentCode": "String"
}
```

---

### `POST` /api/v1/user-service/auth/logout

---

### `GET` /api/v1/user-service/auth/check
**Response:**
```json
"Boolean"
```

---

### `GET` /api/v1/user-service/departments
**Response:**
```json
{
  "meta": {
    "page": "int",
    "pageSize": "int",
    "pages": "int",
    "total": "long"
  },
  "result": "Object"
}
```

---

### `POST` /api/v1/user-service/departments
**Request Body:**
```json
{
  "code": "String",
  "name": "String",
  "description": "String",
  "isActive": "Boolean"
}
```
**Response:**
```json
{
  "id": "Long",
  "code": "String",
  "name": "String",
  "description": "String",
  "is_active": "boolean",
  "employees": [
    {
      "id": "Long",
      "position": "Position",
      "user": "User",
      "reviews": "Set<ReviewEmployee>",
      "avatarUrl": "String",
      "department": "Department",
      "name": "String",
      "phone": "String",
      "email": "String",
      "gender": "String",
      "address": "String",
      "nationality": "String",
      "dateOfBirth": "LocalDate",
      "idNumber": "String",
      "candidateId": "Long",
      "status": "String",
      "createdAt": "LocalDateTime",
      "updatedAt": "LocalDateTime",
      "createBy": "String",
      "updateBy": "String"
    }
  ],
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime",
  "createBy": "String",
  "updateBy": "String"
}
```

---

### `PUT` /api/v1/user-service/departments/{id}
**Request Body:**
```json
{
  "code": "String",
  "name": "String",
  "description": "String",
  "isActive": "Boolean"
}
```
**Response:**
```json
{
  "id": "Long",
  "code": "String",
  "name": "String",
  "description": "String",
  "is_active": "boolean",
  "employees": [
    {
      "id": "Long",
      "position": "Position",
      "user": "User",
      "reviews": "Set<ReviewEmployee>",
      "avatarUrl": "String",
      "department": "Department",
      "name": "String",
      "phone": "String",
      "email": "String",
      "gender": "String",
      "address": "String",
      "nationality": "String",
      "dateOfBirth": "LocalDate",
      "idNumber": "String",
      "candidateId": "Long",
      "status": "String",
      "createdAt": "LocalDateTime",
      "updatedAt": "LocalDateTime",
      "createBy": "String",
      "updateBy": "String"
    }
  ],
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime",
  "createBy": "String",
  "updateBy": "String"
}
```

---

### `DELETE` /api/v1/user-service/departments/{id}

---

### `GET` /api/v1/user-service/departments/{id}
**Response:**
```json
{
  "id": "Long",
  "code": "String",
  "name": "String",
  "description": "String",
  "is_active": "boolean",
  "employees": [
    {
      "id": "Long",
      "position": "Position",
      "user": "User",
      "reviews": "Set<ReviewEmployee>",
      "avatarUrl": "String",
      "department": "Department",
      "name": "String",
      "phone": "String",
      "email": "String",
      "gender": "String",
      "address": "String",
      "nationality": "String",
      "dateOfBirth": "LocalDate",
      "idNumber": "String",
      "candidateId": "Long",
      "status": "String",
      "createdAt": "LocalDateTime",
      "updatedAt": "LocalDateTime",
      "createBy": "String",
      "updateBy": "String"
    }
  ],
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime",
  "createBy": "String",
  "updateBy": "String"
}
```

---

### `GET` /api/v1/user-service/departments/public/{id}
**Response:**
```json
{
  "id": "Long",
  "code": "String",
  "name": "String",
  "description": "String",
  "is_active": "boolean",
  "employees": [
    {
      "id": "Long",
      "position": "Position",
      "user": "User",
      "reviews": "Set<ReviewEmployee>",
      "avatarUrl": "String",
      "department": "Department",
      "name": "String",
      "phone": "String",
      "email": "String",
      "gender": "String",
      "address": "String",
      "nationality": "String",
      "dateOfBirth": "LocalDate",
      "idNumber": "String",
      "candidateId": "Long",
      "status": "String",
      "createdAt": "LocalDateTime",
      "updatedAt": "LocalDateTime",
      "createBy": "String",
      "updateBy": "String"
    }
  ],
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime",
  "createBy": "String",
  "updateBy": "String"
}
```

---

### `GET` /api/v1/user-service/departments
**Response:**
```json
[
  {
    "id": "Long",
    "code": "String",
    "name": "String",
    "description": "String",
    "is_active": "boolean",
    "employees": [
      "Employee"
    ],
    "createdAt": "LocalDateTime",
    "updatedAt": "LocalDateTime",
    "createBy": "String",
    "updateBy": "String"
  }
]
```

---

### `GET` /api/v1/user-service/employees
**Response:**
```json
{
  "meta": {
    "page": "int",
    "pageSize": "int",
    "pages": "int",
    "total": "long"
  },
  "result": "Object"
}
```

---

### `POST` /api/v1/user-service/employees
**Request Body:**
```json
{
  "name": "String",
  "phone": "String",
  "email": "String",
  "gender": "String",
  "address": "String",
  "nationality": "String",
  "dateOfBirth": "LocalDate",
  "idNumber": "String",
  "departmentId": "Long",
  "positionId": "Long",
  "status": "String"
}
```
**Response:**
```json
{
  "id": "Long",
  "position": {
    "id": "Long",
    "name": "String",
    "level": "String",
    "hierarchyOrder": "Integer",
    "isActive": "boolean",
    "employees": [
      "Employee"
    ],
    "createdAt": "LocalDateTime",
    "updatedAt": "LocalDateTime",
    "createBy": "String",
    "updateBy": "String"
  },
  "user": {
    "id": "Long",
    "email": "String",
    "password": "String",
    "is_active": "boolean",
    "createdAt": "LocalDateTime",
    "updatedAt": "LocalDateTime",
    "createBy": "String",
    "updateBy": "String",
    "refreshToken": "String",
    "role": {
      "id": "Long",
      "name": "String",
      "description": "String",
      "is_active": "boolean",
      "createdAt": "LocalDateTime",
      "updatedAt": "LocalDateTime",
      "createBy": "String",
      "updateBy": "String",
      "users": "Set<User>",
      "permissions": "Set<Permission>"
    },
    "employee": {
      "id": "Long",
      "position": "Position",
      "user": "User",
      "reviews": "Set<ReviewEmployee>",
      "avatarUrl": "String",
      "department": "Department",
      "name": "String",
      "phone": "String",
      "email": "String",
      "gender": "String",
      "address": "String",
      "nationality": "String",
      "dateOfBirth": "LocalDate",
      "idNumber": "String",
      "candidateId": "Long",
      "status": "String",
      "createdAt": "LocalDateTime",
      "updatedAt": "LocalDateTime",
      "createBy": "String",
      "updateBy": "String"
    }
  },
  "reviews": [
    {
      "id": "Long",
      "employee": "Employee",
      "reviewerId": "Long",
      "onTimeCompletionScore": "Integer",
      "workEfficiencyScore": "Integer",
      "professionalSkillScore": "Integer",
      "selfLearningScore": "Integer",
      "workAttitudeScore": "Integer",
      "communicationSkillScore": "Integer",
      "honestyResponsibilityScore": "Integer",
      "teamIntegrationScore": "Integer",
      "probationResult": "Boolean",
      "additionalComments": "String",
      "createdAt": "LocalDateTime",
      "updatedAt": "LocalDateTime"
    }
  ],
  "avatarUrl": "String",
  "department": {
    "id": "Long",
    "code": "String",
    "name": "String",
    "description": "String",
    "is_active": "boolean",
    "employees": [
      "Employee"
    ],
    "createdAt": "LocalDateTime",
    "updatedAt": "LocalDateTime",
    "createBy": "String",
    "updateBy": "String"
  },
  "name": "String",
  "phone": "String",
  "email": "String",
  "gender": "String",
  "address": "String",
  "nationality": "String",
  "dateOfBirth": "LocalDate",
  "idNumber": "String",
  "candidateId": "Long",
  "status": "String",
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime",
  "createBy": "String",
  "updateBy": "String"
}
```

---

### `PUT` /api/v1/user-service/employees/{id}
**Request Body:**
```json
{
  "name": "String",
  "phone": "String",
  "email": "String",
  "gender": "String",
  "address": "String",
  "nationality": "String",
  "dateOfBirth": "LocalDate",
  "idNumber": "String",
  "departmentId": "Long",
  "positionId": "Long",
  "status": "String"
}
```
**Response:**
```json
{
  "id": "Long",
  "position": {
    "id": "Long",
    "name": "String",
    "level": "String",
    "hierarchyOrder": "Integer",
    "isActive": "boolean",
    "employees": [
      "Employee"
    ],
    "createdAt": "LocalDateTime",
    "updatedAt": "LocalDateTime",
    "createBy": "String",
    "updateBy": "String"
  },
  "user": {
    "id": "Long",
    "email": "String",
    "password": "String",
    "is_active": "boolean",
    "createdAt": "LocalDateTime",
    "updatedAt": "LocalDateTime",
    "createBy": "String",
    "updateBy": "String",
    "refreshToken": "String",
    "role": {
      "id": "Long",
      "name": "String",
      "description": "String",
      "is_active": "boolean",
      "createdAt": "LocalDateTime",
      "updatedAt": "LocalDateTime",
      "createBy": "String",
      "updateBy": "String",
      "users": "Set<User>",
      "permissions": "Set<Permission>"
    },
    "employee": {
      "id": "Long",
      "position": "Position",
      "user": "User",
      "reviews": "Set<ReviewEmployee>",
      "avatarUrl": "String",
      "department": "Department",
      "name": "String",
      "phone": "String",
      "email": "String",
      "gender": "String",
      "address": "String",
      "nationality": "String",
      "dateOfBirth": "LocalDate",
      "idNumber": "String",
      "candidateId": "Long",
      "status": "String",
      "createdAt": "LocalDateTime",
      "updatedAt": "LocalDateTime",
      "createBy": "String",
      "updateBy": "String"
    }
  },
  "reviews": [
    {
      "id": "Long",
      "employee": "Employee",
      "reviewerId": "Long",
      "onTimeCompletionScore": "Integer",
      "workEfficiencyScore": "Integer",
      "professionalSkillScore": "Integer",
      "selfLearningScore": "Integer",
      "workAttitudeScore": "Integer",
      "communicationSkillScore": "Integer",
      "honestyResponsibilityScore": "Integer",
      "teamIntegrationScore": "Integer",
      "probationResult": "Boolean",
      "additionalComments": "String",
      "createdAt": "LocalDateTime",
      "updatedAt": "LocalDateTime"
    }
  ],
  "avatarUrl": "String",
  "department": {
    "id": "Long",
    "code": "String",
    "name": "String",
    "description": "String",
    "is_active": "boolean",
    "employees": [
      "Employee"
    ],
    "createdAt": "LocalDateTime",
    "updatedAt": "LocalDateTime",
    "createBy": "String",
    "updateBy": "String"
  },
  "name": "String",
  "phone": "String",
  "email": "String",
  "gender": "String",
  "address": "String",
  "nationality": "String",
  "dateOfBirth": "LocalDate",
  "idNumber": "String",
  "candidateId": "Long",
  "status": "String",
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime",
  "createBy": "String",
  "updateBy": "String"
}
```

---

### `DELETE` /api/v1/user-service/employees/{id}

---

### `GET` /api/v1/user-service/employees/{id}
**Response:**
```json
{
  "id": "Long",
  "position": {
    "id": "Long",
    "name": "String",
    "level": "String",
    "hierarchyOrder": "Integer",
    "isActive": "boolean",
    "employees": [
      "Employee"
    ],
    "createdAt": "LocalDateTime",
    "updatedAt": "LocalDateTime",
    "createBy": "String",
    "updateBy": "String"
  },
  "user": {
    "id": "Long",
    "email": "String",
    "password": "String",
    "is_active": "boolean",
    "createdAt": "LocalDateTime",
    "updatedAt": "LocalDateTime",
    "createBy": "String",
    "updateBy": "String",
    "refreshToken": "String",
    "role": {
      "id": "Long",
      "name": "String",
      "description": "String",
      "is_active": "boolean",
      "createdAt": "LocalDateTime",
      "updatedAt": "LocalDateTime",
      "createBy": "String",
      "updateBy": "String",
      "users": "Set<User>",
      "permissions": "Set<Permission>"
    },
    "employee": {
      "id": "Long",
      "position": "Position",
      "user": "User",
      "reviews": "Set<ReviewEmployee>",
      "avatarUrl": "String",
      "department": "Department",
      "name": "String",
      "phone": "String",
      "email": "String",
      "gender": "String",
      "address": "String",
      "nationality": "String",
      "dateOfBirth": "LocalDate",
      "idNumber": "String",
      "candidateId": "Long",
      "status": "String",
      "createdAt": "LocalDateTime",
      "updatedAt": "LocalDateTime",
      "createBy": "String",
      "updateBy": "String"
    }
  },
  "reviews": [
    {
      "id": "Long",
      "employee": "Employee",
      "reviewerId": "Long",
      "onTimeCompletionScore": "Integer",
      "workEfficiencyScore": "Integer",
      "professionalSkillScore": "Integer",
      "selfLearningScore": "Integer",
      "workAttitudeScore": "Integer",
      "communicationSkillScore": "Integer",
      "honestyResponsibilityScore": "Integer",
      "teamIntegrationScore": "Integer",
      "probationResult": "Boolean",
      "additionalComments": "String",
      "createdAt": "LocalDateTime",
      "updatedAt": "LocalDateTime"
    }
  ],
  "avatarUrl": "String",
  "department": {
    "id": "Long",
    "code": "String",
    "name": "String",
    "description": "String",
    "is_active": "boolean",
    "employees": [
      "Employee"
    ],
    "createdAt": "LocalDateTime",
    "updatedAt": "LocalDateTime",
    "createBy": "String",
    "updateBy": "String"
  },
  "name": "String",
  "phone": "String",
  "email": "String",
  "gender": "String",
  "address": "String",
  "nationality": "String",
  "dateOfBirth": "LocalDate",
  "idNumber": "String",
  "candidateId": "Long",
  "status": "String",
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime",
  "createBy": "String",
  "updateBy": "String"
}
```

---

### `GET` /api/v1/user-service/employees
**Response:**
```json
[
  {
    "id": "Long",
    "position": {
      "id": "Long",
      "name": "String",
      "level": "String",
      "hierarchyOrder": "Integer",
      "isActive": "boolean",
      "employees": "Set<Employee>",
      "createdAt": "LocalDateTime",
      "updatedAt": "LocalDateTime",
      "createBy": "String",
      "updateBy": "String"
    },
    "user": {
      "id": "Long",
      "email": "String",
      "password": "String",
      "is_active": "boolean",
      "createdAt": "LocalDateTime",
      "updatedAt": "LocalDateTime",
      "createBy": "String",
      "updateBy": "String",
      "refreshToken": "String",
      "role": "Role",
      "employee": "Employee"
    },
    "reviews": [
      "ReviewEmployee"
    ],
    "avatarUrl": "String",
    "department": {
      "id": "Long",
      "code": "String",
      "name": "String",
      "description": "String",
      "is_active": "boolean",
      "employees": "Set<Employee>",
      "createdAt": "LocalDateTime",
      "updatedAt": "LocalDateTime",
      "createBy": "String",
      "updateBy": "String"
    },
    "name": "String",
    "phone": "String",
    "email": "String",
    "gender": "String",
    "address": "String",
    "nationality": "String",
    "dateOfBirth": "LocalDate",
    "idNumber": "String",
    "candidateId": "Long",
    "status": "String",
    "createdAt": "LocalDateTime",
    "updatedAt": "LocalDateTime",
    "createBy": "String",
    "updateBy": "String"
  }
]
```

---

### `GET` /api/v1/user-service/employees
**Response:**
```json
[
  {
    "id": "Long",
    "position": {
      "id": "Long",
      "name": "String",
      "level": "String",
      "hierarchyOrder": "Integer",
      "isActive": "boolean",
      "employees": "Set<Employee>",
      "createdAt": "LocalDateTime",
      "updatedAt": "LocalDateTime",
      "createBy": "String",
      "updateBy": "String"
    },
    "user": {
      "id": "Long",
      "email": "String",
      "password": "String",
      "is_active": "boolean",
      "createdAt": "LocalDateTime",
      "updatedAt": "LocalDateTime",
      "createBy": "String",
      "updateBy": "String",
      "refreshToken": "String",
      "role": "Role",
      "employee": "Employee"
    },
    "reviews": [
      "ReviewEmployee"
    ],
    "avatarUrl": "String",
    "department": {
      "id": "Long",
      "code": "String",
      "name": "String",
      "description": "String",
      "is_active": "boolean",
      "employees": "Set<Employee>",
      "createdAt": "LocalDateTime",
      "updatedAt": "LocalDateTime",
      "createBy": "String",
      "updateBy": "String"
    },
    "name": "String",
    "phone": "String",
    "email": "String",
    "gender": "String",
    "address": "String",
    "nationality": "String",
    "dateOfBirth": "LocalDate",
    "idNumber": "String",
    "candidateId": "Long",
    "status": "String",
    "createdAt": "LocalDateTime",
    "updatedAt": "LocalDateTime",
    "createBy": "String",
    "updateBy": "String"
  }
]
```

---

### `POST` /api/v1/user-service/employees/upload-avatar
**Response:**
```json
"String"
```

---

### `POST` /api/v1/user-service/employees/from-candidate
**Request Body:**
```json
{
  "candidateId": "Long",
  "name": "String",
  "email": "String",
  "phone": "String",
  "dateOfBirth": "String",
  "gender": "String",
  "nationality": "String",
  "idNumber": "String",
  "address": "String",
  "avatarUrl": "String",
  "departmentId": "Long",
  "positionId": "Long",
  "status": "String"
}
```
**Response:**
```json
{
  "id": "Long",
  "position": {
    "id": "Long",
    "name": "String",
    "level": "String",
    "hierarchyOrder": "Integer",
    "isActive": "boolean",
    "employees": [
      "Employee"
    ],
    "createdAt": "LocalDateTime",
    "updatedAt": "LocalDateTime",
    "createBy": "String",
    "updateBy": "String"
  },
  "user": {
    "id": "Long",
    "email": "String",
    "password": "String",
    "is_active": "boolean",
    "createdAt": "LocalDateTime",
    "updatedAt": "LocalDateTime",
    "createBy": "String",
    "updateBy": "String",
    "refreshToken": "String",
    "role": {
      "id": "Long",
      "name": "String",
      "description": "String",
      "is_active": "boolean",
      "createdAt": "LocalDateTime",
      "updatedAt": "LocalDateTime",
      "createBy": "String",
      "updateBy": "String",
      "users": "Set<User>",
      "permissions": "Set<Permission>"
    },
    "employee": {
      "id": "Long",
      "position": "Position",
      "user": "User",
      "reviews": "Set<ReviewEmployee>",
      "avatarUrl": "String",
      "department": "Department",
      "name": "String",
      "phone": "String",
      "email": "String",
      "gender": "String",
      "address": "String",
      "nationality": "String",
      "dateOfBirth": "LocalDate",
      "idNumber": "String",
      "candidateId": "Long",
      "status": "String",
      "createdAt": "LocalDateTime",
      "updatedAt": "LocalDateTime",
      "createBy": "String",
      "updateBy": "String"
    }
  },
  "reviews": [
    {
      "id": "Long",
      "employee": "Employee",
      "reviewerId": "Long",
      "onTimeCompletionScore": "Integer",
      "workEfficiencyScore": "Integer",
      "professionalSkillScore": "Integer",
      "selfLearningScore": "Integer",
      "workAttitudeScore": "Integer",
      "communicationSkillScore": "Integer",
      "honestyResponsibilityScore": "Integer",
      "teamIntegrationScore": "Integer",
      "probationResult": "Boolean",
      "additionalComments": "String",
      "createdAt": "LocalDateTime",
      "updatedAt": "LocalDateTime"
    }
  ],
  "avatarUrl": "String",
  "department": {
    "id": "Long",
    "code": "String",
    "name": "String",
    "description": "String",
    "is_active": "boolean",
    "employees": [
      "Employee"
    ],
    "createdAt": "LocalDateTime",
    "updatedAt": "LocalDateTime",
    "createBy": "String",
    "updateBy": "String"
  },
  "name": "String",
  "phone": "String",
  "email": "String",
  "gender": "String",
  "address": "String",
  "nationality": "String",
  "dateOfBirth": "LocalDate",
  "idNumber": "String",
  "candidateId": "Long",
  "status": "String",
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime",
  "createBy": "String",
  "updateBy": "String"
}
```

---

### `GET` /api/v1/user-service/permissions
**Response:**
```json
"?"
```

---

### `POST` /api/v1/user-service/permissions
**Request Body:**
```json
{
  "id": "Long",
  "name": "String",
  "active": "boolean",
  "createBy": "String",
  "updateBy": "String",
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime",
  "roles": [
    {
      "id": "Long",
      "name": "String",
      "description": "String",
      "is_active": "boolean",
      "createdAt": "LocalDateTime",
      "updatedAt": "LocalDateTime",
      "createBy": "String",
      "updateBy": "String",
      "users": "Set<User>",
      "permissions": "Set<Permission>"
    }
  ]
}
```
**Response:**
```json
{
  "id": "Long",
  "name": "String",
  "active": "boolean",
  "createBy": "String",
  "updateBy": "String",
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime",
  "roles": [
    {
      "id": "Long",
      "name": "String",
      "description": "String",
      "is_active": "boolean",
      "createdAt": "LocalDateTime",
      "updatedAt": "LocalDateTime",
      "createBy": "String",
      "updateBy": "String",
      "users": "Set<User>",
      "permissions": "Set<Permission>"
    }
  ]
}
```

---

### `PUT` /api/v1/user-service/permissions/{id}
**Request Body:**
```json
{
  "id": "Long",
  "name": "String",
  "active": "boolean",
  "createBy": "String",
  "updateBy": "String",
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime",
  "roles": [
    {
      "id": "Long",
      "name": "String",
      "description": "String",
      "is_active": "boolean",
      "createdAt": "LocalDateTime",
      "updatedAt": "LocalDateTime",
      "createBy": "String",
      "updateBy": "String",
      "users": "Set<User>",
      "permissions": "Set<Permission>"
    }
  ]
}
```
**Response:**
```json
{
  "id": "Long",
  "name": "String",
  "active": "boolean",
  "createBy": "String",
  "updateBy": "String",
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime",
  "roles": [
    {
      "id": "Long",
      "name": "String",
      "description": "String",
      "is_active": "boolean",
      "createdAt": "LocalDateTime",
      "updatedAt": "LocalDateTime",
      "createBy": "String",
      "updateBy": "String",
      "users": "Set<User>",
      "permissions": "Set<Permission>"
    }
  ]
}
```

---

### `DELETE` /api/v1/user-service/permissions/{id}

---

### `GET` /api/v1/user-service/positions
**Response:**
```json
{
  "meta": {
    "page": "int",
    "pageSize": "int",
    "pages": "int",
    "total": "long"
  },
  "result": "Object"
}
```

---

### `POST` /api/v1/user-service/positions
**Request Body:**
```json
{
  "name": "String",
  "level": "String",
  "hierarchyOrder": "Integer",
  "isActive": "Boolean"
}
```
**Response:**
```json
{
  "id": "Long",
  "name": "String",
  "level": "String",
  "hierarchyOrder": "Integer",
  "isActive": "boolean",
  "employees": [
    {
      "id": "Long",
      "position": "Position",
      "user": "User",
      "reviews": "Set<ReviewEmployee>",
      "avatarUrl": "String",
      "department": "Department",
      "name": "String",
      "phone": "String",
      "email": "String",
      "gender": "String",
      "address": "String",
      "nationality": "String",
      "dateOfBirth": "LocalDate",
      "idNumber": "String",
      "candidateId": "Long",
      "status": "String",
      "createdAt": "LocalDateTime",
      "updatedAt": "LocalDateTime",
      "createBy": "String",
      "updateBy": "String"
    }
  ],
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime",
  "createBy": "String",
  "updateBy": "String"
}
```

---

### `PUT` /api/v1/user-service/positions/{id}
**Request Body:**
```json
{
  "name": "String",
  "level": "String",
  "hierarchyOrder": "Integer",
  "isActive": "Boolean"
}
```
**Response:**
```json
{
  "id": "Long",
  "name": "String",
  "level": "String",
  "hierarchyOrder": "Integer",
  "isActive": "boolean",
  "employees": [
    {
      "id": "Long",
      "position": "Position",
      "user": "User",
      "reviews": "Set<ReviewEmployee>",
      "avatarUrl": "String",
      "department": "Department",
      "name": "String",
      "phone": "String",
      "email": "String",
      "gender": "String",
      "address": "String",
      "nationality": "String",
      "dateOfBirth": "LocalDate",
      "idNumber": "String",
      "candidateId": "Long",
      "status": "String",
      "createdAt": "LocalDateTime",
      "updatedAt": "LocalDateTime",
      "createBy": "String",
      "updateBy": "String"
    }
  ],
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime",
  "createBy": "String",
  "updateBy": "String"
}
```

---

### `DELETE` /api/v1/user-service/positions/{id}

---

### `GET` /api/v1/user-service/positions/{id}
**Response:**
```json
{
  "id": "Long",
  "name": "String",
  "level": "String",
  "hierarchyOrder": "Integer",
  "isActive": "boolean",
  "employees": [
    {
      "id": "Long",
      "position": "Position",
      "user": "User",
      "reviews": "Set<ReviewEmployee>",
      "avatarUrl": "String",
      "department": "Department",
      "name": "String",
      "phone": "String",
      "email": "String",
      "gender": "String",
      "address": "String",
      "nationality": "String",
      "dateOfBirth": "LocalDate",
      "idNumber": "String",
      "candidateId": "Long",
      "status": "String",
      "createdAt": "LocalDateTime",
      "updatedAt": "LocalDateTime",
      "createBy": "String",
      "updateBy": "String"
    }
  ],
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime",
  "createBy": "String",
  "updateBy": "String"
}
```

---

### `GET` /api/v1/user-service/positions
**Response:**
```json
[
  {
    "id": "Long",
    "name": "String",
    "level": "String",
    "hierarchyOrder": "Integer",
    "isActive": "boolean",
    "employees": [
      "Employee"
    ],
    "createdAt": "LocalDateTime",
    "updatedAt": "LocalDateTime",
    "createBy": "String",
    "updateBy": "String"
  }
]
```

---

### `GET` /api/v1/user-service/reviews
**Response:**
```json
{
  "meta": {
    "page": "int",
    "pageSize": "int",
    "pages": "int",
    "total": "long"
  },
  "result": "Object"
}
```

---

### `GET` /api/v1/user-service/reviews/{id}
**Response:**
```json
{
  "id": "Long",
  "employeeId": "Long",
  "reviewerId": "Long",
  "reviewerName": "String",
  "onTimeCompletionScore": "Integer",
  "workEfficiencyScore": "Integer",
  "professionalSkillScore": "Integer",
  "selfLearningScore": "Integer",
  "workAttitudeScore": "Integer",
  "communicationSkillScore": "Integer",
  "honestyResponsibilityScore": "Integer",
  "teamIntegrationScore": "Integer",
  "averageScore": "Double",
  "additionalComments": "String",
  "probationResult": "Boolean",
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime"
}
```

---

### `POST` /api/v1/user-service/reviews
**Request Body:**
```json
{
  "employeeId": "Long",
  "onTimeCompletionScore": "Integer",
  "workEfficiencyScore": "Integer",
  "professionalSkillScore": "Integer",
  "selfLearningScore": "Integer",
  "workAttitudeScore": "Integer",
  "communicationSkillScore": "Integer",
  "honestyResponsibilityScore": "Integer",
  "teamIntegrationScore": "Integer",
  "probationResult": "Boolean",
  "additionalComments": "String"
}
```
**Response:**
```json
{
  "id": "Long",
  "employeeId": "Long",
  "reviewerId": "Long",
  "reviewerName": "String",
  "onTimeCompletionScore": "Integer",
  "workEfficiencyScore": "Integer",
  "professionalSkillScore": "Integer",
  "selfLearningScore": "Integer",
  "workAttitudeScore": "Integer",
  "communicationSkillScore": "Integer",
  "honestyResponsibilityScore": "Integer",
  "teamIntegrationScore": "Integer",
  "averageScore": "Double",
  "additionalComments": "String",
  "probationResult": "Boolean",
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime"
}
```

---

### `PUT` /api/v1/user-service/reviews/{id}
**Request Body:**
```json
{
  "onTimeCompletionScore": "Integer",
  "workEfficiencyScore": "Integer",
  "professionalSkillScore": "Integer",
  "selfLearningScore": "Integer",
  "workAttitudeScore": "Integer",
  "communicationSkillScore": "Integer",
  "honestyResponsibilityScore": "Integer",
  "teamIntegrationScore": "Integer",
  "probationResult": "Boolean",
  "additionalComments": "String"
}
```
**Response:**
```json
{
  "id": "Long",
  "employeeId": "Long",
  "reviewerId": "Long",
  "reviewerName": "String",
  "onTimeCompletionScore": "Integer",
  "workEfficiencyScore": "Integer",
  "professionalSkillScore": "Integer",
  "selfLearningScore": "Integer",
  "workAttitudeScore": "Integer",
  "communicationSkillScore": "Integer",
  "honestyResponsibilityScore": "Integer",
  "teamIntegrationScore": "Integer",
  "averageScore": "Double",
  "additionalComments": "String",
  "probationResult": "Boolean",
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime"
}
```

---

### `DELETE` /api/v1/user-service/reviews/{id}

---

### `GET` /api/v1/user-service/roles
**Response:**
```json
{
  "meta": {
    "page": "int",
    "pageSize": "int",
    "pages": "int",
    "total": "long"
  },
  "result": "Object"
}
```

---

### `POST` /api/v1/user-service/roles
**Request Body:**
```json
{
  "name": "String",
  "description": "String",
  "isActive": "Boolean",
  "permissionIds": [
    "Long"
  ]
}
```
**Response:**
```json
{
  "id": "Long",
  "name": "String",
  "description": "String",
  "is_active": "boolean",
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime",
  "createBy": "String",
  "updateBy": "String",
  "users": [
    {
      "id": "Long",
      "email": "String",
      "password": "String",
      "is_active": "boolean",
      "createdAt": "LocalDateTime",
      "updatedAt": "LocalDateTime",
      "createBy": "String",
      "updateBy": "String",
      "refreshToken": "String",
      "role": "Role",
      "employee": "Employee"
    }
  ],
  "permissions": [
    {
      "id": "Long",
      "name": "String",
      "active": "boolean",
      "createBy": "String",
      "updateBy": "String",
      "createdAt": "LocalDateTime",
      "updatedAt": "LocalDateTime",
      "roles": "Set<Role>"
    }
  ]
}
```

---

### `PUT` /api/v1/user-service/roles/{id}
**Request Body:**
```json
{
  "name": "String",
  "description": "String",
  "isActive": "Boolean",
  "permissionIds": [
    "Long"
  ]
}
```
**Response:**
```json
{
  "id": "Long",
  "name": "String",
  "description": "String",
  "is_active": "boolean",
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime",
  "createBy": "String",
  "updateBy": "String",
  "users": [
    {
      "id": "Long",
      "email": "String",
      "password": "String",
      "is_active": "boolean",
      "createdAt": "LocalDateTime",
      "updatedAt": "LocalDateTime",
      "createBy": "String",
      "updateBy": "String",
      "refreshToken": "String",
      "role": "Role",
      "employee": "Employee"
    }
  ],
  "permissions": [
    {
      "id": "Long",
      "name": "String",
      "active": "boolean",
      "createBy": "String",
      "updateBy": "String",
      "createdAt": "LocalDateTime",
      "updatedAt": "LocalDateTime",
      "roles": "Set<Role>"
    }
  ]
}
```

---

### `DELETE` /api/v1/user-service/roles/{id}

---

### `GET` /api/v1/user-service/roles/{id}
**Response:**
```json
{
  "id": "Long",
  "name": "String",
  "description": "String",
  "is_active": "boolean",
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime",
  "createBy": "String",
  "updateBy": "String",
  "users": [
    {
      "id": "Long",
      "email": "String",
      "password": "String",
      "is_active": "boolean",
      "createdAt": "LocalDateTime",
      "updatedAt": "LocalDateTime",
      "createBy": "String",
      "updateBy": "String",
      "refreshToken": "String",
      "role": "Role",
      "employee": "Employee"
    }
  ],
  "permissions": [
    {
      "id": "Long",
      "name": "String",
      "active": "boolean",
      "createBy": "String",
      "updateBy": "String",
      "createdAt": "LocalDateTime",
      "updatedAt": "LocalDateTime",
      "roles": "Set<Role>"
    }
  ]
}
```

---

### `GET` /api/v1/user-service/roles
**Response:**
```json
[
  {
    "id": "Long",
    "name": "String",
    "description": "String",
    "is_active": "boolean",
    "createdAt": "LocalDateTime",
    "updatedAt": "LocalDateTime",
    "createBy": "String",
    "updateBy": "String",
    "users": [
      "User"
    ],
    "permissions": [
      "Permission"
    ]
  }
]
```

---

### `GET` /api/v1/user-service/users
**Response:**
```json
{
  "meta": {
    "page": "int",
    "pageSize": "int",
    "pages": "int",
    "total": "long"
  },
  "result": "Object"
}
```

---

### `POST` /api/v1/user-service/users
**Request Body:**
```json
{
  "email": "String",
  "password": "String",
  "roleId": "Long",
  "employeeId": "Long"
}
```
**Response:**
```json
{
  "id": "Long",
  "email": "String",
  "password": "String",
  "isActive": "boolean",
  "createBy": "String",
  "updateBy": "String",
  "refreshToken": "String",
  "roleId": "Long",
  "employee": {
    "id": "Long",
    "position": {
      "id": "Long",
      "name": "String",
      "level": "String",
      "hierarchyOrder": "Integer",
      "isActive": "boolean",
      "employees": "Set<Employee>",
      "createdAt": "LocalDateTime",
      "updatedAt": "LocalDateTime",
      "createBy": "String",
      "updateBy": "String"
    },
    "user": {
      "id": "Long",
      "email": "String",
      "password": "String",
      "is_active": "boolean",
      "createdAt": "LocalDateTime",
      "updatedAt": "LocalDateTime",
      "createBy": "String",
      "updateBy": "String",
      "refreshToken": "String",
      "role": "Role",
      "employee": "Employee"
    },
    "reviews": [
      "ReviewEmployee"
    ],
    "avatarUrl": "String",
    "department": {
      "id": "Long",
      "code": "String",
      "name": "String",
      "description": "String",
      "is_active": "boolean",
      "employees": "Set<Employee>",
      "createdAt": "LocalDateTime",
      "updatedAt": "LocalDateTime",
      "createBy": "String",
      "updateBy": "String"
    },
    "name": "String",
    "phone": "String",
    "email": "String",
    "gender": "String",
    "address": "String",
    "nationality": "String",
    "dateOfBirth": "LocalDate",
    "idNumber": "String",
    "candidateId": "Long",
    "status": "String",
    "createdAt": "LocalDateTime",
    "updatedAt": "LocalDateTime",
    "createBy": "String",
    "updateBy": "String"
  },
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime"
}
```

---

### `PUT` /api/v1/user-service/users/{id}
**Request Body:**
```json
{
  "email": "String",
  "password": "String",
  "roleId": "Long",
  "employeeId": "Long",
  "isActive": "Boolean"
}
```
**Response:**
```json
{
  "id": "Long",
  "email": "String",
  "password": "String",
  "isActive": "boolean",
  "createBy": "String",
  "updateBy": "String",
  "refreshToken": "String",
  "roleId": "Long",
  "employee": {
    "id": "Long",
    "position": {
      "id": "Long",
      "name": "String",
      "level": "String",
      "hierarchyOrder": "Integer",
      "isActive": "boolean",
      "employees": "Set<Employee>",
      "createdAt": "LocalDateTime",
      "updatedAt": "LocalDateTime",
      "createBy": "String",
      "updateBy": "String"
    },
    "user": {
      "id": "Long",
      "email": "String",
      "password": "String",
      "is_active": "boolean",
      "createdAt": "LocalDateTime",
      "updatedAt": "LocalDateTime",
      "createBy": "String",
      "updateBy": "String",
      "refreshToken": "String",
      "role": "Role",
      "employee": "Employee"
    },
    "reviews": [
      "ReviewEmployee"
    ],
    "avatarUrl": "String",
    "department": {
      "id": "Long",
      "code": "String",
      "name": "String",
      "description": "String",
      "is_active": "boolean",
      "employees": "Set<Employee>",
      "createdAt": "LocalDateTime",
      "updatedAt": "LocalDateTime",
      "createBy": "String",
      "updateBy": "String"
    },
    "name": "String",
    "phone": "String",
    "email": "String",
    "gender": "String",
    "address": "String",
    "nationality": "String",
    "dateOfBirth": "LocalDate",
    "idNumber": "String",
    "candidateId": "Long",
    "status": "String",
    "createdAt": "LocalDateTime",
    "updatedAt": "LocalDateTime",
    "createBy": "String",
    "updateBy": "String"
  },
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime"
}
```

---

### `DELETE` /api/v1/user-service/users/{id}

---

### `GET` /api/v1/user-service/users/{id}
**Response:**
```json
{
  "id": "Long",
  "email": "String",
  "password": "String",
  "isActive": "boolean",
  "createBy": "String",
  "updateBy": "String",
  "refreshToken": "String",
  "roleId": "Long",
  "employee": {
    "id": "Long",
    "position": {
      "id": "Long",
      "name": "String",
      "level": "String",
      "hierarchyOrder": "Integer",
      "isActive": "boolean",
      "employees": "Set<Employee>",
      "createdAt": "LocalDateTime",
      "updatedAt": "LocalDateTime",
      "createBy": "String",
      "updateBy": "String"
    },
    "user": {
      "id": "Long",
      "email": "String",
      "password": "String",
      "is_active": "boolean",
      "createdAt": "LocalDateTime",
      "updatedAt": "LocalDateTime",
      "createBy": "String",
      "updateBy": "String",
      "refreshToken": "String",
      "role": "Role",
      "employee": "Employee"
    },
    "reviews": [
      "ReviewEmployee"
    ],
    "avatarUrl": "String",
    "department": {
      "id": "Long",
      "code": "String",
      "name": "String",
      "description": "String",
      "is_active": "boolean",
      "employees": "Set<Employee>",
      "createdAt": "LocalDateTime",
      "updatedAt": "LocalDateTime",
      "createBy": "String",
      "updateBy": "String"
    },
    "name": "String",
    "phone": "String",
    "email": "String",
    "gender": "String",
    "address": "String",
    "nationality": "String",
    "dateOfBirth": "LocalDate",
    "idNumber": "String",
    "candidateId": "Long",
    "status": "String",
    "createdAt": "LocalDateTime",
    "updatedAt": "LocalDateTime",
    "createBy": "String",
    "updateBy": "String"
  },
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime"
}
```

---

### `GET` /api/v1/user-service/users
**Response:**
```json
[
  {
    "id": "Long",
    "email": "String",
    "password": "String",
    "isActive": "boolean",
    "createBy": "String",
    "updateBy": "String",
    "refreshToken": "String",
    "roleId": "Long",
    "employee": {
      "id": "Long",
      "position": "Position",
      "user": "User",
      "reviews": "Set<ReviewEmployee>",
      "avatarUrl": "String",
      "department": "Department",
      "name": "String",
      "phone": "String",
      "email": "String",
      "gender": "String",
      "address": "String",
      "nationality": "String",
      "dateOfBirth": "LocalDate",
      "idNumber": "String",
      "candidateId": "Long",
      "status": "String",
      "createdAt": "LocalDateTime",
      "updatedAt": "LocalDateTime",
      "createBy": "String",
      "updateBy": "String"
    },
    "createdAt": "LocalDateTime",
    "updatedAt": "LocalDateTime"
  }
]
```

---

### `GET` /api/v1/user-service/users
**Response:**
```json
[
  {
    "id": "Long",
    "email": "String",
    "password": "String",
    "isActive": "boolean",
    "createBy": "String",
    "updateBy": "String",
    "refreshToken": "String",
    "roleId": "Long",
    "employee": {
      "id": "Long",
      "position": "Position",
      "user": "User",
      "reviews": "Set<ReviewEmployee>",
      "avatarUrl": "String",
      "department": "Department",
      "name": "String",
      "phone": "String",
      "email": "String",
      "gender": "String",
      "address": "String",
      "nationality": "String",
      "dateOfBirth": "LocalDate",
      "idNumber": "String",
      "candidateId": "Long",
      "status": "String",
      "createdAt": "LocalDateTime",
      "updatedAt": "LocalDateTime",
      "createBy": "String",
      "updateBy": "String"
    },
    "createdAt": "LocalDateTime",
    "updatedAt": "LocalDateTime"
  }
]
```

---

### `GET` /api/v1/workflow-service/approval-trackings
**Response:**
```json
{
  "meta": {
    "page": "int",
    "pageSize": "int",
    "pages": "int",
    "total": "long"
  },
  "result": "Object"
}
```

---

### `GET` /api/v1/workflow-service/approval-trackings/{id}
**Response:**
```json
{
  "id": "Long",
  "requestId": "Long",
  "stepId": "Long",
  "status": "ApprovalStatus",
  "approverPositionId": "Long",
  "approverPositionName": "String",
  "actionUserId": "Long",
  "actionUserName": "String",
  "actionAt": "LocalDateTime",
  "notes": "String",
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime"
}
```

---

### `GET` /api/v1/workflow-service/approval-trackings/pending/{userId}
**Response:**
```json
[
  {
    "id": "Long",
    "requestId": "Long",
    "stepId": "Long",
    "status": "ApprovalStatus",
    "approverPositionId": "Long",
    "approverPositionName": "String",
    "actionUserId": "Long",
    "actionUserName": "String",
    "actionAt": "LocalDateTime",
    "notes": "String",
    "createdAt": "LocalDateTime",
    "updatedAt": "LocalDateTime"
  }
]
```

---

### `POST` /api/v1/workflow-service/approval-trackings/initialize
**Request Body:**
```json
{
  "requestId": "Long",
  "departmentId": "Long",
  "levelId": "Long"
}
```
**Response:**
```json
{
  "id": "Long",
  "requestId": "Long",
  "stepId": "Long",
  "status": "ApprovalStatus",
  "approverPositionId": "Long",
  "approverPositionName": "String",
  "actionUserId": "Long",
  "actionUserName": "String",
  "actionAt": "LocalDateTime",
  "notes": "String",
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime"
}
```

---

### `POST` /api/v1/workflow-service/approval-trackings/{id}/approve
**Request Body:**
```json
{
  "approved": "Boolean",
  "approvalNotes": "String"
}
```
**Response:**
```json
{
  "id": "Long",
  "requestId": "Long",
  "stepId": "Long",
  "status": "ApprovalStatus",
  "approverPositionId": "Long",
  "approverPositionName": "String",
  "actionUserId": "Long",
  "actionUserName": "String",
  "actionAt": "LocalDateTime",
  "notes": "String",
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime"
}
```

---

### `GET` /api/v1/workflow-service/approval-trackings/by-request/{requestId}
**Response:**
```json
{
  "workflow": {
    "id": "Long",
    "name": "String",
    "description": "String",
    "type": "WorkflowType",
    "departmentId": "Long",
    "isActive": "Boolean",
    "createdBy": "Long",
    "updatedBy": "Long",
    "steps": [
      "WorkflowStepResponseDTO"
    ],
    "createdAt": "LocalDateTime",
    "updatedAt": "LocalDateTime"
  },
  "approvalTrackings": [
    {
      "id": "Long",
      "requestId": "Long",
      "stepId": "Long",
      "status": "ApprovalStatus",
      "approverPositionId": "Long",
      "approverPositionName": "String",
      "actionUserId": "Long",
      "actionUserName": "String",
      "actionAt": "LocalDateTime",
      "notes": "String",
      "createdAt": "LocalDateTime",
      "updatedAt": "LocalDateTime"
    }
  ],
  "currentStepId": "Long"
}
```

---

### `GET` /api/v1/workflow-service/workflows
**Response:**
```json
{
  "meta": {
    "page": "int",
    "pageSize": "int",
    "pages": "int",
    "total": "long"
  },
  "result": "Object"
}
```

---

### `GET` /api/v1/workflow-service/workflows/{id}
**Response:**
```json
{
  "id": "Long",
  "name": "String",
  "description": "String",
  "type": "WorkflowType",
  "departmentId": "Long",
  "isActive": "Boolean",
  "createdBy": "Long",
  "updatedBy": "Long",
  "steps": [
    {
      "id": "Long",
      "stepOrder": "Integer",
      "approverPositionId": "Long",
      "approverPositionName": "String",
      "isActive": "Boolean",
      "createdAt": "LocalDateTime",
      "updatedAt": "LocalDateTime"
    }
  ],
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime"
}
```

---

### `POST` /api/v1/workflow-service/workflows
**Request Body:**
```json
{
  "name": "String",
  "description": "String",
  "type": "WorkflowType",
  "departmentId": "Long",
  "createdBy": "Long",
  "steps": [
    {
      "stepOrder": "Integer",
      "approverPositionId": "Long"
    }
  ]
}
```
**Response:**
```json
{
  "id": "Long",
  "name": "String",
  "description": "String",
  "type": "WorkflowType",
  "departmentId": "Long",
  "isActive": "Boolean",
  "createdBy": "Long",
  "updatedBy": "Long",
  "steps": [
    {
      "id": "Long",
      "stepOrder": "Integer",
      "approverPositionId": "Long",
      "approverPositionName": "String",
      "isActive": "Boolean",
      "createdAt": "LocalDateTime",
      "updatedAt": "LocalDateTime"
    }
  ],
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime"
}
```

---

### `PUT` /api/v1/workflow-service/workflows/{id}
**Request Body:**
```json
{
  "name": "String",
  "description": "String",
  "type": "WorkflowType",
  "departmentId": "Long",
  "isActive": "Boolean",
  "updatedBy": "Long",
  "steps": [
    {
      "stepOrder": "Integer",
      "approverPositionId": "Long"
    }
  ]
}
```
**Response:**
```json
{
  "id": "Long",
  "name": "String",
  "description": "String",
  "type": "WorkflowType",
  "departmentId": "Long",
  "isActive": "Boolean",
  "createdBy": "Long",
  "updatedBy": "Long",
  "steps": [
    {
      "id": "Long",
      "stepOrder": "Integer",
      "approverPositionId": "Long",
      "approverPositionName": "String",
      "isActive": "Boolean",
      "createdAt": "LocalDateTime",
      "updatedAt": "LocalDateTime"
    }
  ],
  "createdAt": "LocalDateTime",
  "updatedAt": "LocalDateTime"
}
```

---

### `DELETE` /api/v1/workflow-service/workflows/{id}

---
