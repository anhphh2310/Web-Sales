package phhanh.tma.model.cassandra;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;


//@Table("location")
public class CassSales {

//	private UUID productID;
//	private UUID timeID;
//	private UUID locationID;
//	private double dollars;
//	private Date createAt;
//	private Date modifiedAt;
//
//	public CassSales(UUID productID, UUID timeID, UUID locationID, double dollars, Date createAt,
//			Date modifiedAt) {
//		super();
//		this.productID = productID;
//		this.timeID = timeID;
//		this.locationID = locationID;
//		this.dollars = dollars;
//		this.createAt = createAt;
//		this.modifiedAt = modifiedAt;
//	}
//
//	public CassSales() {
//		super();
//	}
//
//	@PrimaryKeyColumn(name="PRODUCT_ID",type=PrimaryKeyType.PARTITIONED,ordinal=1)
//	public UUID getProductID() {
//		return productID;
//	}
//
//	public void setProductID(UUID productID) {
//		this.productID = productID;
//	}
//
//	@PrimaryKeyColumn(value="TIME_ID",type=PrimaryKeyType.CLUSTERED,ordinal=2)
//	public UUID getTimeID() {
//		return timeID;
//	}
//
//	public void setTimeID(UUID timeID) {
//		this.timeID = timeID;
//	}
//
//	@PrimaryKeyColumn(value="LOCATION_ID",type=PrimaryKeyType.CLUSTERED,ordinal=3)
//	public UUID getLocationID() {
//		return locationID;
//	}
//
//	public void setLocationID(UUID locationID) {
//		this.locationID = locationID;
//	}
//
//	@Column(value="DOLLARDS")
//	public double getDollars() {
//		return dollars;
//	}
//
//	public void setDollars(double dollars) {
//		this.dollars = dollars;
//	}
//
//	@Column(value="CREATE_AT")
//	public Date getCreateAt() {
//		return createAt;
//	}
//
//	public void setCreateAt(Date createAt) {
//		this.createAt = createAt;
//	}
//
//	@Column(value="MODIFIED_AT")
//	public Date getModifiedAt() {
//		return modifiedAt;
//	}
//
//	public void setModifiedAt(Date modifiedAt) {
//		this.modifiedAt = modifiedAt;
//	}

}
