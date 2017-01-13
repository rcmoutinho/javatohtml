package br.com.rcmoutinho.javatohtml.core.tag;

import java.util.LinkedHashMap;
import java.util.Map;

import br.com.rcmoutinho.javatohtml.core.Element;

/**
 * The implementation of &lt;hr&gt;. <br>
 * <br>
 * Ref.: http://www.w3schools.com/tags/tag_hr.asp
 * 
 * @rcmoutinho
 * @author rodrigo.moutinho
 * @date 11 de jan de 2017
 * @email rcm1989@gmail.com
 */
public class Hr extends Element<Hr> {

	@Override
	protected String getName() {
		return "hr";
	}

	@Override
	protected Map<String, String> getSpecificAttributesMap() {
		return new LinkedHashMap<String, String>();
	}

	@Override
	protected Hr getType() {
		return this;
	}
}
