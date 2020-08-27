package HW1;

public class SingletonCreateMethods {

}

/**
 *  not thread safe
 */
class Singleton1 {
    private static Singleton1 singleton1;
    /* Singleton's constructor must be private. */
    private Singleton1() {}

    private Singleton1 getSingleton() {
        return singleton1;
    }
}

/**
 * thread safe and lazy loading
 * not efficient
 */
class Singleton2 {
    private static Singleton2 singleton2;
    private Singleton2() {}
    public synchronized Singleton2 getSingleton() {
        if (singleton2 == null) {
            singleton2 = new Singleton2();
        }
        return singleton2;
    }
}

/**
 * thread safe and efficient
 * not lazy loading
 */
class Singleton3 {
    private static Singleton3 singleton3= new Singleton3();
    private Singleton3() {}
    public static Singleton3 getSingleton() {
        return singleton3;
    }
}

/**
 * double checked locking
 */
class Singleton4 {
    private volatile static Singleton4 singleton4;
    private Singleton4() {}
    public static Singleton4 getSingleton() {
        if (singleton4 == null) {
            synchronized (Singleton4.class) {
                if (singleton4 == null) {
                    singleton4 = new Singleton4();
                }
            }
        }
        return singleton4;
    }
}

