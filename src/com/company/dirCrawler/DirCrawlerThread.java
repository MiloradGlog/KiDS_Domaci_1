package com.company.dirCrawler;

import com.company.AppSettings;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class DirCrawlerThread extends Thread{

    private String path;

    public DirCrawlerThread(String path){
        this.path = path;
    }

    @Override
    public void run() {
        generateJobs(crawl());
    }

    private ArrayList<Path> crawl() {
        System.out.println("Crawling directory: "+ path);
        ArrayList<Path> paths = new ArrayList<>();

        try {
            Files.walk(Paths.get(path))
                    .filter(x -> isCorpus(x))
                    .forEach(x -> paths.add(x));
        } catch (Exception e){
            e.printStackTrace();
        }

        return paths;
    }

    private boolean isCorpus(Path p){
        if (!Files.isDirectory(p)){
            return false;
        }
        String fileName = p.getFileName().toString();
        for (int i = 0; i < AppSettings.getInstance().getCORPUS_PREFIX().length(); i++){
            if (fileName.charAt(i) != AppSettings.getInstance().getCORPUS_PREFIX().charAt(i)){
                return false;
            }
        }

        return true;
    }

    private void generateJobs(ArrayList<Path> paths){
        for (Path p : paths){
            System.out.println(p);
        }
    }

}
