package com.example.demo_web_1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello Wolk!";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //logger.info("Log: GET");
        System.out.println("Redirect");
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Product product = context.getBean("product", Product.class);
            product.setId(i + "A");
            product.setTitle(i + " product");
            product.setCost(new Random().nextInt(200));
            productList.add(product);//Так нормально создавать продукты или лучше как-то по-другому?
        }
        resp.getWriter().printf("<html><body><h1>" + productList + "</h1></body></html>");
    }

    public void destroy() {
    }
}