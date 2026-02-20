package todo_list_application;

import java.text.ParseException;

public class Main {

	public static void main(String[] args) throws ParseException {
		MainTask mainTask = new MainTask("Study", "16/02/2026 08:28", "17/02/2026 08:28", "study math", false);
		Subtask subTask = new Subtask("Note solutions", "16/02/2026 08:28", "17/02/2026 08:28", "study math", false);
		
		System.out.println(mainTask);
		System.out.println();
		System.out.println(subTask);
	}

}
