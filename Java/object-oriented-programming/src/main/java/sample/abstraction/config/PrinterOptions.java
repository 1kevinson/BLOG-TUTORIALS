package sample.abstraction.config;

import lombok.Builder;

// Options for the printer mechanism
@Builder
public class PrinterOptions {

    private int pages = 1;
    private Color colorChoice;
    private PaperSize paperSize;
    private Orientation orientation;

    public enum PaperSize {
        A5, A4, A3, A2, A1
    }

    public enum Orientation {
        PORTRAIT, LANDSCAPE
    }

    public enum Color {
        BLACK_AND_WHITE, COLORED
    }
}

