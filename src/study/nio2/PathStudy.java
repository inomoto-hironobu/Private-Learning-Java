package site.saishin.study.java8.nio2;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathStudy {
    public static void main(String... args) {
        Path user =  Paths.get(System.getProperty("user.home"));
        Files.exists(user);
    }
}
