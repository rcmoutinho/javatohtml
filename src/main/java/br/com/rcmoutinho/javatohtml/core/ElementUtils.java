package br.com.rcmoutinho.javatohtml.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import br.com.rcmoutinho.javatohtml.core.tag.A;
import br.com.rcmoutinho.javatohtml.core.tag.Br;
import br.com.rcmoutinho.javatohtml.core.tag.Div;
import br.com.rcmoutinho.javatohtml.core.tag.Em;
import br.com.rcmoutinho.javatohtml.core.tag.H1;
import br.com.rcmoutinho.javatohtml.core.tag.H2;
import br.com.rcmoutinho.javatohtml.core.tag.H3;
import br.com.rcmoutinho.javatohtml.core.tag.Hr;
import br.com.rcmoutinho.javatohtml.core.tag.Img;
import br.com.rcmoutinho.javatohtml.core.tag.P;
import br.com.rcmoutinho.javatohtml.core.tag.Span;
import br.com.rcmoutinho.javatohtml.core.tag.Strong;
import br.com.rcmoutinho.javatohtml.core.tag.Table;
import br.com.rcmoutinho.javatohtml.core.tag.Tag;
import br.com.rcmoutinho.javatohtml.core.tag.Tbody;
import br.com.rcmoutinho.javatohtml.core.tag.Td;
import br.com.rcmoutinho.javatohtml.core.tag.Tfoot;
import br.com.rcmoutinho.javatohtml.core.tag.Th;
import br.com.rcmoutinho.javatohtml.core.tag.Thead;
import br.com.rcmoutinho.javatohtml.core.tag.Tr;

/**
 * Helper methods for working with {@link Element}.
 * 
 * @rcmoutinho
 * @author rodrigo.moutinho
 * @date 17 de jan de 2017
 * @email rcm1989@gmail.com
 */
public class ElementUtils {

	private static List<Class<? extends Element<?>>> ALL_IMPLEMENTED_ELEMENTS = Arrays.asList(A.class, Br.class,
			Div.class, Em.class, H1.class, H2.class, H3.class, Hr.class, Img.class, P.class, Span.class, Strong.class,
			Table.class, Tag.class, Tbody.class, Td.class, Tfoot.class, Th.class, Thead.class, Tr.class);

	private ElementUtils() {
	}

	/**
	 * Returns all common supported tags. Do not includes specific tags
	 * supported from &lt;table&gt;.
	 * 
	 * @return
	 */
	public static List<Class<? extends Element<?>>> getCommonSupportedElements() {
		List<Class<? extends Element<?>>> commonSupported = new ArrayList<Class<? extends Element<?>>>(ALL_IMPLEMENTED_ELEMENTS);
		
		// removing table specific elements
		commonSupported.remove(Tbody.class);
		commonSupported.remove(Td.class);
		commonSupported.remove(Tfoot.class);
		commonSupported.remove(Th.class);
		commonSupported.remove(Thead.class);
		commonSupported.remove(Tr.class);
		
		return Collections.unmodifiableList(commonSupported);
	}

	/**
	 * Returns all implemented tags.
	 * 
	 * @return
	 */
	public static List<Class<? extends Element<?>>> getAllImplementedElements() {
		return Collections.unmodifiableList(ALL_IMPLEMENTED_ELEMENTS);
	}
}
