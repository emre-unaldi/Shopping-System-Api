package patika.shoppingsystemapi.repository.concretes;

import org.springframework.stereotype.Repository;
import patika.shoppingsystemapi.repository.abstracts.GenericRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GenericRepositoryImpl<T> implements GenericRepository<T> {
    private final List<T> entities = new ArrayList<T>();

    @Override
    public void save(T entity) {
        entities.add(entity);
    }

    @Override
    public List<T> findAll() {
        return entities;
    }
}
