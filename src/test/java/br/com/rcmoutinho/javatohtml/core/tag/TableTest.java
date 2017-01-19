package br.com.rcmoutinho.javatohtml.core.tag;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.rcmoutinho.javatohtml.core.Element;
import br.com.rcmoutinho.javatohtml.core.ElementUtils;
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

	private String theadToHtml;
	private String tbodyToHtml;
	private String tfootToHtml;
	private String trToHtml;
	private List<Class<? extends Element<?>>> notSupportedElements;

	@Before
	public void beforeTesting() {

		this.theadToHtml = "<table><thead></thead></table>";
		this.tbodyToHtml = "<table><tbody></tbody></table>";
		this.tfootToHtml = "<table><tfoot></tfoot></table>";
		this.trToHtml = "<table><tr></tr></table>";

		this.notSupportedElements = new ArrayList<Class<? extends Element<?>>>(
				ElementUtils.getAllImplementedElements());

		// removes supported elements
		this.notSupportedElements.remove(Thead.class);
		this.notSupportedElements.remove(Tbody.class);
		this.notSupportedElements.remove(Tfoot.class);
		this.notSupportedElements.remove(Tr.class);
	}

	@Test
	public void checkSupportedElementsToAppend() {
		assertEquals(this.theadToHtml, new Table().append(new Thead()).toHtml());
		assertEquals(this.tbodyToHtml, new Table().append(new Tbody()).toHtml());
		assertEquals(this.tfootToHtml, new Table().append(new Tfoot()).toHtml());
		assertEquals(this.trToHtml, new Table().append(new Tr()).toHtml());
	}

	@Test
	public void checkSupportedElementsToPrepend() {
		assertEquals(this.theadToHtml, new Table().prepend(new Thead()).toHtml());
		assertEquals(this.tbodyToHtml, new Table().prepend(new Tbody()).toHtml());
		assertEquals(this.tfootToHtml, new Table().prepend(new Tfoot()).toHtml());
		assertEquals(this.trToHtml, new Table().prepend(new Tr()).toHtml());
	}

	@Test
	public void checkUnsupportedElementsToAppend() {
		int unsupportedTagCount = new ElementTester().countUnsupportedTagExceptionToAppend(new Table(),
				this.notSupportedElements);

		assertEquals(unsupportedTagCount, this.notSupportedElements.size());
	}

	@Test
	public void checkUnsupportedElementsToPrepend() {
		int unsupportedTagCount = new ElementTester().countUnsupportedTagExceptionToPrepend(new Table(),
				this.notSupportedElements);

		assertEquals(unsupportedTagCount, this.notSupportedElements.size());
	}

	@Test(expected = UnsupportedTagException.class)
	public void checkUnsupportedStringToAppend() {
		new Table().append("text");
	}

	@Test(expected = UnsupportedTagException.class)
	public void checkUnsupportedStringToPrepend() {
		new Table().prepend("text");
	}
}
