package com.example.demo.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.Optional ; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
@Slf4j
@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	
	public List<Product> getallProduct () {
		return productRepository.findAll() ; 
	}
	
	public Product saveProduct(Product product) {
		return productRepository.save(product); 
	}
	public List<Product> getdate(){
		return productRepository.findAllByOrderByCreatedDateDesc() ; 
	}
	public Optional<Product>  getProduct (long id){
		return productRepository.findById(id) ; 
	}
    public void delete(long id ){
         productRepository.deleteById(id);
    }
	

	public String uploadCsvFile() 
		{
	
			String msg = "Successfully uploaded csv.";
	
			try 
				{
					BufferedReader bufferedreader = new BufferedReader(new FileReader("src/main/resources/product_information.csv"));
					String line = "";
	
					//int recordCount = 0;
	
					while ((line = bufferedreader.readLine()) != null)
						{
					//		recordCount++;
	
							// if (recordCount == 1)
							// 	{
							// 		//logger.info("header :{}", line);
	
							// 		continue;
							// 	}
							String[] data =line.split(",") ; 
							Product product = new Product();
							product.setBrand(data [0]);
							product.setDescription(data [1]);
							//product.setMadeIn(data [2]);
							product.setName(data [3]);
							//product.setPrice(Double.valueOf(data [4]));
							product.setCategory(data [5]);
							//product.setCreationTime(new Date());
							//product.setModificationTime(new Date());
							//product.setProvider(new Provider( "name","name","name","name" ));
							productRepository.save(product);
						}
				}
			catch (Exception e)
				{
					msg = "Something goes wrong, while process csv";
	
					//logger.error("Error while upload the csv file, err msg : {}", e.getMessage());
				}
			return msg;
		}
	

}
