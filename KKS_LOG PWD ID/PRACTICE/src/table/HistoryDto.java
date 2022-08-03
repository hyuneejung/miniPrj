package table;

import java.sql.Timestamp;

public class HistoryDto {

	private int no;
	private String id;
	private Timestamp time_report;
	private int point;
	private String report;
	
	public HistoryDto() {
		
	}
	
	public HistoryDto(int no, String id, Timestamp time_report, int point, String report) {
		super();
		this.no = no;
		this.id = id;
		this.time_report = time_report;
		this.point = point;
		this.report = report;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Timestamp getTime_report() {
		return time_report;
	}

	public void setTime_report(Timestamp time_report) {
		this.time_report = time_report;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	@Override
	public String toString() {
		return "HistoryDto [no=" + no + ", id=" + id + ", time_report=" + time_report + ", point=" + point + ", report="
				+ report + "]";
	}
	
	
	
	
	
	
	
	
	
	
}