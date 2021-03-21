package pe.learning.itemservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private Product product;
    private Integer quantity;

//    public Double getTotal() {
//        return product.getPrice() * quantity.doubleValue();
//    }

    public Item(Product product) {
        this.product = product;
        this.quantity = 1;
    }
}
