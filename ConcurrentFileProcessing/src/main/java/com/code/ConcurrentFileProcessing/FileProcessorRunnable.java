package com.code.ConcurrentFileProcessing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class FileProcessorRunnable implements Runnable{

	private String filePath;
	private Logger logger = LoggerFactory.getLogger(FileProcessorRunnable.class);
	
	public FileProcessorRunnable(String filePath){
		this.filePath=filePath;
	}
	
	@Override
	public void run() {
		
		if(filePath!=null && filePath.isEmpty()){
			logger.info("File path is null or empty");
			return;
		}
		
		try{
			File file= new File(filePath);
			// File should be exist, it is file or dir and can read it
			if(file.exists() && file.isFile() && file.canRead() && validateFileExtension(file)){
				
				BufferedReader bufferReader = new BufferedReader(new FileReader(file));
				
				String line;
				while((line=bufferReader.readLine()) != null)
				{
					logger.info(line);
				}
				
				// closing the buffer stream
				bufferReader.close();
			}
			else {
				logger.info("File Exist: "+file.exists()+", isFile: "+file.isFile()+", is readable: "+file.canRead()+", is valid file extension: "+validateFileExtension(file));
			}
		}
		catch(IOException ioException){
			logger.error("IOException :"+ioException.getMessage());			
		}
		catch(Exception e){
			logger.error("Exception: "+e.getMessage());			
		}
		
	}
	
	private boolean validateFileExtension(File file){
		return file.getName().toLowerCase().endsWith(".csv");
	}
}
