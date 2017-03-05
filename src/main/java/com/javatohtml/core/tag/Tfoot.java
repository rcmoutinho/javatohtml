package com.javatohtml.core.tag;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.javatohtml.core.Element;

/**
 * The implementation of &lt;tfoot&gt;. <br>
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
	protected List<Class<? extends Element<?>>> getSupportedElements() {
		return Arrays.asList(Tr.class);
	}

	@Override
	protected Tfoot getType() {
		return this;
	}

	@Override
	protected boolean isStringValuesSupported() {
		return false;
	}
}
