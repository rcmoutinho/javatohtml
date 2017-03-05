package com.javatohtml.core.tag;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.javatohtml.core.Element;
import com.javatohtml.core.ElementUtils;

/**
 * The implementation of a custom tag, &lt;???&gt;. Useful for the newest tags
 * not supported yet or for the old HTML 4.01 tags.
 * 
 * @rcmoutinho
 * @author rodrigo.moutinho
 * @date 11 de jan de 2017
 * @email rcm1989@gmail.com
 */
public class Tag extends Element<Tag> {

	private String name;
	private boolean endTag = true;
	private Map<String, String> customAttr = new LinkedHashMap<String, String>();

	/**
	 * Define the tag name.
	 * 
	 * @param name
	 *            {@link String}
	 */
	public Tag(String name) {

		if (StringUtils.isBlank(name))
			throw new RuntimeException("This dynamic tag must have a name");

		this.name = name;
	}

	@Override
	protected String getName() {
		return this.name;
	}

	@Override
	protected Map<String, String> getSpecificAttributesMap() {
		Map<String, String> customAttr = new LinkedHashMap<String, String>();

		for (String attr : this.customAttr.keySet()) {
			String value = this.customAttr.get(attr);

			if (StringUtils.isNotBlank(value))
				customAttr.put(attr, value);
		}

		return customAttr;
	}

	@Override
	protected List<Class<? extends Element<?>>> getSupportedElements() {
		return ElementUtils.getCommonSupportedElements();
	}

	@Override
	protected Tag getType() {
		return this;
	}

	@Override
	protected boolean hasEndTag() {
		return this.endTag;
	}

	/**
	 * Adds an attribute and your value. If the attribute already exists, the
	 * value will be overridden.
	 * 
	 * @param attr
	 * @param value
	 * @return {@link Tag}
	 */
	public Tag attr(String attr, String value) {

		if (StringUtils.isNotBlank(attr))
			this.customAttr.put(attr, value);

		return this;
	}

	/**
	 * Verifies that the attribute already exists.
	 * 
	 * @param attr
	 * @return {@link Boolean}
	 */
	public boolean hasAttr(String attr) {
		return this.customAttr.get(attr) != null;
	}

	/**
	 * Defines this dynamic tag with no end tag.
	 * 
	 * @return {@link Tag}
	 */
	public Tag noEndTag() {
		this.endTag = false;

		return this;
	}

	/**
	 * Removes the attribute.
	 * 
	 * @param attr
	 * @return
	 */
	public Tag removeAttr(String attr) {
		this.customAttr.remove(attr);
		return this;
	}
}
