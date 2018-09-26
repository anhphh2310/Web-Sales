package phhanh.tma.model;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.joda.time.DateTime;

@Entity
@Table(name = "PRODUCT")
public class Product {

	private UUID productId;
	private int item;
	private String classProduct;
	private String inventory;
	private DateTime createAt;
	private DateTime modifiedAt;
	private Set<Sales> sales = new HashSet<Sales>(0);

	public Product(int item, String classProduct, String inventory, DateTime createAt, DateTime modifiedAt) {
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
	@GeneratedValue(generator="UUID")
	@GenericGenerator(
			name = "UUID",
			strategy = "org.hibernate.id.UUIDGenerator"
			)
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

	@Column(name = "CREATE_AT")
	public DateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(DateTime createAt) {
		this.createAt = createAt;
	}

	@Column(name = "MODIFIED_AT")
	public DateTime getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(DateTime modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	@OneToMany(fetch=FetchType.LAZY,mappedBy="product")
	public Set<Sales> getSales() {
		return sales;
	}

	public void setSales(Set<Sales> sales) {
		this.sales = sales;
	}

	
}
