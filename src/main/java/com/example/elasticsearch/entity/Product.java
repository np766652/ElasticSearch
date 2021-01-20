package com.example.elasticsearch.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "mysearch")
public class Product {
    @Id
    String id;
    String company;
    String product;
    String typeName;
    String imageUrl;
    double inches;
    String screenResolution;
    String ram;
    String memory;
    String gpu;
    String opSys;
    String weight;
    double merchantProductRating;
    String merchantId;
    double price;
    int quantity;

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", company='" + company + '\'' +
                ", product='" + product + '\'' +
                ", typeName='" + typeName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", inches=" + inches +
                ", screenResolution='" + screenResolution + '\'' +
                ", ram='" + ram + '\'' +
                ", memory='" + memory + '\'' +
                ", gpu='" + gpu + '\'' +
                ", opSys='" + opSys + '\'' +
                ", weight='" + weight + '\'' +
                ", merchantProductRating=" + merchantProductRating +
                ", merchantId='" + merchantId + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getInches() {
        return inches;
    }

    public void setInches(double inches) {
        this.inches = inches;
    }

    public String getScreenResolution() {
        return screenResolution;
    }

    public void setScreenResolution(String screenResolution) {
        this.screenResolution = screenResolution;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getOpSys() {
        return opSys;
    }

    public void setOpSys(String opSys) {
        this.opSys = opSys;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public double getMerchantProductRating() {
        return merchantProductRating;
    }

    public void setMerchantProductRating(double merchantProductRating) {
        this.merchantProductRating = merchantProductRating;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

