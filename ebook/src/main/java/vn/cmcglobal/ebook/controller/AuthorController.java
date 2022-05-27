package vn.cmcglobal.ebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.cmcglobal.ebook.entity.Author;
import vn.cmcglobal.ebook.entity.Ebook;
import vn.cmcglobal.ebook.service.AuthorService;

import javax.validation.Valid;
import java.util.List;

/*/
5.	Thêm tác giả
Thêm tác giả mới vào hệ thống.

6.	Sửa thông tin tác giả
Chỉnh sửa thông tin của tác giả theo mã tác giả.
Nếu mã tác giả không tồn tại, hệ thống cần thông báo lỗi.

7.	Xóa tác giả
Xóa tác giả khỏi hệ thống theo mã tác giả
Nếu mã tác giả không tồn tại, hệ thống cần thông báo lỗi.
Nếu vẫn còn sách của tác giả đó trong hệ thống thì không cho phép xóa tác giả.

8.	Xem thông tin của tác giả
Trả về thông tin của tác giả theo mã tác giả.
Ngoài các thông tin cơ bản của tác giả, cần trả về thêm:
•	Số lượng đầu sách của tác giả đó trong hệ thống.
•	Danh sách 3 đầu sách bán chạy nhất của tác giả đó.
Nếu mã tác giả không tồn tại, hệ thống cần thông báo lỗi.

 */
@RestController
@RequestMapping("authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping
    public ResponseEntity<?> getListAuthor() {
        List<Author> result = authorService.getListAuthors();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping()
    public ResponseEntity<?> addAuthor(@Valid @RequestBody Author author) {
        Author result = authorService.addAuthor(author);
        return ResponseEntity.ok(result);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateEbook(@Valid @RequestBody Author author,@PathVariable Long id) {
        Author result =authorService.updateAuthor(author,id);
        return ResponseEntity.ok(result);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEbook(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.ok("Delete success");
    }

}
