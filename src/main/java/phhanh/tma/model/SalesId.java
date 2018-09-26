package phhanh.tma.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SalesId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UUID productId;
	private UUID timeId;
	private UUID locationId;

	public SalesId(UUID productId, UUID timeId, UUID locationId) {
		super();
		this.productId = productId;
		this.timeId = timeId;
		this.locationId = locationId;
	}

	public SalesId() {
		super();
	}
	@Column(name="PRODUCT_ID",nullable=false)
	public UUID getProductId() {
		return productId;
	}

	public void setProductId(UUID productId) {
		this.productId = productId;
	}

	@Column(name="TIME_ID", nullable=false)
	public UUID getTimeId() {
		return timeId;
	}

	public void setTimeId(UUID timeId) {
		this.timeId = timeId;
	}

	@Column(name="LOCATION_ID", nullable=false)
	public UUID getLocationId() {
		return locationId;
	}

	public void setLocationId(UUID locationId) {
		this.locationId = locationId;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj)
		return false;
		if(obj==null)
			return false;
		if(!(obj instanceof SalesId))
			return false;
		SalesId tempobj = (SalesId) obj;
		return (this.getProductId() == tempobj.getProductId()) && (this.getTimeId() == tempobj.getTimeId())
				&& (this.getLocationId() == tempobj.getLocationId());
	}
	
	@Override
	public int hashCode() {
		 int result = 17;
	        result = 31 * result + this.getProductId().hashCode();
	        result = 31 * result + this.getLocationId().hashCode();
	        result = 31 * result + this.getTimeId().hashCode();
	        return result;
	}
}
