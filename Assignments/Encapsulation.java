interface Logger {
    void logInfo(String message);
    void logError(String message);
}

class FileLogger implements Logger {
    @Override
    public void logInfo(String message) {
        System.out.println("Logging info to file: " + message);
    }

    @Override
    public void logError(String message) {
        System.out.println("Logging error to file: " + message);
    }
}

class DatabaseLogger implements Logger {
    @Override
    public void logInfo(String message) {
        System.out.println("Logging info to database: " + message);
    }

    @Override
    public void logError(String message) {
        System.out.println("Logging error to database: " + message);
    }
}

class Application {
    private Logger logger;

    public Application(Logger logger) {
        this.logger = logger;
    }

    public void performApplicationTask() {
        logger.logInfo("Performing application task");
        logger.logError("An error occurred during application task execution.");
    }
}

public class Encapsulation {
    public static void main(String[] args) {
        Logger fileLogger = new FileLogger();
        Logger databaseLogger = new DatabaseLogger();
        Application appWithFileLogger = new Application(fileLogger);
        appWithFileLogger.performApplicationTask();
        Application appWithDatabaseLogger = new Application(databaseLogger);
        appWithDatabaseLogger.performApplicationTask();
    }
}
