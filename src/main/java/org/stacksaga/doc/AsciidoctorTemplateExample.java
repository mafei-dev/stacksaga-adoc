package org.stacksaga.doc;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.Options;
import org.asciidoctor.ast.Document;
import org.asciidoctor.ast.DocumentHeader;

import java.io.File;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class AsciidoctorTemplateExample {
    public static void main(String[] args) {
        Asciidoctor asciidoctor = Asciidoctor.Factory.create();

        DocumentHeader documentHeader = asciidoctor.readDocumentHeader(new File("./src/main/resources/content/content1.adoc"));
        System.out.println("documentHeader = " + documentHeader);
        // Load the AsciiDoc file
        Document document = asciidoctor.loadFile(new File("./src/main/resources/content/content1.adoc"), new HashMap<>());

        // Render the AsciiDoc content using the template
        String templateContent = new String(asciidoctor.convert(String.valueOf(document), Options.builder()
                .templateDir(Paths.get("./src/main/resources/template.html").toFile())
                .templateEngine("asciidoctor")
                .get()));

        System.out.println(templateContent);

        asciidoctor.shutdown();
    }
}
