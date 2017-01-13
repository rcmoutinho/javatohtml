package br.com.rcmoutinho.javatohtml.core.tag;

import java.util.LinkedHashMap;
import java.util.Map;

import br.com.rcmoutinho.javatohtml.core.Element;

/**
 * The implementation of &lt;h3&gt;. <br>
 * <br>
 * Ref.: http://www.w3schools.com/tags/tag_hn.asp
 * 
 * @rcmoutinho
 * @author rodrigo.moutinho
 * @date 11 de jan de 2017
 * @email rcm1989@gmail.com
 */
public class H3 extends Element<H3> {

	@Override
	protected String getName() {
		return "h3";
	}

	@Override
	protected Map<String, String> getSpecificAttributesMap() {
		return new LinkedHashMap<String, String>();
	}

	@Override
	protected H3 getType() {
		return this;
	}
}
