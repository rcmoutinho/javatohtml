package br.com.rcmoutinho.javatohtml.core.tag;

import java.util.LinkedHashMap;
import java.util.Map;

import br.com.rcmoutinho.javatohtml.core.Element;

/**
 * Implementação da tag HTML &lt;tfoot&gt;. <br>
 * <br>
 * Ref.: http://www.w3schools.com/tags/tag_tfoot.asp
 * 
 * @rcmoutinho
 * @author rodrigo.moutinho
 * @date 10 de jan de 2017
 * @email rcm1989@gmail.com
 */
public class Tfoot extends Element<Tfoot> {

	@Override
	protected String getName() {
		return "tfoot";
	}

	@Override
	protected Map<String, String> getSpecificAttributesMap() {
		return new LinkedHashMap<String, String>();
	}

	@Override
	protected Tfoot getType() {
		return this;
	}
}
