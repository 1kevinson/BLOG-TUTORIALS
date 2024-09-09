package com.example.a_one_indentation_level;

public class BoardValid {

    public String displayBoard(char[][][] data) {
        StringBuilder buffer = new StringBuilder();
        collectRows(buffer,data);

        return buffer.toString();
    }

    private void collectRows(StringBuilder buffer, char[][][] data) {
        for (int i = 0; i < 10; i++) {
            collectRow(buffer, data, i);
        }
    }

    private void collectRow(StringBuilder buffer, char[][][] data, int row) {
        for (int i = 0; i < 10; i++) {
            buffer.append(data[row][i]);
        }

        buffer.append("\n");
    }
}
