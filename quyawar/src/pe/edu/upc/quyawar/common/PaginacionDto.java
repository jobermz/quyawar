package pe.edu.upc.quyawar.common;

public class PaginacionDto {
	private int totalRows;
	private int startPosition;
	private int maxResult;

	public PaginacionDto() {
	}
	public PaginacionDto(int startPosition, int maxResult) {
		this.startPosition	= startPosition;
		this.maxResult		= maxResult;
	}
	
	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getStartPosition() {
		return startPosition;
	}

	public void setStartPosition(int startPosition) {
		this.startPosition = startPosition;
	}

	public int getMaxResult() {
		return maxResult;
	}

	public void setMaxResult(int maxResult) {
		this.maxResult = maxResult;
	}
	
}
