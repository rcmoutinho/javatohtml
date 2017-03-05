package com.javatohtml.core.tag;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.javatohtml.core.Element;

/**
 * The implementation of &lt;thead&gt;. <br>
 * <br>
 * Ref.: http://www.w3schools.com/tags/tag_thead.asp
 * 
 * @rcmoutinho
 * @author rodrigo.moutinho
 * @date 10 de jan de 2017
 * @email rcm1989@gmail.com
 */
public class Thead extends Element<Thead> {

	@Override
	protected String getName() {
		return "thead";
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
	protected Thead getType() {
		return this;
	}

	@Override
	protected boolean isStringValuesSupported() {
		return false;
	}
}
