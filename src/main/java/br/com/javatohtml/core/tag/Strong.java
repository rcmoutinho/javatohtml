package br.com.javatohtml.core.tag;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import br.com.javatohtml.core.Element;

/**
 * The implementation of &lt;strong&gt;. <br>
 * <br>
 * Ref.: http://www.w3schools.com/tags/tag_strong.asp
 * 
 * @rcmoutinho
 * @author rodrigo.moutinho
 * @date 11 de jan de 2017
 * @email rcm1989@gmail.com
 */
public class Strong extends Element<Strong> {

	/**
	 * Creates the {@link Strong} element.
	 */
	public Strong() {
	}

	/**
	 * Creates a {@link Strong} with a {@link String}.
	 * 
	 * @param value
	 */
	public Strong(String value) {
		this.append(value);
	}

	@Override
	protected String getName() {
		return "strong";
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
	protected Strong getType() {
		return this;
	}
}
