package com.ty.foodOrder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ty.foodOrder.dto.Products;
import com.ty.foodOrder.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService ;
	
	@RequestMapping("/loadproduct")
	public ModelAndView loadProduct() {
		ModelAndView modelAndView = new ModelAndView("loadproduct.jsp");
		modelAndView.addObject("product" , new Products()) ;
		return modelAndView ;
	}
	
	@RequestMapping("/saveproduct")
	public ModelAndView saveProduct(@ModelAttribute Products products) {
		boolean res = productService.saveProduct(products) ;
		ModelAndView modelAndView = new ModelAndView("adminmenu.jsp");
		if(res) {
			
			modelAndView.addObject("msg" , "product added successfully") ;
			return modelAndView ;
		}else {
			modelAndView.addObject("msg" , "product not added ") ;
			return modelAndView ;
		}
	}
	
	@RequestMapping("/displayproducts")
	public ModelAndView allProducts() {
		List<Products> products = productService.getAllProducts() ;
		ModelAndView modelAndView = new ModelAndView("displayproducts.jsp");
		modelAndView.addObject("products" , products) ;
		return modelAndView ;
	}
	
	@RequestMapping("/editproduct")
	public ModelAndView editProducts(@RequestParam(name = "id") int id) {
		Products product = productService.getProductById(id) ;
		ModelAndView modelAndView = new ModelAndView("editproduct.jsp");
		modelAndView.addObject("product" , product) ;
		return modelAndView ;
	}
	@RequestMapping("/updateproduct")
	public ModelAndView updateProduct(@ModelAttribute Products product) {
		productService.updateProduct(product.getId(), product) ;
		ModelAndView modelAndView = new ModelAndView("displayproducts");
		modelAndView.addObject("msg" , "product updated successfully") ;
		return modelAndView ;
	}
	
	@RequestMapping("/deleteproduct")
	public ModelAndView deleteProduct(@RequestParam(name = "id") int id) {
		productService.deletProduct(id) ;
		ModelAndView modelAndView = new ModelAndView("displayproducts");
		modelAndView.addObject("msg" , "product deleted successfully") ;
		return modelAndView ;
	}
}
