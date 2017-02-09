package br.com.javatohtml.core.tag;

/**
 * Helps easy creation of tags.
 * 
 * @rcmoutinho
 * @author rodrigo.moutinho
 * @date 8 de fev de 2017
 * @email rcm1989@gmail.com
 */
public class JavaToHtml {

	/**
	 * Creates {@link A} element.
	 * 
	 * @return
	 */
	public static A a() {
		return new A();
	}

	/**
	 * Creates {@link Br} element.
	 * 
	 * @return
	 */
	public static Br br() {
		return new Br();
	}

	/**
	 * Creates {@link Div} element.
	 * 
	 * @return
	 */
	public static Div div() {
		return new Div();
	}

	/**
	 * Creates {@link Em} element.
	 * 
	 * @return
	 */
	public static Em em() {
		return new Em();
	}

	/**
	 * Creates {@link H1} element.
	 * 
	 * @return
	 */
	public static H1 h1() {
		return new H1();
	}

	/**
	 * Creates {@link H2} element.
	 * 
	 * @return
	 */
	public static H2 h2() {
		return new H2();
	}

	/**
	 * Creates {@link H3} element.
	 * 
	 * @return
	 */
	public static H3 h3() {
		return new H3();
	}

	/**
	 * Creates {@link Hr} element.
	 * 
	 * @return
	 */
	public static Hr hr() {
		return new Hr();
	}

	/**
	 * Creates {@link Img} element.
	 * 
	 * @return
	 */
	public static Img img() {
		return new Img();
	}

	/**
	 * Creates {@link P} element.
	 * 
	 * @return
	 */
	public static P p() {
		return new P();
	}

	/**
	 * Creates {@link Span} element.
	 * 
	 * @return
	 */
	public static Span span() {
		return new Span();
	}

	/**
	 * Creates {@link Strong} element.
	 * 
	 * @return
	 */
	public static Strong strong() {
		return new Strong();
	}

	/**
	 * Creates {@link Strong} element.
	 * 
	 * @param value
	 *            {@link String}
	 * @return
	 */
	public static Strong strong(String value) {
		return new Strong().append(value);
	}

	/**
	 * Creates {@link Table} element.
	 * 
	 * @return
	 */
	public static Table table() {
		return new Table();
	}

	/**
	 * Creates {@link Tag} element.
	 * 
	 * @param name
	 *            {@link String}
	 * @return
	 */
	public static Tag tag(String name) {
		return new Tag(name);
	}

	/**
	 * Creates {@link Tbody} element.
	 * 
	 * @return
	 */
	public static Tbody tbody() {
		return new Tbody();
	}

	/**
	 * Creates {@link Td} element.
	 * 
	 * @return
	 */
	public static Td td() {
		return new Td();
	}

	/**
	 * Creates {@link Td} element.
	 * 
	 * @param value
	 *            {@link String}
	 * @return
	 */
	public static Td td(String value) {
		return new Td().append(value);
	}

	/**
	 * Creates {@link Tfoot} element.
	 * 
	 * @return
	 */
	public static Tfoot tfoot() {
		return new Tfoot();
	}

	/**
	 * Creates {@link Th} element.
	 * 
	 * @return
	 */
	public static Th th() {
		return new Th();
	}

	/**
	 * Creates {@link Th} element.
	 * 
	 * @param value
	 *            {@link String}
	 * @return
	 */
	public static Th th(String value) {
		return new Th().append(value);
	}

	/**
	 * Creates {@link Thead} element.
	 * 
	 * @return
	 */
	public static Thead thead() {
		return new Thead();
	}

	/**
	 * Creates {@link Tr} element.
	 * 
	 * @return
	 */
	public static Tr tr() {
		return new Tr();
	}

	private JavaToHtml() {
	}
}
