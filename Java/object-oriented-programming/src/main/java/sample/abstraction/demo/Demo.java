package sample.abstraction.demo;

import sample.abstraction.config.PrinterOptions;
import sample.abstraction.main.PrinterMachine;

import static sample.abstraction.config.PrinterOptions.Color.BLACK_AND_WHITE;
import static sample.abstraction.config.PrinterOptions.Orientation.PORTRAIT;
import static sample.abstraction.config.PrinterOptions.PaperSize.A4;

public class Demo {

    public static void main(String[] args) {

        PrinterOptions printerOptions = PrinterOptions.builder()
                                        .pages(2)
                                        .paperSize(A4)
                                        .orientation(PORTRAIT)
                                        .colorChoice(BLACK_AND_WHITE)
                                        .build();

        PrinterMachine printer = new PrinterMachine();
        printer.startPrinting(printerOptions);
    }
}
