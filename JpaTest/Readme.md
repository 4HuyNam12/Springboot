Câu 1. Thuộc tính name trong annotation @Entity khác với thuộc tính name trong @Table như thế
nào? Hãy giải thích rõ cần thì minh hoạ:
    Trả lời : name trong @Entity dùng trong JPQL , name trong @Table dùng đặt tên bảng và trong native query
 
Câu 2 .Để debug câu lệnh SQL mà Hibernate sẽ sinh ra trong quá trình thực thi, cần phải bổ sung
      lệnh nào vào file application.properties?
    Trả lời :spring.jpa.show-sql=true

Câu 3:Khi sử dụng H2, làm thế nào để xem được cơ sở dữ liệu và viết câu truy vấn?
    Trả lời : spring.h2.console.enabled=true, localhost:8080/h2-console

Câu 4. Khi viết mô tả một model, những thuộc tính chúng ta không muốn lưu xuống CSDL thì cần
   đánh dấu bằng annotation nào?
    Trả lời :@Formula , @Transient

Câu 5.Annotation @Column dùng để bổ sung tính chất cho cột ứng với một thuộc tính. Tham số
nào trong @Column sẽ đổi lại tên cột nếu muốn khác với tên thuộc tính, tham số nào chỉ định
yêu cầu duy nhất, không được trùng lặp dữ liệu, tham số nào buộc trường không được null?
    Trả lời : các tham số lần lượt là name , unique,nullable

Câu 6:Có 2 sự kiện mà JPA có thể bắt được, viết logic bổ sung
 --Ngay trước khi đối tượng Entity lưu xuống CSDL (ngay trước lệnh INSERT)
 --Ngay trước khi đối tượng Entity cập nhật xuống CSDL (ngay trước lệnh UPDATE)
    Vậy 2 annotation này là gì : 
Trả lời : --Trước khi đối tượng Entity lưu xuống csdl : @PrePersist
            --trước khi đối tượng Entity cập nhật xuống CSDL:@PreUpdate

Câu 7. Tổ hợp các trường thông tin địa chỉ: country, city, county, addressline thường luôn đi cùng
   nhau và sử dụng lại trong các Entity khác nhau. Nhóm 2 annotation nào dùng để tái sử dụng,
   nhúng một Entity vào một Entity khác?
   Trả lời : @Embeddable  và @Embedded
Câu 8. JpaRepository là một interface có sẵn trong thư viện JPA, nó cũng cấp các mẫu hàm thuận
   tiện cho thao tác dữ liệu. Cụ thể JpaRepository kế thừa từ interface nào?
    Trả lời : Repository,PagingAndSortingRepository,CrudRepository,

Câu 9. Hãy viết khai báo một interface repository thao tác với một Entity tên là Post, kiểu dữ liệu
   trường Identity là long, tuân thủ interface JpaRepository. 

    public interface PostRepository extends JpaRepository<Post,Long>{}

Câu 10 .Khi đã chọn một cột là Identity dùng @Id để đánh dấu, thì có cần phải dùng xác định unique
dùng annotation @Column(unique=true) không?
    Trả lời : Không 

Câu 11 Khác biệt giữa @Id với @NaturalId là gì?
    Trả lời : @Id xác định trường nào là primary key.
            @NaturalID tạo unique constrain lên một trường không phải PrimaryKey
        @Id, primary cần giữ nguyên không đổi, nhưng @NaturalId có thể được phép thay đổi, miễn
        đảm bảo duy nhất

Câu 12 : 12. Có những cột không phải primary key (@Id) hay @NaturalId, dữ liệu có thể trùng lặp
(unique không đảm bảo true), nhưng cần đánh chỉ mục (index) để tìm kiếm nhanh hơn vậy
phải dùng annotation gì? Hãy viết 1 ví dụ sử dụng annotation đó với index cho 1 column và 1
ví dụ với index cho tổ hợp nhiều column. Tham khảo tại (https://www.baeldung.com/jpaindexes)
@Entity
@Table(indexes = @Index(columnList = "firstName"))
public class Student implements Serializable {
@Id
@GeneratedValue
private Long id;
private String firstName;
private String lastName;

Câu 13 : Annotation @GeneratedValue dùng để chọn cách tự sinh unique id cho primary key phải là
trường kiểu int hoặc long. Nếu trường primary key có kiểu là String, chúng ta không thể
dùng @GeneratedValue vậy hãy thử liệt kê các cách đảm bảo sinh ra chuỗi có tính duy nhất?
Trả lời : Custom ID generator , tạo 1 class RandomID có method generate thực hiện trả về random string
@GenericGenerator(name = "random_id", strategy = RandomID)
@Id @GeneratedValue(generator="random_id")

Câu 14 : . Giả sử có 1 class Employee với các fields sau {id, emailAddress, firstName, lastName}. Hãy
viết các method trong interface EmployeeRespository để :
 Tìm tất cả các Employee theo emailAddress và lastName
    List<Employee>  findByEmailAddressAndLastname(String emailAddress, String lastName);
 Tìm tất cả các Employee khác nhau theo firstName hoặc lastName
    List<Employee> findDistinctByLastnameOrFirstname(String lastname, String firstname);
 Tìm tất cả các Employee theo lastName và sắp xếp thứ tự theo firstName tăng dần
    List<Employee> findByLastnameOrderByFirstnameAsc(String lastname);
 Tìm tất cả các Employee theo fistName không phân biệt hoa thường
    List<Employee> findByFirstnameAllIgnoreCase(String lastname, String firstname);

Câu 15 :Hãy nêu cách sử dụng của @NamedQuery và @Query. Cho ví dụ:
    @Query("select e from Employee e where e.emailAddress = ?1")
    Employee myCustomQuery(String emailAddress);

    @NamedQuery
    (name = "Employee.FIND_BY_NAME", query = "SELECT e FROM e WHERE c.emailAddress like =?1")
Câu 16 :Làm thế nào để có thể viết custom method implemetations cho Jpa Repository .
        Trả lời : package cau16

Câu 17 : Hãy nêu 1 ví dụ sử dụng sorting và paging khi query đối tượng Employee ở trên
Page<Employee> page = employeeRepository.findAll(PageRequest.of(1, 5));
page.nextPageable() = PageRequest.of(2, 5);
page.previousPageable() = PageRequest.of(0,5);
Sort :
employeeRepository.findAll(Sort.by("lastName").descending());

Câu 18 : Có 3 Entity Product.java và Category.java và Tag.java 
Trả lời : entity

Câu 19 : 19. Có 2 Entity Student.java và Course.java
Trả lời : entity









   

