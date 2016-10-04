package br.com.rcmoutinho.javatohtml.core.tag;

import java.util.LinkedHashMap;
import java.util.Map;

import br.com.rcmoutinho.javatohtml.core.Element;

/**
 * Implementação da tag HTML &lt;td&gt;. <br>
 * <br>
 * Ref.: http://www.w3schools.com/tags/tag_td.asp
 * 
 * @rcmoutinho
 * @author rodrigo.moutinho
 * @date 4 de out de 2016
 * @email rcm1989@gmail.com
 */
public class Td extends Element {

	private Integer colspan;
	private String headers;
	private Integer rowspan;

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.rcmoutinho.javatohtml.core.Element#getName()
	 */
	@Override
	public String getName() {
		return "td";
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

		if (this.colspan != null)
			map.put("colspan", this.colspan.toString());

		if (this.headers != null)
			map.put("headers", this.headers);

		if (this.rowspan != null)
			map.put("rowspan", this.rowspan.toString());

		return map;
	}

	/**
	 * Specifies the number of columns a cell should span.
	 * 
	 * @param colspan
	 *            number
	 * @return {@link Td}
	 */
	public Td setColspan(Integer colspan) {
		this.colspan = colspan;
		return this;
	}

	/**
	 * Specifies one or more header cells a cell is related to.
	 * 
	 * @param headers
	 *            header_id
	 * @return {@link Td}
	 */
	public Td setHeaders(String headers) {
		this.headers = headers;
		return this;
	}

	/**
	 * Sets the number of rows a cell should span.
	 * 
	 * @param rowspan
	 *            number
	 * @return {@link Td}
	 */
	public Td setRowspan(Integer rowspan) {
		this.rowspan = rowspan;
		return this;
	}
}
