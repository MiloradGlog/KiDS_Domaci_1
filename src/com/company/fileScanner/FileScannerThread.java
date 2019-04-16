package com.company.fileScanner;

import com.company.model.FileScannerJob;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.stream.Stream;

public class FileScannerThread extends Thread {

    private String word = "test_word";
    private FileScannerJob job;
    private int counter;

    public FileScannerThread(FileScannerJob job) {
        this.job = job;
        counter = 0;
    }

    @Override
    public void run() {
        counter = 0;
        try (Stream<Path> paths = Files.walk(job.getPath())) {
            paths
                    .filter(Files::isRegularFile)
                    .forEach(x -> read(x));
        } catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("Pronasao "+ counter +" ponavljanja kljucne reci \""+ word +"\"");
    }

    private void read(Path p) {
        try {
            File f = new File(p.toUri());
            Scanner sc = new Scanner(f);

            while (sc.hasNextLine()){
                String nextWord = sc.next();
                if (nextWord.equals(word))
                    counter++;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
