package todo_list_application;

import java.io.Serializable;
import java.util.ArrayList;

public class ToDoList implements Serializable {
	String title;
	ArrayList<MainTask> mainTask;
	
	public ToDoList(String title) {
		this.title = title;
		this.mainTask = new ArrayList<MainTask>();
	}
	
	public void renameList(String title) {
		this.title = title;
	}
	
}
