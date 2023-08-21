package org.stacksaga.doc;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.Options;
import org.asciidoctor.OptionsBuilder;
import org.asciidoctor.SafeMode;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static org.asciidoctor.OptionsBuilder.options;

public class AsciidoctorGenerateHtml {
    public static void main(String[] args) {
        Asciidoctor asciidoctor = Asciidoctor.Factory.create();
        Map<String, Object> options = options().safe(SafeMode.SAFE).backend("html5")
                .asMap();

        String outfile = asciidoctor.convertFile(new File("./src/main/resources/content/content.adoc"), options);
        System.out.println("outfile = " + outfile);
        asciidoctor.shutdown();
    }
}
