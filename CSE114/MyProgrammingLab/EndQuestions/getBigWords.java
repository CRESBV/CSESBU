public class getBigWords {
    public static void main(String[] args) {
        System.out.println(java.util.Arrays.toString(getBigWords("there-is-large chiken coming")));
    }

    public static String[] getBigWords(String line) {
        line = line.replace('@', ' ');
        line = line.replace('.', ' ');
        line = line.replace(',', ' ');

        for (int i = 0; i < line.length(); i++) {
            if (Character.isDigit(line.charAt(i))) {
                char temp = line.charAt(i);
                line = line.replace(temp,' ');
            }
        }

        String[] splitArray = line.split(" ");
        java.util.ArrayList<String> tempArrayList = new java.util.ArrayList<>();

        for (int i = 0; i < splitArray.length; i++) {
            boolean nonLetterFound = false;

            for (int j = 0; j < splitArray[i].length(); j++) {
                if (!Character.isLetter(splitArray[i].charAt(j))) {
                    nonLetterFound = true;
                }
            }

            if (!nonLetterFound && splitArray[i].length() > 5) {
                tempArrayList.add(splitArray[i]);
            }
        }

        String[] arr = tempArrayList.toArray(new String[0]);
        return arr;
    }
}
