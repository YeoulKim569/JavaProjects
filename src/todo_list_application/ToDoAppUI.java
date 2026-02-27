package todo_list_application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.util.ArrayList;

public class ToDoAppUI extends JFrame {

    private ArrayList<ToDoList> lists;
    private JTabbedPane tabbedPane;
    private JButton createListButton;

    public ToDoAppUI() {
        lists = new ArrayList<>();

        setTitle("To-Do Application");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initializeComponents();
        layoutComponents();

        // Create default ToDoList
        createNewToDoList("Study");
        createNewToDoList("Hobby");
    }

    private void initializeComponents() {
        tabbedPane = new JTabbedPane();
        createListButton = new JButton("Create New ToDo List");
    }

    private void layoutComponents() {
        setLayout(new BorderLayout());

        add(tabbedPane, BorderLayout.CENTER);
        add(createListButton, BorderLayout.SOUTH);

        createListButton.addActionListener((ActionEvent e) -> {
            String name = JOptionPane.showInputDialog(
                    this,
                    "Enter new list name:"
            );

            if (name != null && !name.trim().isEmpty()) {
                createNewToDoList(name);
            }
        });
    }

    private void createNewToDoList(String title) {

        ToDoList list = new ToDoList(title);
        lists.add(list);

        // Panel for this specific ToDoList
        JPanel panel = new JPanel(new BorderLayout());

        DefaultListModel<String> taskModel = new DefaultListModel<>();
        JList<String> taskListUI = new JList<>(taskModel);
        addDefaultMainTask(list, taskModel);

        JButton addTaskButton = new JButton("Add Main Task");
        JButton viewTaskButton = new JButton("View Selected Task");

        panel.add(new JScrollPane(taskListUI), BorderLayout.CENTER);
        
        // Create bottom panel
        JPanel bottomPanel = new JPanel();

        // Choose layout for bottom panel
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        // You could also use new GridLayout(1, 3)

        bottomPanel.add(addTaskButton);
        bottomPanel.add(viewTaskButton);
        // Add third component here if needed

        panel.add(bottomPanel, BorderLayout.SOUTH);
        
        // Add task ONLY to this ToDoList
        addTaskButton.addActionListener(e -> {
            addMainTaskToList(list, taskModel);
        });

        tabbedPane.addTab(title, panel);
    }

    private void addMainTaskToList(ToDoList list, DefaultListModel<String> taskModel) {

        JTextField titleField = new JTextField();
        JTextField dateField = new JTextField("dd/MM/yyyy HH:mm");
        JTextField deadlineField = new JTextField("dd/MM/yyyy HH:mm");
        JTextField descriptionField = new JTextField();
        JCheckBox starredBox = new JCheckBox("Starred");

        Object[] message = {
                "Title:", titleField,
                "Start Date (optional):", dateField,
                "Deadline (optional):", deadlineField,
                "Description:", descriptionField,
                starredBox
        };

        int option = JOptionPane.showConfirmDialog(
                this,
                message,
                "Create Main Task",
                JOptionPane.OK_CANCEL_OPTION
        );

        if (option == JOptionPane.OK_OPTION) {
            try {
                MainTask task = new MainTask(
                        titleField.getText(),
                        dateField.getText(),
                        deadlineField.getText(),
                        descriptionField.getText(),
                        starredBox.isSelected()
                );

                list.mainTask.add(task);   // Add to correct ToDoList
                taskModel.addElement(task.title); // Update UI

            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this,
                        "Invalid date format.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void addDefaultMainTask(ToDoList list, DefaultListModel<String> taskModel) {  	 		
		try {
			MainTask defaultTask = new MainTask(
			         "Default Task",
			         "17/02/2026 08:28",
			         "17/02/2026 08:28",
			         "default desciption",
			         false
			 );
			
			list.mainTask.add(defaultTask);   // Add to correct ToDoList
	        taskModel.addElement(defaultTask.title); // Update UI
	        
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
    }
}