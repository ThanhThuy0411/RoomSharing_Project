package tma.interns.roomsharing.enumration;

public enum FileType
{
    Image("image",1),
    Audio("audio",2),
    Video("video",3),
    Document("document",4);

   private final String key;
   private final Integer value;

    FileType(String key, Integer value) {
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
