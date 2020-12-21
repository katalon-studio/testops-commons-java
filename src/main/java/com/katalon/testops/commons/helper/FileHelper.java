package com.katalon.testops.commons.helper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class FileHelper {

    public static void ensureDirectory(Path directory) {
        try {
            Files.createDirectories(directory);
        } catch (IOException e) {
            ExceptionHelper.wrap(e);
        }
    }

    public static List<Path> scanFiles(Path path, String filePattern) {
        try {
            return Files.walk(path)
                    .filter(Files::isRegularFile)
                    .filter(files -> {
                        String fileName = files.toFile().getName();
                        return fileName.matches(filePattern);
                    })
                    .collect(Collectors.toList());
        } catch (IOException e) {
            return ExceptionHelper.wrap(e);
        }
    }
}
