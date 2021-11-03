package tma.interns.roomsharing.enumration;

public enum ShareRole {
    Key ("key",0),
    Member("member",1);
    private final String key;
    private final Integer value;

    ShareRole(String key, Integer value) {
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
