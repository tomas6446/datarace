public class Reservation {
    private String status = "Available";

    public void reserveUnSync(String threadName, String newStatus) {
        reserve(threadName, newStatus);
    }

    public synchronized void reserveSync(String threadName, String newStatus) {
        reserve(threadName, newStatus);
    }

    /*
        * Metodas, kuris simbolizuoja rezervacijos veiksmą.
        * critical section - status kintamasis
     */
    private void reserve(String threadName, String newStatus) {
        System.out.println(threadName + ": Attempting to change status to " + newStatus);

        try {
            // Atsitiktinis gijų užlaikymas, siekiant padidinti programos nedeterminizmą.
            Thread.sleep((long) (Math.random() * 200));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        if (this.status.equals("Available")) {
            this.status = newStatus;
            System.out.println(threadName + ": Reservation succeeded");
        } else {
            System.out.println(threadName + ": Reservation failed - Status is " + this.status);
        }
    }

    public void setStatus(String available) {
        this.status = available;
    }
}
