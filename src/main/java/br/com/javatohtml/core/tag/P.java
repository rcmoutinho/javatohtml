package br.com.javatohtml.core.tag;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import br.com.javatohtml.core.Element;
import br.com.javatohtml.core.ElementUtils;

/**
 * The implementation of &lt;p&gt;. <br>
 * <br>
 * Ref.: http://www.w3schools.com/tags/tag_p.asp
 * 
 * @rcmoutinho
 * @author rodrigo.moutinho
 * @date 11 de jan de 2017
 * @email rcm1989@gmail.com
 */
public class P extends Element<P> {

	@Override
	protected String getName() {
		return "p";
	}

	@Override
	protected Map<String, String> getSpecificAttributesMap() {
		return new LinkedHashMap<String, String>();
	}

	@Override
	protected List<Class<? extends Element<?>>> getSupportedElements() {
		return ElementUtils.getCommonSupportedElements();
	}

	@Override
	protected P getType() {
		return this;
	}
}
