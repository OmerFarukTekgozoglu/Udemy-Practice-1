package com.omerfaruk;
import java.util.Scanner;

public class Email extends Main {
    private int passLength = 6;
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private int mailboxCapacity = 500;
    private String alternateEmail;
    private String regionID = ".edu.tr";
    private String email;
    private double salary;

    public Email(String firtsName, String lastName) {
        this.firstName = firtsName;
        this.lastName = lastName;
        System.out.println("Email created:" + this.firstName + " " + this.lastName);

        this.department = setDepartment();

        this.password = randomPassword(passLength);

        email = getFirtsName().toLowerCase().replaceAll(" ", "") + "." + getLastName().toLowerCase().replaceAll(" ", "") + "@" + getDepartment() + regionID;
        System.out.println("Your e-mail is: " + email);
        System.out.println("Your default password is: " + password);

        System.out.println("Do you want to change the password;\n1)Yes (Recommended)\n2)No (Unsafe)\n3)Continue, the password is default.\n>>");
        Scanner scan = new Scanner(System.in);
        int passwordChoice = scan.nextInt();

        try {
            switch (passwordChoice) {
                case 1:
                    System.out.println("Enter your new password: ");
                    String newPassword = scan.next();
                    setPassword(newPassword);
                    break;
                case 2:
                    System.out.println("Your password is default password: " + this.password);
                    break;
                case 3:
                    System.out.println("Continues.");
                    break;
                default:
                    System.out.println("Wrong input!");
            }
        }catch(Exception e){
            e.printStackTrace();
            setPassword("12345");
        }
        System.out.println("Does the new employee have a certain salary?\n1)Yes and I want to assign.\n2)No, salary is default salary 1600$ for every month.\nYour choice is >>");
        int salaryChoice = scan.nextInt();
        switch (salaryChoice) {
            case 1:
                System.out.print("The salary is: ");
                salary = scan.nextDouble();
                setSalary(salary);
                break;
            case 2:
                salary = 1600.0;
                System.out.println("Salary assigned 1600$.");
                setSalary(salary);
                break;
            default:
                System.out.println("Wrong input!");
        }
        System.out.println("Salary: " + getSalary());
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartment() {
        return department;
    }

    private String setDepartment() {
        System.out.print("Enter your department\n" +
                "1-Sales\n" +
                "2-Development\n" +
                "3-Accounting\n" +
                "4-None\n>>");
        Scanner scan = new Scanner(System.in);
        int choose = scan.nextInt();
        switch (choose) {
            case 1:
                this.department = "salesgazi";
                System.out.println("Choice is successfully!");
                break;
            case 2:
                this.department = "developmentgazi";
                System.out.println("Choice is successfully!");
                break;
            case 3:
                this.department = "accountinggazi";
                System.out.println("Choice is successfully!");
                break;
            case 4:
                System.out.println("Domain id selected to the default id.");
                this.department = "gazi";
                System.out.println("Choice is successfully!");
                break;
            default:
                System.out.println("Your choice is invalid. Please don't do that again!");
        }
        return department;

    }

    public void setPassword(String password) {
        System.out.println("Password changing is successfully done.");
        this.password = password;
    }

    public void setMailboxCapacity(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }

    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    public String getFirtsName() {
        return firstName;
    }

    public String getPassword() {
        return password;
    }


    public String getLastName() {
        return lastName;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPRSTYVZWQX!#$%&*1234567890";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }
}

