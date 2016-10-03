package br.com.rcmoutinho.javatohtml.core;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Controla as informações mais utilizadas e comuns a qualquer tag HTML.
 * 
 * Referência: http://www.w3schools.com/tags/ref_standardattributes.asp
 * 
 * @rcmoutinho
 * @author rodrigo.moutinho
 * @date 14/09/2016
 * @email rcm1989@gmail.com
 */
public class StandardAttributes {

	private ElementClass classes = new ElementClass();
	private ElementDataAttributes dataAttr = new ElementDataAttributes(); // data-*
	private String dir;
	private String id;
	private String lang;
	private ElementStyle style = new ElementStyle();
	private Integer tabindex;
	private String title;

	/**
	 * Obtêm um mapa com todos os atributos de acordo com a especificação.
	 * 
	 * @return
	 */
	protected Map<String, String> getAttributesMap() {
		Map<String, String> map = new LinkedHashMap<String, String>();

		if (this.classes.isEmpty())
			map.put("class", this.classes.getValues());

		if (this.dataAttr.isEmpty())
			map.putAll(this.dataAttr.getAttributesMap());

		if (this.dir != null)
			map.put("dir", this.dir);

		if (this.id != null)
			map.put("id", this.id);

		if (this.lang != null)
			map.put("lang", this.lang);

		if (this.style.isEmpty())
			map.put("style", this.style.getValues());

		if (this.tabindex != null)
			map.put("tabindex", this.tabindex.toString());

		if (this.title != null)
			map.put("title", this.title);

		return map;
	}

	/**
	 * Specifies one or more classnames for an element (refers to a class in a
	 * style sheet).
	 * 
	 * @return
	 */
	public ElementClass getClasses() {
		return classes;
	}

	/**
	 * Used to store custom data private to the page or application.
	 * 
	 * @return
	 */
	public ElementDataAttributes getDataAttr() {
		return dataAttr;
	}

	/**
	 * Specifies an inline CSS style for an element.
	 * 
	 * @return
	 */
	public ElementStyle getStyle() {
		return style;
	}

	/**
	 * Specifies the text direction for the content in an element.
	 * 
	 * @param dir
	 * @return
	 */
	public StandardAttributes setDir(String dir) {
		this.dir = dir;
		return this;
	}

	/**
	 * Specifies a unique id for an element.
	 * 
	 * @param id
	 * @return
	 */
	public StandardAttributes setId(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Specifies the language of the element's content.
	 * 
	 * @param lang
	 * @return
	 */
	public StandardAttributes setLang(String lang) {
		this.lang = lang;
		return this;
	}

	/**
	 * Specifies the tabbing order of an element.
	 * 
	 * @param tabindex
	 * @return
	 */
	public StandardAttributes setTabindex(Integer tabindex) {
		this.tabindex = tabindex;
		return this;
	}

	/**
	 * Specifies extra information about an element.
	 * 
	 * @param title
	 * @return
	 */
	public StandardAttributes setTitle(String title) {
		this.title = title;
		return this;
	}
}
