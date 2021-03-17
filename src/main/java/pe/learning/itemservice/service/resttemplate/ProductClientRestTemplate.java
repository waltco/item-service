package pe.learning.itemservice.service.resttemplate;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pe.learning.itemservice.model.Item;
import pe.learning.itemservice.model.Product;
import pe.learning.itemservice.service.ProductClient;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductClientRestTemplate implements ProductClient {

    final RestTemplate restTemplate;

    @Override
    public List<Item> findAll() {
        log.info("findAll - RestTemplate");
        List<Product> products = getProductListRTExchange();
        return products.stream().map(Item::new).collect(Collectors.toList());
    }

    private List<Product> getProductListRTExchange() {
        return restTemplate.exchange("http://localhost:8001/products/",
                                     HttpMethod.GET,
                                     null,
                                     new ParameterizedTypeReference<List<Product>>() {
                                     })
                           .getBody();
    }

    @Override
    public Item findById(Long id, Integer quantity) {
        log.info("findById - RestTemplate");
        Map<String, String> pathVariables = new HashMap<>();
        pathVariables.put("id", id.toString());
        Product product = restTemplate.getForObject("http://localhost:8001/product/{id}", Product.class, pathVariables);
        return new Item(product, quantity);
    }

    public List<Product> getProductListRTGetForEntity() {
        Product[] body = restTemplate.getForEntity("http://localhost:8001/products/", Product[].class).getBody();
        return Arrays.asList(Objects.requireNonNull(body));
    }
}
