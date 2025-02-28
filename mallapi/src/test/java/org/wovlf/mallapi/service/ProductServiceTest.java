package org.wovlf.mallapi.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.wovlf.mallapi.dto.PageRequestDTO;
import org.wovlf.mallapi.dto.PageResponseDTO;
import org.wovlf.mallapi.dto.ProductDTO;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Log4j2
public class ProductServiceTest {
    @Autowired
    ProductService productService;
    @Test
    public void testList() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().build();
        PageResponseDTO<ProductDTO> result = productService.getList(pageRequestDTO);
        result.getDtoList().forEach(dto -> log.info(dto));
    }
}