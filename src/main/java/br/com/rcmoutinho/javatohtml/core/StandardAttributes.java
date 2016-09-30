package br.com.rcmoutinho.javatohtml.core;

import java.util.HashMap;
import java.util.Map;


/**
 * Controla as informações mais utilizadas e comuns a qualquer tag HTML.
 * 
 * Referência: http://www.w3schools.com/tags/ref_standardattributes.asp
 * 
 * @rcmoutinho
 * @author rodrigo.moutinho
 * @date   14/09/2016
 * @email  rcm1989@gmail.com
 */
public class StandardAttributes {
	
	// Specifies one or more classnames for an element (refers to a class in a style sheet)
	private ElementClass classes = new ElementClass();
	
	// Used to store custom data private to the page or application
	private ElementDataAttributes dataAttr = new ElementDataAttributes(); // data-*
	
	// Specifies the text direction for the content in an element
	private String dir;
	
	// Specifies a unique id for an element
	private String id;
	
	// Specifies the language of the element's content
	private String lang;
	
	// Specifies an inline CSS style for an element
	private ElementStyle style = new ElementStyle();
	
	// Specifies the tabbing order of an element
	private String tabindex;
	
	// Specifies extra information about an element
	private String title;
	
	/**
	 * Obtêm um mapa com todos os atributos de acordo com a especificação.
	 * 
	 * @return
	 */
	protected Map<String, String> getAttributesMap() {
		HashMap<String, String> map = new HashMap<String, String>();
		
		// FIXME Implementar mapa de acordo com a especificação do W3C
		// TODO Analisar outra implementação do map para conseguir controlar os valores em testes
		
		return map;
	}
}
