import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.JTextComponent;

public class PasswordGeneratorGUI extends JFrame {
    private PasswordGenerator passwordGenerator;

    public PasswordGeneratorGUI(){

        super("Password Generator UI");
        setSize(540,570);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        passwordGenerator = new PasswordGenerator();
        addComponentGUI();
    }
    public void addComponentGUI(){
        //Add title
        JLabel titlelabel = new JLabel("Password Generator");
        titlelabel.setFont(new Font("Dialog", Font.BOLD,32));
        titlelabel.setHorizontalAlignment(SwingConstants.CENTER);
        titlelabel.setBounds(0,10,540,39);
        add(titlelabel);
        
        // Adding Text Area
        JTextArea passwordOutput = new JTextArea();
        passwordOutput.setEditable(false);
        passwordOutput.setFont(new Font ("Dialog", Font.BOLD,32));
        // Adding Scroll Bar to the text area
        JScrollPane passwordJScrollPane = new JScrollPane(passwordOutput);
        passwordJScrollPane.setBounds(25,97,479,70);
        passwordJScrollPane.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        add(passwordJScrollPane);

        // Create Password Lenght
        JLabel passwordlength = new JLabel("Password length");
        passwordlength.setFont(new Font("Dialog", Font.PLAIN, 32 ));
        passwordlength.setBounds(25,215,272,39);
        add(passwordlength);

        // Create Passwordd length Text area
        JTextArea passwordInput = new JTextArea();
        passwordInput.setFont(new Font("Dialog", Font.PLAIN, 32));
        passwordInput.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        passwordInput.setBounds(310,215,192,39);
        add(passwordInput);

        //add toggle button
        JToggleButton uppercasetoggle =new JToggleButton("Upper Case");
        uppercasetoggle.setFont(new Font("Dialog", Font.PLAIN, 26));
        uppercasetoggle.setBounds(25,302,225,56);
        add(uppercasetoggle);

        JToggleButton lowercasetoggle =new JToggleButton("Lower Case");
        lowercasetoggle.setFont(new Font("Dialog", Font.PLAIN, 26));
        lowercasetoggle.setBounds(282,302,225,56);
        add(lowercasetoggle);

        JToggleButton numbertoggle =new JToggleButton("Number");
        numbertoggle.setFont(new Font("Dialog", Font.PLAIN, 26));
        numbertoggle.setBounds(25,373,225,56);
        add(numbertoggle);

        JToggleButton symboltoggle =new JToggleButton("Symbol");
        symboltoggle.setFont(new Font("Dialog", Font.PLAIN, 26));
        symboltoggle.setBounds(282,373,225,56);
        add(symboltoggle);

        // Create Generate Button
        JButton generateButton = new JButton("Generate");
        generateButton.setFont(new Font("dialog", Font.PLAIN,32));
        generateButton.setBounds(155,477,222,41);
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(passwordInput.getText().length()<=0) return;
                boolean anyToggleSelected = lowercasetoggle.isSelected() ||
                uppercasetoggle.isSelected() ||
                numbertoggle.isSelected() ||
                symboltoggle.isSelected();

                int passwordLength = Integer.parseInt(passwordInput.getText());

                if(anyToggleSelected){
                    String generatePassword = passwordGenerator.generatePassword(passwordLength, 
                    uppercasetoggle.isSelected(),
                    lowercasetoggle.isSelected(), 
                    numbertoggle.isSelected(), 
                    symboltoggle.isSelected()); 

                    passwordOutput.setText(generatePassword);
                }
            }
        });
        add(generateButton);
    }
}