package com.javatohtml.examples;

import static com.javatohtml.core.ElementCreator.*;

import java.io.File;

import com.javatohtml.core.Element;
import com.javatohtml.core.tag.Div;

/**
 * Builds an email template.
 * 
 * @rcmoutinho
 * @author rodrigo.moutinho
 * @date 6 de fev de 2017
 * @email rcm1989@gmail.com
 */
public class TemplateEmail {

	/**
	 * Builds the email model.
	 * 
	 * @return
	 */
	public Element<?> createSampleEmail() {

		Div root = div().style("height:100%;margin:0;padding: 25px 0;width:100%;background-color:#fafafa;")
		.append(
			div().style("padding:15px;margin:auto;width:100%;max-width:600px !important;background-color: #ffffff;")
			.append(
				table().style("border-collapse:collapse;border-spacing:0;border:0;width:100%;")
				.append(
					tr()
					.append(
						td().style("text-align: center;")
						.append(
							img().src("https://cdn1.iconfinder.com/data/icons/business-and-finance-20/200/vector_65_06-128.png")
								.alt("Company Logo").style("margin: 10px 0; max-width: 240px;")
						)
					)
				).append(
					tr()
					.append(
						td().style("border-top:0;border-bottom:0;padding-top:9px;padding-bottom:9px")
						.append(hr().style("border-top-style: dotted;border-top-width: 2px;border-bottom: none;"))
					)
				).append(
					tr()
					.append(
						td().style("border-top:0;border-bottom:0;padding-top:9px;padding-bottom:9px;color: #202020;font-family: Helvetica;font-size: 16px;line-height: 150%;text-align: left;")
						.append(h1("What is Lorem Ipsum?"))
						.append(br())
						.append(strong("Lorem Ipsum")).append(" is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.")
						.append(br()).append(br())
						.append(h2("Where does it come from?"))
						.append("Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old.")
						.append(h1("..."))
					)
				)
			)
		).append(
			div().style("padding:15px;margin:auto;width:100%;max-width:600px !important;text-align:center;")
			.append(
				a().href("https://twitter.com/").style("margin:0 10px;")
				.append(img().src("https://cdn3.iconfinder.com/data/icons/capsocial-round/500/twitter-32.png").alt("Twitter"))
			)
			.append(
				a().href("https://www.facebook.com/").style("margin:0 10px;")
				.append(img().src("https://cdn3.iconfinder.com/data/icons/capsocial-round/500/facebook-32.png").alt("Facebook"))
			).append(
				hr().style("margin:20px 10px;")
			).append(
				div().style("color:#999999;font-family:Helvetica;font-size:.7em;line-height:150%;")
				.append("Não quer mais receber nossos emails?")
				.append(br())
				.append(a("Remova seu email").href("#").style("color:#777777;")).append(" de nossa lista.")
			)
		);
		
		return root;
	}

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		File htmlFile = new File(ExampleExport.BASE_EXAMPLE_PATH + "TemplateEmailCaelum.html");
		
		Element<?> email = new TemplateEmail().createSampleEmail();
		new ExampleExport().exportElementsToFileAndOpenDefaultBrowser(htmlFile, email);
	}
}
