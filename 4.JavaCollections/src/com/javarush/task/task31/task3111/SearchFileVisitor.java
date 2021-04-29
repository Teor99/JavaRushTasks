package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {

    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;
    private List<Path> foundFiles = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        boolean a = isPassMinSizeConstrains(attrs);
        boolean b = isPassMaxSizeConstrains(attrs);
        boolean c = isPassPartOfNameConstrains(file);
        boolean d = isPassPartOfContentConstrains(file);

        if (a && b && c && d) foundFiles.add(file);

        return super.visitFile(file, attrs);
    }

    private boolean isPassPartOfContentConstrains(Path file) throws IOException {
//        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        return partOfContent == null || partOfContent.isEmpty() || new String(Files.readAllBytes(file)).contains(partOfContent);
    }


    private boolean isPassPartOfNameConstrains(Path file) {

        return partOfName == null || partOfName.isEmpty() || file.toString().contains(partOfName);
    }

    private boolean isPassMaxSizeConstrains(BasicFileAttributes attrs) {
        return maxSize == 0 || attrs.size() < maxSize;
    }

    private boolean isPassMinSizeConstrains(BasicFileAttributes attrs) {
        return minSize == 0 || attrs.size() > minSize;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }
}
