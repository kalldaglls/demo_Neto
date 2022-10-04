package com.geekbrains.service;

import com.geekbrains.entites.Product;
import com.geekbrains.entites.Student;
import com.geekbrains.repositories.ProductRep;
import com.geekbrains.repositories.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
        private ProductRep productRep;

        @Autowired
        public void setProductRep(ProductRep productRep) {
                this.productRep = productRep;
        }

        public Product getProductById(int id) {
                return productRep.findOneById(id);
        }

        public ProductRep getProductRep() {
                return productRep;
        }

        public ProductService() {

        }
}

