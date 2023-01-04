package sample.config;

// Options for the printer mechanism
public class PrinterOptions {

    private int pages = 1;
    private BlackAndWhite colorChoice;
    private PaperSize paperSize;
    private Orientation orientation;

    enum PaperSize {
        A5, A4, A3, A2, A1
    }

    enum Orientation {
        PORTRAIT, LANDSCAPE
    }

    enum BlackAndWhite {
        TRUE,FALSE
    }

}

