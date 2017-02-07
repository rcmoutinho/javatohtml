package br.com.javatohtml.core;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 * Manage the data-* attributes values.
 * 
 * http://www.w3schools.com/tags/att_global_data.asp
 * 
 * @rcmoutinho
 * @author rodrigo.moutinho
 * @date 30/09/2016
 * @email rcm1989@gmail.com
 */
public class ElementDataAttributes {

	private Map<String, String> dataAttr = new LinkedHashMap<String, String>();

	/**
	 * Adds an attribute and your value. If the attribute already exists, the
	 * value will be overridden.
	 * 
	 * @param attr
	 * @param value
	 * @return {@link ElementDataAttributes}
	 */
	public ElementDataAttributes add(String attr, String value) {
		String parametersToLog = "Attr: ['" + attr + "'] Value: ['" + value + "']";

		if (StringUtils.isNotBlank(attr)) {

			// avoid null values
			if (value == null) {
				value = "";

				// TODO log here
				System.out.println("Invalid value fixed to an empty String. " + parametersToLog);
			}

			this.dataAttr.put(attr, value);

		} else {
			// TODO log here
			System.out.println("Invalid attr! " + parametersToLog);
		}

		return this;
	}

	/**
	 * Gets the value of the attribute, if exists.
	 * 
	 * @param attr
	 * @return {@link String}
	 */
	public String get(String attr) {
		return this.dataAttr.get(attr);
	}

	/**
	 * Gets all data-* attributes.
	 * 
	 * @return {@link Map}
	 */
	public Map<String, String> getAttributesMap() {
		Map<String, String> dataAttr = new LinkedHashMap<String, String>();

		// just set the data- prefix
		for (String data : this.dataAttr.keySet()) {
			dataAttr.put("data-" + data, this.dataAttr.get(data));
		}

		return dataAttr;
	}

	/**
	 * Verifies that the attribute already exists.
	 * 
	 * @param attr
	 * @return {@link Boolean}
	 */
	public boolean has(String attr) {
		return this.dataAttr.get(attr) != null;
	}

	/**
	 * Verifies if there is any attribute.
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return this.dataAttr.isEmpty();
	}

	/**
	 * Removes the attribute.
	 * 
	 * @param attr
	 * @return
	 */
	public ElementDataAttributes remove(String attr) {
		this.dataAttr.remove(attr);
		return this;
	}
}
