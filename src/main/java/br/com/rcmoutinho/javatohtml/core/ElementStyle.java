package br.com.rcmoutinho.javatohtml.core;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 * Representa todos os estilos de um elemento.
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
	 * Adiciona todo o estilo desejado.
	 * 
	 * @param style
	 *            (property: value;){,n}
	 * @return {@link ElementStyle}
	 */
	public ElementStyle add(String style) {

		if (StringUtils.isNotBlank(style)) {

			for (String styleValue : style.split(";")) {
				styleValue = styleValue.trim();

				if (StringUtils.isNotBlank(styleValue)) {
					String[] array = styleValue.split(":");

					if (array.length != 2) {
						// TODO transformar em lançamento de log
						System.out.println("CSS Style invalido! [ " + styleValue + " ]");

					} else {
						this.style.put(array[0], array[1]);
					}
				}
			}
		}

		return this;
	}

	/**
	 * Adiciona o estilo desejado.
	 * 
	 * @param property
	 * @param value
	 * @return {@link ElementStyle}
	 */
	public ElementStyle add(String property, String value) {

		if (StringUtils.isNotBlank(property))
			this.style.put(property, value);

		return this;
	}

	/**
	 * Obtêm os valores utilizados.
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
	 * Verifica se existem estilos válidos.
	 * 
	 * @return boolean
	 */
	public boolean isEmpty() {
		return this.style.isEmpty();
	}

	/**
	 * Remove o estilo desejado.
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
