public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Please enter your name: ");
        String name = System.console().readLine();
        System.out.println("Hello " + name);
    }
}
