package testdome.xml;


import org.w3c.dom.*;
import org.xml.sax.InputSource;

import javax.xml.parsers.*;
import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class Trojan {
    public static int countCompromised(String xml, String infectedFileId) throws Exception{
    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBbuilder = factory.newDocumentBuilder();
		 InputSource is = new InputSource();
		 is.setCharacterStream(new StringReader(xml));
		 Document doc = dBbuilder.parse(is);
		 NodeList snapshotNodes = doc.getElementsByTagName("snapshot");   
		 // iterate the snapshot
         //get file underneath the folder
       
         
        Map<Integer, Set<Integer>> files = new HashMap<Integer, Set<Integer>>();  
        for (int i = 0; i < snapshotNodes.getLength(); i++) {
           Element element = (Element) snapshotNodes.item(i);
           findAndUpdateAllFileIds(files, element);
        }
        Set<Integer> keySet = files.keySet();
        Iterator<Integer> keySetItr = keySet.iterator();
        Set<Integer> infectedFiles = new HashSet<Integer>();
        while(keySetItr.hasNext()){
        	Integer nextKey = keySetItr.next();
        	Set<Integer> values = files.get(nextKey);
        	if(values.contains(Integer.parseInt(infectedFileId))){
        		infectedFiles.addAll(values);
        	}
        }
        System.out.println("###########################################################");
		return infectedFiles.size(); 

    }
    
    
    private static void findAndUpdateAllFileIds(Map<Integer, Set<Integer>> files, Element element){
        NodeList childNodes = element.getChildNodes();       
        
        //the child node can be folder or a file
        for(int k=0; k<childNodes.getLength(); k++){
     	   Node childNode = childNodes.item(k);
     	   findAndUpdateFileIds(files, 0, childNode);
        }
    }
    
    //should be done by recursion here. that would be better approach
    private static void findAndUpdateFileIds(Map<Integer, Set<Integer>> files, int level, Node topNode){
		   String nodeName = topNode.getNodeName();
		   if(nodeName.equals("folder")){
			   System.out.println("have to process special");
			   NodeList childrenList = topNode.getChildNodes();
			   level++;
 			   for(int a=0;a<childrenList.getLength();a++){
				   		findAndUpdateFileIds(files, level, childrenList.item(a));     				   
 			   }
		   }
		   if(nodeName.equals("file")){
			   String fileId = topNode.getAttributes().getNamedItem("fileId").getNodeValue();
			   System.out.println("level=" + level+ " fileId = " + fileId);
			   updateToList(files, level, Integer.parseInt(fileId));
			   System.out.println(files);
		   }
    }
    
    //find the level and update the list
    private static void updateToList(Map<Integer, Set<Integer>> files, int level, int value){
    	Set<Integer> set = files.get(level);
    	if(set == null)
    		set = new HashSet<Integer>();
    	set.add(value);
		files.put(level, set);
	
    }
    

    public static void main(String[] args) throws Exception{
        String xml =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<root>" +
                "   <snapshot>" +
                "      <folder>" +
                "         <file fileId=\"1\"/>" +
                "         <file fileId=\"2\"/>" +
                "         <folder>" +
                "            <file fileId=\"3\"/>" +
                "            <file fileId=\"4\"/>" +
                "         </folder>" +
                "      </folder>" +
                "   </snapshot>" +
                "   <snapshot>" +
                "      <file fileId=\"1\"/>" +
                "      <file fileId=\"3\"/>" +
                "      <folder>" +
                "         <file fileId=\"2\"/>" +
                "         <file fileId=\"4\"/>" +
                "         <folder>" +
                "            <file fileId=\"3\"/>" +
                "            <file fileId=\"4\"/>" +
                "         </folder>" +
                "      </folder>" +
                "   </snapshot>" +
                "</root>";        
        System.out.println(Trojan.countCompromised(xml, "3"));
    }    
    
}
