package test.data.base;

import java.util.ArrayList;
import java.util.List;

import com.core.utils.JsonHelper;

public class DataBase {

	private String jsonFile = "";

	public String getJsonFile() {
		return jsonFile;
	}

	public void setJsonFile(String jsonFile) {
		this.jsonFile = jsonFile;
	}

	public DataBase(String jsonFile) {
		this.jsonFile = jsonFile;
	}

	public <T> T getData() {
		return JsonHelper.getData(jsonFile, this.getClass());
	}

	public <T> List<T> getListByIndex(List<T> baseList, int... indexs) {
		List<T> lst = new ArrayList<T>();
		for (int i = 0; i < indexs.length; i++) {
			lst.add(baseList.get(indexs[i]));
		}
		return lst;
	}
}
