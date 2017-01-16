package br.com.rcmoutinho.javatohtml.core.tag;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import br.com.rcmoutinho.javatohtml.core.Element;

/**
 * The implementation of &lt;h2&gt;. <br>
 * <br>
 * Ref.: http://www.w3schools.com/tags/tag_hn.asp
 * 
 * @rcmoutinho
 * @author rodrigo.moutinho
 * @date 11 de jan de 2017
 * @email rcm1989@gmail.com
 */
public class H2 extends Element<H2> {

	@Override
	protected String getName() {
		return "h2";
	}

	@Override
	protected Map<String, String> getSpecificAttributesMap() {
		return new LinkedHashMap<String, String>();
	}

	@Override
	protected List<Class<? extends Element<?>>> getSupportedElements() {
		return Arrays.asList(A.class, Br.class, Em.class, Strong.class, Tag.class);
	}

	@Override
	protected H2 getType() {
		return this;
	}
}
