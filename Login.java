import java.awt.EventQueue;//
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.eclipse.wb.swing.Registration;
import org.eclipse.wb.swing.dbconnection;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Login extends JFrame {//

	private final JPanel contentPane;
    private final JTextField textField;
    private final JTextField textField_1;//

    /**
     * Launch the application.
     */
    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    final Login frame = new Login();
                    frame.setVisible(true);
                } catch (final Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Login() {
        final Registration reg = new Registration();//
        final dbconnection dbcon = new dbconnection();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        final JLabel lblLogin = new JLabel("LOGIN");
        lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
        lblLogin.setFont(new Font("Adobe Garamond Pro Bold", Font.BOLD, 18));
        lblLogin.setBounds(126, 11, 150, 35);
        contentPane.add(lblLogin);

        final JLabel lblNewLabel = new JLabel("Acc no :");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));//
        lblNewLabel.setBounds(56, 73, 80, 25);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(146, 75, 150, 25);
        contentPane.add(textField);
        textField.setColumns(10);

        final JComboBox comboBox = new JComboBox();//
        comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
        comboBox.setBounds(146, 121, 150, 25);
        contentPane.add(comboBox);
        comboBox.addItem("Deposit");
        comboBox.addItem("Withdraw");
        comboBox.setSelectedIndex(0);

        final JButton btnNewButton = new JButton("Submit");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent arg0) {
                String data = " ";
                if (comboBox.getSelectedIndex() != -1) {
                    data = (String) comboBox.getItemAt(comboBox.getSelectedIndex());
                }
                final String accno = textField.getText();
                final String amnt = textField_1.getText();
                final String type = (String) comboBox.getSelectedItem();
                dbcon.login(accno, type, amnt);

            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton.setBounds(179, 225, 89, 25);
        contentPane.add(btnNewButton);

        final JLabel lblNewLabel_1 = new JLabel("Type :");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(45, 121, 90, 25);
        contentPane.add(lblNewLabel_1);

        final JLabel lblNewLabel_2 = new JLabel("Amount :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(66, 170, 90, 25);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(146, 174, 150, 25);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}
}