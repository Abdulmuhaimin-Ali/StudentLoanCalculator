# Student Loan Calculator

This Java application is designed to help users calculate monthly loan payments for both Canada Student Loans (CSL) and Ontario Student Loans (OSL). It allows users to input various student and loan details and provides a breakdown of the monthly payments.

## About the Project

The Student Loan Calculator collects student information such as ID, name, address, and loan amounts. It calculates monthly payments based on the entered loan amounts, prime rate, and amortization period.

## Getting Started

To run the Student Loan Calculator on your local machine, follow these steps:

1. Clone or download the repository to your computer.
2. Open the project in your preferred Java development environment.
3. Compile and run the `StudentLoanApp.java` file.
4. Input student information and loan details.
5. Click the "Calculate" button to compute the monthly loan payments.

### Prerequisites

- Java Development Kit (JDK) installed on your machine.
- A Java Integrated Development Environment (IDE) such as IntelliJ IDEA, Eclipse, or NetBeans.

## Usage

### Input Fields

- **Student ID:** Enter the student's unique identification number.
- **Name:** Enter the student's name, including surname, middle name, and first name.
- **Address:** Provide the student's address details, including apartment number, street number, street name, city, province, and postal code.
- **Loan Amounts:** Input the amounts for both CSL and OSL loans.
- **Prime Rate:** Select the prime rate from the dropdown menu.
- **Amortization Period:** Enter the amortization period in months.

### Buttons

- **Submit:** Add the current student's information to the system.
- **Clear:** Clear all input fields to start fresh.
- **Calculate:** Compute the monthly loan payments based on the entered details.
- **Next/Previous:** Navigate between students if multiple entries are present.

## Structure

The project structure is organized as follows:

---
```text
StudentLoanCalculator
└── src
    ├── A_A_LoanPayable.java
    ├── A_A_NegativeValueException.java
    ├── Student.java
│   └── StudentLoanApp.java
└── README.md
```

## Contributing

Contributions to this project are welcome. Feel free to fork the repository, make improvements, and submit pull requests.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---
For more information or support, please contact [Your Name] at [Your Email].
