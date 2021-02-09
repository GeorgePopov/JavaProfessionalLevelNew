package lesson6_developmentTools.loggingExampleArtem;

import java.io.IOException;
import java.util.logging.*;

public class MainClass2 {
    private static final Logger logger = Logger.getLogger(lesson6_developmentTools.loggingExampleArtem.MainClass2.class.getName());

    public static void main(String[] args) throws IOException {

        // создаём хендлер, указываем файл(можно указать путь), который создасться при логирование.
        // append:true означает, что не надо перезаписывать логи в файле.
        Handler handler = new FileHandler("myLog.log", true);
        handler.setLevel(Level.ALL);                 // устанавливаем уровень
        handler.setFormatter(new SimpleFormatter()); // устанавливаем свойство форматирования
        logger.addHandler(handler);                  // прикрепляем хендлер к логиру

        logger.log(Level.SEVERE, "Java SERVER");
        logger.log(Level.SEVERE, "C# SERVER");
        logger.log(Level.INFO, "Java INFO");
        logger.log(Level.INFO, "go INFO");
        logger.log(Level.CONFIG, "Java CONFIG");
        logger.log(Level.FINE, "Java FINE");
        logger.log(Level.FINE, "Python FINE");
    }
}
