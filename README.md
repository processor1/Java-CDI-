# Java-CDI-
CDI (contexts and dependency injection) is a dependency injection (DI) specification bundled with Java EE 6 and higher. It implements an annotation-based DI framework, making it easier to fully automate dependency management and letting developers focus on coding, rather than dealing with DI in all its different slants.  DI is one of the most ubiquitous forms of inversion of control used in object-oriented design. But this doesn’t imply that implementing the pattern manually is inherently easy, as it always requires explicitly implementing some kind of creational pattern, such as factories or builders as the underlying injectors.

Easy Dependency Injection with CDI
DI per se becomes a necessity when it comes to designing decoupled components based on several polymorphic implementations. The typical use case is having a segregated contract, defined through an interface or an abstract class, and multiple implementations, where one or more of these must be injected into a client object at runtime.

Creating an injection point
Consider the following example, which is part of a naive application that processes a given string in a few basic ways:

public interface TextProcessor {

    String processText(String text);

}
The API for processing strings is so basic that it doesn’t deserve any further analysis. So, here are the corresponding implementations:

public class LowerCaseTextProcessor implements TextProcessor {

    public String processText(String text) {
        return text.toLowerCase();
    }

}

public class UppercaseTextProcessor implements TextProcessor {

    public String processText(String text) {
        return text.toUpperCase();
    }

}

public class ReverseTextProcessor implements TextProcessor {

    public String processText(String text) {
        return new StringBuilder(text).reverse().toString();
    }

}
At this point, we’ve created three simple implementations, whose functionality boils down to lowercasing, uppercasing and reversing a given string.

Now, suppose we want to inject at runtime an instance of these classes into a client object, in order to process a string entered in the console. In such a case, first we’d need to define a class similar to this one:

public class TextApplication {

    private TextProcessor textProcessor;
    private BufferedReader userInputReader;

    @Inject
    public TextApplication(TextProcessor textProcessor) {
        this.textProcessor = textProcessor;
        this.userInputReader =
                new BufferedReader(new InputStreamReader(System.in));
    }

    public void run() throws IOException {
        System.out.println("Enter the text to process : ");
        String text = userInputReader.readLine();
        System.out.println(textProcessor.processText(text));
    }

}
Asides from the evil new operator I used to create a BufferedReader object (bear with me for now, as I’ll refactor it later), the first thing worth pointing out here is the use of the @Inject annotation, which tells CDI that an instance of the TextProcessor interface must be injected into the class’ constructor. This is vanilla constructor injection made easy!

Bootstrapping Weld
Well, not so easy. First we need to download the Weld artifact – here it is for Maven:

<dependency>
    <groupId>org.jboss.weld.se</groupId>
    <artifactId>weld-se</artifactId>
    <version>2.4.0.Final</version>
</dependency>
With the Weld artifact in place, we must create a beans.xml file in the src/main/java/resources/META-INF/ directory, as CDI needs to scan this file, even if it doesn’t contain additional injection options. At its bare bones, here’s how a typical version of this file might look:

<?xml version="1.0" encoding="UTF-8"?>
<beans
        xmlns="http://xmlns.jcp.org/xml/ns/javaee"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
                      http://xmlns.jcp.org/xml/ns/javaee/beans_1_1.xsd"
        bean-discovery-mode="all">
</beans>
Next, we must programmatically bootstrap Weld, grab an instance of the TextApplication class from the Weld container, and finally start using it at will, as follows:

public class Main {

    public static void main(String[] args) throws IOException {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        TextApplication textApplication =
                container.instance().select(TextApplication.class).get();
        textApplication.run();
        weld.shutdown();
    }

}
