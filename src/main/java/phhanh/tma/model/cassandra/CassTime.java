package phhanh.tma.model.cassandra;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("time")
public class CassTime {

	private UUID timeId;
	private int month;
	private int quarter;
	private int year;
	private Date createAt;
	private Date modifiedAt;

	public CassTime(UUID timeId, int month, int quarter, int year, Date createAt, Date modifiedAt) {
		super();
		this.timeId = timeId;
		this.month = month;
		this.quarter = quarter;
		this.year = year;
		this.createAt = createAt;
		this.modifiedAt = modifiedAt;
	}

	public CassTime() {
		super();
	}

	@PrimaryKeyColumn(name="TIME_ID",type=PrimaryKeyType.PARTITIONED,ordinal=1)
	public UUID getTimeId() {
		return timeId;
	}

	public void setTimeId(UUID timeId) {
		this.timeId = timeId;
	}

	@Column(value="MONTH")
	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	@Column(value="QUARTER")
	public int getQuarter() {
		return quarter;
	}

	public void setQuarter(int quarter) {
		this.quarter = quarter;
	}

	@Column(value="YEAR")
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
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
		return "CassTime [timeId=" + timeId + ", month=" + month + ", quarter=" + quarter + ", year=" + year
				+ ", createAt=" + createAt + ", modifiedAt=" + modifiedAt + "]";
	}

	
}
