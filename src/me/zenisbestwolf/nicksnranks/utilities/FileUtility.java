package me.zenisbestwolf.nicksnranks.utilities;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import me.zenisbestwolf.nicksnranks.Main;

public class FileUtility {
	private static Main plugin = Main.getPlugin(Main.class);
	private static String dataPath = plugin.getDataFolder().getAbsolutePath();
	public static void writeData(String fileName, String key, String value) {
		JSONObject main = new JSONObject();
		main.put(key, value);
		try {
			File file = new File(dataPath + File.separator + fileName + ".json");
			File filePath = new File(dataPath);
			filePath.mkdirs();
			if (!file.exists()) {
				file.createNewFile();
				FileWriter fileWriter = new FileWriter(file);
				fileWriter.write(main.toJSONString());
				fileWriter.flush();
				fileWriter.close();
			} else {
				JSONParser parser = new JSONParser();
				Object obj = parser.parse(new FileReader(file));
				JSONObject jsonObject = (JSONObject) obj;
				jsonObject.putAll(main);
				FileWriter fileWriter = new FileWriter(file);
				fileWriter.write(jsonObject.toJSONString());
				fileWriter.flush();
				fileWriter.close();
			}
		} catch (Exception e) {}
	}
	public static String readData(String fileName, String key) {
		String result = null;
		try {
			JSONParser parser = new JSONParser();
			File file = new File(dataPath + File.separator + fileName + ".json");
			Object obj = parser.parse(new FileReader(file));
			JSONObject jsonObject = (JSONObject) obj;
			result = (String) jsonObject.get(key);
		} catch (Exception e) {}
		return result;
	}
	public static void removeData(String fileName, String key) {
		try {
			JSONParser parser = new JSONParser();
			File file = new File(dataPath + File.separator + fileName + ".json");
			Object obj = parser.parse(new FileReader(file));
			JSONObject jsonObject = (JSONObject) obj;
			jsonObject.remove(key);
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write(jsonObject.toJSONString());
			fileWriter.flush();
			fileWriter.close();
		} catch (Exception e) {}
	}
}
