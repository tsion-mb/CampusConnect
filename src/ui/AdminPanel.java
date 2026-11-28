package ui;

import javax.swing.*;
import java.awt.*;

/**
 * Provides the administrator interface for managing campus information.
 * Administrators can add, update, and delete information.
 *
 * @author CampusConnect Team
 */
public class AdminPanel extends JPanel {

    private JTextField titleField;
    private JTextField keywordsField;
    private JTextArea answerArea;
    private JComboBox<String> categoryBox;

    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton clearButton;

    /**
     * Creates the admin panel and initializes its form and buttons.
     */
    public AdminPanel() {

        setLayout(new BorderLayout(10, 10));

        // Heading
        JLabel heading = new JLabel("Campus Information Management");
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        heading.setHorizontalAlignment(JLabel.CENTER);

        add(heading, BorderLayout.NORTH);

        // Information form
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));

        titleField = new JTextField();
        keywordsField = new JTextField();

        categoryBox = new JComboBox<>(new String[]{
                "Academic",
                "Facility",
                "Student Service"
        });

        answerArea = new JTextArea(5, 20);
        answerArea.setLineWrap(true);
        answerArea.setWrapStyleWord(true);

        formPanel.add(new JLabel("Title:"));
        formPanel.add(titleField);

        formPanel.add(new JLabel("Keywords:"));
        formPanel.add(keywordsField);

        formPanel.add(new JLabel("Category:"));
        formPanel.add(categoryBox);

        formPanel.add(new JLabel("Answer:"));
        formPanel.add(new JScrollPane(answerArea));

        add(formPanel, BorderLayout.CENTER);

        // Management buttons
        JPanel buttonPanel = new JPanel(new FlowLayout());

        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        clearButton = new JButton("Clear");

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(clearButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    /**
     * Temporary main method for testing the AdminPanel independently.
     */
    public static void main(String[] args) {

        JFrame frame = new JFrame("CampusConnect - Admin Test");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        frame.add(new AdminPanel());

        frame.setVisible(true);
    }


    public class Main {

        public static void main(String[] args) {

            MainFrame frame = new MainFrame();
            frame.add(new ChatPanel());

            frame.setVisible(true);
        }


    }
}


