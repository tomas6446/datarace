
public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting synchronized threads...");
        processThreads(true);
        System.out.println("Synchronized threads complete.\n\n");

        System.out.println("Starting unsynchronized threads...");
        processThreads(false);
        System.out.println("Unsynchronized threads complete.");
    }

    private static void processThreads(boolean syncFlag) throws InterruptedException {
        Hotel hotel = new Hotel(20000, 0);
        ReservationThread[] threads = new ReservationThread[20];

        for (int i = 0; i < 20; i++) {
            threads[i] = new ReservationThread(hotel, syncFlag, 1000);
            threads[i].setName(syncFlag ? "SyncThread-" + i : "UnsyncThread-" + i);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Expected hotel balance: " + 20000000 + " got: " + hotel.getBalance());
        System.out.println("Expected hotel room count: " + 0 + " got: " + hotel.getRoomCount());
    }
}
