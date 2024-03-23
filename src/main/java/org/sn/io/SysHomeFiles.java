package org.sn.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class SysHomeFiles {
    private static String HOME = System.getProperty("user.home");
    static String whitespace_chars =  ""       /* dummy empty string for homogeneity */
            + "\\u0009" // CHARACTER TABULATION
            + "\\u000A" // LINE FEED (LF)
            + "\\u000B" // LINE TABULATION
            + "\\u000C" // FORM FEED (FF)
            + "\\u000D" // CARRIAGE RETURN (CR)
            + "\\u0020" // SPACE
            + "\\u0085" // NEXT LINE (NEL)
            + "\\u00A0" // NO-BREAK SPACE
            + "\\u1680" // OGHAM SPACE MARK
            + "\\u180E" // MONGOLIAN VOWEL SEPARATOR
            + "\\u2000" // EN QUAD
            + "\\u2001" // EM QUAD
            + "\\u2002" // EN SPACE
            + "\\u2003" // EM SPACE
            + "\\u2004" // THREE-PER-EM SPACE
            + "\\u2005" // FOUR-PER-EM SPACE
            + "\\u2006" // SIX-PER-EM SPACE
            + "\\u2007" // FIGURE SPACE
            + "\\u2008" // PUNCTUATION SPACE
            + "\\u2009" // THIN SPACE
            + "\\u200A" // HAIR SPACE
            + "\\u2028" // LINE SEPARATOR
            + "\\u2029" // PARAGRAPH SEPARATOR
            + "\\u202F" // NARROW NO-BREAK SPACE
            + "\\u205F" // MEDIUM MATHEMATICAL SPACE
            + "\\u3000" // IDEOGRAPHIC SPACE
            ;
    /* A \s that actually works for Java’s native character set: Unicode */
    static String     whitespace_charclass = "["  + whitespace_chars + "]";

    public static void readFiles() throws Exception{
        Path homePath = Path.of(HOME+"/logs");
        Stream<Path> pths=Files.walk(homePath);
        pths.filter(Files::isRegularFile).forEach((Path p)-> {
            File f= p.toFile();
            try {
                BufferedReader fs = Files.newBufferedReader(p);
                fs.lines().forEach((String s)->{
                    String[] st= s.split(whitespace_charclass);
                    Arrays.asList(st).forEach((String sd)->{
                        System.out.println(sd);
                    });

                });
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
    public static void main(String[] args){
        try {
//           // readFiles();
//            var x = 45;
//            Executors.newSingleThreadExecutor().submit(()->{
//                try{
//                    readFiles();
//                }catch (Exception e) {
//                    throw new RuntimeException(e);
//                }
//            });
           // SysHomeFiles sysHomeFiles =new SysHomeFiles();
            NumX<Integer> a = new NumX<>();
            a.write(10);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static class NumX<T extends Number>{
        void write(T a){
            System.out.println(a);
        }

    }
}
