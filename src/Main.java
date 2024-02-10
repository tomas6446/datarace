import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Reservation reservation = new Reservation();

        System.out.println("Synced threads");
        IntStream.range(0, 2).forEach(i -> new ReserveThread(reservation, "Reserved", true).start());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        reservation.setStatus("Available");

        System.out.println("\n\nUnsynced threads");
        IntStream.range(0, 2).forEach(i -> new ReserveThread(reservation, "Reserved", false).start());
    }
}
