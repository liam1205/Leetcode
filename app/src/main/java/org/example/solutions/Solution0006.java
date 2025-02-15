package org.example.solutions;

public class Solution0006 {
    public String convert(String s, int numRows) {
        int row = 0;
        boolean bounce = true;

        StringBuilder[] temp = new StringBuilder[numRows];

        for (int i = 0; i < s.length(); i++) {
            if (row == numRows - 1) {
                bounce = false;
            }
            if (row == 0) {
                bounce = true;
            }

            temp[row].append(s.charAt(i));

            if (bounce) {
                row++;
            } else {
                row--;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < temp.length; i++){
            result.append(temp[i].toString());
        }

        return result.toString();

    }
}
