package com.bodega.api.infrastructure.adapters.in.web.mapper;

import com.bodega.api.domain.model.Category;
import com.bodega.api.infrastructure.adapters.in.web.dto.CategoryDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-10-07T12:09:02-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.12.1 (Ubuntu)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryDTO toDto(Category domain) {
        if ( domain == null ) {
            return null;
        }

        CategoryDTO.CategoryDTOBuilder categoryDTO = CategoryDTO.builder();

        categoryDTO.id( domain.getId() );
        categoryDTO.name( domain.getName() );
        categoryDTO.active( domain.getActive() );

        return categoryDTO.build();
    }

    @Override
    public Category toDomain(CategoryDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( dto.getId() );
        category.setName( dto.getName() );
        category.setActive( dto.getActive() );

        return category;
    }

    @Override
    public List<CategoryDTO> toDtoList(List<Category> domainList) {
        if ( domainList == null ) {
            return null;
        }

        List<CategoryDTO> list = new ArrayList<CategoryDTO>( domainList.size() );
        for ( Category category : domainList ) {
            list.add( toDto( category ) );
        }

        return list;
    }

    @Override
    public void updateEntityFromDto(CategoryDTO dto, Category domain) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            domain.setId( dto.getId() );
        }
        if ( dto.getName() != null ) {
            domain.setName( dto.getName() );
        }
        if ( dto.getActive() != null ) {
            domain.setActive( dto.getActive() );
        }
    }
}
