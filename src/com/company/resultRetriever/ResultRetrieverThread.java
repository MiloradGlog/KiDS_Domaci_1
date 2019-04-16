package com.company.resultRetriever;

import java.util.Map;
import java.util.concurrent.Callable;

public class ResultRetrieverThread implements Callable<String>{
	
	private String corpusName;
	
	public ResultRetrieverThread(String corpusName) {
		this.corpusName = corpusName;
	}
	
	public String getResult() {
		ResultRetrieverPool pool = ResultRetrieverPool.getInstance();
		for (int i = 0; i < pool.getData().size(); i++) {
			Map<String, String> map = pool.getData().poll();
			if (map.containsKey(corpusName)) {
				return map.get(corpusName);
			}
			pool.getData().add(map);
		}
		return null;
	}

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return getResult();
		
	}
	
}
