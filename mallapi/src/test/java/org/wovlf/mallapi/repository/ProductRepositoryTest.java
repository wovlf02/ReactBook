package org.wovlf.mallapi.repository;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.wovlf.mallapi.domain.Product;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Log4j2
public class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    public void testInsert() {
        for(int i = 0; i < 10; i++) {
            Product product = Product.builder()
                    .pname("상품"+i)
                    .price(100*i)
                    .pdesc("상품설명 " + i)
                    .build();

            // 2개의 이미지 파일 추가
            product.addImageString("IMAGE1.jpg");
            product.addImageString("IMAGE2.jpg");

            productRepository.save(product);
            log.info("---------------------------");
        }
    }

    @Test
    public void testDelete() {
        Long pno = 1L;
        productRepository.deleteById(pno);
    }

    @Test
    public void testRead2() {
        Long pno = 1L;
        Optional<Product> result = productRepository.selectOne(pno);
        Product product = result.orElseThrow();

        log.info(product);
        log.info(product.getImageList());
    }

    @Test
    public void testUpdate() {
        Long pno = 10L;
        Product product = productRepository.selectOne(pno).get();
        product.changeName("10번 상품");
        product.changeDesc("10번 상품 설명입니다.");
        product.changePrice(5000);

        product.clearList();
        product.addImageString(UUID.randomUUID().toString()+"_"+"NEWIMAGE1.jpg");
        product.addImageString(UUID.randomUUID().toString()+"_"+"NEWIMAGE2.jpg");
        product.addImageString(UUID.randomUUID().toString()+"_"+"NEWIMAGE3.jpg");
        productRepository.save(product);
    }

}