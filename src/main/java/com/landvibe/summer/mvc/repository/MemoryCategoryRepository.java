package com.landvibe.summer.mvc.repository;

import com.landvibe.summer.mvc.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryCategoryRepository implements CategoryRepository {
    private static final Map<Long, Category> categoryDb = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public void save(Category category) {
        category.setId(++sequence);
        category.setCount(0);
        categoryDb.put(category.getId(), category);
    }

    @Override
    public Optional<Category> findById(Long id) {
        return Optional.ofNullable(categoryDb.get(id));
    }

    @Override
    public Optional<Category> findByName(String name) {
        return categoryDb.values().stream()
                .filter(category -> category.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Category> findAll() {
        return new ArrayList<>(categoryDb.values());
    }
}