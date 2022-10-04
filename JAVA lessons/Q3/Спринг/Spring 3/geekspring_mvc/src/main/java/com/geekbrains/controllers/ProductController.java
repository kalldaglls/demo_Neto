package com.geekbrains.controllers;


import com.geekbrains.entites.Product;
import com.geekbrains.entites.Student;
import com.geekbrains.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private ProductService productService;


    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/showProduct")
    public String hello(Model uiModel) {
        List<Product> list = productService.getProductRep().showAllProducts();
        System.out.println(list);
        uiModel.addAttribute("product", list);
        return "product";
    }

    @RequestMapping("/showForm")
    public String showSimpleForm(Model uiModel) {
        Product product = new Product();
        uiModel.addAttribute("product", product);
        return "product-form";
    }


    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("product") Product product) {
        productService.getProductRep().addProduct(product);
        System.out.println(productService.getProductRep().showAllProducts());
        return "product-form-result";
    }

    @RequestMapping(path = "/showProductById", method = RequestMethod.GET)
    @ResponseBody
    public Product showStudentById(Model uiModel, @RequestParam int id) {
        Product product = productService.getProductById(id);
        return product;
    }
}

