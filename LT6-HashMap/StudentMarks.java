package LT6_HashMap;
import java.util.HashMap;
import java.util.Map;

public class StudentMarks {
    public static void main(String[] args) {
        Map<String, Integer> studentMap = new HashMap<>();

        // 1. Insert five student records into the map
        studentMap.put("Ali", 85);
        studentMap.put("Zara", 92);
        studentMap.put("Usman", 78);
        studentMap.put("Sara", 90);
        studentMap.put("Hamza", 88);
        // 2. Display all student records
        System.out.println("--- All Student Records ---");
        for (Map.Entry<String, Integer> entry : studentMap.entrySet()) {
            System.out.println("Student: " + entry.getKey() + " | Marks: " + entry.getValue());
        }

        // 3. Update the marks of one student
        System.out.println("\n--- Updating Student Mark ---");
        studentMap.put("Usman", 84);
        System.out.println("Updated Marks for Usman: " + studentMap.get("Usman"));

        // 4. Retrieve and display the marks of a specific student
        System.out.println("\n--- Retrieve Specific Student Marks ---");
        String searchStudent = "Zara";
        System.out.println("Marks for " + searchStudent + ": " + studentMap.get(searchStudent));
        // 5. Display total number of students in the map
        System.out.println("\nTotal number of students in map: " + studentMap.size());
    }
}