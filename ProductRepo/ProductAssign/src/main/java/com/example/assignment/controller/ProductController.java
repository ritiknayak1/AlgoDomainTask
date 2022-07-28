package com.example.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.assignment.model.Product;
import com.example.assignment.service.ProductService;
import com.example.assignment.vo.ProductPriceRangeVo;
import com.example.assignment.vo.ProductVo;



@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/save")
	public String addProduct(@RequestBody ProductVo productVo) {
		productService.addProduct(productVo);
		return "Data added Successfully";
	}
	@GetMapping("/view")
	public List<ProductVo> getProduct(){
		return productService.getAllProduct();
	}
	@DeleteMapping("/delete")
	public String deleteProduct(@RequestBody ProductVo productvo ) {
		productService.deleteProduct(productvo);
		return "Data is deleted";
	}
	
	@PostMapping("/update")
	public String updateProduct(@RequestBody ProductVo pr) {
		 productService.updateProduct(pr);
		 return "Updted";
	}
	@GetMapping("/cPName/{productName}")
	public List<ProductVo> getSearchByProductName(@PathVariable String productName){
		return productService.getSearchByProductName(productName);
	}
	
	@GetMapping("/cpc/{productCategory}")
	public List<ProductVo> getSearchByProductCategory(@PathVariable String productCategory){
		return productService.getSearchByProductCategory(productCategory);
	}
	@GetMapping("/cpt/{productType}")
	public List<ProductVo> getSearchByProductType(@PathVariable String productType){
		return productService.getSearchByProductType(productType);
	}
	@GetMapping("/priceRange/{max}/{min}")
	public List<ProductVo> getSearchByProductPriceRange(@PathVariable int max,int min){
		return productService.getSearchByProductPriceRange(max,min);
	}
	
}
