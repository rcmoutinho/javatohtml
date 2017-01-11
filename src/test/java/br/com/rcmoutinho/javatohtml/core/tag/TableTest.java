package br.com.rcmoutinho.javatohtml.core.tag;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

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
	public void setAllSupportedElements() {
		Table table = new Table();

		table.append(new Thead());
		table.append(new Tbody());
		table.append(new Tfoot());
		table.append(new Tr());

		assertTrue(true);
	}

}
