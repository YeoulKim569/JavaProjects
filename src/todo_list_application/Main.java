package todo_list_application;

import java.text.ParseException;

import javax.swing.SwingUtilities;

public class Main {
	// ✅ MAIN METHOD (How to initiate the UI)
    public static void main(String[] args) throws ParseException {
    	// Always start Swing app on Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            ToDoAppUI app = new ToDoAppUI();
            app.setVisible(true);
        });
        
    	MainTask mainTask = new MainTask("Study", "16/02/2026 08:28", "17/02/2026 08:28", "study math", false);
		SubTask subTask = new SubTask("Note solutions", "16/02/2026 08:28", "17/02/2026 08:28", "study math", false);
		
		System.out.println(mainTask);
		System.out.println();
		System.out.println(subTask);   
    }
}
