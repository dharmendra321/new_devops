package com.onlinebackend.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.springframework.web.multipart.MultipartFile;
@Entity
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int pid;
	
	private String productName;
	private String brand;
	private String description;
	@Column(name = "unitprice", nullable = false, columnDefinition = "double default 100")
	private double unitprice;
	@Min(value = 1, message="Quantity Should be >0!")
	private int qty;
	private int cid;
	private int sid;
	private boolean isactive ;
	@Column(name = "userView", nullable = false, columnDefinition = "int default 0")
	private int userView;
	
	@Transient
	private MultipartFile pic;
	
	public MultipartFile getPic() {
		return pic;
	}
	public void setPic(MultipartFile pic) {
		this.pic = pic;
	}
	public int getUserView() {
		return userView;
	}
	public void setUserView(int userView) {
		this.userView = userView;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public double getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(double untiprice) {
		this.unitprice = untiprice;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public boolean isIsactive() {
		return isactive;
	}
	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}
		public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
  
}
