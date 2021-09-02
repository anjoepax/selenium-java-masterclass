package org.selenium.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.selenium.util.JacksonUtils;
import java.io.IOException;

@NoArgsConstructor
@Getter
@Setter
public final class Product {

    private int id;
    private String name;

    public Product(int id) {
        Product[] products =
                JacksonUtils.deserializeJson("products.json", Product[].class);
        for(Product product : products) {
            if(product.getId() == id) {
                this.id = id;
                this.name = product.getName();
            }
        }
    }
}

