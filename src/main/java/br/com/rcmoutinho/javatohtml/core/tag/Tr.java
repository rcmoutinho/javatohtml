package br.com.rcmoutinho.javatohtml.core.tag;

import java.util.LinkedHashMap;
import java.util.Map;

import br.com.rcmoutinho.javatohtml.core.Element;

/**
 * Implementação da tag HTML &lt;tr&gt;. <br>
 * <br>
 * Ref.: http://www.w3schools.com/tags/tag_tr.asp
 * 
 * @rcmoutinho
 * @author rodrigo.moutinho
 * @date 4 de out de 2016
 * @email rcm1989@gmail.com
 */
public class Tr extends Element {

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.rcmoutinho.javatohtml.core.Element#getName()
	 */
	@Override
	public String getName() {
		return "tr";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.rcmoutinho.javatohtml.core.Element#getSpecificaAttributesMap()
	 */
	@Override
	public Map<String, String> getSpecificaAttributesMap() {
		return new LinkedHashMap<String, String>();
	}
}
