package tma.interns.roomsharing.enumration;

public enum RoomType {
    Room("room",1),
    House("house",2);
    private final String key;
    private final Integer value;

    RoomType(String key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public Integer getValue() {
        return value;
    }
}
