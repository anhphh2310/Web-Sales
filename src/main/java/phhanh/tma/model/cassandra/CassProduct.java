package phhanh.tma.model.cassandra;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("product")
public class CassProduct {

	private UUID productId;
	private int item;
	private String classProduct;
	private String inventory;
	private Date createAt;
	private Date modifiedAt;

	public CassProduct(UUID productId, int item, String classProduct, String inventory, Date createAt,
			Date modifiedAt) {
		super();
		this.productId = productId;
		this.item = item;
		this.classProduct = classProduct;
		this.inventory = inventory;
		this.createAt = createAt;
		this.modifiedAt = modifiedAt;
	}

	public CassProduct() {
		super();
	}

	@PrimaryKeyColumn(name="PRODUCT_ID",type=PrimaryKeyType.PARTITIONED,ordinal=1)
	
	public UUID getProductId() {
		return productId;
	}

	public void setProductId(UUID productId) {
		this.productId = productId;
	}

	@Column(value="ITEM")
	public int getItem() {
		return item;
	}

	public void setItem(int item) {
		this.item = item;
	}

	@Column(value="CLASS")
	public String getClassProduct() {
		return classProduct;
	}

	public void setClassProduct(String classProduct) {
		this.classProduct = classProduct;
	}

	@Column(value="INVENTORY")
	public String getInventory() {
		return inventory;
	}

	public void setInventory(String inventory) {
		this.inventory = inventory;
	}

	@Column(value="CREATE_AT")
	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	@Column(value="MODIFIED_AT")
	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	@Override
	public String toString() {
		return "CassProduct [productId=" + productId + ", item=" + item + ", classProduct=" + classProduct
				+ ", inventory=" + inventory + ", createAt=" + createAt + ", modifiedAt=" + modifiedAt + "]";
	}

	
}
