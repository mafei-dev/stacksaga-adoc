/*
package org.stacksaga.doc;
import org.asciidoctor.Asciidoctor;
import org.asciidoctor.Options;
import org.asciidoctor.ast.Document;

public class AsciidoctorExample {
    public static void main(String[] args) {
        // Initialize Asciidoctor
        Asciidoctor asciidoctor = Asciidoctor.Factory.create();

        // Source content in Asciidoc format
        String sourceContent = "= My Document Title\n\n" +
                "== Section 1\n\nSome content in section 1\n\n" +
                "== Section 2\n\nSome content in section 2";

        // Convert Asciidoc source to Document object
        Document document = asciidoctor.load(sourceContent, new Options());

        // Generate TOC (Table of Contents)
//        String toc = document.getStructuralNode().convert();

        // Generate HTML content from Asciidoc source
        String content = asciidoctor.convert(sourceContent, new Options());

        // Close Asciidoctor
        asciidoctor.shutdown();

        // Now you have 'toc' and 'content' strings
        // You can proceed to insert these strings into your HTML template
    }
}
*/
