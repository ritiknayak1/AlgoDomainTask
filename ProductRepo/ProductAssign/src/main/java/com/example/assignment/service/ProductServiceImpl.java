package com.example.assignment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.assignment.dao.ProductRepository;
import com.example.assignment.model.Product;
import com.example.assignment.vo.ProductPriceRangeVo;
import com.example.assignment.vo.ProductVo;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepo;
	
	@Override
	public String addProduct(ProductVo pVo) {
	  Product pr=new Product();
		pr.setId(pVo.getId());
	  pr.setProductName(pVo.getProductName());
	  pr.setProductType(pVo.getProductType());
	  pr.setProductCategory(pVo.getProductCategory());
	  pr.setPrice(pVo.getPrice());
	  productRepo.save(pr);
		return "Data Added";
	}

	@Override
	public List<ProductVo> getAllProduct() {
		List<Product> pr=productRepo.findAll();
		List<ProductVo> pvo=new ArrayList<ProductVo>();
		for(Product p:pr) {
			ProductVo prv=new ProductVo();
			prv.setId(p.getId());
			prv.setProductName(p.getProductName());
			  prv.setProductType(p.getProductType());
			  prv.setProductCategory(p.getProductCategory());
			 prv.setPrice(p.getPrice());
			pvo.add(prv);
		}
		return pvo;
	}

	@Override
	public void deleteProduct(ProductVo pvo) {
		Product pr=productRepo.getById(pvo.getId());
		pr.setId(pvo.getId());
		
		pr.setProductCategory(pvo.getProductCategory());
		pr.setProductName(pvo.getProductName());
		pr.setProductType(pvo.getProductType());
		pr.setPrice(pvo.getPrice());
		productRepo.delete(pr);
		
	}

	@Override
	public String updateProduct(ProductVo pro) {
		Product pr=productRepo.getById(pro.getId());
		pr.setId(pro.getId());
		
		pr.setProductCategory(pro.getProductCategory());
		pr.setProductName(pro.getProductName());
		pr.setProductType(pro.getProductType());
		pr.setPrice(pro.getPrice());
		productRepo.save(pr);
		return "Data Updated";
	}

	@Override
	public List<ProductVo> getSearchByProductName(String productName) {
		List<Product> pr1=productRepo.findAll();
		List<ProductVo> npr=new ArrayList<>();
		for(Product pro:pr1) {
			if(pro.getProductName().equalsIgnoreCase(productName)) {
				ProductVo pr=new ProductVo();
				pr.setId(pro.getId());
			pr.setProductCategory(pro.getProductCategory());
			pr.setProductName(pro.getProductName());
			pr.setProductType(pro.getProductType());
			pr.setPrice(pro.getPrice());
			npr.add(pr);
			}
		}
	
		return npr;
	}

	@Override
	public List<ProductVo> getSearchByProductCategory(String productCategory) {
		List<Product> pr1=productRepo.getByProductCategory(productCategory);
		List<ProductVo> npr=new ArrayList<>();
		for(Product pro:pr1) {
			
				ProductVo pr=new ProductVo();
				pr.setId(pro.getId());
			pr.setProductCategory(pro.getProductCategory());
			pr.setProductName(pro.getProductName());
			pr.setProductType(pro.getProductType());
			pr.setPrice(pro.getPrice());
			npr.add(pr);
			
		}
	
		return npr;
	}

	@Override
	public List<ProductVo> getSearchByProductType(String productType) {
		List<Product> pr1=productRepo.getByProductType(productType);
		List<ProductVo> npr=new ArrayList<>();
		for(Product pro:pr1) {  
			
				ProductVo pr=new ProductVo();
				pr.setId(pro.getId());
			pr.setProductCategory(pro.getProductCategory());
			pr.setProductName(pro.getProductName());
			pr.setProductType(pro.getProductType());
			pr.setPrice(pro.getPrice());
			npr.add(pr);
			
		}
	
		return npr;
	}

	@Override
	public List<ProductVo> getSearchByProductPriceRange(int max,int min) {
		List<Product> pr1=productRepo.findAll();
		List<ProductVo> npr=new ArrayList<>();
		for(Product pro:pr1) {  
			int pri=pro.getPrice();
			
			if(max>pri && min<pri) {
				ProductVo pr=new ProductVo();
				pr.setId(pro.getId());
			pr.setProductCategory(pro.getProductCategory());
			pr.setProductName(pro.getProductName());
			pr.setProductType(pro.getProductType());
			pr.setPrice(pro.getPrice());
			npr.add(pr);
			}
		}
	
		return npr;
	}

	
}
