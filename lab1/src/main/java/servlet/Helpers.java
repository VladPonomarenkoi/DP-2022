package servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import jakarta.servlet.http.HttpServletRequest;
import trees.Trees;

public class Helpers {

	public static JsonElement bodyParse(HttpServletRequest request) {
		JsonElement jsonElement=null;	
		
		try {
			jsonElement = JsonParser.parseReader(request.getReader());
		} catch (JsonIOException | JsonSyntaxException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonElement;
	}
	
	public static Trees treesParse(HttpServletRequest request) {
		Trees trees = new Trees();
		JsonElement jsonElement = bodyParse(request);
		trees.setId(jsonElement.getAsJsonObject().get("id").getAsInt());
		trees.setTitle(jsonElement.getAsJsonObject().get("title").getAsString());
		trees.setAge(jsonElement.getAsJsonObject().get("age").getAsInt());
		trees.setInfo(jsonElement.getAsJsonObject().get("info").getAsString());
		
		return trees;
	}
	
	
	public static int getNextId(List<Trees> list) {
		int maxId = 0;
		Iterator<Trees> iterator = list.iterator();
		while(iterator.hasNext()) {
			int currentId = iterator.next().getId();
			if(currentId>maxId) maxId=currentId;
		}
		return maxId+1;
	}
	
	public static int getIndexBytreesId(int Id,List<Trees> list) {
		int listId = Id;
		
		Iterator<Trees> iterator = list.iterator();
		while(iterator.hasNext()) {
			Trees temp =iterator.next();
			if(temp.getId()==listId) { 
				listId=list.indexOf(temp);
				break;
			}
		}
		return listId;
	}
	
}