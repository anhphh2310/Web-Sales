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
@Table(name = "TIME")
public class Time {

	private UUID timeId;
	private int month;
	private int quarter;
	private int year;
	private DateTime createAt;
	private DateTime modifiedAt;
	private Set<Sales> sales = new HashSet<Sales>(0);
	
	public Time(int month, int quarter, int year, DateTime createAt, DateTime modifiedAt) {
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
	@GenericGenerator(
			name = "UUID",
			strategy = "org.hibernate.id.UUIDGenerator"
			)
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

	@OneToMany(fetch=FetchType.LAZY,mappedBy="time")
	public Set<Sales> getSales() {
		return sales;
	}

	public void setSales(Set<Sales> sales) {
		this.sales = sales;
	}

	
}
