package br.com.rcmoutinho.javatohtml.core.tag;

import java.util.LinkedHashMap;
import java.util.Map;

import br.com.rcmoutinho.javatohtml.core.Element;

/**
 * The implementation of &lt;img&gt;. <br>
 * <br>
 * Ref.: http://www.w3schools.com/tags/tag_img.asp
 * 
 * @rcmoutinho
 * @author rodrigo.moutinho
 * @date 11 de jan de 2017
 * @email rcm1989@gmail.com
 */
public class Img extends Element<Img> {

	private String alt;
	private String height;
	private String src;
	private String width;

	@Override
	protected String getName() {
		return "img";
	}

	@Override
	protected Map<String, String> getSpecificAttributesMap() {
		Map<String, String> map = new LinkedHashMap<String, String>();

		if (this.alt != null)
			map.put("alt", this.alt);

		if (this.height != null)
			map.put("height", this.height);

		if (this.src != null)
			map.put("src", this.src);

		if (this.width != null)
			map.put("width", this.width);

		return map;
	}

	@Override
	protected Img getType() {
		return this;
	}

	/**
	 * Specifies an alternate text for an image.
	 * 
	 * @param alt
	 *            text
	 * @return {@link Img}
	 */
	public Img alt(String alt) {
		this.alt = alt;
		return this;
	}

	/**
	 * Specifies the height of an image.
	 * 
	 * @param height
	 *            pixels
	 * @return {@link Img}
	 */
	public Img height(String height) {
		this.height = height;
		return this;
	}

	/**
	 * Specifies the URL of an image.
	 * 
	 * @param src
	 *            URL
	 * @return {@link Img}
	 */
	public Img src(String src) {
		this.src = src;
		return this;
	}

	/**
	 * Specifies the width of an image.
	 * 
	 * @param width
	 *            pixels
	 * @return {@link Img}
	 */
	public Img width(String width) {
		this.width = width;
		return this;
	}
}
