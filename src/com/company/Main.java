package com.company;

import com.company.cli.CLIThread;
import com.company.fileScanner.FileScannerPool;
import com.company.jobQueue.jobDispatcherThread;

public class Main {

    public static void main(String[] args) {
//        String path = "files";

        Thread t = new CLIThread();
        t.start();

        FileScannerPool pool = new FileScannerPool();

        new jobDispatcherThread(pool).start();

    }
}
