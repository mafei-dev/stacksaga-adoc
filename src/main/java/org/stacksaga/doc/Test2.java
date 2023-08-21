package org.stacksaga.doc;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.AttributesBuilder;
import org.asciidoctor.Options;
import org.asciidoctor.OptionsBuilder;
import org.asciidoctor.ast.Document;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static org.asciidoctor.SafeMode.UNSAFE;

public class Test2 {
    public static void main(String[] args) {
        // Initialize Asciidoctor
        Asciidoctor asciidoctor = Asciidoctor.Factory.create();

        // Read your AsciiDoc files
        String[] asciidocFiles = {"./src/main/resources/content/content1.adoc"};

       /* // Load your template
        String template;
        try {
            template = new String(Files.readAllBytes(Paths.get("./src/main/resources/content/template1.html")));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
*/

        // Iterate through AsciiDoc files
        for (String asciidocFile : asciidocFiles) {

//            Map<String, Object> options = new HashMap<>();
//            options.put(Options.PARSE_HEADER_ONLY, true);

/*            Document document = asciidoctor.loadFile(new File(asciidocFile), options);

            Object o = document.getAttributes().get("toc");*/
//            System.out.println("o : " + o);

            Map<String, Object> options = new HashMap<>();
            options.put("toc", "left");

            /*Document document = asciidoctor.loadFile(new File(asciidocFile), options);
            document.getBlocks().forEach(structuralNode -> {
                System.out.println("structuralNode = " + structuralNode.getContent());
            });*/

            Options base = OptionsBuilder.options()
                    .headerFooter(true)
                    .docType("backend")
                    .backend("html5")
                    .toFile(false)
                    .safe(UNSAFE)
                    .get();


            String baseHtml = asciidoctor.convertFile(
                    new File(asciidocFile),
                    base
            );

            System.out.println("baseHtml = " + baseHtml);

        }

        // Shut down Asciidoctor
        asciidoctor.shutdown();
    }

}
