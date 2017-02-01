package br.com.rcmoutinho.javatohtml.core;

import static org.junit.Assert.assertEquals;

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

	@Before
	public void beforeTesting() {
		this.tagName = "tag";
		this.tag = new Tag(this.tagName);
	}

	@Test
	public void addingDataAttrInOrder() {

		this.tag.dataAttr("test1", "value1").dataAttr("test2", "value2");

		String html = "<" + this.tagName + " data-test1=\"value1\" data-test2=\"value2\"></" + this.tagName + ">";
		assertEquals(html, this.tag.toHtml());
	}
}
