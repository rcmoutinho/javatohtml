package br.com.rcmoutinho.javatohtml.core;

import java.util.ArrayList;
import java.util.List;

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
	 * Verifica se existem classes válidas.
	 * 
	 * @return
	 */
	protected boolean isEmpty() {
		return this.classes.isEmpty();
	}

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
}
