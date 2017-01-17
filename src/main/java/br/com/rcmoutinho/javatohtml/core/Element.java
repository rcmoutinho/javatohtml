package br.com.rcmoutinho.javatohtml.core;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import br.com.rcmoutinho.javatohtml.core.exception.UnsupportedTagException;

/**
 * Global attributes that apply to any HTML element.<br>
 * <br>
 * Referência: http://www.w3schools.com/tags/ref_standardattributes.asp
 * 
 * @rcmoutinho
 * @author rodrigo.moutinho
 * @date 30/09/2016
 * @email rcm1989@gmail.com
 */
public abstract class Element<T> {

	private T type; // element implementation type
	private List<Object> values = new ArrayList<Object>(); // element content

	private ElementDataAttributes dataAttr = new ElementDataAttributes(); // data-*
	private String dir;
	private ElementClass elementClass = new ElementClass();
	private String id;
	private String lang;
	private ElementStyle style = new ElementStyle();
	private Integer tabindex;

	private String title;

	/**
	 * Minimal initialization.
	 */
	public Element() {
		this.type = this.getType();
	}

	/**
	 * Identifies the element name.
	 * 
	 * @return {@link String}
	 */
	protected abstract String getName();

	/**
	 * Gets all specific attributes of the implemented element. <br>
	 * Note: Although an abstraction is returned, it is recommended to use a
	 * LinkedHashMap to favor and simplify unit tests.
	 * 
	 * @return {@link Map}
	 */
	protected abstract Map<String, String> getSpecificAttributesMap();

	/**
	 * Defines which are the elements supported by the implementation. The
	 * others will get {@link UnsupportedTagException} exception.
	 * 
	 * @return {@link List}
	 */
	protected abstract List<Class<? extends Element<?>>> getSupportedElements();

	/**
	 * Defines what is the type of the implementation.
	 * 
	 * @return
	 */
	protected abstract T getType();

	/**
	 * Defines if the tag must be properly closed.
	 * 
	 * @return boolean
	 */
	protected boolean hasEndTag() {
		return true;
	}

	/**
	 * Verifies the support to add {@link String} values to the element.
	 * 
	 * @return boolean
	 */
	protected boolean isStringValuesSupported() {
		return true;
	}

	/**
	 * Adds an {@link Element} in the end of the element content.
	 * 
	 * @param element
	 * @return
	 */
	public T append(Element<?> element) {

		// protection for worthless objects
		if (element != null) {

			if (!this.getSupportedElements().contains(element.getClass()))
				throw new UnsupportedTagException(element.getClass() + " not supported");

			this.values.add(element);
		}

		return this.type;
	}

	/**
	 * Adds a {@link String} in the end of the element content.
	 * 
	 * @param value
	 * @return
	 */
	public T append(String value) {

		if (!this.isStringValuesSupported())
			throw new UnsupportedTagException("String not supported");

		// protection for worthless objects
		if (StringUtils.isNotBlank(value))
			this.values.add(value);

		return this.type;
	}

	/**
	 * Adds the current instance at the end of parameter {@link Element} object.
	 * 
	 * @param element
	 * @return
	 */
	public T appendTo(Element<?> element) {

		if (element != null)
			element.values.add(this);

		return this.type;
	}

	/**
	 * Specifies one or more classnames for an element (refers to a class in a
	 * style sheet).
	 * 
	 * @return {@link ElementClass}
	 */
	public ElementClass classCss() {
		return elementClass;
	}

	/**
	 * Adds css classes.
	 * 
	 * @param classCss
	 * @return
	 */
	public T classCss(String... classCss) {

		if (classCss.length > 0) {
			for (String value : classCss) {
				this.elementClass.add(value);
			}
		}

		return this.type;
	}

	/**
	 * Used to store custom data private to the page or application.
	 * 
	 * @return {@link ElementDataAttributes}
	 */
	public ElementDataAttributes dataAttr() {
		return this.dataAttr;
	}

	/**
	 * Adds an attribute and your value. If the attribute already exists, the
	 * value will be overridden.
	 * 
	 * @param attr
	 *            without data- prefix
	 * @param value
	 * @return
	 */
	public T dataAttr(String attr, String value) {
		this.dataAttr.add(attr, value);
		return this.type;
	}

	/**
	 * Specifies the text direction for the content in an element.
	 * 
	 * @param dir
	 * @return
	 */
	public T dir(String dir) {
		this.dir = dir;
		return this.type;
	}

	/**
	 * Specifies a unique id for an element.
	 * 
	 * @param id
	 * @return
	 */
	public T id(String id) {
		this.id = id;
		return this.type;
	}

	/**
	 * Specifies the language of the element's content.
	 * 
	 * @param lang
	 * @return
	 */
	public T lang(String lang) {
		this.lang = lang;
		return this.type;
	}

	/**
	 * Adds an {@link Element} in the beginning of the element content.
	 * 
	 * @param element
	 * @return
	 */
	public T prepend(Element<?> element) {

		// protection for worthless objects
		if (element != null) {

			if (!this.getSupportedElements().contains(element.getClass()))
				throw new UnsupportedTagException(element.getClass() + " not supported");

			this.values.add(0, element);
		}

		return this.type;
	}

	/**
	 * Adds a {@link String} in the beginning of the element content.
	 * 
	 * @param value
	 * @return
	 */
	public T prepend(String value) {

		if (!this.isStringValuesSupported())
			throw new UnsupportedTagException("String not supported");

		// protection for worthless objects
		if (StringUtils.isNotBlank(value))
			this.values.add(0, value);

		return this.type;
	}

	/**
	 * Adds the current instance at the beginning of parameter {@link Element}
	 * object.
	 * 
	 * @param element
	 * @return
	 */
	public T prependTo(Element<?> element) {

		if (element != null)
			element.values.add(this);

		return this.type;
	}

	/**
	 * Specifies an inline CSS style for an element.
	 * 
	 * @return {@link ElementStyle}
	 */
	public ElementStyle style() {
		return this.style;
	}

	/**
	 * Adds some style.
	 * 
	 * @param style
	 *            (property: value;){,n}
	 * @return
	 */
	public T style(String style) {
		this.style.add(style);
		return this.type;
	}

	/**
	 * Adds some style setting your property and value.
	 * 
	 * @param property
	 * @param value
	 * @return
	 */
	public T style(String property, String value) {
		this.style.add(property, value);
		return this.type;
	}

	/**
	 * Specifies the tabbing order of an element.
	 * 
	 * @param tabindex
	 * @return
	 */
	public T tabindex(Integer tabindex) {
		this.tabindex = tabindex;
		return this.type;
	}

	/**
	 * Specifies extra information about an element.
	 * 
	 * @param title
	 * @return
	 */
	public T title(String title) {
		this.title = title;
		return this.type;
	}

	/**
	 * Builds the element in HTML format.
	 * 
	 * @return {@link String}
	 */
	public String toHtml() {
		StringBuilder html = new StringBuilder();

		html.append("<").append(this.getName());
		html.append(this.getHtmlAttrValues(this.getAttributesMap()));
		html.append(this.getHtmlAttrValues(this.getSpecificAttributesMap()));
		html.append(">");

		for (Object object : this.values) {

			if (object instanceof Element)
				html.append(((Element<?>) object).toHtml());
			else
				html.append(object.toString());

		}

		html.append("</").append(this.getName()).append(">");

		return html.toString();
	}

	@Override
	public String toString() {
		return this.toHtml();
	}

	/**
	 * Gets a map with all globals attributes according to specification.<br>
	 * Note: In alphabetical order to simplify unit tests.
	 * 
	 * @return
	 */
	private Map<String, String> getAttributesMap() {
		Map<String, String> map = new LinkedHashMap<String, String>();

		if (!this.elementClass.isEmpty())
			map.put("class", this.elementClass.getValues());

		if (!this.dataAttr.isEmpty())
			map.putAll(this.dataAttr.getAttributesMap());

		if (this.dir != null)
			map.put("dir", this.dir);

		if (this.id != null)
			map.put("id", this.id);

		if (this.lang != null)
			map.put("lang", this.lang);

		if (!this.style.isEmpty())
			map.put("style", this.style.getValues());

		if (this.tabindex != null)
			map.put("tabindex", this.tabindex.toString());

		if (this.title != null)
			map.put("title", this.title);

		return map;
	}

	/**
	 * Builds the attributes values according to HTML format.
	 * 
	 * @param map
	 * @return
	 */
	private StringBuilder getHtmlAttrValues(Map<String, String> map) {
		StringBuilder attrValues = new StringBuilder();

		for (String attr : map.keySet()) {
			String value = map.get(attr);

			if (StringUtils.isNotBlank(value))
				attrValues.append(" ").append(attr).append("='").append(value).append("'");
		}

		return attrValues;
	}
}
