import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Student {
private String name;
private String surname;
private String studentID;
private double GPA;
private String department;
private int enrollmentYear;
private String dateOfBirth;

    public Student(String name, String surname, String studentID, double GPA, String department, int enrollmentYear, String dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.studentID = studentID;
        this.GPA = GPA;
        this.department = department;
        this.enrollmentYear = enrollmentYear;
        this.dateOfBirth = dateOfBirth;
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getEnrollmentYear() {
        return enrollmentYear;
    }

    public void setEnrollmentYear(int enrollmentYear) {
        this.enrollmentYear = enrollmentYear;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    // toString method to print out object data
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", studentID='" + studentID + '\'' +
                ", GPA=" + GPA +
                ", department='" + department + '\'' +
                ", enrollmentYear=" + enrollmentYear +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }

    public static Student[] readCSV(String filePath) {
        int numStudents = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // get number of lines in file (excluding header)
            numStudents = (int) br.lines().skip(1).count();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Student[] students = new Student[numStudents];

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int i = 0;
            boolean firstLine = true; // skip first line (header)
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String[] fields = line.split(",");
                String name = fields[0];
                String surname = fields[1];
                String studentID = fields[2];
                double GPA = Double.parseDouble(fields[3]);
                String department = fields[4];
                int enrollmentYear = Integer.parseInt(fields[5]);
                String dateOfBirth = fields[6];
                Student student = new Student(name, surname, studentID, GPA, department, enrollmentYear, dateOfBirth);
                students[i++] = student;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }

    public static String toJSArray(Student[] students) {
        String jsArray = "[\n";
        for (int i = 0; i < students.length; i++) {
            Student student = students[i];
            jsArray += "  {\n";
            jsArray += "    Name: \"" + student.getName() + "\",\n";
            jsArray += "    Surname: \"" + student.getSurname() + "\",\n";
            jsArray += "    \"Student ID\": \"" + student.getStudentID() + "\",\n";
            jsArray += "    GPA: " + student.getGPA() + ",\n";
            jsArray += "    Department: \"" + student.getDepartment() + "\",\n";
            jsArray += "    \"Enrollment Year\": " + student.getEnrollmentYear() + ",\n";
            jsArray += "    \"Date of Birth\": \"" + student.getDateOfBirth() + "\"\n";
            if (i == students.length - 1) {
                jsArray += "  }\n";
            } else {
                jsArray += "  },\n";
            }
        }
        jsArray += "]";
        return jsArray;
    }

    public static String toPythonList(Student[] students) {
        String pythonList = "[\n";
        for (int i = 0; i < students.length; i++) {
            Student student = students[i];
            pythonList += "  {\n";
            pythonList += "    \"Name\": \"" + student.getName() + "\",\n";
            pythonList += "    \"Surname\": \"" + student.getSurname() + "\",\n";
            pythonList += "    \"Student ID\": \"" + student.getStudentID() + "\",\n";
            pythonList += "    \"GPA\": " + student.getGPA() + ",\n";
            pythonList += "    \"Department\": \"" + student.getDepartment() + "\",\n";
            pythonList += "    \"Enrollment Year\": " + student.getEnrollmentYear() + ",\n";
            pythonList += "    \"Date of Birth\": \"" + student.getDateOfBirth() + "\"\n";
            if (i == students.length - 1) {
                pythonList += "  }\n";
            } else {
                pythonList += "  },\n";
            }
        }
        pythonList += "]";
        return pythonList;
    }
}