package sample.liskov.demo1;

public class MenuExampleWrong {

    static class MenuItem {

        protected int price;
        protected String label;
        protected String description;

        protected MenuItem(int price, String label, String description) {
            this.price = price;
            this.label = label;
            this.description = description;
        }

        protected int getPrice() {
            return this.price;
        }
    }

    static class KidItem extends MenuItem {

        public KidItem(int price, String label, String description) {
            super(price, label, description);
        }

        public double getPriceWithDiscount(int discountPercent) {
            return this.price - (discountPercent * 0.01 * this.price);
        }
    }

    static void printItemPrice(MenuItem item) {
        if (item instanceof KidItem) {
            System.out.printf("Kid item = %f %n", ((KidItem) item).getPriceWithDiscount(3));
        } else {
            System.out.printf("Menu item = %d %n", item.getPrice());
        }
    }

    public static void main(String[] args) {
        MenuItem menuItem = new MenuItem(10, "Pen", "Pen for Teenagers");
        KidItem kidItem = new KidItem(10, "Pencil", "Pencil for Children");

        printItemPrice(menuItem);
        printItemPrice(kidItem);
    }
}
