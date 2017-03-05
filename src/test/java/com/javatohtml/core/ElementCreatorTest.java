package com.javatohtml.core;

import static com.javatohtml.core.ElementCreator.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.javatohtml.core.ElementCreator;

/**
 * Unit test for {@link ElementCreator}.
 * 
 * @rcmoutinho
 * @author rodrigo.moutinho
 * @date 8 de fev de 2017
 * @email rcm1989@gmail.com
 */
public class ElementCreatorTest {

	@Test
	public void testCreatingA() {
		assertEquals("<a></a>", a().toHtml());
		assertEquals("<a>text</a>", a("text").toHtml());
	}

	@Test
	public void testCreatingBr() {
		assertEquals("<br />", br().toHtml());
	}

	@Test
	public void testCreatingDiv() {
		assertEquals("<div></div>", div().toHtml());
	}

	@Test
	public void testCreatingEm() {
		assertEquals("<em></em>", em().toHtml());
		assertEquals("<em>text</em>", em("text").toHtml());
	}

	@Test
	public void testCreatingH1() {
		assertEquals("<h1></h1>", h1().toHtml());
		assertEquals("<h1>text</h1>", h1("text").toHtml());
	}

	@Test
	public void testCreatingh2() {
		assertEquals("<h2></h2>", h2().toHtml());
		assertEquals("<h2>text</h2>", h2("text").toHtml());
	}

	@Test
	public void testCreatingh3() {
		assertEquals("<h3></h3>", h3().toHtml());
		assertEquals("<h3>text</h3>", h3("text").toHtml());
	}

	@Test
	public void testCreatinghr() {
		assertEquals("<hr />", hr().toHtml());
	}

	@Test
	public void testCreatingImg() {
		assertEquals("<img />", img().toHtml());
	}

	@Test
	public void testCreatingP() {
		assertEquals("<p></p>", p().toHtml());
		assertEquals("<p>text</p>", p("text").toHtml());
	}

	@Test
	public void testCreatingSpan() {
		assertEquals("<span></span>", span().toHtml());
	}

	@Test
	public void testCreatingStrong() {
		assertEquals("<strong></strong>", strong().toHtml());
		assertEquals("<strong>text</strong>", strong("text").toHtml());
	}

	@Test
	public void testCreatingTable() {
		assertEquals("<table></table>", table().toHtml());
	}

	@Test
	public void testCreatingTag() {
		assertEquals("<name></name>", tag("name").toHtml());
	}

	@Test
	public void testCreatingTbody() {
		assertEquals("<tbody></tbody>", tbody().toHtml());
	}

	@Test
	public void testCreatingTd() {
		assertEquals("<td></td>", td().toHtml());
		assertEquals("<td>text</td>", td("text").toHtml());
		assertEquals("<td><span></span></td>", td(span()).toHtml());
	}

	@Test
	public void testCreatingTfoot() {
		assertEquals("<tfoot></tfoot>", tfoot().toHtml());
	}

	@Test
	public void testCreatingTh() {
		assertEquals("<th></th>", th().toHtml());
		assertEquals("<th>text</th>", th("text").toHtml());
		assertEquals("<th><span></span></th>", th(span()).toHtml());
	}

	@Test
	public void testCreatingThead() {
		assertEquals("<thead></thead>", thead().toHtml());
	}

	@Test
	public void testCreatingTr() {
		assertEquals("<tr></tr>", tr().toHtml());
	}
}
