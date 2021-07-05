package j6l12hw.service;

import j6l12hw.dto.ProductDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> findAll();

    ProductDto findById(int id);

    ProductDto save(ProductDto productDto);

    void delete(int id);
}
