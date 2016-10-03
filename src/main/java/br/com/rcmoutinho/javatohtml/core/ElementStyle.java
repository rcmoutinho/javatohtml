package br.com.rcmoutinho.javatohtml.core;

import java.util.LinkedHashMap;
import java.util.Map;

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
	 * Verifica se existem estilos válidos.
	 * 
	 * @return
	 */
	protected boolean isEmpty() {
		return this.style.isEmpty();
	}

	/**
	 * Obtêm os valores utilizados.
	 * 
	 * @return
	 */
	protected String getValues() {
		StringBuilder values = new StringBuilder();

		for (String property : this.style.keySet()) {

			if (values.length() > 0)
				values.append(" ");

			values.append(property).append(": ").append(this.style.get(property)).append(";");
		}

		return values.toString();
	}
}
