

```markdown
# Task Controller API

## Giới thiệu

Đây là một API điều khiển nhiệm vụ (Task Controller API) được xây dựng để quản lý danh sách nhiệm vụ. API này cung cấp các phương thức để lấy, thêm, cập nhật và xóa nhiệm vụ.

## Cài đặt

1. Clone repository về máy của bạn.
2. Mở project trong môi trường phát triển (IDE) của bạn.
3. Cài đặt các dependencies và thư viện cần thiết.
4. Cấu hình cơ sở dữ liệu MySQL bằng các thay đổi trong file `application.properties`.
5. Chạy ứng dụng trong môi trường cục bộ.

## Cấu hình cơ sở dữ liệu

Cấu hình kết nối cơ sở dữ liệu MySQL trong file `application.properties`:
```

```properties
server.port=8081
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/todo
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.show-sql=true
```

- `server.port`: Cổng mà ứng dụng sẽ chạy trên.
- `spring.jpa.hibernate.ddl-auto`: Chế độ cập nhật cấu trúc cơ sở dữ liệu.
- `spring.datasource.url`: URL kết nối đến cơ sở dữ liệu MySQL.
- `spring.datasource.username`: Tên đăng nhập cho cơ sở dữ liệu MySQL.
- `spring.datasource.password`: Mật khẩu cho cơ sở dữ liệu MySQL.
- `spring.datasource.driver-class-name`: Tên lớp trình điều khiển cho MySQL.
- `spring.jpa.show-sql`: Hiển thị câu lệnh SQL được tạo ra.

## API Endpoints

### Lấy danh sách nhiệm vụ

```
GET /api/v1/tasks
```

Endpoint này trả về danh sách tất cả các nhiệm vụ.

#### Tham số

Không có.

#### Phản hồi thành công

Status: 200 OK

```json
{
  "status": 200,
  "message": "Get list task successfully",
  "data": [
    {
      "id": 1,
      "title": "Nhiệm vụ 1",
      "completed": false
    },
    {
      "id": 2,
      "title": "Nhiệm vụ 2",
      "completed": false
    }
  ]
}
```

### Thêm nhiệm vụ mới

```
POST /api/v1/task
```

Endpoint này cho phép thêm một nhiệm vụ mới vào danh sách.

#### Tham số

Request Body (application/json):

```json
{
  "title": "Nhiệm vụ mới",
  "completed": false
}
```

- `title` (bắt buộc): Tiêu đề của nhiệm vụ.
- `description`: Mô tả của nhiệm vụ (tùy chọn).

#### Phản hồi thành công

Status: 200 OK

```json
{
  "status": 200,
  "message": "Thêm nhiệm vụ mới thành công",
  "data": {
    "id": 3,
    "title": "Nhiệm vụ mới",
    "completed": false
  }
}
```

### Cập nhật nhiệm vụ

```
PUT /api/v1/task/{id}
```

Endpoint này cho phép cập nhật thông tin của một nhiệm vụ trong danh sách.

#### Tham số

Path Variable:
- `{id}`: ID của nhiệm vụ cần cập nhật.

Request Body (application/json):

```json
{
  "title": "Nhiệm vụ cập nhật",
  "completed": true
}
```

- `title` (bắt buộc): Tiêu đề mới của nhiệm vụ.
- `description`: Mô tả mới của nhiệm vụ (tùy chọn).

#### Phản hồi thành công

Status: 200 OK

```json
{
  "status": 200,
  "message": "Cập nhật nhiệm vụ thành công",
  "data": {
    "id": 3,
    "title": "Nhiệm vụ cập nhật",
    "completed": true
  }
}
```

### Xóa nhiệm vụ

```
DELETE /api/v1/task/{id}
```

Endpoint này cho phép xóa một nhiệm vụ khỏi danh sách.

#### Tham số

Path Variable:
- `{id}`: ID của nhiệm vụ cần xóa.

#### Phản hồi thành công

Status: 200 OK

```json
{
  "status": 200,
  "message": "Xóa nhiệm vụ thành công"
}
```

## Đóng góp

Nếu bạn muốn đóng góp vào dự án, hãy tạo pull request và chúng tôi sẽ xem xét và hợp nhất các thay đổi.

## Giấy phép

## Liên hệ

Nếu bạn có bất kỳ câu hỏi hoặc thắc mắc, hãy liên hệ với tôi qua email: letienlocvn@gmmail.com
```

Hãy sử dụng nội dung này và tùy chỉnh nó theo yêu cầu của dự án của bạn.