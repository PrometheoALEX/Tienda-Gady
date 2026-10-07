package com.bodega.api.infrastructure.adapters.in.web.mapper;

import com.bodega.api.domain.model.Category;
import com.bodega.api.infrastructure.adapters.in.web.dto.CategoryDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDTO toDto(Category domain);

    Category toDomain(CategoryDTO dto); // Or rename to toDomain if you prefer

    List<CategoryDTO> toDtoList(List<Category> domainList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(CategoryDTO dto, @MappingTarget Category domain);
}