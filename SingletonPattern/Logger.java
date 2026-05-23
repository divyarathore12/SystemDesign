public class Loggger {
    private static volatile Logger instance;

    private Logger() {
    }

    public static Logger getInstance() {
        if (instance == null) {
            // here we are writing Logger.class becuase it is static function and don't have object => can't use this, so internally java create class object which have everything of object
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }
    public void log(String message)
    {
        System.out.println("Log: "+message);
    }

}