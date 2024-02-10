public class ReserveThread extends Thread {
    private final Reservation sender;
    private final String status;
    private final boolean isSync;

    public ReserveThread(Reservation sender, String status, boolean isSync) {
        this.sender = sender;
        this.status = status;
        this.isSync = isSync;
    }

    @Override
    public void run() {
        if (isSync) {
            sender.reserveSync(this.getName(), status);
        } else {
            sender.reserveUnSync(this.getName(), status);
        }
    }
}
