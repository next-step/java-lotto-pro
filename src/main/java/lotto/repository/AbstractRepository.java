package lotto.repository;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractRepository<E> {
    private final Map<String, E> idToElement = new ConcurrentHashMap<>();

    public E getById(final String id) {
        return idToElement.get(id);
    }

    public String save(final E element) {
        String id = UUID.randomUUID().toString();
        idToElement.put(id, element);
        return id;
    }

    public void deleteById(final String id) {
        idToElement.remove(id);
    }
}
