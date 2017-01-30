package br.com.rcmoutinho.javatohtml.core;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 * Represents the style of an element.
 * 
 * http://www.w3schools.com/tags/att_global_style.asp
 * 
 * @rcmoutinho
 * @author rodrigo.moutinho
 * @date 30/09/2016
 * @email rcm1989@gmail.com
 */
public class ElementStyle {

	private Map<String, String> style = new LinkedHashMap<String, String>();

	/**
	 * Adds some style.
	 * 
	 * @param style
	 *            (property: value;){,n}
	 * @return {@link ElementStyle}
	 */
	public ElementStyle add(String style) {

		// TODO throw some real log and make some tests
		if (StringUtils.isNotBlank(style)) {

			for (String styleValue : style.split(";")) {
				styleValue = styleValue.trim();

				if (StringUtils.isNotBlank(styleValue)) {
					String[] array = styleValue.split(":");

					if (array.length != 2) {
						System.out.println("Invalid CSS Style! [ " + styleValue + " ]");
					} else {
						this.add(array[0], array[1]);
					}
				}
			}
		}

		return this;
	}

	/**
	 * Adds some style setting your property and value.
	 * 
	 * @param property
	 * @param value
	 * @return {@link ElementStyle}
	 */
	public ElementStyle add(String property, String value) {
		String msg = "CSS Style %s is empty! Property: ['" + property + "'] Value: ['" + value + "']";

		if (StringUtils.isBlank(property)) {
			System.out.println(String.format(msg, "property"));

		} else if (StringUtils.isBlank(value)) {
			System.out.println(String.format(msg, "value"));

		} else {

			// avoid empty spaces and invalid characters
			property = property.trim().replace(":", "");
			value = value.trim().replace(";", "");

			this.style.put(property, value);
		}

		return this;
	}

	/**
	 * Specifies an inline CSS style for an element.
	 * 
	 * @return {@link String}
	 */
	public String getValues() {
		StringBuilder values = new StringBuilder();

		for (String property : this.style.keySet()) {

			if (values.length() > 0)
				values.append(" ");

			values.append(property).append(": ").append(this.style.get(property)).append(";");
		}

		return values.toString();
	}

	/**
	 * Verifies if there is any style.
	 * 
	 * @return {@link Boolean}
	 */
	public boolean isEmpty() {
		return this.style.isEmpty();
	}

	/**
	 * Removes the style.
	 * 
	 * @param property
	 * @return {@link ElementStyle}
	 */
	public ElementStyle remove(String property) {

		if (StringUtils.isNotBlank(property) && this.style.get(property) != null)
			this.style.remove(property);

		return this;
	}
}
