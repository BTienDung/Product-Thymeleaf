package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {
    ProductServiceImpl productService = new ProductServiceImpl();
    @RequestMapping("/list-product")
    public ModelAndView showListProduct(){
        ModelAndView modelAndView = new ModelAndView("list");
        List<Product> productList = productService.findAll();
        modelAndView.addObject("products", productList);
        return modelAndView;
    }
    @GetMapping("/formCreate")
    public ModelAndView showFormCreate(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }
    @PostMapping("/create-product")
    public ModelAndView createProduct(@ModelAttribute Product product){
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("create");
        List<Product> productList = productService.findAll();
        modelAndView.addObject("products",productList);
        return modelAndView;
    }
    @PostMapping("/search")
    public ModelAndView searchProduct(@RequestParam("name") String name){
        ModelAndView modelAndView = new ModelAndView("list");
        List<Product> products = productService.findByName(name);
        modelAndView.addObject("products",products);
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("edit");
        Product productEdit = productService.findById(id);
        modelAndView.addObject("product", productEdit);
        return modelAndView;
    }

    @PostMapping("/edit/edit-product")
    public ModelAndView modelAndView(@ModelAttribute Product product){
        ModelAndView modelAndView = new ModelAndView("list");
        productService.edit(product);
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView showFormDelete(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("delete");
        Product product = productService.findById(id);
        modelAndView.addObject("product",product);
        return modelAndView;
    }
    @PostMapping("delete/delete-product")
    public ModelAndView deleteProduct(@ModelAttribute Product product){
        productService.delete(product);
        ModelAndView modelAndView = new ModelAndView("list");
        List<Product> productList = productService.findAll();
        modelAndView.addObject("products", productList);
        return modelAndView;
    }
    @GetMapping("/view/{id}")
    public ModelAndView viewProduct(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("view");
        Product product = productService.findById(id);
        modelAndView.addObject("product", product);
        return modelAndView;
    }
}
