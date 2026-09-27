package samplearrays;

import java.util.Arrays;
import java.util.Comparator;

public class ManageStudent {

    // 2) Find the Oldest Student
    public static Student findOldest(Student[] students) {
        if (students.length == 0) {
            return  null;
        }
        Student oldest = students[0];
        for (int i = 1; i < students.length; i++) {
            if (students[i].getAge() > oldest.getAge()) {
                oldest = students[i];
            }
        }
        return oldest;
    }

    // 3) Count Adult Students (age >= 18)
    public static int countAdults(Student[] students) {
        int count = 0;
        for (Student s : students) {
            if (s.isAdult()) {
                count++;
            }
        }
        return count;
    }

    // 4) Average Grade (returns NaN if no students or grades)
    public static double averageGrade(Student[] students) {
        if (students == null || students.length == 0) {
            return Double.NaN;
        }
        double sum = 0;
        for (Student s : students) {
            sum += s.getGrade();
        }
        return sum / students.length;
    }

    // 5) Search by Name (case-sensitive; change to equalsIgnoreCase if desired)
    public static Student findStudentByName(Student[] students, String name) {
        if (students == null) return null;
        for (Student s : students) {
            if (s.getName().equals(name)) {
                return s;
            }
        }
        return null;
    }

    // 6) Sort Students by Grade (descending)
    public static void sortByGradeDesc(Student[] students) {
        boolean swapped;
        for (int i = 0; i < students.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < students.length - 1 - i; j++) {
                if (students[j].getGrade() < students[j + 1].getGrade()) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    // 7) Print High Achievers (grade >= 15)
    public static void printHighAchievers(Student[] students) {
        if (students == null) return;
        for (Student s: students) {
            if (s.getGrade() >= 15) {
                System.out.println(s);
            }
        }
    }

    // 8) Update Student Grade by id
    public static boolean updateGrade(Student[] students, int id, int newGrade) {
        if (students == null) return false;
        for (Student s: students) {
            if (s.getId() == id) {
                s.setGrade(newGrade);
                return true;
            }
        }
        return false;
    }

    // 9) Find Duplicate Names
    public static boolean hasDuplicateNames(Student[] students) {
        if (students == null) return false;
        for (int i = 0; i < students.length; i++) {
            for (int j = i + 1; j < students.length; j++) {
                if (students[i].getName().equals(students[j].getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    // 10) Expandable Array: return a new array with one more slot and append student
    public static Student[] appendStudent(Student[] students, Student newStudent) {
        if (students == null) return new Student[]{newStudent};
        Student[] newArr = Arrays.copyOf(students, students.length + 1);
        newArr[newArr.length - 1] = newStudent;
        return newArr;
    }

    // 1) Create an Array of Students + demos for all tasks
    public static void main(String[] args) {
        // Create & initialize array of 5 students
        Student[] arr = {
                new Student(1, "Oussama", 19, 14),
                new Student(2, "Ahmed", 17, 16),
                new Student(3, "Hamza", 20, 12),
                new Student(4, "Houssam", 18, 14),
                new Student(5, "Nabil", 21, 13)
        };

        // Print all
        System.out.println("== All Students ==");
        for (Student s : arr) System.out.println(s);
        System.out.println("Total created: " + Student.getNumStudent());

        // 2) Oldest
        Student oldest = findOldest(arr);
        System.out.println("\n== Oldest Student ==");
        System.out.println(oldest);

        // 3) Count adults
        int adultCount = countAdults(arr);
        System.out.println("\nNumber of adult students: " + adultCount);

        // 4) Average grade
        double avg = averageGrade(arr);
        System.out.println("Average grade: " + avg);

        // 5) Find by name
        Student found = findStudentByName(arr, "Mohammed");
        System.out.println("Found by name (Mohammed): " + found);

        // 6) Sort by grade desc
        // sort function
        sortByGradeDesc(arr);
        System.out.println("\n== Sorted by grade (desc) ==");
        for (Student s : arr) System.out.println(s);

        // 7) High achievers >= 15
        System.out.println("\nHigh achievers:");
        printHighAchievers(arr);

        // 8) Update grade by id
        // function
        boolean updated = updateGrade(arr, 4, 18);
        System.out.println("\nUpdated id=4? " + updated);
        System.out.println(findStudentByName(arr, "Dina"));

        // 9) Duplicate names
        boolean hasDupes = hasDuplicateNames(arr);
        System.out.println("\nDuplicate names found? " + hasDupes);

        // 10) Append new student
        arr = appendStudent(arr, new Student(6, "Adam", 22, 16));
        System.out.println("\n== Array after appending a new student ==");
        for (Student s : arr) System.out.println(s);
    }
}

