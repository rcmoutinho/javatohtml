# JAVA to HTML
Write **JAVA** code and get **HTML** without writing unreadable big *String*. Create report or email models easily.

## Code Example

```JAVA
import static br.com.javatohtml.core.JavaToHtml.*;

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

```HTML
<div style="border: 2px solid #000;">
    <h1>My Gallery</h1>
    <img class="language" src="img/java.jpg" />
    <img src="img/html.jpg" />
</div>
```


## Motivation
After years developing complex reports on HTML format and email models, I've decided to create an API that minimally respect W3C docs to compile and transform JAVA code into HTML.

## License
MIT Lincese