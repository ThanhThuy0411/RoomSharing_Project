package tma.interns.roomsharing.enumration;

public enum FileParentType
{
    Room("room",1),
    Review("review",2),
    Comment("comment",3);

   private final String key;
   private final Integer value;

    FileParentType(String key, Integer value) {
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
