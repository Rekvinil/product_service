package storeLab.product_service.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private float price;
    private String discount;
    private String img;

    @OneToMany(mappedBy = "product", fetch=FetchType.EAGER)
    private List<ProductCharacteristic> productCharacteristics;


    public Product() {
    }

    public Product(String name, float price, String discount, String img) {
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

}
