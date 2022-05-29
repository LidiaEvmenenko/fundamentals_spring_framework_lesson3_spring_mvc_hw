package ru.geekbrains.fundamentals_spring_framework_lesson3_spring_mvc_hw.controllers;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.fundamentals_spring_framework_lesson3_spring_mvc_hw.model.Product;
import ru.geekbrains.fundamentals_spring_framework_lesson3_spring_mvc_hw.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // POST http://localhost:8189/app/create
    @PostMapping("/create")
    public String saveNewProduct(@RequestParam String title, @RequestParam int cost){
        productService.saveNewProduct(new Product(0L, title, cost));
        return "redirect:/show_all";
    }
    // Get http://localhost:8189/app/create
    @GetMapping("/create")
    public String createNewProduct(){
        return "create_product";
    }
    // GET http://localhost:8189/app/show_all
    @GetMapping("/show_all")
    public String showProductsAll(Model model){
        model.addAttribute("products",productService.findProductsAll());
        return "products";
    }
    // GET http://localhost:8189/app/show/{id}
    @GetMapping("/show/{id}")
    public String showProductId(Model model, @PathVariable Long id){
        model.addAttribute("product", productService.findProductId(id));
        return "product";
    }
    @GetMapping("/inc/{id}")
    public String incCostOfProductByOne(@PathVariable Long id){
        productService.incCostOfProductByOne(id);
        return "redirect:/show_all";
    }
    @GetMapping("/dec/{id}")
    public String decCostOfProductByOne(@PathVariable Long id){
        productService.decCostOfProductByOne(id);
        return "redirect:/show_all";
    }
}
