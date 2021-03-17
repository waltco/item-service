package pe.learning.itemservice.service;

import pe.learning.itemservice.model.Item;

import java.util.List;

public interface ProductClient {

    List<Item> findAll();
    Item findById(Long id, Integer quantity);

}
