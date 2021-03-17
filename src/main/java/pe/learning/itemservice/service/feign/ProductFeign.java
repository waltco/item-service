package pe.learning.itemservice.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pe.learning.itemservice.model.Product;

import java.util.List;

@FeignClient(name="product-service", url = "localhost:8001")
public interface ProductFeign {

    @GetMapping("/products")
    List<Product> findAll();

    @GetMapping("/product/{id}")
    Product findById(@PathVariable Long id);

}
