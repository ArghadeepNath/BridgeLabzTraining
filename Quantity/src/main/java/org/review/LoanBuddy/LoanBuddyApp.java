package org.review.LoanBuddy;

import java.util.ArrayList;
import java.util.List;

interface IApprovable {
    boolean approveLoan();
    double calculateEMI();
}

class Applicant {
    private final String name;
    private final int creditScore;
    private final double income;
    private final double loanAmount;

    public Applicant(String name, int creditScore, double income, double loanAmount) {
        this.name = name;
        this.creditScore = creditScore;
        this.income = income;
        this.loanAmount = loanAmount;
    }

    public String getName() {
        return name;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public double getIncome() {
        return income;
    }

    public double getLoanAmount() {
        return loanAmount;
    }
}

class LoanApplication implements IApprovable {
    protected final Applicant app;
    private final String loanType;
    private final int term;
    private final double interestRate;
    private String status;

    public LoanApplication(Applicant app, String loanType, int term, double interestRate) {
        this.app = app;
        this.loanType = loanType;
        this.term = term;
        this.interestRate = interestRate;
    }

    protected void setStatus(String status) {
        this.status = status;
    }

    public String getLoanType() {
        return loanType;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public boolean approveLoan() {
        if (app.getCreditScore() >= 650 && app.getIncome() >= 30000) {
            setStatus("Approved");
            return true;
        }
        setStatus("Rejected");
        return false;
    }

    @Override
    public double calculateEMI() {
        double p = app.getLoanAmount();
        double r = interestRate / (12 * 100);
        int n = term;
        return (p * r * Math.pow(1 + r, n)) / (Math.pow(1 + r, n) - 1);
    }

    public void display() {
        System.out.println("Applicant: " + app.getName());
        System.out.println("Loan Type: " + loanType);
        System.out.println("Status: " + status);
        if ("Approved".equals(status)) {
            System.out.printf("EMI: %.2f%n", calculateEMI());
        }
        System.out.println("---------------------");
    }
}

class HomeLoan extends LoanApplication {
    public HomeLoan(Applicant app, int term, double interestRate) {
        super(app, "HomeLoan", term, interestRate);
    }

    @Override
    public boolean approveLoan() {
        if (app.getCreditScore() >= 700 && app.getIncome() >= 50000) {
            setStatus("Approved");
            return true;
        }
        setStatus("Rejected");
        return false;
    }
}

class PersonalLoan extends LoanApplication {
    public PersonalLoan(Applicant app, int term, double interestRate) {
        super(app, "PersonalLoan", term, interestRate);
    }

    @Override
    public boolean approveLoan() {
        if (app.getCreditScore() >= 700 && app.getIncome() >= 40000) {
            setStatus("Approved");
            return true;
        }
        setStatus("Rejected");
        return false;
    }
}

class AutoLoan extends LoanApplication {
    public AutoLoan(Applicant app, int term, double interestRate) {
        super(app, "AutoLoan", term, interestRate);
    }

    @Override
    public boolean approveLoan() {
        if (app.getCreditScore() >= 650 && app.getIncome() >= 30000) {
            setStatus("Approved");
            return true;
        }
        setStatus("Rejected");
        return false;
    }
}

public class LoanBuddyApp {
    public static void main(String[] args) {
        List<LoanApplication> loans = new ArrayList<>();

        loans.add(new HomeLoan(new Applicant("Rahul", 750, 60000, 500000), 60, 7.5));
        loans.add(new PersonalLoan(new Applicant("Sneha", 600, 25000, 200000), 36, 12));
        loans.add(new AutoLoan(new Applicant("Amit", 720, 40000, 300000), 48, 9));

        for (LoanApplication loan : loans) {
            loan.approveLoan();
            loan.display();
        }
    }
}