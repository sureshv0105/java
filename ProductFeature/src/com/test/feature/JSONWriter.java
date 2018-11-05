package com.test.feature;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SequenceWriter;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.test.feature.model.Feature;



public class JSONWriter {
	
	private final static String featureFile = "C:\\sureshv0105\\workspace\\projects\\ProductFeature\\model\\feature.json";
	
	public void writeFeature(String fromEmail, String description) throws IOException{
		//read json file data to String
		byte[] jsonData = Files.readAllBytes(Paths.get(featureFile));

		ObjectMapper objectMapper = new ObjectMapper();

		//create JsonNode
		JsonNode rootNode = objectMapper.readTree(jsonData);

		//update JSON data
		//((ObjectNode) rootNode).put("id", 500);
		
		//add new key value
		((ObjectNode) rootNode).put("test1", "test value");

		objectMapper.writeValue(new File(featureFile), rootNode);		
	}
	
	public static void appendFeature(Feature feature) throws IOException {
		try {
	        File file = new File(featureFile);
	        FileWriter fileWriter = new FileWriter(file, true);

	        ObjectMapper mapper = new ObjectMapper();
	        String jsonString = mapper.writer().writeValueAsString(feature);
	        System.out.println("jsonString: " + jsonString);
	        
	        mapper.writeValue(fileWriter, jsonString);
	        
	        //mapper.write

	        /*String jsonString = mapper.writer().writeValueAsString(feature);
	        System.out.println("jsonString: " + jsonString);
	        SequenceWriter seqWriter = mapper.writer().*/
	        //seqWriter.write(feature);
	        //seqWriter.close();
	        fileWriter.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }		
	}

	public static void main(String[] args) throws IOException {
		
		appendFeature(new Feature("Foo", "This is first feature"));
		appendFeature(new Feature("Bar", "This is second feature"));
		appendFeature(new Feature("Crude", "This is third feature"));
	}
	

}
