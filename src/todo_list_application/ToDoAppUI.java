package todo_list_application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.ParseException;

public class ToDoAppUI extends JFrame {

    private ToDoList toDoList;

    private DefaultListModel<String> taskListModel;
    private JList<String> taskJList;

    private JButton addTaskButton;
    private JButton viewTaskButton;

    public ToDoAppUI() {
        toDoList = new ToDoList("My Tasks");

        setTitle("To-Do List Application");
        setSize(600, 400);
        setLocationRelativeTo(null); // center window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initializeComponents();
        layoutComponents();
        registerListeners();
    }

    private void initializeComponents() {
        taskListModel = new DefaultListModel<>();
        taskJList = new JList<>(taskListModel);

        addTaskButton = new JButton("Add Main Task");
        viewTaskButton = new JButton("View Selected Task");
    }

    private void layoutComponents() {
        setLayout(new BorderLayout());

        JScrollPane scrollPane = new JScrollPane(taskJList);
        add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(addTaskButton);
        bottomPanel.add(viewTaskButton);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void registerListeners() {

        addTaskButton.addActionListener((ActionEvent e) -> {
            addMainTask();
        });

        viewTaskButton.addActionListener((ActionEvent e) -> {
            viewSelectedTask();
        });
    }

    private void addMainTask() {

        JTextField titleField = new JTextField();
        JTextField dateField = new JTextField("dd/MM/yyyy HH:mm");
        JTextField deadlineField = new JTextField("dd/MM/yyyy HH:mm");
        JTextField descriptionField = new JTextField();
        JCheckBox starredBox = new JCheckBox("Starred");

        Object[] message = {
                "Title:", titleField,
                "Start Date:", dateField,
                "Deadline:", deadlineField,
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

                toDoList.mainTask.add(task);
                taskListModel.addElement(task.title);

            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this,
                        "Invalid date format!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void viewSelectedTask() {
        int index = taskJList.getSelectedIndex();

        if (index == -1) {
            JOptionPane.showMessageDialog(this,
                    "Please select a task first.");
            return;
        }

        MainTask task = toDoList.mainTask.get(index);

        JOptionPane.showMessageDialog(this,
                task.toString(),
                "Task Details",
                JOptionPane.INFORMATION_MESSAGE);
    }
}