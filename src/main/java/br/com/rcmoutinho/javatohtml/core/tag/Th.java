package br.com.rcmoutinho.javatohtml.core.tag;

import java.util.LinkedHashMap;
import java.util.Map;

import br.com.rcmoutinho.javatohtml.core.Element;

/**
 * Implementação da tag HTML &lt;th&gt;. <br>
 * <br>
 * Ref.: http://www.w3schools.com/tags/tag_th.asp
 * 
 * @rcmoutinho
 * @author rodrigo.moutinho
 * @date 4 de out de 2016
 * @email rcm1989@gmail.com
 */
public class Th extends Element {

	private String abbr;
	private Integer colspan;
	private String headers;
	private Integer rowspan;
	private String scope;
	private String sorted;

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.rcmoutinho.javatohtml.core.Element#getName()
	 */
	@Override
	public String getName() {
		return "th";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.rcmoutinho.javatohtml.core.Element#getSpecificaAttributesMap()
	 */
	@Override
	public Map<String, String> getSpecificaAttributesMap() {
		Map<String, String> map = new LinkedHashMap<String, String>();

		if (this.abbr != null)
			map.put("abbr", this.abbr);

		if (this.colspan != null)
			map.put("colspan", this.colspan.toString());

		if (this.headers != null)
			map.put("headers", this.headers);

		if (this.rowspan != null)
			map.put("rowspan", this.rowspan.toString());
		
		if (this.scope != null)
			map.put("scope", this.scope);
		
		if (this.sorted != null)
			map.put("sorted", this.sorted);

		return map;
	}

	/**
	 * Specifies an abbreviated version of the content in a header cell.
	 * 
	 * @param abbr
	 *            text
	 * @return {@link Th}
	 */
	public Th setAbbr(String abbr) {
		this.abbr = abbr;
		return this;
	}

	/**
	 * Specifies the number of columns a cell should span.
	 * 
	 * @param colspan
	 *            number
	 * @return {@link Th}
	 */
	public Th setColspan(Integer colspan) {
		this.colspan = colspan;
		return this;
	}

	/**
	 * Specifies one or more header cells a cell is related to.
	 * 
	 * @param headers
	 *            header_id
	 * @return {@link Th}
	 */
	public Th setHeaders(String headers) {
		this.headers = headers;
		return this;
	}

	/**
	 * Sets the number of rows a cell should span.
	 * 
	 * @param rowspan
	 *            number
	 * @return {@link Th}
	 */
	public Th setRowspan(Integer rowspan) {
		this.rowspan = rowspan;
		return this;
	}

	/**
	 * Specifies whether a header cell is a header for a column, row, or group
	 * of columns or rows.
	 * 
	 * @param scope
	 *            col colgroup row rowgroup
	 * @return {@link Th}
	 */
	public Th setScope(String scope) {
		this.scope = scope;
		return this;
	}

	/**
	 * Defines the sort direction of a column.
	 * 
	 * @param sorted
	 *            reversed number reversed number number reversed
	 * @return
	 */
	public Th setSorted(String sorted) {
		this.sorted = sorted;
		return this;
	}
}