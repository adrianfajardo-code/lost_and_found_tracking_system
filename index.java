import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class LostAndFoundSystem {

    static class Item {
        String name, description, date, location, contact;

        Item(String name, String description, String date, String location, String contact) {
            this.name = name;
            this.description = description;
            this.date = date;
            this.location = location;
            this.contact = contact;
        }
    }

    private static List<Item> items = new ArrayList<>();

    public static void main(String[] args) {
        try { UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel"); }
        catch(Exception e) { e.printStackTrace(); }

        JFrame frame = new JFrame("Lost & Found System");
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout(10,10));
        panel.setBorder(new EmptyBorder(10,10,10,10));
        frame.add(panel);

        // Title
        JLabel title = new JLabel("Lost & Found System", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 26));
        title.setForeground(new Color(33, 150, 243));
        panel.add(title, BorderLayout.NORTH);

        // Table for items
        String[] columns = {"Name", "Description", "Date", "Location", "Contact"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Form panel
        JPanel formPanel = new JPanel(new GridLayout(6,2,10,10));
        formPanel.setBorder(BorderFactory.createTitledBorder("Add Lost Item"));

        JTextField nameField = new JTextField();
        JTextField descField = new JTextField();
        JTextField dateField = new JTextField();
        JTextField locField = new JTextField();
        JTextField contactField = new JTextField();

        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Description:"));
        formPanel.add(descField);
        formPanel.add(new JLabel("Date:"));
        formPanel.add(dateField);
        formPanel.add(new JLabel("Location:"));
        formPanel.add(locField);
        formPanel.add(new JLabel("Contact:"));
        formPanel.add(contactField);

        JButton addButton = createRoundedButton("Add Item", new Color(33,150,243));
        JButton removeButton = createRoundedButton("Mark Found", new Color(244,67,54));

        formPanel.add(addButton);
        formPanel.add(removeButton);

        panel.add(formPanel, BorderLayout.SOUTH);

        // Button actions
        addButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String desc = descField.getText().trim();
            String date = dateField.getText().trim();
            String loc = locField.getText().trim();
            String contact = contactField.getText().trim();

            if(!name.isEmpty() && !desc.isEmpty()) {
                Item item = new Item(name, desc, date, loc, contact);
                items.add(item);
                tableModel.addRow(new Object[]{name, desc, date, loc, contact});
                nameField.setText(""); descField.setText(""); dateField.setText(""); locField.setText(""); contactField.setText("");
            } else {
                JOptionPane.showMessageDialog(frame, "Name and Description required", "Error", JOptionPane.WARNING_MESSAGE);
            }
        });

        removeButton.addActionListener(e -> {
            int selected = table.getSelectedRow();
            if(selected >= 0) {
                tableModel.removeRow(selected);
                items.remove(selected);
            } else {
                JOptionPane.showMessageDialog(frame, "Select an item to mark as found", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });

        frame.setVisible(true);
    }

    private static JButton createRoundedButton(String text, Color bgColor) {
        JButton button = new JButton(text);
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setBorder(BorderFactory.createEmptyBorder(8,16,8,16));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(MouseEvent evt) { button.setBackground(bgColor.darker()); }
            public void mouseExited(MouseEvent evt) { button.setBackground(bgColor); }
        });
        return button;
    }
}
