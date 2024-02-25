public class ReservationThread extends Thread {
    private final Hotel hotel;
    private final boolean syncFlag;
    private int volume;

    public ReservationThread(Hotel hotel, boolean syncFlag, int volume) {
        this.hotel = hotel;
        this.syncFlag = syncFlag;
        this.volume = volume;
    }

    public void run() {
        if (syncFlag) {
            synchronized (hotel) {
                reservation();
            }
        } else {
            reservation();
        }
    }

    private void reservation() {
        // ================== CRITICAL SECTION ==================
        for (int i = 0; i < volume; i++) {
            hotel.reserveRoom(50);
            hotel.removeRoom();
        }
        // ================== CRITICAL SECTION ==================
    }
}
