package Singleton;

import Domain.Kurierfirmen;

public class KurierfirmenSingleton {
    private static Kurierfirmen instance;

    private KurierfirmenSingleton() {}

    public static Kurierfirmen getInstance() {
        if (instance == null) {
            instance = new Kurierfirmen();
            System.out.println("S-a creat o instanta unica a clasei Kurierfirmen.");

        }
        return instance;
    }
}