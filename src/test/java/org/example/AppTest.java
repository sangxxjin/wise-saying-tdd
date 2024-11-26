package org.example;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;
import org.example.standard.uttil.TestUtil;

public class AppTest {

    public static String run(String input) {
        input = input.stripIndent().trim();
        Scanner scanner = TestUtil.getScanner(input+"\n종료");
        ByteArrayOutputStream outputStream = TestUtil.setOutToByteArray();
        App app = new App(scanner);
        app.run();
        String output = outputStream.toString();
        TestUtil.clearSetOutToByteArray(outputStream);
        return output;
    }

}
