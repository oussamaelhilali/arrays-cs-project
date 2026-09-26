package samplearrays;

public class CourseNumbersArray {
    public static void main(String[] args) {
        int[] registeredCourses = {1010, 1020, 2080, 2140, 2150, 2160};
        int newCourse = 3050;
        int[] updatedCourses = new int[registeredCourses.length + 1];

        for (int i = 0; i <registeredCourses.length; i++) {
            updatedCourses[i] = registeredCourses[i];
        }

        updatedCourses[updatedCourses.length - 1] = newCourse;

        System.out.println("Courses updated: ");
        for (int i = 0; i < updatedCourses.length; i++) {
            System.out.println((updatedCourses[i] + " "));
        }
        System.out.println();

        int courseToFind = 2000;

        boolean found = false;

        for (int i = 0; i < updatedCourses.length; i++) {
            if (updatedCourses[i] == courseToFind) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("The course " + courseToFind + " is in the list");
        } else {
            System.out.println("The course" + courseToFind + " is not in the list");
        }

    }
}
