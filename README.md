# JAVA to HTML
Write **JAVA** code and get **HTML** without writing unreadable big *String*. Create report or email models easily. All implementation focus on HTML5 features but it's possible to create any other attribute/element (older or not implemented yet) if it's necessary.

## Code Example

Import ElementCreator and start making elements on the same way that HTML is written appending contents you need.

```JAVA
import static br.com.javatohtml.core.ElementCreator.*;

public class Main {
    public static void main(String[] args) {
        div().style("border: 2px solid #000")
        .append(
            h1("My Gallery")
        ).append(
            img().src("img/java.jpg").classCss("language")
        ).append(
            img().src("img/html.jpg")
        ).toHtml();
    }
}
```

The **JAVA** code above will become this **HTML**:

```HTML
<div style="border: 2px solid #000;">
    <h1>My Gallery</h1>
    <img class="language" src="img/java.jpg" />
    <img src="img/html.jpg" />
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

## Ways to enjoy JavaToHtml API
* Take advantage of a compiled language to build HTML without weird bugs hard to find and fix
* Create email templates dynamically on a efficient way
* Create HTML reports without manipulating big and complex Strings
* Style the page with maped css classes and exports a single file HTML

**Note:** there is no intentions to compete with template engines, only build understandable and good looking code.

## Motivation
After years developing complex reports on HTML format and email models, I've decided to create an API that minimally respect W3C docs to compile and transform JAVA code into HTML.

## License
MIT Lincese