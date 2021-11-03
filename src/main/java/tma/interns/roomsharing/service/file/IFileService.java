package tma.interns.roomsharing.service.file;

import tma.interns.roomsharing.dto.file.FileDto;

import java.util.*;

public interface IFileService {
    FileDto createFile (FileDto file);
    FileDto updateFile (FileDto file, UUID fileId);
    FileDto getById (UUID fileId);
    boolean delete(UUID fileId);
    List<FileDto> getByParentTypeAndParentId(int parentType, UUID parentId);
    void deleteByParentTypeAndParentId(int parentType, UUID parentId);
}
