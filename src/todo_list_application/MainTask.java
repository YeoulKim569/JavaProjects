package todo_list_application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainTask {
	String title;
	Date date;
	Date deadline;
	String description;
	boolean starred;
	ArrayList<String> subTask;
	
	public MainTask(String title, String date, String deadline, String description, boolean starred) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		this.title = title;
		this.date = sdf.parse(date);
		this.deadline = sdf.parse(deadline);
		this.description = description;
		this.starred = starred;
		this.subTask = new ArrayList<String>();
	}
	
	public String toString() {
		String str = "Title: " + title + "\nDate: " + date + "\nDeadline: " + deadline + "\ndescription: " + description + "\nstarred: " + starred + "\nnumber of subtask: " + subTask.size();
		return str;
	}
	
}