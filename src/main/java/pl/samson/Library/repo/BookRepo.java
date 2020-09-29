package pl.samson.Library.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.samson.Library.repo.entity.Book;

@Repository
public interface BookRepo extends CrudRepository<Book, Integer> {
}
