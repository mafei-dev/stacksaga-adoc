package org.stacksaga.doc;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.asciidoctor.Asciidoctor;
import org.asciidoctor.OptionsBuilder;
import org.asciidoctor.SafeMode;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws IOException {
        Asciidoctor asciidoctor = Asciidoctor.Factory.create();

        String content1 = asciidoctor.convertFile(new File("./src/main/resources/content/content1.adoc"),
                OptionsBuilder.options().safe(SafeMode.UNSAFE).toFile(false).backend("html5").get()
        );
        System.out.println("Content1 HTML: " + content1);

        String template = loadResourceFile("template.html");
        template = template.replace("{{content}}", content1);

        FileUtils.writeStringToFile(new File("./src/main/resources/final_document.html"), template, "UTF-8");

        asciidoctor.shutdown();

    }

    private static String loadResourceFile(String fileName) throws IOException {
        try (InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(fileName)) {
            if (inputStream != null) {
                return IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            } else {
                throw new IOException("Resource not found: " + fileName);
            }
        }
    }


}