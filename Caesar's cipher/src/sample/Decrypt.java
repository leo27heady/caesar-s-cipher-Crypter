package sample;

public class Decrypt {

    public String decrypt(int key, String text) {

        key = Math.abs(key);
        char[] mass = text.toCharArray();
        String newText = "";

        for (int i = 0; i < mass.length; i++) {
            if ((int) mass[i] >= 97 && (int) mass[i] <= 122) { // eng small
                if ((int) mass[i] - key >= 97) newText += (char) ((int) mass[i] - key);
                else {
                    int under = 97 - ((int) mass[i] - key) - 1;
                    int mod = under % (122 - 97 + 1);
                    newText += (char) (122 - mod);
                }
            } else if ((int) mass[i] >= 65 && (int) mass[i] <= 90) { // eng Big
                if ((int) mass[i] - key >= 65) newText += (char) ((int) mass[i] - key);
                else {
                    int under = 65 - ((int) mass[i] - key) - 1;
                    int mod = under % (90 - 65 + 1);
                    newText += (char) (90 - mod);
                }
            } else if ((int) mass[i] >= 1072 && (int) mass[i] <= 1103) { // rus small
                if ((int) mass[i] - key >= 1072) newText += (char) ((int) mass[i] - key);
                else {
                    int under = 1072 - ((int) mass[i] - key) - 1;
                    int mod = under % (1103 - 1072 + 1);
                    newText += (char) (1103 - mod);
                }
            } else if ((int) mass[i] >= 1040 && (int) mass[i] <= 1071) { // rus Big
                if ((int) mass[i] - key >= 1040) newText += (char) ((int) mass[i] - key);
                else {
                    int under = 1040 - ((int) mass[i] - key) - 1;
                    int mod = under % (1071 - 1040 + 1);
                    newText += (char) (1071 - mod);
                }
            } else newText += mass[i];
        }

        System.out.println("newText: " + newText);
        return  newText;
    }

}