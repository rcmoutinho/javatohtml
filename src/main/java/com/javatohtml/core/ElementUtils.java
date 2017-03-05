package com.javatohtml.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.javatohtml.core.tag.A;
import com.javatohtml.core.tag.Br;
import com.javatohtml.core.tag.Div;
import com.javatohtml.core.tag.Em;
import com.javatohtml.core.tag.H1;
import com.javatohtml.core.tag.H2;
import com.javatohtml.core.tag.H3;
import com.javatohtml.core.tag.Hr;
import com.javatohtml.core.tag.Img;
import com.javatohtml.core.tag.P;
import com.javatohtml.core.tag.Span;
import com.javatohtml.core.tag.Strong;
import com.javatohtml.core.tag.Table;
import com.javatohtml.core.tag.Tag;
import com.javatohtml.core.tag.Tbody;
import com.javatohtml.core.tag.Td;
import com.javatohtml.core.tag.Tfoot;
import com.javatohtml.core.tag.Th;
import com.javatohtml.core.tag.Thead;
import com.javatohtml.core.tag.Tr;

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

	/**
	 * Returns all implemented tags.
	 * 
	 * @return
	 */
	public static List<Class<? extends Element<?>>> getAllImplementedElements() {
		return new ArrayList<Class<? extends Element<?>>>(ALL_IMPLEMENTED_ELEMENTS);
	}

	/**
	 * Returns all common supported tags. Do not includes specific tags
	 * supported from &lt;table&gt;.
	 * 
	 * @return
	 */
	public static List<Class<? extends Element<?>>> getCommonSupportedElements() {
		List<Class<? extends Element<?>>> commonSupported = getAllImplementedElements();

		// removing table specific elements
		commonSupported.remove(Tbody.class);
		commonSupported.remove(Td.class);
		commonSupported.remove(Tfoot.class);
		commonSupported.remove(Th.class);
		commonSupported.remove(Thead.class);
		commonSupported.remove(Tr.class);

		return commonSupported;
	}

	private ElementUtils() {
	}
}
