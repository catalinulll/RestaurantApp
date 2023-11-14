package Strategy;

import java.util.Random;

public enum TransportType {
    MASINA,
    BICICLETA,
    MOTOCICLETA,
    PE_JOS,
    TROTINETA,
    AVION;

    private static final TransportType[] VALUES = values();
    private static final int SIZE = VALUES.length;
    private static final Random RANDOM = new Random();

    public static TransportType getRandomTransportType() {
        return VALUES[RANDOM.nextInt(SIZE)];
    }

}