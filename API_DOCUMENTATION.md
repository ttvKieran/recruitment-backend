# Recruitment Backend — API Documentation

Phiên bản: 1.0 — Tài liệu tổng quan cho toàn bộ backend `recruitment-backend`.

## Mục lục
- Tổng quan
- Truy cập API (Gateway vs Direct)
- Xác thực (Auth)
- Định dạng phản hồi chung
- Danh sách service & endpoint chính
- Database & Seeders
- Cách cập nhật tài liệu

---

## Tổng quan
Repository `recruitment-backend` gồm một `gateway` và nhiều microservice (user, candidate, job, email, notification, schedule, workflow, communications, upload, ...). Mỗi service là một Spring Boot app dùng MySQL và tuân theo cùng một envelope phản hồi JSON.

Mục tiêu tài liệu này: cung cấp bản tóm tắt các endpoint chính, cách truy cập (qua Gateway hoặc trực tiếp), định dạng trả về, và chỗ chứa seeders để nạp dữ liệu thử.

## Truy cập API

- Gateway (khuyến nghị cho integration):
  - Base: `http://localhost:8081` (Gateway chạy mặc định trên 8081 trong docker-compose của dự án).
  - Gateway định tuyến các đường dẫn như `/api/v1/{service-name}/...` tới service tương ứng.

- Truy cập trực tiếp (hữu ích để debug): mặc định từng service có port nội bộ trong compose. Một số port thường thấy trong dự án:
  - user-service: `http://localhost:8082`
  - job-service: `http://localhost:8083`
  - candidate-service: `http://localhost:8084`
  - gateway: `http://localhost:8081`

Ví dụ gọi test endpoint (qua gateway):

```
curl -v "http://localhost:8081/api/v1/user-service/auth/check?name=test" \
  -H "Authorization: Bearer <TOKEN>"
```

Với truy cập trực tiếp:

```
curl -v "http://localhost:8082/api/v1/auth/check?name=test" -H "Authorization: Bearer <TOKEN>"
```

## Xác thực
- Các service dùng Spring Security (resource server) — yêu cầu Bearer token cho hầu hết endpoint bảo mật.
- Một số endpoint public (login/health) có thể không yêu cầu token — kiểm tra controller tương ứng.

## Định dạng phản hồi chung
Các service trả theo envelope chung `Response<T>` với cấu trúc tương tự:

```json
{
  "statusCode": 200,
  "error": null,
  "message": "OK",
  "data": { /* payload */ }
}
```

- Khi xảy ra lỗi, `statusCode` sẽ chứa HTTP status tương ứng và `error`/`message` chứa thông tin lỗi.
- ResponseBodyAdvice (`FormatResponse`) và `GlobalExceptionHandler` được dùng để chuẩn hoá phản hồi trên toàn bộ services.

## Danh sách service & endpoint chính (tóm tắt)
Lưu ý: đây là bản tóm tắt tổng quát; để lấy danh sách đầy đủ các endpoint, mở controller tương ứng trong `services/*/src/main/java`.

- **User Service** (`user-service`) — Base path (gateway): `/api/v1/user-service`
  - `GET /auth/check?name={name}` — health / test auth endpoint
  - `POST /auth/login` — đăng nhập (nếu service có auth controller)
  - `GET /users` — danh sách người dùng
  - `GET /users/{id}` — chi tiết người dùng
  - `POST /users` — tạo người dùng

- **Candidate Service** (`candidate-service`) — Base: `/api/v1/candidate-service`
  - `GET /candidates` — danh sách ứng viên
  - `GET /candidates/{id}` — chi tiết ứng viên
  - `POST /candidates` — tạo ứng viên

- **Job Service** (`job-service`) — Base: `/api/v1/job-service`
  - `GET /jobs` — danh sách vị trí
  - `GET /jobs/{id}` — chi tiết vị trí
  - `POST /jobs` — tạo vị trí tuyển dụng

- **Email Service** (`email-service`) — Base: `/api/v1/email-service`
  - `POST /emails/send` — gửi email (hàm gửi email nội bộ)
  - `GET /emails/{id}` — trạng thái email

- **Notification Service** (`notification-service`) — Base: `/api/v1/notification-service`
  - `GET /notifications` — lấy thông báo
  - `POST /notifications` — tạo thông báo

- **Schedule Service** (`schedule-service`) — Base: `/api/v1/schedule-service`
  - `GET /schedules` — lịch
  - `POST /schedules` — tạo lịch

- **Workflow Service** (`workflow-service`) — Base: `/api/v1/workflow-service`
  - `GET /workflows` — luồng công việc
  - `POST /workflows` — tạo/cập nhật luồng
  - Bảng quan trọng: `workflows` (cột `is_active` kiểm soát trạng thái)

- **Communications Service** (`communications-service`) — Base: `/api/v1/communications-service`
  - Các endpoint liên quan tin nhắn / hội thoại / threads

- **Upload Service** (`upload-service`) — Base: `/api/v1/upload-service`
  - `POST /upload` — tải tệp lên

(Nếu cần danh sách đầy đủ endpoint, tôi có thể quét controllers và chụp lại route + method cụ thể.)

## Database & Seeders
- Database: MySQL container (host-mapped port thường là `3307` trong docker-compose của dự án).
- Mỗi service có schema/DB riêng (ví dụ `user_service`, `job_service`, `candidate_service`, ...).
- Seeders (đã tạo/đặt ở workspace): tìm các lớp `DataSeeder` trong `services/*/src/main/java/.../config`.
  - Các seeder được viết là idempotent (chỉ chèn khi table trống — check `count() == 0`).
  - Nếu muốn tái nạp toàn bộ dữ liệu thử: dừng compose, xóa volume MySQL (`mysql_data`), khởi động lại compose — seeders sẽ chạy trên DB trống.

## Health & Monitoring
- Gateway: kiểm tra `http://localhost:8081/actuator/health` nếu có actuator; một số service chưa bật actuator mặc định.
- Kiểm tra logs bằng `docker compose logs -f {service-name}`.

## Cách cập nhật tài liệu này
- Để cập nhật endpoints chính xác, duyệt các controller trong:
  - `services/*/src/main/java/**/controller` hoặc `*Controller.java`.
- Nếu muốn tôi tự động sinh danh sách endpoint (method + path + mô tả ngắn), cho phép tôi quét codebase và thêm bản chi tiết.

## Ghi chú & best practices
- Kiểm tra `Response<T>` và `GlobalExceptionHandler` khi triển khai client để parse envelope.
- Khi gặp lỗi SQL (ví dụ cập nhật `is_active`): kiểm tra kiểu cột (`TINYINT(1)` / `BOOLEAN`) và dùng `1`/`0` hoặc `TRUE`/`FALSE` thay vì chuỗi '1'.

---
File này được tạo tự động để cung cấp cái nhìn tổng quan. Muốn tôi mở rộng: quét controllers và tạo tài liệu endpoint chi tiết (bao gồm HTTP method, path, request/response schemas, example), hay xuất OpenAPI/Swagger JSON không? Reply với lựa chọn bạn muốn.
