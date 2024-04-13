public class Student implements A_A_LoanPayable{
    private String studentID;
    private String surname;
    private String middleName;
    private String firstName;
    private String aptNumber;
    private String streetNumber;
    private String streetName;
    private String city;
    private String province;
    private String postalCode;
    private double cslLoanAmount;
    private double oslLoanAmount;

    // Constructor
    public Student(String studentID, String surname, String middleName, String firstName,
                   String aptNumber, String streetNumber, String streetName, String city,
                   String province, String postalCode, double cslLoanAmount, double oslLoanAmount) {
        this.studentID = studentID;
        this.surname = surname;
        this.middleName = middleName;
        this.firstName = firstName;
        this.aptNumber = aptNumber;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
        this.cslLoanAmount = cslLoanAmount;
        this.oslLoanAmount = oslLoanAmount;
    }

    // Getters
    public String getStudentID() {
        return studentID;
    }

    public String getSurname() {
        return surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getAptNumber() {
        return aptNumber;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public double getCslLoanAmount() {
        return cslLoanAmount;
    }

    public double getOslLoanAmount() {
        return oslLoanAmount;
    }

    // Setters
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setAptNumber(String aptNumber) {
        this.aptNumber = aptNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setCslLoanAmount(double cslLoanAmount) {
        this.cslLoanAmount = cslLoanAmount;
    }

    public void setOslLoanAmount(double oslLoanAmount) {
        this.oslLoanAmount = oslLoanAmount;
    }
    

    // toString method
    @Override
    public String toString() {
        return "Student Name: " + surname + ", " + firstName + " " + middleName + "\n" +
               "Student Number: " + studentID + "\n" +
               "CSL Amount is $" + cslLoanAmount + "\n" +
               "OSL Amount is $" + oslLoanAmount;
    }
    
    @Override
    public double calculateLoanPayment(double loanAmount, double annualInterestRate, int amortizationPeriod) throws A_A_NegativeValueException {
        // Check for negative values
        if (loanAmount < 0 || annualInterestRate < 0) {
            throw new A_A_NegativeValueException("Loan amount or interest rate cannot be negative.");
        }

        // Calculate monthly interest rate
        double monthlyInterestRate = annualInterestRate / 12.0;

        // Calculate monthly payment
        double power = Math.pow(1 + monthlyInterestRate, amortizationPeriod);
        double monthlyPayment = loanAmount * monthlyInterestRate * power / (power - 1);

        return Math.round(monthlyPayment * 100.0) / 100.0; // Round to two decimal places
    }

}

