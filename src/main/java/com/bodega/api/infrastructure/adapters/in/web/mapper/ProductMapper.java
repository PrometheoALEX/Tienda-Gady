package com.bodega.api.infrastructure.adapters.in.web.mapper;

import com.bodega.api.domain.model.Product;
import com.bodega.api.infrastructure.adapters.in.web.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "categoryId", source = "category.id")
    ProductDTO toDto(Product product);

    @Mapping(target = "category.id", source = "categoryId")
    Product toDomain(ProductDTO productDTO);

    List<ProductDTO> toDtoList(List<Product> products);
}