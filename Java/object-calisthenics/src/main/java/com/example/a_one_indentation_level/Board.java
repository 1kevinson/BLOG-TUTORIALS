package com.example.a_one_indentation_level;

public class Board {

    public String displayBoard(char[][][] data) {
        StringBuilder buffer = new StringBuilder();

        // 0
        for (int i = 0; i < 10; i++) {
            // 1
            for (int j = 0; j < 10; j++) {
                // 2
                buffer.append(data[i][j]);
            }
            buffer.append("\n");
        }

        return buffer.toString();
    }
}
