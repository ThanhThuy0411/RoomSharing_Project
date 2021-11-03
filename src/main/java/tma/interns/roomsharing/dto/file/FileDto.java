package tma.interns.roomsharing.dto.file;

import lombok.Data;
import tma.interns.roomsharing.enumration.FileType;

import java.util.UUID;

@Data
public class FileDto {
    private String name;
    private FileType type;
    private int parentType;
    private UUID parentId;
    private String url;
}
