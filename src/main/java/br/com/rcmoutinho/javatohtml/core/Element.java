package br.com.rcmoutinho.javatohtml.core;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 * Representa um elemento HTML completo.
 * 
 * @rcmoutinho
 * @author rodrigo.moutinho
 * @date 30/09/2016
 * @email rcm1989@gmail.com
 */
public abstract class Element<T> {

	private T type;

	/*
	 * Atributos comuns a todo elemento HTML.
	 * 
	 * Referência: http://www.w3schools.com/tags/ref_standardattributes.asp
	 */
	private ElementDataAttributes dataAttr = new ElementDataAttributes(); // data-*
	private String dir;
	private ElementClass elementClass = new ElementClass();
	private String id;
	private String lang;
	private ElementStyle style = new ElementStyle();
	private Integer tabindex;
	private String title;

	// conteúdo do elemento
	private List<Object> values = new ArrayList<Object>();

	/**
	 * Inicialização mínima para o objeto.
	 */
	public Element() {
		this.type = this.getType();
	}

	/**
	 * Identifica o nome do elemento.
	 * 
	 * @return
	 */
	protected abstract String getName();

	/**
	 * Define o tipo que será utilizado pela implementação.
	 * 
	 * @return
	 */
	protected abstract T getType();

	/**
	 * Obtêm todos os atributos específicos do elemento implementado. Obs.:
	 * Utilizar implementação LinkedHashMap para facilitar a montagem dos
	 * testes.
	 * 
	 * @return
	 */
	protected abstract Map<String, String> getSpecificAttributesMap();

	/**
	 * Adiciona um {@link Element} ao final do conteúdo do elemento.
	 * 
	 * @param element
	 * @return
	 */
	public T append(Element<?> element) {

		// proteção para evitar objetos inúteis
		if (element != null)
			this.values.add(element);

		return this.type;
	}

	/**
	 * Adiciona uma {@link String} ao final do conteúdo do elemento.
	 * 
	 * @param value
	 * @return
	 */
	public T append(String value) {

		// proteção para evitar objetos inúteis
		if (StringUtils.isNotBlank(value))
			this.values.add(value);

		return this.type;
	}

	/**
	 * Adiciona este objeto no final do conteúdo do {@link Element} passado por
	 * parâmetro.
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
	 * Adiciona a classe desejada.
	 * 
	 * @param classCss
	 * @return {@link Element}
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
	 * Adiciona o atributo com o valor desejado. Caso o atributo já exista, seu
	 * valor será substituído.
	 * 
	 * @param attr
	 *            sem o prefixo data-
	 * @param value
	 * @return {@link Element}
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
	 * Adiciona um {@link Element} no início do conteúdo do elemento.
	 * 
	 * @param element
	 * @return
	 */
	public T prepend(Element<?> element) {

		// proteção para evitar objetos inúteis
		if (element != null)
			this.values.add(0, element);

		return this.type;
	}

	/**
	 * Adiciona uma {@link String} no início do conteúdo do elemento.
	 * 
	 * @param value
	 * @return
	 */
	public T prepend(String value) {

		// proteção para evitar objetos inúteis
		if (StringUtils.isNotBlank(value))
			this.values.add(0, value);

		return this.type;
	}

	/**
	 * Adiciona este objeto no início do conteúdo do {@link Element} passado por
	 * parâmetro.
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
	 * Adiciona todo o estilo desejado.
	 * 
	 * @param style
	 *            (property: value;){,n}
	 * @return {@link Element}
	 */
	public T style(String style) {
		this.style.add(style);
		return this.type;
	}

	/**
	 * Adiciona o estilo desejado.
	 * 
	 * @param property
	 * @param value
	 * @return {@link Element}
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
	 * Monta o elemento no formato HTML.
	 * 
	 * @return {@link String}
	 */
	public String toHtml() {
		StringBuilder html = new StringBuilder();

		html.append("<").append(this.getName());
		html.append(this.getAttrValues(this.getAttributesMap()));
		html.append(this.getAttrValues(this.getSpecificAttributesMap()));
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
	 * Obtêm um mapa com todos os atributos globais de acordo com a
	 * especificação.
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
	 * Monta os valores de cada atributo.
	 * 
	 * @param map
	 * @return
	 */
	private StringBuilder getAttrValues(Map<String, String> map) {
		StringBuilder attrValues = new StringBuilder();

		for (String attr : map.keySet()) {
			String value = map.get(attr);

			if (StringUtils.isNotBlank(value))
				attrValues.append(" ").append(attr).append("='").append(value).append("'");
		}

		return attrValues;
	}
}
