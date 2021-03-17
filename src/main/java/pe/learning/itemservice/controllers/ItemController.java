package pe.learning.itemservice.controllers;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.learning.itemservice.model.Item;
import pe.learning.itemservice.service.ProductClient;

import java.util.List;

@RestController
public class ItemController {

    @Qualifier("productClientFeign")
    @Autowired
    ProductClient productClient;

    @GetMapping("/items")
    public List<Item> findAll(){
        return productClient.findAll();
    }


    @GetMapping("/item")
    public Item findItemById(@RequestParam(name="id") Long id,
                             @RequestParam(name="quantity") Integer quantity){
        return productClient.findById(id, quantity);
    }
}
