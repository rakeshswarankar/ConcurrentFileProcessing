package com.code.ConcurrentFileProcessing;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@SpringBootApplication
public class ConcurrentFileProcessingApplication {

	private static Logger logger = LoggerFactory.getLogger(ConcurrentFileProcessingApplication.class);
	public static void main(String[] args) {
		//SpringApplication.run(ConcurrentFileProcessingApplication.class, args);
		
		String filePaths[]= {"",null,"/Users/rakesh.swarankar/Downloads/test.Csv","/Users/rakesh.swarankar/Downloads/test.txt","/Users/rakesh.swarankar/Downloads"};
		fileProcessor(filePaths);
	}
	
	public static void fileProcessor(String filePaths[]){
		
		// allowing only .csv files rest filter out
		List<String> filePathsList=Arrays.stream(filePaths)
		.filter(v -> v!=null && !v.isEmpty())
		.filter(v ->  v.length() >= 4 && v.substring(v.length()-4).toLowerCase().endsWith(".csv"))
		.collect(Collectors.toList());
		
		logger.info("After filter list size "+filePathsList.size());

		//Creating Executor service thread pool
		ExecutorService threadPool = Executors.newCachedThreadPool();
		
		//process each file in separate thread
		for(int i=0;i<filePathsList.size();i++){
			
			threadPool.execute(new FileProcessorRunnable(filePathsList.get(i)));
		}	
		logger.info("All threads starteded ");
		
	}

}
