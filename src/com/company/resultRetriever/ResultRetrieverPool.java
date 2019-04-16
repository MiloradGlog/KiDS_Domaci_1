package com.company.resultRetriever;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;

public class ResultRetrieverPool {

	// da cuvam future?
	private ExecutorService executor;
	private BlockingQueue<Map<String, String>> data;
	
	private static ResultRetrieverPool instance;
	
	private ResultRetrieverPool() {
		this.executor = Executors.newSingleThreadExecutor();
		this.data = new LinkedBlockingQueue<>();
		Map<String, String> map = new HashMap<String, String>();
		map.put("haha", "test ");
		data.add(map);
	}
	
	public static ResultRetrieverPool getInstance() {
		if (instance == null) {
			instance = new ResultRetrieverPool();
		}
		return instance;
	}
	
	public String getResult(String corpusName) {
		
		Future<String> future = executor.submit(new ResultRetrieverThread(corpusName));
		
		try {
			String res = future.get();
			return res;
			
			
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}

	
	public BlockingQueue<Map<String, String>> getData() {
		return data;
	}
	
}
