package to.ogarne.ogarneblog.dao;

import java.io.Serializable;
import java.util.List;

// T - any type of object to persist
// PK - private key
public interface ExperimentDao<T, PK extends Serializable> {

    void setClazz(Class<T> clazz);
    List<T> findAll();
    T findById(PK id);
    void save(T object);
    void delete(T object);



}
