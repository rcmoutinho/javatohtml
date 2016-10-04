package br.com.rcmoutinho.javatohtml.core;

import java.util.ArrayList;
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
public abstract class Element {

	// atributos comuns a todo elemento HTML
	private StandardAttributes standardAttributes = new StandardAttributes();

	// conteúdo do elemento
	private List<Object> values = new ArrayList<Object>();

	/**
	 * Identifica o nome do elemento.
	 * 
	 * @return
	 */
	public abstract String getName();

	/**
	 * Obtêm todos os atributos específicos do elemento implementado. Obs.:
	 * Utilizar implementação LinkedHashMap para facilitar a montagem dos
	 * testes.
	 * 
	 * @return
	 */
	public abstract Map<String, String> getSpecificaAttributesMap();

	/**
	 * Adiciona um {@link Element} ao final do conteúdo do elemento.
	 * 
	 * @param element
	 * @return
	 */
	public Element append(Element element) {

		// proteção para evitar objetos inúteis
		if (element != null)
			this.values.add(element);

		return this;
	}

	/**
	 * Adiciona uma {@link String} ao final do conteúdo do elemento.
	 * 
	 * @param value
	 * @return
	 */
	public Element append(String value) {

		// proteção para evitar objetos inúteis
		if (StringUtils.isNotBlank(value))
			this.values.add(value);

		return this;
	}

	/**
	 * Adiciona este objeto no final do conteúdo do {@link Element} passado por
	 * parâmetro.
	 * 
	 * @param element
	 * @return
	 */
	public Element appendTo(Element element) {

		if (element != null)
			element.values.add(this);

		return this;
	}

	/**
	 * Adiciona um {@link Element} no início do conteúdo do elemento.
	 * 
	 * @param element
	 * @return
	 */
	public Element prepend(Element element) {

		// proteção para evitar objetos inúteis
		if (element != null)
			this.values.add(0, element);

		return this;
	}

	/**
	 * Adiciona uma {@link String} no início do conteúdo do elemento.
	 * 
	 * @param value
	 * @return
	 */
	public Element prepend(String value) {

		// proteção para evitar objetos inúteis
		if (StringUtils.isNotBlank(value))
			this.values.add(0, value);

		return this;
	}

	/**
	 * Adiciona este objeto no início do conteúdo do {@link Element} passado por
	 * parâmetro.
	 * 
	 * @param element
	 * @return
	 */
	public Element prependTo(Element element) {

		if (element != null)
			element.values.add(this);

		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.getHtml();
	}

	/**
	 * Monta o elemento no formato HTML.
	 * 
	 * @return {@link String}
	 */
	public String getHtml() {
		StringBuilder html = new StringBuilder();

		html.append("<").append(this.getName());
		html.append(this.getAttrValues(this.standardAttributes.getAttributesMap()));
		html.append(this.getAttrValues(this.getSpecificaAttributesMap()));
		html.append(">");

		for (Object object : this.values) {

			if (object instanceof Element)
				html.append(((Element) object).getHtml());
			else
				html.append(object.toString());

		}

		html.append("</").append(this.getName()).append(">");

		return html.toString();
	}

	/**
	 * Monta os valores de cada atributo.
	 * 
	 * @param map
	 * @return
	 */
	private StringBuilder getAttrValues(Map<String, String> map) {
		StringBuilder attrValues = new StringBuilder();

		for (String attr : map.keySet())
			attrValues.append(" ").append(attr).append("='").append(map.get(attr)).append("'");

		return attrValues;
	}
}
