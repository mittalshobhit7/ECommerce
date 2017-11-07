package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity // so table will be autocreated in DB
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // this indicates that Prod_id will be generated automatically in a sequential order
	private String prod_id; // unique

	@NotEmpty(message = "Name cannot be blank")
	private String prod_name;
	
	private String prod_desc;
	
	@Min(value = 0, message = "Price cannot be less than zero")
	private double prod_price;
	
	@Min(value = 0, message = "Price cannot be less than zero")
	private int prod_inStockunits;
	
	private String prod_condition;
	private String prod_status;
	private String prod_category;
	private String prod_manufacturer;
	
	@Transient
	private MultipartFile prod_img;
	
	
	public String getProd_id() {
		return prod_id;
	}
	public void setProd_id(String prod_id) {
		this.prod_id = prod_id;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public String getProd_desc() {
		return prod_desc;
	}
	public void setProd_desc(String prod_desc) {
		this.prod_desc = prod_desc;
	}
	public double getProd_price() {
		return prod_price;
	}
	public void setProd_price(double prod_price) {
		this.prod_price = prod_price;
	}
	public int getProd_inStockunits() {
		return prod_inStockunits;
	}
	public void setProd_inStockunits(int prod_inStockunits) {
		this.prod_inStockunits = prod_inStockunits;
	}
	public String getProd_condition() {
		return prod_condition;
	}
	public void setProd_condition(String prod_condition) {
		this.prod_condition = prod_condition;
	}
	public String getProd_status() {
		return prod_status;
	}
	public void setProd_status(String prod_status) {
		this.prod_status = prod_status;
	}
	public String getProd_category() {
		return prod_category;
	}
	public void setProd_category(String prod_category) {
		this.prod_category = prod_category;
	}
	public String getProd_manufacturer() {
		return prod_manufacturer;
	}
	public void setProd_manufacturer(String prod_manufacturer) {
		this.prod_manufacturer = prod_manufacturer;
	}
	public MultipartFile getProd_img() {
		return prod_img;
	}
	public void setProd_img(MultipartFile prod_img) {
		this.prod_img = prod_img;
	}
}
