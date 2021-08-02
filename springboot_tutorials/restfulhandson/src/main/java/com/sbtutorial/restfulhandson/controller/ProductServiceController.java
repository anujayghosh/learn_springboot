package com.sbtutorial.restfulhandson.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sbtutorial.restfulhandson.model.Product;
import com.sbtutorial.restfulhandson.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@Api(value="productstore", description="Operations pertaining to products in store")
public class ProductServiceController {
   @Autowired
   ProductService productService;
   
   @ApiOperation(value = "Read a list of available products", response = Iterable.class)
   @ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully retrieved list"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
   @RequestMapping(value = "/products", method = RequestMethod.GET)
   public ResponseEntity<Object> getProduct() {
      return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
   }
   @ApiOperation(value = "Update a product using ID", response = Iterable.class)
   @ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully updated product"),
	        @ApiResponse(code = 401, message = "You are not authorized to update the product"),
	        @ApiResponse(code = 403, message = "Accessing the product you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The product you were trying to reach is not found")
	})
   @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
   public ResponseEntity<Object> 
      updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
      
      productService.updateProduct(id, product);
      return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
   }
   @ApiOperation(value = "Delete a product using ID", response = Iterable.class)
   @ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully deleted product"),
	        @ApiResponse(code = 401, message = "You are not authorized to delete the product"),
	        @ApiResponse(code = 403, message = "Accessing the product you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The product you were trying to reach is not found")
	})
   @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
   public ResponseEntity<Object> delete(@PathVariable("id") String id) {
      productService.deleteProduct(id);
      return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
   }
   @ApiOperation(value = "Create a new product", response = Iterable.class)
   @ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully created product"),
	        @ApiResponse(code = 201, message = "Successfully created product"),
	        @ApiResponse(code = 401, message = "You are not authorized to delete the product"),
	        @ApiResponse(code = 403, message = "Accessing the product you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The product you were trying to reach is not found")
	})
   @RequestMapping(value = "/products", method = RequestMethod.POST)
   public ResponseEntity<Object> createProduct(@RequestBody Product product) {
      productService.createProduct(product);
      return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
   }
}