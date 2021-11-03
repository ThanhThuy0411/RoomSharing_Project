package tma.interns.roomsharing.dto.file;

import lombok.Data;

import java.util.UUID;
@Data
public class FileSearchDto {
    private int parentType;
    private UUID parentId;
}
