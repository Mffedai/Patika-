package dev.patika.ecommerce.business.abstracts;

import dev.patika.ecommerce.entity.Category;
import org.springframework.data.domain.Page;

import java.beans.Customizer;

public interface ICategoryService {
    Category save(Category category);
    Category get(int id);
    Page<Category> cursor(int page, int pageSize);

    Category update(Category category);

    boolean delete(int id);

}
