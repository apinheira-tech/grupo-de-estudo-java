package cap5.exercs;

public class ArrayDeString {
    // Demostracao de um array de String
    public static void main(String[] args) {
        //String strs[] = new String[5];
        String strs[] = {"This", "is", "a", "test.", "ok"};
        System.out.println("Original array:");
        for (String s : strs)
            System.out.print(s + " " + "\n");
        // Change a String
        strs[1] = "was";
        strs[3] = "test, too! ";
        System.out.println("Modified array:");
        for (String s : strs)
            System.out.print(s + " ");
    }
}
