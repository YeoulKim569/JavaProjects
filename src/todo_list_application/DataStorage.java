package todo_list_application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class DataStorage {
	private static final String DATA_FILE = "data_storage/todoData.dat";
	
	public static void saveData(ArrayList<ToDoList> lists) {
		System.out.println("saving data");
	    try {

	        File folder = new File("data_storage");
	        if (!folder.exists()) {
	            folder.mkdir();   // create folder if missing
	        }

	        ObjectOutputStream out = new ObjectOutputStream(
	                new FileOutputStream(DATA_FILE));

	        out.writeObject(lists);
	        out.close();

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	public static ArrayList<ToDoList> loadData() {
		System.out.println("loading data");
        try {

            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(DATA_FILE)
            );

            ArrayList<ToDoList> lists = (ArrayList<ToDoList>) in.readObject();
            in.close();

            return lists;

        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
