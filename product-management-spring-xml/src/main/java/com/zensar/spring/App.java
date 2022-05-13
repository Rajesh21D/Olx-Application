package com.zensar.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zensar.spring.beans.Product;
import com.zensar.spring.service.ProductService;


public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("context.xml");
        
        ProductService service=context.getBean("service",ProductService.class);
        
      //  Product product=new Product(2,"Laptop",150000);
       // service.insertProduct(product);
        
       // System.out.println("Product inserted successfullyyyyy !!!");
        //	delete
        //service.deleteProduct(2);
        //	System.out.println("Product deleted successfullyyyyy !!!");
        
        //	update
        	service.updateProduct(new Product(1,"BMW", 2440000));
        	System.out.println("Product updated successfullyyyyy !!!");
        
    }
}
