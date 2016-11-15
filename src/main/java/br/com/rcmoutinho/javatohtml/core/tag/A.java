package br.com.rcmoutinho.javatohtml.core.tag;

import java.util.LinkedHashMap;
import java.util.Map;

import br.com.rcmoutinho.javatohtml.core.Element;

/**
 * Implementação da tag HTML &lt;a&gt;. <br>
 * <br>
 * Ref.: http://www.w3schools.com/tags/tag_a.asp
 * 
 * @rcmoutinho
 * @author rodrigo.moutinho
 * @date 4 de out de 2016
 * @email rcm1989@gmail.com
 */
public class A extends Element<A> {

	private String download;
	private String href;
	private String hrefLang;
	private String media;
	private String rel;
	private String target;
	private String type;

	@Override
	protected String getName() {
		return "a";
	}

	@Override
	protected A getType() {
		return this;
	}

	@Override
	protected Map<String, String> getSpecificAttributesMap() {
		Map<String, String> map = new LinkedHashMap<String, String>();

		if (this.download != null)
			map.put("download", this.download);

		if (this.href != null)
			map.put("href", this.href);

		if (this.hrefLang != null)
			map.put("hrefLang", this.hrefLang);

		if (this.media != null)
			map.put("media", this.media);

		if (this.rel != null)
			map.put("rel", this.rel);

		if (this.target != null)
			map.put("target", this.target);

		if (this.type != null)
			map.put("type", this.type);

		return map;
	}

	/**
	 * Specifies that the target will be downloaded when a user clicks on the
	 * hyperlink.
	 * 
	 * @param download
	 *            filename
	 * @return {@link A}
	 * @category HTML5
	 */
	public A download(String download) {
		this.download = download;
		return this;
	}

	/**
	 * Specifies the URL of the page the link goes to.
	 * 
	 * @param href
	 *            URL
	 * @return {@link A}
	 */
	public A href(String href) {
		this.href = href;
		return this;
	}

	/**
	 * Specifies the language of the linked document.
	 * 
	 * @param hrefLang
	 *            language_code
	 * @return {@link A}
	 */
	public A hrefLang(String hrefLang) {
		this.hrefLang = hrefLang;
		return this;
	}

	/**
	 * Specifies what media/device the linked document is optimized for.
	 * 
	 * @param media
	 *            media_query
	 * @return {@link A}
	 * @category HTML5
	 */
	public A media(String media) {
		this.media = media;
		return this;
	}

	/**
	 * Specifies the relationship between the current document and the linked
	 * document.
	 * 
	 * @param rel
	 *            alternate author bookmark external help license next nofollow
	 *            noreferrer noopener prev search tag
	 * @return {@link A}
	 */
	public A rel(String rel) {
		this.rel = rel;
		return this;
	}

	/**
	 * Specifies where to open the linked document.
	 * 
	 * @param target
	 *            _blank _parent _self _top framename
	 * @return {@link A}
	 */
	public A target(String target) {
		this.target = target;
		return this;
	}

	/**
	 * Specifies the media type of the linked document.
	 * 
	 * @param type
	 *            media_type
	 * @return {@link A}
	 */
	public A type(String type) {
		this.type = type;
		return this;
	}
}
