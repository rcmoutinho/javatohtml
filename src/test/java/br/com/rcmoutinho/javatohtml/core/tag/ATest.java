package br.com.rcmoutinho.javatohtml.core.tag;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for {@link A}.
 * 
 * @rcmoutinho
 * @author rodrigo.moutinho
 * @date 15 de nov de 2016
 * @email rcm1989@gmail.com
 */
public class ATest {

	@Test
	public void emptyAttrsGenerateSimpleTag() {
		A a = new A().download("").href("").hrefLang("").media("").rel("").target("").type("");
		assertEquals("<a></a>", a.toHtml());
	}

	@Test
	public void fullAttrsBuildInOrder() {
		A a = new A().download("#").href("#").hrefLang("#").media("#").rel("#").target("#").type("#");
		assertEquals("<a download='#' href='#' hrefLang='#' media='#' rel='#' target='#' type='#'></a>", a.toHtml());
	}
	
	@Test
	public void tagContentWithHref() {
		A a = new A().href("#anchor").append("testing");
		assertEquals("<a href='#anchor'>testing</a>", a.toHtml());
	}
}
