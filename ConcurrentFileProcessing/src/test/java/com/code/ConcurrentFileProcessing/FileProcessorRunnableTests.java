package com.code.ConcurrentFileProcessing;

import java.io.File;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ConcurrentFileProcessingApplication.class)
class FileProcessorRunnableTests {

	private Logger logger = LoggerFactory.getLogger(FileProcessorRunnableTests.class);
	
	private final String VALID_FILE_PATH="/Users/rakesh.swarankar/Downloads/test.csv";
	private final String INVALID_FILE_PATH="/Users/rakesh.swarankar/Downloads/test.txt";
	private final String DIR_PATH="/Users/rakesh.swarankar/Downloads";
	
	@Test
	void contextLoads() {
	}
	@Test
	void validTest() {
		logger.info("running validTest");
		
		FileProcessorRunnable fileProcessorRunnable = new FileProcessorRunnable(VALID_FILE_PATH);
		fileProcessorRunnable.run();
	}
	
	@Test
	void validateTestWithEmptyFilePath() {
		logger.info("running validateTestWithEmptyFilePath");
		String filePath="";
		FileProcessorRunnable fileProcessorRunnable = new FileProcessorRunnable(filePath);
		fileProcessorRunnable.run();
	}
	
	@Test
	void validateTestWithNull() {
		logger.info("running validateTestWithNull");
		String filePath=null;
		FileProcessorRunnable fileProcessorRunnable = new FileProcessorRunnable(filePath);
		fileProcessorRunnable.run();
	}
	
	@Test
	void validateTestFileFormat() {
		logger.info("running validateTestFileFormat");
		
		FileProcessorRunnable fileProcessorRunnable = new FileProcessorRunnable(INVALID_FILE_PATH);
		fileProcessorRunnable.run();
	}
	@Test
	void validateTestDir() {
		logger.info("running validateTestDir");
		FileProcessorRunnable fileProcessorRunnable = new FileProcessorRunnable(DIR_PATH);
		fileProcessorRunnable.run();		
	}
	@Test
	void validateTestReadPermission() {
		logger.info("running validateTestReadPermission");
		
		File file= new File(VALID_FILE_PATH);
		file.setReadable(false);
		FileProcessorRunnable fileProcessorRunnable = new FileProcessorRunnable(VALID_FILE_PATH);
		fileProcessorRunnable.run();
		file.setReadable(true);
	}

}
