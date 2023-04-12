package sample.srp.good;

public class DemoSrp {

    public static void main(String[] args) {
        CTO albert = new CTO();
        albert.save(); // This is his role as CTO
        albert.participateMeeting("2023-04-06"); // This a shared role by all executive

        CFO hannah = new CFO();
        hannah.calculatePay(); // This is her role as CFO
        hannah.participateMeeting("2023-04-06"); // This a shared role by all executive
    }
}
