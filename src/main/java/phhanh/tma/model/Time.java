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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TIME")
public class Time {

	private UUID timeId;
	private int month;
	private int quarter;
	private int year;
	private Date createAt;
	private Date modifiedAt;
	private Set<Sales> sales;
	
	public Time(int month, int quarter, int year, Date createAt, Date modifiedAt) {
		super();
		this.month = month;
		this.quarter = quarter;
		this.year = year;
		this.createAt = createAt;
		this.modifiedAt = modifiedAt;
	}

	public Time() {
		super();
	}

	@Id
	@GeneratedValue(generator="UUID")
	@Column(name="TIME_ID",nullable=false,updatable=false)
	public UUID getTimeId() {
		return timeId;
	}

	public void setTimeId(UUID timeId) {
		this.timeId = timeId;
	}

	@Column(name="MONTH")
	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	@Column(name="QUARTER")
	public int getQuarter() {
		return quarter;
	}

	public void setQuarter(int quarter) {
		this.quarter = quarter;
	}

	@Column(name="YEAR")
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Temporal(TemporalType.DATE)
	@Column(name="CREATE_AT")
	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	@Column(name="MODIFIED_AT")
	@Temporal(TemporalType.DATE)
	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	@OneToMany(mappedBy="TIME")
	public Set<Sales> getSales() {
		return sales;
	}

	public void setSales(Set<Sales> sales) {
		this.sales = sales;
	}

	
}
