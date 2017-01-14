package br.com.rcmoutinho.javatohtml.core.tag;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.rcmoutinho.javatohtml.core.exception.UnsupportedTagException;

/**
 * Unit test for {@link Table}.
 * 
 * @rcmoutinho
 * @author rodrigo.moutinho
 * @date 10 de jan de 2017
 * @email rcm1989@gmail.com
 */
public class TableTest {

	@Test
	public void allSupportedElements() {
		String thead = "<table><thead></thead></table>";
		String tbody = "<table><tbody></tbody></table>";
		String tfoot = "<table><tfoot></tfoot></table>";
		String tr = "<table><tr></tr></table>";

		// append
		assertEquals(thead, new Table().append(new Thead()).toHtml());
		assertEquals(tbody, new Table().append(new Tbody()).toHtml());
		assertEquals(tfoot, new Table().append(new Tfoot()).toHtml());
		assertEquals(tr, new Table().append(new Tr()).toHtml());

		// prepend
		assertEquals(thead, new Table().prepend(new Thead()).toHtml());
		assertEquals(tbody, new Table().prepend(new Tbody()).toHtml());
		assertEquals(tfoot, new Table().prepend(new Tfoot()).toHtml());
		assertEquals(tr, new Table().prepend(new Tr()).toHtml());
	}

	@Test(expected = UnsupportedTagException.class)
	public void doNotSupportAppendString() {
		assertEquals("<table>text</table>", new Table().append("text").toHtml());
	}

	@Test(expected = UnsupportedTagException.class)
	public void doNotSupportPrependString() {
		assertEquals("<table>text</table>", new Table().prepend("text").toHtml());
	}

	@Test(expected = UnsupportedTagException.class)
	public void doNotSupportAppendOtherElement() {
		assertEquals("<table><tag></tag></table>", new Table().append(new Tag("tag")).toHtml());
	}

	@Test(expected = UnsupportedTagException.class)
	public void doNotSupportPrependOtherElement() {
		assertEquals("<table><tag></tag></table>", new Table().prepend(new Tag("tag")).toHtml());
	}

}
