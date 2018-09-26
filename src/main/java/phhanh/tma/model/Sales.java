package phhanh.tma.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.joda.time.DateTime;

@Entity
@Table(name = "SALES")
public class Sales {

	private SalesId saleId;
	private Product product;
	private Time time;
	private Location location;
	private double dollars;
	private DateTime createAt;
	private DateTime modifiedAt;

	public Sales(Product product, Time time, Location location, double dollars, DateTime createAt, DateTime modifiedAt) {
		super();
		this.product = product;
		this.time = time;
		this.location = location;
		this.dollars = dollars;
		this.createAt = createAt;
		this.modifiedAt = modifiedAt;
	}

	public Sales() {
		super();
	}

	@EmbeddedId
//	@AttributeOverrides({
//		@AttributeOverride(name="productId",column= @Column(name="PRODUCT_ID", nullable = false)),
//		@AttributeOverride(name="timeId",column = @Column(name="TIME_ID", nullable = false)),
//		@AttributeOverride(name="locationId",column = @Column(name="LOCATION_ID", nullable = false))
//	})
	public SalesId getSaleId() {
		return saleId;
	}

	public void setSaleId(SalesId saleId) {
		this.saleId = saleId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="PRODUCT_ID", updatable = false, nullable = false)
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="TIME_ID", updatable = false, nullable = false)
	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="LOCATION_ID", updatable = false, nullable = false)
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Column(name="DOLLARS")
	public double getDollars() {
		return dollars;
	}

	public void setDollars(double dollars) {
		this.dollars = dollars;
	}

	@Column(name="CREATE_AT")
	public DateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(DateTime createAt) {
		this.createAt = createAt;
	}

	@Column(name="MODIFIED_AT")
	public DateTime getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(DateTime modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

}
