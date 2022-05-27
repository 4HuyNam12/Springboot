package vn.cmcglobal.ebook.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.cmcglobal.ebook.entity.Author;
import vn.cmcglobal.ebook.entity.Ebook;
import vn.cmcglobal.ebook.exception.NotFoundException;
import vn.cmcglobal.ebook.model.dto.AuthorInformation;
import vn.cmcglobal.ebook.model.mapper.AuthorMapper;
import vn.cmcglobal.ebook.repository.AuthorRepository;
import vn.cmcglobal.ebook.repository.EbookRepository;
import vn.cmcglobal.ebook.service.AuthorService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private EbookRepository ebookRepository;
    @Override
    public Author addAuthor(Author author) {
        authorRepository.save(author);
        return author;
    }

    @Override
    public void deleteAuthor(Long id) {
        Optional<Author> result = authorRepository.findById(id);
        if (result.isPresent()) {
            List<Ebook> books = ebookRepository.findByAuthorId(id);
            if (books.isEmpty()) {
                authorRepository.delete(result.get());
            }
        }
        throw new NotFoundException("Author with: " + id + " Not Found");


    }

    @Override
    public List<Author> getListAuthors() {
        return null;
    }


    @Override
    public Author updateAuthor(Author author, Long id) {
        Optional<Author> result = authorRepository.findById(id);
        if (result.isPresent()) {
            Author existingAuthor = result.get();
            existingAuthor.setFirstName(author.getFirstName());
            existingAuthor.setLastName(author.getLastName());
            existingAuthor.setYearOfBirth(author.getYearOfBirth());
            existingAuthor.setDescription(author.getDescription());
            existingAuthor.setWebsite(author.getWebsite());
            existingAuthor.setOrganization(author.getOrganization());
            authorRepository.save(existingAuthor);
            return  existingAuthor;
        }
        throw new NotFoundException("Author with: " + id + " Not Found");
    }

    @Override
    public AuthorInformation getAuthorInformation(Long id) {
        Optional<Author> result = authorRepository.findById(id);
        if (result.isPresent()) {
            Author existingAuthor = result.get();
                Long bookOwer = ebookRepository.countByAuthorId(id);
                List<String> listResult = new ArrayList<>();
                List<Ebook> ebookByAuthor = ebookRepository.findTop3ByAuthorId(id);
                if (!ebookByAuthor.isEmpty()) {
                    for (Ebook ebook:ebookByAuthor) {
                        listResult.add(ebook.getTitle());
                    }
                }
                AuthorInformation authorInformation = new AuthorInformation();
                authorInformation.setBookOwner(bookOwer);
                authorInformation.setTopThreeBooks(listResult);
                AuthorMapper authorMapper = new AuthorMapper();
                authorMapper.authorToAuthorInformation(existingAuthor);
                return authorInformation;
            }
        throw  new NotFoundException("Author with: " + id + " Not Found");
        }

    }

