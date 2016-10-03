package br.com.rcmoutinho.javatohtml.core;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Controla os valores para atributos data-*.
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
	 * Verifica se existem estilos válidos.
	 * 
	 * @return
	 */
	protected boolean isEmpty() {
		return this.dataAttr.isEmpty();
	}

	/**
	 * Obtêm todos os atributos utilizados.
	 * 
	 * @return
	 */
	protected Map<String, String> getAttributesMap() {
		Map<String, String> dataAttr = new LinkedHashMap<String, String>();

		// mantem os valores apenas colocando o prefixo esperado
		for (String data : this.dataAttr.keySet()) {
			dataAttr.put("data-" + data, this.dataAttr.get(data));
		}

		return dataAttr;
	}
}
