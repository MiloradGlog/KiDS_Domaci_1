package com.company.model;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileScannerJob extends ScannerJob {

    private Path path;

    public FileScannerJob(Path p) {
        this.path = p;



    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "File Scanner job, path: "+ path.toString();
    }
}
