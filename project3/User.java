package project3;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Project 3 -- User
 *
 * This program stores the employee and patron array list and
 * a few methods used to modify the list.
 *
 *
 * @author Yicheng Huang, lab sec LE1 Monday 3:30 pm - 5:30 pm
 * @version March 15, 2020
 *
 */

public class User {
    private ArrayList<Employee> employees = new ArrayList<>();
    private ArrayList<Patron> patrons = new ArrayList<>();

    public User() { }

    public void loadUsers(File employeeRecords, File patronRecords) throws IOException, UnsupportedFileException {
        FileReader frEmployee = new FileReader(employeeRecords);
        BufferedReader bfrEmployee = new BufferedReader(frEmployee);

        FileReader frPatron = new FileReader(patronRecords);
        BufferedReader bfrPatron = new BufferedReader(frPatron);

        while (true) {
            String[] employeeList;
            String line = bfrEmployee.readLine();
            if (line == null) {
                break;
            }
            employeeList = line.split(",");
            if (employeeList.length < 6) {
                throw new UnsupportedFileException("Missing fields in the file!");
            }
            employeeList[5] = employeeList[5].trim();
            String[] last = employeeList[5].split(" ");
            for (int i = 0; i < last.length; i++) {
                last[i] = last[i].trim();
            }
            ArrayList<String> actionList = new ArrayList<>(Arrays.asList(last));
            Employee employeeInfo = new Employee(Integer.parseInt(employeeList[0].trim()), employeeList[1].trim(),
                    employeeList[2].trim(), Double.parseDouble(employeeList[3].trim()),
                    Double.parseDouble(employeeList[4].trim()), actionList);
            addEmployee(employeeInfo);
        }
        bfrEmployee.close();

        while (true) {
            String[] patronList;
            String line = bfrPatron.readLine();
            if (line == null) {
                break;
            }
            patronList = line.split(",");
            if (patronList.length < 6) {
                throw new UnsupportedFileException("Missing fields in the file!");
            }
            patronList[5] = patronList[5].trim();
            ArrayList<Integer> bookList = new ArrayList<>();
            String[] last = patronList[5].split(" ");
            for (String bookID : last) {
                bookList.add(Integer.parseInt(bookID.trim()));
            }

            Patron patronInfo = new Patron(Integer.parseInt(patronList[0].trim()), patronList[1].trim(),
                    patronList[2].trim(), patronList[3].trim(), patronList[4].trim(), bookList);
            addPatron(patronInfo);
        }
        bfrPatron.close();
    }

    public void writeUsers(File employeeRecords, File patronRecords) throws FileNotFoundException {
        FileOutputStream fosEmployee = new FileOutputStream(employeeRecords);
        PrintWriter pw1 = new PrintWriter(fosEmployee);

        FileOutputStream fosPatron = new FileOutputStream(patronRecords);
        PrintWriter pw2 = new PrintWriter(fosPatron);

        for (Employee element : employees) {
            String rate = String.format("%.2f", element.getHourlyRate());
            String hour = String.format("%.0f", element.getHoursWorked());
            String newContent = element.getId() + ", " + element.getName() + ", " + element.getAddress() +
                    ", " + rate + ", " + hour + ", ";
            for (int i = 0; i < element.getActionList().size(); i++) {
                newContent += element.getActionList().get(i);
                if (i == element.getActionList().size() - 1) {
                    break;
                }
                newContent += " ";
            }
            pw1.println(newContent);
        }
        pw1.close();

        for (Patron element : patrons) {
            String newContent = element.getId() + ", " + element.getName() + ", " + element.getAddress() +
                    ", " + element.getEmail() + ", " + element.getPhoneNumber() + ", ";
            for (int j = 0; j < element.getBookLoanList().size(); j++) {
                newContent += element.getBookLoanList().get(j);
                if (j == element.getBookLoanList().size() - 1) {
                    break;
                }
                newContent += " ";
            }
            pw2.println(newContent);
        }
        pw2.close();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void addPatron(Patron patron) {
        patrons.add(patron);
    }

    public boolean removeEmployee(int id) {
        for (Employee element : employees) {
            if (element.getId() == id) {
                employees.remove(element);
                return true;
            }
        }
        return false;
    }

    public boolean removePatron(int id) {
        for (Patron element: patrons) {
            if (element.getId() == id) {
                patrons.remove(element);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Employee> getEmployees() {
        return this.employees;
    }
    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }
    public ArrayList<Patron> getPatrons() {
        return this.patrons;
    }
    public void setPatrons(ArrayList<Patron> patrons) {
        this.patrons = patrons;
    }
}
