package sample;

public class Crypt {

    public String crypt(int key, String text) {

        key = Math.abs(key);
        char[] mass = text.toCharArray();
        String newText = "";

        for (int i = 0; i < mass.length; i++) {
            if ((int) mass[i] >= 97 && (int) mass[i] <= 122) { // eng small
                if ((int) mass[i] + key <= 122) newText += (char) ((int) mass[i] + key);
                else {
                    int over = (int) mass[i] + key - 122 - 1;
                    int mod = over % (122 - 97 + 1);
                    System.out.println("mod: " + mod + "; over: " + over);
                    newText += (char) (97 + mod);
                }
            } else if ((int) mass[i] >= 65 && (int) mass[i] <= 90) { // eng Big
                if ((int) mass[i] + key <= 90) newText += (char) ((int) mass[i] + key);
                else {
                    int over = (int) mass[i] + key - 90 - 1;
                    int mod = over % (90 - 65 + 1);
                    //if (mod < 0) mod = Math.abs(mod) - 1;
                    System.out.println("mod: " + mod + "; over: " + over);
                    newText += (char) (65 + mod);
                }
            } else if ((int) mass[i] >= 1072 && (int) mass[i] <= 1103) { // rus small
                if ((int) mass[i] + key <= 1103) newText += (char) ((int) mass[i] + key);
                else {
                    int over = (int) mass[i] + key - 1103 - 1;
                    int mod = over % (1103 - 1072 + 1);
                    System.out.println("mod: " + mod + "; over: " + over);
                    newText += (char) (1072 + mod);
                }
            } else if ((int) mass[i] >= 1040 && (int) mass[i] <= 1071) { // rus Big
                if ((int) mass[i] + key <= 1071) newText += (char) ((int) mass[i] + key);
                else {
                    int over = (int) mass[i] + key - 1071 - 1;
                    int mod = over % (1071 - 1040 + 1);
                    System.out.println("mod: " + mod + "; over: " + over);
                    newText += (char) (1040 + mod);
                }
            } else newText += mass[i];
        }

        System.out.println("newText: " + newText);
        return  newText;
    }

}
