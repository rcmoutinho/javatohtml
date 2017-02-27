# JAVA to HTML

[![Build Status][travis img]][travis]
[![Release][release img]][release]
[![License][license img]][license]
[![Donate][donate img]][donate]

Write **JAVA** code and get **HTML** without writing unreadable big *String*. Create report or email models easily. All implementation focus on HTML5 features but it's possible to create any other attribute/element (older or not implemented yet) if it's necessary.

## Code Example

Import ElementCreator and start making elements on the same way that HTML is written appending contents you need.

```JAVA
import static br.com.javatohtml.core.ElementCreator.*;

public class Main {
    public static void main(String[] args) {
        div().style("border:5px solid #aaa;padding:25px;margin:25px;text-align:center;")
        .append(
            h1("Foods").style("margin:0 0 25px;")
        ).append(
            img().alt("cupcake").classCss("candy")
                .src("https://cdn4.iconfinder.com/data/icons/miu/24/food-cupcake-muffin-dessert-birthday-glyph-128.png")
        ).append(
            img().alt("pizza").classCss("slice")
                .src("https://cdn4.iconfinder.com/data/icons/miu/24/food-pizza-fastfood-glyph-128.png")
        ).append(
            img().alt("bith cake").classCss("candy")
                .src("https://cdn4.iconfinder.com/data/icons/miu/24/food-birthday-cake-party-candle-glyph-128.png")
        ).toHtml();
    }
}
```

The **JAVA** code above will become this **HTML**:

```HTML
<div style="border: 5px solid #aaa; padding: 25px; margin: 25px; text-align: center;">
    <h1 style="margin: 0 0 25px;">Foods</h1>
    <img class="candy" alt="cupcake" src="https://cdn4.iconfinder.com/data/icons/miu/24/food-cupcake-muffin-dessert-birthday-glyph-128.png">
    <img class="slice" alt="pizza" src="https://cdn4.iconfinder.com/data/icons/miu/24/food-pizza-fastfood-glyph-128.png">
    <img class="candy" alt="bith cake" src="https://cdn4.iconfinder.com/data/icons/miu/24/food-birthday-cake-party-candle-glyph-128.png">
</div>
```

Need to use old tags or not implemented elements/attributes? Try this crazy one to understand how far you can go.

```JAVA
tag("dog").attr("breed", "German Shepherd").noEndTag().toHtml();
```

Just works:

```HTML
<dog breed="German Shepherd" />
```

An old HTML tag that is not supported anymore by HTML5:
```JAVA
tag("center").append("bye old tag").toHtml();
```
```HTML
<center>bye old tag</center>
```

## Ways to enjoy JavaToHtml API
* Take advantage of a compiled language to build HTML without weird bugs hard to find and fix
* Create email templates dynamically on a efficient way
* Create HTML reports without manipulating big and complex Strings
* Style the page with maped css classes and exports a single file HTML

**Note:** there is no intentions to compete with template engines, only build understandable and good looking code.

## Next Goals
* Deploy the project at maven central repository
* Create feature to translate simple mapped css classes on styles making easier to modify, understand and maintain the code
* Support the main tags: \<html>, \<head>, \<body>, \<link> and \<script>.
* Support new HTML5 tags like \<main>, \<article>, etc
* Create more examples of Email and Report templating
* Support other HTML5 tags

## API Reference and Unit Tests
You can run **mvn clean verify** to execute all tests and check the code quality. Thereby the site will be generated with the source and test API Reference, test converage, etc.

## Motivation
After years developing complex reports on HTML format and email models, I've decided to create an API that minimally respect W3C docs to compile and transform JAVA code into HTML.

[travis]:https://travis-ci.org/rcmoutinho/javatohtml
[travis img]:https://travis-ci.org/rcmoutinho/javatohtml.svg?branch=master

[release]:https://github.com/rcmoutinho/javatohtml/releases
[release img]:https://img.shields.io/github/release/rcmoutinho/javatohtml.svg

[license]:LICENSE
[license img]:https://img.shields.io/badge/License-Apache%202-blue.svg

[donate]:https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=6LFUJSNAGZ6WJ
[donate img]:https://img.shields.io/badge/Donate-PayPal-green.svg