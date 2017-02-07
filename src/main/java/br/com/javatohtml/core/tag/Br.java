package br.com.javatohtml.core.tag;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import br.com.javatohtml.core.Element;

/**
 * The implementation of &lt;br&gt;. <br>
 * <br>
 * Ref.: http://www.w3schools.com/tags/tag_br.asp
 * 
 * @rcmoutinho
 * @author rodrigo.moutinho
 * @date 11 de jan de 2017
 * @email rcm1989@gmail.com
 */
public class Br extends Element<Br> {

	@Override
	protected String getName() {
		return "br";
	}

	@Override
	protected Map<String, String> getSpecificAttributesMap() {
		return new LinkedHashMap<String, String>();
	}

	@Override
	protected List<Class<? extends Element<?>>> getSupportedElements() {
		return Arrays.asList();
	}

	@Override
	protected Br getType() {
		return this;
	}
	
	@Override
	protected boolean hasEndTag() {
		return false;
	}

	@Override
	protected boolean isStringValuesSupported() {
		return false;
	}
}
