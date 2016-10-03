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

	/**
	 * Verifica se existem estilos válidos.
	 * 
	 * @return
	 */
	protected boolean isEmpty() {
		return this.style.isEmpty();
	}
	
	/**
	 * Adiciona o estilo desejado.
	 * 
	 * @param property
	 * @param value
	 * @return
	 */
	public ElementStyle add(String property, String value) {
		
		if (StringUtils.isNotBlank(property))
			this.style.put(property, value); // TODO Verificar como tratar valores já existentes no estilo
		
		return this;
	}
	
	/**
	 * Remove o estilo desejado.
	 * 
	 * @param property
	 * @return
	 */
	public ElementStyle remove(String property) {
		
		if (StringUtils.isNotBlank(property) && this.style.get(property)!=null)
			this.style.remove(property);
		
		return this;
	}
}
