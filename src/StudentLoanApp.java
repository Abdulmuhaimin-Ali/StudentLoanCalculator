import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

public class StudentLoanApp extends JFrame {
    private ArrayList<Student> students;
    private JLabel studentIDLabel, surnameLabel, middleNameLabel, firstNameLabel, aptNumberLabel, streetNumberLabel,
            streetNameLabel, cityLabel, provinceLabel, postalCodeLabel, cslLoanAmountLabel, oslLoanAmountLabel, primeRateLabel, amortizationPeriodLabel;
    private JTextField studentIDField, surnameField, middleNameField, firstNameField, aptNumberField, streetNumberField,
            streetNameField, cityField, provinceField, postalCodeField, cslLoanAmountField, oslLoanAmountField, amortizationPeriodField;
    private JButton submitButton, clearButton, calculateButton, nextButton, prevButton;
    private JTextArea resultTextArea;
    private int currentIndex = 0;
    private JComboBox<String> primeRateComboBox;
    

    public StudentLoanApp(String title) {
        super(title);
        students = new ArrayList<>();

        // Set up GUI components
        studentIDLabel = new JLabel("Student ID:"); 
        surnameLabel = new JLabel("Surname:");
        middleNameLabel = new JLabel("Middle Name:");
        firstNameLabel = new JLabel("First Name:");
        aptNumberLabel = new JLabel("Apt Number:");
        streetNumberLabel = new JLabel("Street Number:");
        streetNameLabel = new JLabel("Street Name:");
        cityLabel = new JLabel("City:");
        provinceLabel = new JLabel("Province:");
        postalCodeLabel = new JLabel("Postal Code:");
        cslLoanAmountLabel = new JLabel("CSL Loan Amount:");
        oslLoanAmountLabel = new JLabel("OSL Loan Amount:");
        primeRateLabel = new JLabel("Prime Rate:");
        amortizationPeriodLabel = new JLabel("Amortization Period (months):");

        studentIDField = new JTextField(10);
        studentIDField.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusLost(FocusEvent e) {
        		validateStudentID();
        	}
		});
        
        surnameField = new JTextField(10);
        middleNameField = new JTextField(10);
        firstNameField = new JTextField(10);
        aptNumberField = new JTextField(10);
        streetNumberField = new JTextField(10);
        streetNameField = new JTextField(10);
        cityField = new JTextField(10);
        provinceField = new JTextField(10);
        postalCodeField = new JTextField(10);
        cslLoanAmountField = new JTextField(10);
        oslLoanAmountField = new JTextField(10);
        amortizationPeriodField = new JTextField(10);
        primeRateComboBox = new JComboBox<>(new String[]{"0%", "0.25%", "0.5%", "0.75%", "1%", "1.25%", "1.5%", "1.75%",
                "2%", "2.25%", "2.5%", "2.75%", "3%", "3.25%", "3.5%", "3.75%", "4%", "4.25%", "4.5%", "4.75%", "5%",
                "5.25%", "5.5%", "5.75%", "6%", "6.25%", "6.5%", "6.75%", "7%", "7.25%", "7.5%", "7.75%", "8%",
                "8.25%", "8.5%", "8.75%", "9%", "9.25%", "9.5%", "9.75%", "10%"});
        submitButton = new JButton("Submit");
        clearButton = new JButton("Clear");
        calculateButton = new JButton("Calculate");
        nextButton = new JButton("Next");
        prevButton = new JButton("Previous");
        resultTextArea = new JTextArea(10, 30);

        // Set layout
        setLayout(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridLayout(0, 2, 5, 5));
        inputPanel.add(studentIDLabel);
        inputPanel.add(studentIDField);
        inputPanel.add(surnameLabel);
        inputPanel.add(surnameField);
        inputPanel.add(middleNameLabel);
        inputPanel.add(middleNameField);
        inputPanel.add(firstNameLabel);
        inputPanel.add(firstNameField);
        inputPanel.add(aptNumberLabel);
        inputPanel.add(aptNumberField);
        inputPanel.add(streetNumberLabel);
        inputPanel.add(streetNumberField);
        inputPanel.add(streetNameLabel);
        inputPanel.add(streetNameField);
        inputPanel.add(cityLabel);
        inputPanel.add(cityField);
        inputPanel.add(provinceLabel);
        inputPanel.add(provinceField);
        inputPanel.add(postalCodeLabel);
        inputPanel.add(postalCodeField);
        inputPanel.add(cslLoanAmountLabel);
        inputPanel.add(cslLoanAmountField);
        inputPanel.add(oslLoanAmountLabel);
        inputPanel.add(oslLoanAmountField);
        inputPanel.add(primeRateLabel);
        inputPanel.add(primeRateComboBox);
        inputPanel.add(amortizationPeriodLabel);
        inputPanel.add(amortizationPeriodField);
        JPanel buttonPanel = new JPanel(new GridLayout(1, 5, 5, 5));
        buttonPanel.add(submitButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(calculateButton);
        buttonPanel.add(nextButton);
        buttonPanel.add(prevButton);
        JScrollPane scrollPane = new JScrollPane(resultTextArea);

        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        add(scrollPane, BorderLayout.EAST);

        // Set JFrame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        // Add action listeners
        submitButton.addActionListener(e -> addStudent());

        clearButton.addActionListener(e -> clearFields());

        calculateButton.addActionListener(e -> {
			try {
				calculateLoan();
			} catch (A_A_NegativeValueException e1) {
			}
		});

        nextButton.addActionListener(e -> nextStudent());

        prevButton.addActionListener(e -> previousStudent());
    }

    private void addStudent() {
        String studentID = studentIDField.getText();
        String surname = surnameField.getText();
        String middleName = middleNameField.getText();
        String firstName = firstNameField.getText();
        String aptNumber = aptNumberField.getText();
        String streetNumber = streetNumberField.getText();
        String streetName = streetNameField.getText();
        String city = cityField.getText();
        String province = provinceField.getText();
        String postalCode = postalCodeField.getText();
        double cslLoanAmount = Double.parseDouble(cslLoanAmountField.getText());
        double oslLoanAmount = Double.parseDouble(oslLoanAmountField.getText());

        students.add(new Student(studentID, surname, middleName, firstName, aptNumber, streetNumber, streetName,
                city, province, postalCode, cslLoanAmount, oslLoanAmount));
        clearFields();
        JOptionPane.showMessageDialog(this, "Student added successfully!");
    }

    private void clearFields() {
        studentIDField.setText("");
        surnameField.setText("");
        middleNameField.setText("");
        firstNameField.setText("");
        aptNumberField.setText("");
        streetNumberField.setText("");
        streetNameField.setText("");
        cityField.setText("");
        provinceField.setText("");
        postalCodeField.setText("");
        cslLoanAmountField.setText("");
        oslLoanAmountField.setText("");
        amortizationPeriodField.setText("");
        primeRateComboBox.setSelectedIndex(0);
        resultTextArea.setText("");
    }
    
    private void validateStudentID() {
    	String studentID = studentIDField.getText();
    	if(!studentID.matches("\\d+")) {
    		JOptionPane.showMessageDialog(this, "Student ID should contain only numbers and should consiste of 7 numeric characters ");
    		studentIDField.requestFocusInWindow();
    	}
    }



    private void nextStudent() {
        if (currentIndex < students.size() - 1) {
            currentIndex++;
            displayStudentInfo();
        }
    }

    private void previousStudent() {
        if (currentIndex > 0) {
            currentIndex--;
            displayStudentInfo();
        }
    }

    private void displayStudentInfo() {
    	if (currentIndex >= 0 && currentIndex < students.size()) {
            Student currentStudent = students.get(currentIndex);
            studentIDField.setText(currentStudent.getStudentID());
            surnameField.setText(currentStudent.getSurname());
            middleNameField.setText(currentStudent.getMiddleName());
            firstNameField.setText(currentStudent.getFirstName());
            aptNumberField.setText(currentStudent.getAptNumber());
            streetNumberField.setText(currentStudent.getStreetNumber());
            streetNameField.setText(currentStudent.getStreetName());
            cityField.setText(currentStudent.getCity());
            provinceField.setText(currentStudent.getProvince());
            postalCodeField.setText(currentStudent.getPostalCode());
            cslLoanAmountField.setText(String.valueOf(currentStudent.getCslLoanAmount()));
            oslLoanAmountField.setText(String.valueOf(currentStudent.getOslLoanAmount()));
            // Populate prime rate and amortization period if needed
        }
    }
    

    private void calculateLoan() throws A_A_NegativeValueException {
    	resultTextArea.setText("");
        // Get the selected prime rate and amortization period
        int selectedRateIndex = primeRateComboBox.getSelectedIndex();
        double primeRate = selectedRateIndex * 0.25;
        int amortizationPeriod = Integer.parseInt(amortizationPeriodField.getText());

        // Check if currentIndex is within bounds
        if (currentIndex >= 0 && currentIndex < students.size()) {
            // Get the current student at currentIndex
            Student currentStudent = students.get(currentIndex);

            // Calculate CSL and OSL monthly payments for the current student
            double cslMonthlyPayment = currentStudent.calculateLoanPayment(currentStudent.getCslLoanAmount(), primeRate + 2.5, amortizationPeriod);
            double oslMonthlyPayment = currentStudent.calculateLoanPayment(currentStudent.getOslLoanAmount(), primeRate + 1.0, amortizationPeriod);

            // Calculate total monthly payment
            double totalMonthlyPayment = cslMonthlyPayment + oslMonthlyPayment;

            // Display the calculated payments
            resultTextArea.setText("CSL Monthly Payment: $" + cslMonthlyPayment + "\n" +
                    "OSL Monthly Payment: $" + oslMonthlyPayment + "\n" +
                    "Total Monthly Payment: $" + totalMonthlyPayment);
        }
     // Display the calculated payments
        resultTextArea.setText("CSL Monthly Payment: $" + "" + "\n" +
                "OSL Monthly Payment: $" + "" + "\n" +
                "Total Monthly Payment: $" + "");
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentLoanApp("Student Loan Application"));
    }
}
