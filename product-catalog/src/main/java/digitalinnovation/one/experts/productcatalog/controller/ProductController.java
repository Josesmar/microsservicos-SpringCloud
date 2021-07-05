package digitalinnovation.one.experts.productcatalog.controller;

import digitalinnovation.one.experts.productcatalog.model.Product;
import digitalinnovation.one.experts.productcatalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    private ProductRepository productRepositoryPro;

    @Autowired
    public ProductController(ProductRepository productRepositoryPro) {
        this.productRepositoryPro = productRepositoryPro;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Product create(@RequestBody Product product) {
        return productRepositoryPro.save(product);
    }

    @RequestMapping
    public Iterable<Product> list() {
        return productRepositoryPro.findAll();
    }

    @RequestMapping(value = "/{id}")
    public Optional<Product> findById(@PathVariable("id") Integer id) {
        return productRepositoryPro.findById(id);
    }

    @RequestMapping(value = "/name/{name}")
    public Iterable<Product> findByName(@PathVariable("name") String name) {
        return productRepositoryPro.findByName(name);
    }

}
