package se.iths.grocerylistgenerator.mapper;

import org.springframework.stereotype.Service;
import se.iths.grocerylistgenerator.dto.CategoryDto;
import se.iths.grocerylistgenerator.model.Category;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryMapper {

    public CategoryMapper() {
    }

    public Category mapp(CategoryDto categoryDto) {
        return new Category(categoryDto.getName());
    }

    public CategoryDto mapp(Category category) {
        if(category == null)
            return new CategoryDto();
        return new CategoryDto(category.getId(), category.getName());
    }

    public List<CategoryDto> mapp(List<Category> categories) {
        return categories
                .stream()
                .map(this::mapp)
                .collect(Collectors.toList());
    }

    public Optional<CategoryDto> mapp(Optional<Category> optionalCategory) {
        if (optionalCategory.isEmpty())
            return Optional.empty();
        return Optional.of(mapp(optionalCategory.get()));
    }
}
