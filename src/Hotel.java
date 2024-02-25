public class Hotel {
    private int balance;
    private int roomCount;

    public Hotel(int roomCount, int balance) {
        this.roomCount = roomCount;
        this.balance = balance;
    }

    public void removeRoom() {
        roomCount--;
    }

    public void reserveRoom(int price) {
        balance += price;
    }

    public int getBalance() {
        return balance;
    }

    public int getRoomCount() {
        return roomCount;
    }
}
