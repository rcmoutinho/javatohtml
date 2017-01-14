package br.com.rcmoutinho.javatohtml.core.tag;

import java.util.LinkedHashMap;
import java.util.Map;

import br.com.rcmoutinho.javatohtml.core.Element;
import br.com.rcmoutinho.javatohtml.core.exception.UnsupportedTagException;

/**
 * The implementation of &lt;table&gt;. <br>
 * <br>
 * Ref.: http://www.w3schools.com/tags/tag_table.asp
 * 
 * @rcmoutinho
 * @author rodrigo.moutinho
 * @date 4 de out de 2016
 * @email rcm1989@gmail.com
 */
public class Table extends Element<Table> {

	@Override
	protected String getName() {
		return "table";
	}

	@Override
	protected Map<String, String> getSpecificAttributesMap() {
		return new LinkedHashMap<String, String>();
	}

	@Override
	protected Table getType() {
		return this;
	}
	
	@Override
	public Table append(Element<?> element) {
		
		if (element instanceof Thead || element instanceof Tbody || element instanceof Tfoot || element instanceof Tr)
			return super.append(element);
		
		throw new UnsupportedTagException("Element not supported");
	}
	
	@Override
	public Table append(String value) {
		throw new UnsupportedTagException("String not supported");
	}
	
	@Override
	public Table prepend(Element<?> element) {
		
		if (element instanceof Thead || element instanceof Tbody || element instanceof Tfoot || element instanceof Tr)
			return super.append(element);
		
		throw new UnsupportedTagException("Element not supported");
	}
	
	@Override
	public Table prepend(String value) {
		throw new UnsupportedTagException("String not supported");
	}
}
