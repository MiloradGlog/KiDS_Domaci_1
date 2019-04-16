package com.company.fileScanner;

import com.company.model.FileScannerJob;
import com.company.model.ScannerJob;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileScannerPool {

    private ExecutorService executor;

    public FileScannerPool() {
        this.executor = Executors.newFixedThreadPool(10);
    }

    public void addJob(FileScannerJob job){
        executor.submit(new FileScannerThread(job));
    }

}
