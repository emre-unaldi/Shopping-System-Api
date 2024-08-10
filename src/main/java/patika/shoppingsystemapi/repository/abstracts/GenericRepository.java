package patika.shoppingsystemapi.repository.abstracts;

import java.util.List;

public interface GenericRepository<T> {
    void save(T entity);
    List<T> findAll();
}
