package br.com.rcmoutinho.javatohtml.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.rcmoutinho.javatohtml.core.tag.Tag;

/**
 * Unit test for {@link Element}.
 * 
 * @rcmoutinho
 * @author rodrigo.moutinho
 * @date 31 de jan de 2017
 * @email rcm1989@gmail.com
 */
public class ElementTest {

	private Tag tag;
	private String tagName;

	@Test
	public void addingDataAttrInOrder() {

		this.tag.dataAttr("test1", "value1").dataAttr("test2", "value2");
		assertFalse(this.tag.dataAttr().isEmpty());

		String html = "<" + this.tagName + " data-test1=\"value1\" data-test2=\"value2\"></" + this.tagName + ">";
		assertEquals(html, this.tag.toHtml());
	}

	@Test
	public void appendInvalidValuesGenerateSimpleTag() {

		String string = null;
		this.tag.append(string);
		this.tag.append("");

		Element<?> element = null;
		this.tag.append(element);
		this.tag.appendTo(element);

		assertEquals("<" + this.tagName + "></" + this.tagName + ">", this.tag.toHtml());
	}

	@Before
	public void beforeTesting() {
		this.tagName = "tag";
		this.tag = new Tag(this.tagName);
	}

	@Test
	public void emptyAttrsGenerateSimpleTag() {
		this.tag.classCss("").dataAttr("", "").dir("").id("").lang("").style("").style("", "").tabindex(null).title("");

		assertTrue(this.tag.classCss().isEmpty());
		assertTrue(this.tag.dataAttr().isEmpty());
		assertTrue(this.tag.style().isEmpty());

		assertEquals("<" + this.tagName + "></" + this.tagName + ">", this.tag.toHtml());
	}

	@Test
	public void fullAttrsBuildedInOrder() {
		this.tag.classCss("test").dataAttr("test", "val").dir("#").id("#").lang("#").style("border: none;")
				.style("margin", "2px").tabindex(1).title("test");

		assertFalse(this.tag.classCss().isEmpty());
		assertFalse(this.tag.dataAttr().isEmpty());
		assertFalse(this.tag.style().isEmpty());

		assertEquals("<" + this.tagName
				+ " class=\"test\" data-test=\"val\" dir=\"#\" id=\"#\" lang=\"#\" style=\"border: none; margin: 2px;\" "
				+ "tabindex=\"1\" title=\"test\"></" + this.tagName + ">", this.tag.toHtml());
	}

	@Test
	public void prependInvalidValuesGenerateSimpleTag() {

		String string = null;
		this.tag.prepend(string);
		this.tag.prepend("");

		Element<?> element = null;
		this.tag.prepend(element);
		this.tag.prependTo(element);

		assertEquals("<" + this.tagName + "></" + this.tagName + ">", this.tag.toHtml());
	}

	@Test
	public void testAppendAndPrepend() {
		this.tag.append("3").prepend("2").append("4").prepend("1").append("5");
		assertEquals("<" + this.tagName + ">12345</" + this.tagName + ">", this.tag.toHtml());
	}

	@Test
	public void testAppendTo() {
		Tag outter = new Tag("outter");

		outter.append("content");
		new Tag("inner").appendTo(outter);

		assertEquals("<outter>content<inner></inner></outter>", outter.toHtml());
	}

	@Test
	public void testInvalidClass() {
		this.tag.classCss(new String[] {});

		String[] array = null;
		this.tag.classCss(array);

		assertTrue(this.tag.classCss().isEmpty());
	}

	@Test
	public void testPrependTo() {
		Tag outter = new Tag("outter");

		outter.append("content");
		new Tag("inner").prependTo(outter);

		assertEquals("<outter><inner></inner>content</outter>", outter.toHtml());
	}

	@Test
	public void testToStringSameAsToHtmlWithoutArgs() {
		this.tag.append("test").classCss("class").dataAttr("test", "val").style("border", "none");
		assertEquals(this.tag.toString(), this.tag.toHtml());
	}
}
