package com.bodega.api.infrastructure.adapters.in.web.mapper;

import com.bodega.api.domain.model.Category;
import com.bodega.api.domain.model.Product;
import com.bodega.api.infrastructure.adapters.in.web.dto.ProductDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-10-28T18:48:54-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.10 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDTO toDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDTO.ProductDTOBuilder productDTO = ProductDTO.builder();

        productDTO.categoryId( productCategoryId( product ) );
        productDTO.id( product.getId() );
        productDTO.name( product.getName() );
        productDTO.description( product.getDescription() );
        productDTO.price( product.getPrice() );
        productDTO.stock( product.getStock() );
        productDTO.image( product.getImage() );
        productDTO.discount( product.getDiscount() );
        productDTO.active( product.getActive() );

        return productDTO.build();
    }

    @Override
    public Product toDomain(ProductDTO productDTO) {
        if ( productDTO == null ) {
            return null;
        }

        Product product = new Product();

        product.setCategory( productDTOToCategory( productDTO ) );
        product.setId( productDTO.getId() );
        product.setName( productDTO.getName() );
        product.setDescription( productDTO.getDescription() );
        product.setPrice( productDTO.getPrice() );
        product.setStock( productDTO.getStock() );
        product.setImage( productDTO.getImage() );
        product.setDiscount( productDTO.getDiscount() );
        product.setActive( productDTO.getActive() );

        return product;
    }

    @Override
    public List<ProductDTO> toDtoList(List<Product> products) {
        if ( products == null ) {
            return null;
        }

        List<ProductDTO> list = new ArrayList<ProductDTO>( products.size() );
        for ( Product product : products ) {
            list.add( toDto( product ) );
        }

        return list;
    }

    private Long productCategoryId(Product product) {
        if ( product == null ) {
            return null;
        }
        Category category = product.getCategory();
        if ( category == null ) {
            return null;
        }
        Long id = category.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Category productDTOToCategory(ProductDTO productDTO) {
        if ( productDTO == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( productDTO.getCategoryId() );

        return category;
    }
}
