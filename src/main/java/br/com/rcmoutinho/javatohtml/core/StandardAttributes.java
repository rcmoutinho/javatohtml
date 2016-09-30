package br.com.rcmoutinho.javatohtml.core;

import java.util.List;
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
	
	// Specifies a unique id for an element
	private String id;
	
	// Specifies one or more classnames for an element (refers to a class in a style sheet)
	private List<String> classes;
	
	// Specifies the language of the element's content
	private String lang;
	
	// Specifies an inline CSS style for an element
	private Map<String, String> styles;
	
	// Specifies the tabbing order of an element
	private String tabindex;
	
	// Specifies extra information about an element
	private String title;
	
}
