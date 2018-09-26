package phhanh.tma.model;

import java.sql.Date;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class Product {

	private UUID productId;
	private int item;
	private String classProduct;
	private String inventory;
	private Date createAt;
	private Date modifiedAt;
	private Set<Sales> sales;

	public Product(int item, String classProduct, String inventory, Date createAt, Date modifiedAt) {
		super();
		this.item = item;
		this.classProduct = classProduct;
		this.inventory = inventory;
		this.createAt = createAt;
		this.modifiedAt = modifiedAt;
	}

	public Product() {
		super();
	}

	@Id
	@GeneratedValue(generator = "UUID")
	@Column(name = "PRODUCT_ID", updatable = false, nullable = false)
	public UUID getProductId() {
		return productId;
	}

	public void setProductId(UUID productId) {
		this.productId = productId;
	}

	@Column(name = "ITEM")
	public int getItem() {
		return item;
	}

	public void setItem(int item) {
		this.item = item;
	}

	@Column(name = "CLASS")
	public String getClassProduct() {
		return classProduct;
	}

	public void setClassProduct(String classProduct) {
		this.classProduct = classProduct;
	}

	@Column(name = "INVENTORY")
	public String getInventory() {
		return inventory;
	}

	public void setInventory(String inventory) {
		this.inventory = inventory;
	}

	@Column(name = "CREATE_aT")
	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	@Column(name = "MODIFIED_aT")
	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	@OneToMany(mappedBy="PRODUCT")
	public Set<Sales> getSales() {
		return sales;
	}

	public void setSales(Set<Sales> sales) {
		this.sales = sales;
	}

	
}
