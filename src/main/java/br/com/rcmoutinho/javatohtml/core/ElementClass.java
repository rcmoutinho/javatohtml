package br.com.rcmoutinho.javatohtml.core;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * Representa todas as classes de um elemento.
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
	 * Obtêm os valores utilizados.
	 * 
	 * @return
	 */
	protected String getValues() {
		StringBuilder values = new StringBuilder();

		for (String clazz : this.classes) {

			if (values.length() > 0)
				values.append(" ");

			values.append(clazz);
		}

		return values.toString();
	}

	/**
	 * Verifica se existem classes válidas.
	 * 
	 * @return
	 */
	protected boolean isEmpty() {
		return this.classes.isEmpty();
	}

	/**
	 * Adiciona a classe desejada.
	 * 
	 * @param clazz
	 * @return
	 */
	public ElementClass add(String clazz) {

		if (StringUtils.isNotBlank(clazz) && !this.has(clazz))
			this.classes.add(clazz);

		return this;
	}

	/**
	 * Verifica se a classe desejada já existe.
	 * 
	 * @param clazz
	 * @return
	 */
	public boolean has(String clazz) {
		return this.classes.contains(clazz);
	}

	/**
	 * Remove a classe desejada.
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
	 * Inverte a classe desejada. Se existir, apaga. O contrário, adiciona.
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
