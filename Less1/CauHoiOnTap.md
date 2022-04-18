Câu 1 :Trong quá trình tạo dự án Spring Boot chúng ta phải khai báo những tham số sau đây : groupID, artifactID. Ý nghĩa
các tham số này là gì? Trả Lời : Chúng ta cần khai báo cả groupID và artifactID .

- groupID dùng để phân biệt công ty , tổ chức sở hữu.
- artifactID là tên package chính , cũng là tên thư mục dự án.

Câu 2 : Tại sao phải đảo ngược tên miền trong <groupId>vn.techmaster</groupId>?
Trả lời : theo quy tắc đặt tên package của Java để tránh trùng lặp , đảm bảo cho group id là duy nhất.

Câu 3 :SpringBoot có 2 cơ chế để quản lý thư viện. Hãy kể tên chúng?
Trả lời : Maven và Gradle

Câu 4: File pom.xml có tác dụng gì? Trả lời : File pom.xml là nơi khai báo tất cả những gì liên quan đến dự án được cấu
hình qua maven, như khai báo các dependency, version của dự án, tên dự án, repossitory …

Câu 5 :Trong file pom.xml có các thẻ dependency. Ý nghĩa của chúng là gì? Trả Lời :dùng để khai báo thư viện với các
thông tin bao gồm tên thư viện và version của thư viện

Câu 6 :Ý nghĩa của @Controllerlà gì?
Trả lời : gắn cho các Bean tiếp nhận các thông tin request từ phía người dùng và chuyển các yêu cầu này xuống cho tầng Service xử lý

Câu 7 :Ý nghĩa của @RequestMapping là gì? Nó có những tham số gì ngoài value? @RequestMapping Có nhiệm vụ ánh xạ các
request người dùng vào method tương ứng trong controller. @RequestMapping có những tham số value ,method( xử lý các HTTP
method), headers( chỉ xử lý những request có header chứa các tham số đã chỉ rõ là các cặp keyvalue),consumes( chỉ chấp
nhận các request có content-type giống với giá trị khai báo bên trong consumes),produces(kiểu dữ liệu trả về)

Câu 8 :Ý nghĩa của @RequestBody khi đặt trong hàm hứng request để làm gì? Trả lời : @RequestBody được sử dụng để lấy các
giá trị mà người dùng gửi lên server mà các giá trị đó được chứa trong phần thân (body) của request
Câu 9: Hãy trả lời khi nào thì dùng @PathVariable và khi nào nên dùng @RequestParam
Trả lời : @RequestParam được sử dụng để truy cập (lấy) giá trị của parameters trên URL(kiểu query string).
@PathVariable được sử dụng để lấy giá trị trên URI theo template (còn gọi là URI template).

Câu 10:Thứ tự các thành phần đường dẫn @PathVariable có thể hoán đổi được không?
Trả lời : không.

Câu 11 :@GetMapping khác gì so với @PostMapping?
Trả lời : @PostMapping có nhiệm vụ đánh dấu hàm xử lý POST request trong Controller,@GetMapping có nhiệm vụ đánh dấu hàm xử lý GET request trong controller
@PostMapping cần nhập phần body , @GetMapping không nhập được phần body

Câu 12 :Trong các annotation @RequestMapping, @GetMapping, @PostMapping… có tham số produces = MediaType.XXXX ý nghĩa
tham số này là gì? Trả lời : dùng để quy định dạng dữ liệu trả về cho người dùng khi request.

Câu 13: Giải thích ý nghĩa của @RequestBody trong đoạn code dưới đây @PostMapping(value = "/message", produces =
MediaType.APPLICATION_JSON_VALUE)
@ResponseBody public Message echoMessage(@RequestBody Message message){ return message; }
Trả lời : Spring chuyển chuỗi JSON trong requestbody thành obj Message

Câu 14 :Cổng mặc định ứng dụng SpringBoot là 8080. Hãy google cách để thay đổi cổng lắng nghe mặc định.
Trả lời : điều
chỉnh giá trị server.port trong application.properties(vd :server.port =8081) hay application.yml(vd:server: port : 8081)
