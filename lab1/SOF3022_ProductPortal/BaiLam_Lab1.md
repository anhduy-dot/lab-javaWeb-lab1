# Bài làm Lab 1 - SOF3022_ProductPortal

## Bài 1: Môi trường phát triển

Phiên bản Java (lệnh `java -version`): OpenJDK 25.0.2 (Temurin).

| Công cụ | Vai trò |
|---|---|
| JDK | Biên dịch mã Java thành bytecode và cung cấp JVM để chạy ứng dụng |
| Maven | Tải thư viện khai báo trong `pom.xml`, build, test và đóng gói project |
| IDE (STS4) | Môi trường viết code, gợi ý, debug và chạy nhanh bằng Spring Boot App |

## Bài 2: Project và dependency

Thành phần chính của project:

| Thành phần | Vai trò |
|---|---|
| `pom.xml` | Khai báo thông tin project, phiên bản Java, dependency và plugin build |
| `src/main/resources/application.properties` | Cấu hình ứng dụng (tên ứng dụng, cổng, ...) |
| `src/main/resources/templates` | Chứa các View Thymeleaf, được xử lý ở server trước khi trả về |
| `src/main/resources/static` | Chứa file tĩnh (CSS, JS, ảnh), trả về nguyên bản không qua xử lý |
| `src/main/java` | Chứa mã nguồn Java: class main và các Controller |

Bảng Dependency - Vai trò:

| Dependency | Vai trò |
|---|---|
| Spring Web (`spring-boot-starter-webmvc`) | Cung cấp Spring MVC và Tomcat nhúng để xử lý request/response |
| Thymeleaf (`spring-boot-starter-thymeleaf`) | Template engine, đưa dữ liệu từ Model vào file HTML ở server |
| Spring Boot DevTools | Tự khởi động lại ứng dụng khi code thay đổi, chỉ dùng lúc phát triển |
| Lombok | Sinh getter, setter, constructor qua annotation, giảm code lặp (Lab 1 chưa dùng đến) |

## Bài 3: Controller, Model và View phối hợp thế nào (luồng /home/index)

- **Controller** (`HomeController`) nhận request `/home/index`, chuẩn bị dữ liệu và chọn View bằng cách trả về chuỗi `"home/index"`.
- **Model** là nơi chứa dữ liệu chuyển sang View: `appName`, `subject`, `semester`, `message`.
- **View** (`templates/home/index.html`) lấy dữ liệu từ Model bằng cú pháp như `th:text="${appName}"` để sinh ra HTML.

## Bài 4: Quan sát HTML Response

**1. Trình duyệt nhận được file Thymeleaf gốc hay HTML đã render?**
HTML đã render. Trong View Page Source không còn thuộc tính `th:` nào.

**2. Các biến như `${appName}`, `${subject}` còn xuất hiện trong HTML response không?**
Không. Chúng đã được thay bằng giá trị thật, ví dụ `Product Portal`, `SOF3022 - Spring Boot MVC`.

**3. Dữ liệu từ Controller được đưa vào View ở bước nào?**
Ở bước Thymeleaf render, diễn ra sau khi `HomeController.index()` trả về tên View và trước khi server gửi response. Thymeleaf đọc giá trị từ Model và thay vào các biểu thức `${...}`.

**4. Luồng xử lý request/response của URL /home/index:**

```
Browser
→ Request /home/index
→ HomeController.index()
→ Model chứa appName, subject, semester, message
→ home/index.html
→ Thymeleaf render HTML
→ Server trả HTML response
→ Browser hiển thị giao diện
```

**5. Template HTML và HTML Response khác nhau thế nào (ví dụ từ /home/index):**

| | Nội dung |
|---|---|
| Template (`templates/home/index.html`, nằm trên server) | `<h1 th:text="${appName}">Tên hệ thống</h1>` |
| HTML Response (trình duyệt nhận được) | `<h1>Product Portal</h1>` |

Template là khuôn mẫu chứa cú pháp Thymeleaf. HTML Response là kết quả sau khi ghép khuôn mẫu với dữ liệu trong Model, và trình duyệt chỉ nhận được phần này.
