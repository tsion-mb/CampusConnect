
package ui;

import javax.swing.*;
import java.awt.*;

/**
 * Provides the chatbot interface where students can type questions
 * and view the conversation with CampusConnect.
 *
 * @author CampusConnect Team
 */
public class ChatPanel extends JPanel {

    private JTextArea chatArea;
    private JTextField messageField;
    private JButton sendButton;

    /**
     * Initializes the chatbot interface, including the chat display,
     * message input field, and send button.
     */
    public ChatPanel() {

        // Main panel layout
        setLayout(new BorderLayout());

        // Chat display area
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(chatArea);

        // Message input field
        messageField = new JTextField();

        // Send button
        sendButton = new JButton("Send");

        // Bottom panel for input and button
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(messageField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        // Add components to main panel
        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        // Welcome message
        chatArea.append("CampusConnect: Welcome! How can I help you today?\n");
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("CampusConnect - Chat Test");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        frame.add(new ChatPanel());

        frame.setVisible(true);
    }
}

