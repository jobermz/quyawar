package pe.edu.upc.quyawar.common.util;

import java.util.Collection;
import java.util.List;

public class PagedResult<E> {
	private int totalRows;
	private Collection<E> lista;
	
	public PagedResult (int totalRows, List<E> lista) {
		this.setTotalRows(totalRows);
		this.setLista(lista);
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public Collection<E> getLista() {
		return lista;
	}

	public void setLista(Collection<E> lista) {
		this.lista = lista;
	}
	
	
	
}
