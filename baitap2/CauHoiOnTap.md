Câu 1:Tại sao chúng ta dùng kiểu dữ liệu ConcurrentHashMap trong dự án này?
    đọc ghi dữ liệu nhanh , đồng bộ  ,thread safe phù hợp với việc quản lý dữ liệu lớn như dự án về book.
Câu 2:Để sinh một chuỗi ngẫu nhiên duy nhất thì dùng hàm nào?
String uuid = UUID.randomUUID().toString();
Câu 3:Nếu không sử dụng khai báo public record BookRequest(String title, String author, int year) thì dùng cách gì thay thế?
    thì phải tạo contructor ,getter
Câu 4:Ở phương thức getBooks() chúng ta có thể trả trực tiếp biến books kiểu ConcurrentHashMap về cho trình duyệt được không? Hãy thử nghiệm
    Trả lời : có thể .