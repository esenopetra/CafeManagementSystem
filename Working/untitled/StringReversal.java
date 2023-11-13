public class StringReversal {
    public static String reverseString(String input) {
        char[] characters = input.toCharArray();
        int left = 0;
        int right = characters.length - 1;

        while (left < right) {
            // Swap characters at the left and right positions
            char temp = characters[left];
            characters[left] = characters[right];
            characters[right] = temp;

            // Move the pointers towards each other
            left++;
            right--;
        }

        return new String(characters);
    }

    public static void main(String[] args) {
        String original = "ERFAN";
        String reversed = reverseString(original);

        System.out.println("Original String: " + original);
        System.out.println("Reversed String: " + reversed);
    }
}
