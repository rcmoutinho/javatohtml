package br.com.javatohtml.core.tag;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import br.com.javatohtml.core.Element;
import br.com.javatohtml.core.ElementUtils;

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
public class Td extends Element<Td> {

	private Integer colspan;
	private String headers;
	private Integer rowspan;

	/**
	 * Creates the {@link Td} element.
	 */
	public Td() {
	}

	/**
	 * Creates a {@link Td} with an {@link Element}.
	 * 
	 * @param element
	 */
	public Td(Element<?> element) {
		this.append(element);
	}

	/**
	 * Creates a {@link Td} with a {@link String}.
	 * 
	 * @param value
	 */
	public Td(String value) {
		this.append(value);
	}

	@Override
	protected String getName() {
		return "td";
	}

	@Override
	protected Map<String, String> getSpecificAttributesMap() {
		Map<String, String> map = new LinkedHashMap<String, String>();

		if (this.colspan != null && this.colspan > 1)
			map.put("colspan", this.colspan.toString());

		if (this.headers != null)
			map.put("headers", this.headers);

		if (this.rowspan != null && this.rowspan > 1)
			map.put("rowspan", this.rowspan.toString());

		return map;
	}

	@Override
	protected List<Class<? extends Element<?>>> getSupportedElements() {
		return ElementUtils.getCommonSupportedElements();
	}

	@Override
	protected Td getType() {
		return this;
	}

	/**
	 * Specifies the number of columns a cell should span.
	 * 
	 * @param colspan
	 *            number
	 * @return {@link Td}
	 */
	public Td colspan(Integer colspan) {
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
	public Td headers(String headers) {
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
	public Td rowspan(Integer rowspan) {
		this.rowspan = rowspan;
		return this;
	}
}
