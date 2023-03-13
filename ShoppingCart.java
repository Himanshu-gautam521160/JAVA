import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ShoppingCart extends JFrame implements ActionListener {
    private JTextField itemNameField;
    private JTextField quantityField;
    private JTextArea cartTextArea;

    public ShoppingCart() {
        super("S.K Online Shopping Store");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create labels and fields for item name and quantity
        JLabel itemNameLabel = new JLabel("Item Name:");
        itemNameField = new JTextField(20);
        JLabel quantityLabel = new JLabel("Quantity:");
        quantityField = new JTextField(5);

        // Create button for adding item to cart
        JButton addButton = new JButton("Add to Cart");
        addButton.addActionListener(this);

        // Create text area for displaying the shopping cart
        cartTextArea = new JTextArea(15, 30);
        cartTextArea.setEditable(false);

        // Add components to the frame
        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        inputPanel.add(itemNameLabel);
        inputPanel.add(itemNameField);
        inputPanel.add(quantityLabel);
        inputPanel.add(quantityField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);

        JPanel cartPanel = new JPanel();
        cartPanel.add(new JScrollPane(cartTextArea));

        getContentPane().add(inputPanel, BorderLayout.NORTH);
        getContentPane().add(buttonPanel, BorderLayout.CENTER);
        getContentPane().add(cartPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String itemName = itemNameField.getText();
        int quantity = Integer.parseInt(quantityField.getText());
        String cartText = cartTextArea.getText();

        // Add item to the cart
        cartText += itemName + " (" + quantity + ")\n";
        cartTextArea.setText(cartText);

        // Clear input fields
        itemNameField.setText("");
        quantityField.setText("");
       
    }

    public static void main(String[] args) {
        new ShoppingCart();
    }
}