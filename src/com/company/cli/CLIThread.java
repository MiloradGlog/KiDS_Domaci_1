package com.company.cli;

import com.company.dirCrawler.DirCrawlerThread;
import com.company.jobQueue.JobQueue;
import com.company.resultRetriever.ResultRetrieverPool;

import java.util.Scanner;
import java.util.StringTokenizer;

public class CLIThread extends Thread {

    private Scanner in;
    private JobQueue queue;

    public CLIThread(){
        in = new Scanner(System.in);
        this.queue = JobQueue.getInstance();
    }

    @Override
    public void run() {
        while(true){
            String inputString = in.nextLine();
            interpret(inputString);
            try {
                sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private void interpret(String str){
        StringTokenizer tokenizer = new StringTokenizer(str);
        String commandString = tokenizer.nextToken();
        String parameterString = getParameterFromTokenizer(tokenizer);
        switch (commandString){
            case ("ad"): {
                System.out.println("Komanda je add data");
                new DirCrawlerThread(parameterString).run();
                break;
            }
            case ("aw"): {
                System.out.println("Komanda je add web");
                break;
            }
            case ("stop"): {
                System.out.println("Komanda je stop");
                break;
            }
            case ("get"): {
                System.out.println("Komanda je get");
                System.out.println("Rezultat za parametar "+ parameterString +" je: "+ ResultRetrieverPool.getInstance().getResult(parameterString));
                break;
            }
            case ("query"): {
                System.out.println("Komanda je query");
                //System.out.println("Rezultat za parametar "+ parameterString +" je: "+ ResultRetrieverPool.getInstance().getQuery(parameterString));
                break;
            }
            default: {
                System.out.println("Nepoznata komanda");
                break;
            }

        }
    }

    private String getParameterFromTokenizer(StringTokenizer tokenizer){
        if (tokenizer.hasMoreElements())
            return tokenizer.nextToken();
        return null;
    }
}
