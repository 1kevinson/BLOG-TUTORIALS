package sample.liskov.demo1;

public class MenuExampleCorrect {

    static class MenuItem {

        protected int price;
        protected String label;
        protected String description;

        protected MenuItem(int price, String label, String description) {
            this.price = price;
            this.label = label;
            this.description = description;
        }

        protected double getPrice() {
            return this.price - getDiscount();
        }

        private double getDiscount() {
            return 0;
        }
    }

    static class KidItem extends MenuItem {

        public KidItem(int price, String label, String description) {
            super(price, label, description);
        }

        @Override
        public double getPrice() {
            return this.price - getDiscount();
        }

        private double getDiscount() {
            int discountPercent = 5;
            return discountPercent * 0.01 * this.price;
        }
    }

    static void printItemPrice(MenuItem item) {
        if (item instanceof KidItem) {
            System.out.printf("Kid item = %.2f %n", item.getPrice());
        } else {
            System.out.printf("Menu item = %.2f %n", item.getPrice());
        }
    }

    public static void main(String[] args) {
        KidItem kidItem = new KidItem(10, "Pencil", "Pencil for Children");
        MenuItem menuItem = new MenuItem(10, "Pen", "Pen for Teenagers");

        printItemPrice(kidItem);
        printItemPrice(menuItem);
    }
}
