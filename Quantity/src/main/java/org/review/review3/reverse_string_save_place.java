package review;

public class reverse_string_save_place {
    public static void main(String[] args) {
        String s = "India Is my country";
        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] == ' ') {
                left++;
            }
            else if (arr[right] == ' ') {
                right--;
            }
            else {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        System.out.println(new String(arr));
    }
}