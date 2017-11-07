package controller;

// NOTE - THIS IS NOT THE FRONT CONTROLLER. 
// Its just a normal user-defined controller

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import dao.ProductDAO_intrfc;
import model.Product;

@Controller
public class Home_Controller {

	@Autowired
	private ProductDAO_intrfc productdao;
	
	private Path path;

	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@RequestMapping("/productList")
	public String getProducts(Model model) { // this function name can be anything
				// if we dont use the model attribute here, then EMPTY page will be displayed, bcoz we would have not binded the model/DB to the view

		List<Product> productList = productdao.getAllProducts();
		
		/* this is when there is only a single product
		Product product = productList.get(0); // since only 1 prod is added, its
																					// index will be 0
		model.addAttribute(product);
		
		/* Basically, data(from DAO) is binded to model which is binded/attached to view
		 and shown to user
		 It is necessary to attach the model to the view so that we can access its properties
		 ( E.g like product.prod_price in the view)
		*/
		
		model.addAttribute("productList", productList); //(String atributName,Object atributValue)
		// Here, we are basically attaching the productList(2nd) defined above, and naming it also as productList (1st)
		
		
		return "productList";
		// we return the string which is the name of the view
	}
	
	@RequestMapping("/productList/viewProduct/{prod_id}")
	public String viewProduct(@PathVariable String prod_id, Model model) throws IOException{
		// In the func, the String arg. prod_id will have the actual value of {prod_id}
		// i.e bcoz, here the value from url is given to the funcn
		// @PathVariable is used to grab a value from a url
		
		Product product = productdao.getProductById(prod_id); // user defined normal funcn
		model.addAttribute(product);
		return "viewProduct";
	}
	
	@RequestMapping("/customerLogin")
	public String custLogin() {
		return "customerLogin";
	}
	
  @RequestMapping("/admin")
  public String adminPage() {
      return "admin";
  }

  @RequestMapping("/admin/productInventory")
  public String productInventory(Model model) {
      List<Product> products = productdao.getAllProducts();
      model.addAttribute("products", products);

      return "productInventory";
  }


  @RequestMapping("/admin/productInventory/addProduct")
  public String addProduct(Model model) {
      Product product = new Product();
      product.setProd_category("instrument"); // these 3 are being set as default values, becuase we plan to use radio buttons for these
      product.setProd_condition("new");
      product.setProd_status("active");

      model.addAttribute("product", product);

      return "addProduct";
  }
  
  // By default, all RequestMappings are considered GET unless specifed otherwise  
  //note the above mapping too, its the same, but here its POST
  
  @RequestMapping(value = "/admin/productInventory/addProduct", method = RequestMethod.POST)
  public String addProductPost(@Valid @ModelAttribute("product") Product prod, 
  														 BindingResult result, HttpServletRequest request) { // within quotes is the model name. it is referenced by 'prod'
  																																									// @Valid and BindingResult are added to enable validation
  																										// VIMP - BindingResult argument should be immediately after ModelAttribute or it wont work
  	
  		if(result.hasErrors()){ // To prevent submission of form having errors 
  			return "addProduct";
  		}
  		
  	
  		productdao.addProduct(prod);
  		
  		// all this is just to upload the image to the images folder
  		
      MultipartFile productImage = prod.getProd_img(); // to retrieve the img details from the model
      
      //String rootDirectory = request.getSession().getServletContext().getRealPath("/");
      path = Paths.get("C:\\Users\\Admin\\workspace_spring\\ECommerce_using_STS_3\\Uploaded_data\\"+prod.getProd_id()+".png");
      // to save the img as 'prod_id' in above external directory
      
      if (productImage != null && !productImage.isEmpty()) {
          try {
              productImage.transferTo(new File(path.toString())); // to convert that img to .png format
          } catch (Exception e) {
              e.printStackTrace();
              throw new RuntimeException("Product image saving failed", e);
          }
      } 		// till here

      return "redirect:/admin/productInventory"; // redirect tells spring that it is not a jsp page but a path
  }


  //ISSUE - images are not getting deleted from system
  @RequestMapping("/admin/productInventory/deleteProduct/{id}")
  public String deleteProduct(@PathVariable String id, Model model, HttpServletRequest request) {

  		// all this is just to delete the image from the images folder
  		path = Paths.get("C:\\Users\\Admin\\workspace_spring\\ECommerce_using_STS_3\\Uploaded_data\\"+id+".png");
  	
      if (Files.exists(path)) {
          try {
              Files.delete(path);
          } catch (IOException e) {
              e.printStackTrace();
          }
      }				// till here

      productdao.deleteProduct(id);

      return "redirect:/admin/productInventory";
  }
  
  @RequestMapping("/admin/productInventory/editProduct/{id}")
  public String editProduct(@PathVariable("id") String id, Model model){
  	Product product = productdao.getProductById(id);
  	model.addAttribute(product);
  	return "editProduct";
  }
  
  @RequestMapping(value = "/admin/productInventory/editProduct", method = RequestMethod.POST)
  public String editProduct(@Valid @ModelAttribute("product") Product prod, 
  		BindingResult result, HttpServletRequest request) { // within quotes is the model name. it is referenced by 'prod'
  		  		 		
  		if(result.hasErrors()){
  			return "editProduct";
  		}
  		
      MultipartFile productImage = prod.getProd_img(); // to retrieve the img details from the model
      
      path = Paths.get("C:\\Users\\Admin\\workspace_spring\\ECommerce_using_STS_3\\Uploaded_data\\"+prod.getProd_id()+".png");
      // to save the img as 'prod_id' in above external directory
      
      if (productImage != null && !productImage.isEmpty()) {
          try {
              productImage.transferTo(new File(path.toString())); // to convert that img to .png format
          } catch (Exception e) {
              e.printStackTrace();  
              throw new RuntimeException("Product image saving failed", e);
          }
      }
      
      productdao.editProduct(prod);
      return "redirect:/admin/productInventory"; // redirect tells spring that it is not a jsp page but a path
  }

}