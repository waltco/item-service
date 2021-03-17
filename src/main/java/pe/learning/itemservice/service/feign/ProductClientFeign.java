package pe.learning.itemservice.service.feign;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.learning.itemservice.model.Item;
import pe.learning.itemservice.service.ProductClient;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductClientFeign implements ProductClient {

    final ProductFeign productFeign;

    @Override
    public List<Item> findAll() {
        log.info("findAll - Feign");
        return productFeign.findAll().stream().map(Item::new).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer quantity) {
        log.info("findById - Feign");
        return new Item(productFeign.findById(id),quantity);
    }
}
