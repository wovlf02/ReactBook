package org.wovlf.mallapi.service;

import org.springframework.transaction.annotation.Transactional;
import org.wovlf.mallapi.dto.PageRequestDTO;
import org.wovlf.mallapi.dto.PageResponseDTO;
import org.wovlf.mallapi.dto.ProductDTO;

@Transactional
public interface ProductService {

    PageResponseDTO<ProductDTO> getList(PageRequestDTO pageRequestDTO);

    Long register(ProductDTO productDTO);

    ProductDTO get(Long pno);

    void modify(ProductDTO productDTO);

    void remove(Long pno);

}
