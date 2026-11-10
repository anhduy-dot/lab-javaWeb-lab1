# lab-javaWeb-lab1

Bài lab môn **JAV203 – Phát triển web nâng cao cùng AI (Java)** – FPT Polytechnic.

Sinh viên: Nguyễn Anh Duy – PS48450

## Danh sách bài lab

| Lab | Nội dung | Thư mục |
|---|---|---|
| Lab 1 | Phân tích kiến trúc và khởi tạo ứng dụng Spring Boot MVC cho hệ thống quản lý sản phẩm | [`lab1/SOF3022_ProductPortal`](lab1/SOF3022_ProductPortal) |

## Lab 1 – SOF3022_ProductPortal

- Spring Boot MVC, Thymeleaf, Spring Boot DevTools, Lombok
- Package chính: `poly.edu`
- `HomeController` map các URL `/home/index`, `/home/about`, `/home/help` và truyền `appName`, `subject`, `semester`, `message` sang View qua `Model`
- Phần trả lời câu hỏi của đề: [`BaiLam_Lab1.md`](lab1/SOF3022_ProductPortal/BaiLam_Lab1.md)

### Chạy project

```bash
cd lab1/SOF3022_ProductPortal
./mvnw spring-boot:run        # Windows: mvnw.cmd spring-boot:run
```

Sau đó mở http://localhost:8080/home/index
