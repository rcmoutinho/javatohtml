package br.com.rcmoutinho.javatohtml.core;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * Represents all CSS classes of an element.
 * 
 * http://www.w3schools.com/tags/att_global_class.asp
 * 
 * @rcmoutinho
 * @author rodrigo.moutinho
 * @date 30/09/2016
 * @email rcm1989@gmail.com
 */
public class ElementClass {

	private List<String> classes = new ArrayList<String>();

	/**
	 * Adds a CSS class.
	 * 
	 * @param clazz
	 * @return {@link ElementClass}
	 */
	public ElementClass add(String clazz) {

		if (StringUtils.isNotBlank(clazz) && !this.has(clazz))
			this.classes.add(clazz);

		return this;
	}

	/**
	 * Gets all classes.
	 * 
	 * @return {@link String}
	 */
	public String getValues() {
		StringBuilder values = new StringBuilder();

		for (String clazz : this.classes) {

			if (values.length() > 0)
				values.append(" ");

			values.append(clazz);
		}

		return values.toString();
	}

	/**
	 * Verifies if the class already exists.
	 * 
	 * @param clazz
	 * @return
	 */
	public boolean has(String clazz) {
		return this.classes.contains(clazz);
	}

	/**
	 * Verifies if there is any class.
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return this.classes.isEmpty();
	}

	/**
	 * Removes the CSS class.
	 * 
	 * @param clazz
	 * @return
	 */
	public ElementClass remove(String clazz) {

		if (StringUtils.isNotBlank(clazz) && this.has(clazz))
			this.classes.remove(clazz);

		return this;
	}

	/**
	 * Toggle the CSS class. If exists, will be removed. The opposite, adds the
	 * class.
	 * 
	 * @param clazz
	 * @return
	 */
	public ElementClass toggle(String clazz) {

		if (StringUtils.isNotBlank(clazz)) {

			if (this.has(clazz)) {
				this.classes.remove(clazz);

			} else {
				this.classes.add(clazz);
			}
		}

		return this;
	}
}
