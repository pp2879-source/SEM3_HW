public class TrafficLightDemo {

    static class TrafficLight {
        private final String id;
        private String color;

        public TrafficLight(String id) {
            this.id = id;
            this.color = "RED";
        }

        public String next() {
            if (color.equals("RED")) {
                color = "GREEN";
            } else if (color.equals("GREEN")) {
                color = "YELLOW";
            } else {
                color = "RED";
            }
            return color;
        }

        public String getColor() {
            return color;
        }
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");

        System.out.println(t.getColor());
        System.out.println(t.next());
        System.out.println(t.next());
        System.out.println(t.next());
    }
}
