import java.io.Console;

import service.NumberService;

public class App {
    public static void main(String[] args) throws Exception {
        NumberService ns = NumberService.getInstance();

        System.out.println("Insira um número: ");
        Console console = System.console();
        String  data = console.readLine();
        Float value = Float.parseFloat(data);

        String result = ns.NumberWatching(value);
        System.out.println(result);
    }
}
