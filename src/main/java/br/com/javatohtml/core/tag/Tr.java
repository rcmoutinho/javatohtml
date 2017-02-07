package br.com.javatohtml.core.tag;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import br.com.javatohtml.core.Element;

/**
 * The implementation of &lt;tr&gt;. <br>
 * <br>
 * Ref.: http://www.w3schools.com/tags/tag_tr.asp
 * 
 * @rcmoutinho
 * @author rodrigo.moutinho
 * @date 4 de out de 2016
 * @email rcm1989@gmail.com
 */
public class Tr extends Element<Tr> {

	@Override
	protected String getName() {
		return "tr";
	}

	@Override
	protected Map<String, String> getSpecificAttributesMap() {
		return new LinkedHashMap<String, String>();
	}

	@Override
	protected List<Class<? extends Element<?>>> getSupportedElements() {
		return Arrays.asList(Td.class, Th.class);
	}

	@Override
	protected Tr getType() {
		return this;
	}

	@Override
	protected boolean isStringValuesSupported() {
		return false;
	}
}
