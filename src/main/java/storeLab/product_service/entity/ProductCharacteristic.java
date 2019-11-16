package storeLab.product_service.entity;

import javax.persistence.*;

@Entity
public class ProductCharacteristic {

    @Id
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="characteristics_id")
    private Characteristic characteristics;

    private String value;

    public ProductCharacteristic(Product product, Characteristic characteristics, String value) {
        this.product = product;
        this.characteristics = characteristics;
        this.value = value;
    }

    public ProductCharacteristic() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Characteristic getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(Characteristic characteristics) {
        this.characteristics = characteristics;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
