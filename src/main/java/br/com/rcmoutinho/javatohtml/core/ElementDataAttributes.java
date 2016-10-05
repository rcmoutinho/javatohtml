package br.com.rcmoutinho.javatohtml.core;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

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
	 * Adiciona o atributo com o valor desejado. Caso o atributo já exista, seu
	 * valor será substituído.
	 * 
	 * @param attr
	 * @param value
	 * @return
	 */
	public ElementDataAttributes add(String attr, String value) {

		if (StringUtils.isNotBlank(attr))
			this.dataAttr.put(attr, value);

		return this;
	}

	/**
	 * Obtêm todos os atributos utilizados.
	 * 
	 * @return
	 */
	public Map<String, String> getAttributesMap() {
		Map<String, String> dataAttr = new LinkedHashMap<String, String>();

		// mantem os valores apenas colocando o prefixo esperado
		for (String data : this.dataAttr.keySet()) {
			dataAttr.put("data-" + data, this.dataAttr.get(data));
		}

		return dataAttr;
	}

	/**
	 * Verifica se a classe desejada já existe.
	 * 
	 * @param attr
	 * @return
	 */
	public boolean has(String attr) {
		return this.dataAttr.get(attr) != null;
	}

	/**
	 * Verifica se existem estilos válidos.
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return this.dataAttr.isEmpty();
	}

	/**
	 * Remove o atributo desejado.
	 * 
	 * @param clazz
	 * @return
	 */
	public ElementDataAttributes remove(String clazz) {

		if (StringUtils.isNotBlank(clazz) && this.has(clazz))
			this.dataAttr.remove(clazz);

		return this;
	}
}
