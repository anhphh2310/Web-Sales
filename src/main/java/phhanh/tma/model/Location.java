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
@Table(name = "LOCATION")
public class Location {

	private UUID locationId;
	private String country;
	private String city;
	private Date createAt;
	private Date modifiedAt;
	private Set<Sales> sales;

	public Location(String country, String city, Date createAt, Date modifiedAt) {
		super();
		this.country = country;
		this.city = city;
		this.createAt = createAt;
		this.modifiedAt = modifiedAt;
	}

	public Location() {
		super();
	}

	@Id
	@GeneratedValue(generator = "UUID")
	@Column(name = "LOCATION_ID", updatable = false, nullable = false)
	public UUID getLocationId() {
		return locationId;
	}

	public void setLocationId(UUID locationId) {
		this.locationId = locationId;
	}

	@Column(name = "COUNTRY")
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "CITY")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "CREATE_AT", nullable = true)
	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	@Column(name = "MODIFIED_AT", nullable = true)
	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}
	
	@OneToMany(mappedBy="LOCATION")
	public Set<Sales> getSales() {
		return sales;
	}

	public void setSales(Set<Sales> sales) {
		this.sales = sales;
	}
	
	

}
