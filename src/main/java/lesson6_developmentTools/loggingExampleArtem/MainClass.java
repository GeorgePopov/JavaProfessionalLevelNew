package lesson6_developmentTools.loggingExampleArtem;

import java.util.logging.*;

// Логирование в консоль встроенное в Java
public class MainClass {

    private static final Logger logger = Logger.getLogger("");

    public static void main(String[] args) {

        // можно без этих настроек
        logger.setLevel(Level.ALL); // задаём уровень
        logger.getHandlers()[0].setLevel(Level.ALL); // задаём слушатель (Handler по умолчанию уровень INFO)
        logger.getHandlers()[0].setFormatter(new Formatter() { // задаём форматирование вывода в консоль
            @Override
            public String format(LogRecord record) {
                return record.getLevel() + "\t" + record.getMessage() + "\t" + record.getMillis() + "\n";
            }
        });

        logger.getHandlers()[0].setFilter(new Filter() { // задаём фильтр по названию 'Java'
            @Override
            public boolean isLoggable(LogRecord record) {
                return record.getMessage().startsWith("Java");
            }
        });

        logger.log(Level.SEVERE, "Java SERVER");
        logger.log(Level.SEVERE, "C# SERVER");
        logger.log(Level.INFO, "Java INFO");
        logger.log(Level.INFO, "go INFO");
        logger.log(Level.CONFIG, "Java CONFIG");
        logger.log(Level.FINE, "Java FINE");
        logger.log(Level.FINE, "Python FINE");

    }
}
