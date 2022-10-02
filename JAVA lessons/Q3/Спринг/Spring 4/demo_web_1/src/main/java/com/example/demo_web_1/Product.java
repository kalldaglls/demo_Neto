package com.example.demo_web_1;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("product")
@Scope("prototype")
public class Product {
    private String id;
    private String title;
    private int cost;

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", cost=" + cost +
                '}';
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
