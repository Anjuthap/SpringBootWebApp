package com.example.SimpleWebApp.model; // representDatabase
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "products")
@Component
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //primary key generation strategy

    private int prodId;
@Column(name = "prod_name")
    private String prodName;
@Column(name = "price_rs")
    private int priceRs;
    @Column(name = "description")
    private String description;
    private String category;
    private int quantity;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getProdId() {
        return prodId;
    }
    public void setProdId(int Id) {
        this.prodId = Id;
    }

    public String getProdName() {
        return prodName;
    }
    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public int getPriceRs() {
        return priceRs;
    }
    public void setPriceRs(int priceRs) {
        this.priceRs = priceRs;
    }
    public Product() {
    }

    public Product( int prodId,String prodName,int priceRs,String description, String category,int quantity ) {
        this.prodId = prodId;
        this.prodName = prodName;
        this.priceRs = priceRs;
        this.description=description;
        this.category=category;
        this.quantity=quantity;

    }
    @Override
    public String toString() {
        return "Product{" +
                "prodId=" + prodId +
                ", prodName='" + prodName + '\'' +
                ", priceRs=" + priceRs +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", quantity='" + quantity + '\'' +
                '}';
    }
}
