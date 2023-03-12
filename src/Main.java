import ru.mvp.Console;
import ru.mvp.Presenter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Presenter p = new Presenter(new Console());
        p.update();
    }
}
