package br.com.javatohtml.core.tag;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import br.com.javatohtml.core.Element;

/**
 * The implementation of &lt;em&gt;. <br>
 * <br>
 * Ref.: http://www.w3schools.com/tags/tag_em.asp
 * 
 * @rcmoutinho
 * @author rodrigo.moutinho
 * @date 11 de jan de 2017
 * @email rcm1989@gmail.com
 */
public class Em extends Element<Em> {

	@Override
	protected String getName() {
		return "em";
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
	protected Em getType() {
		return this;
	}
}
