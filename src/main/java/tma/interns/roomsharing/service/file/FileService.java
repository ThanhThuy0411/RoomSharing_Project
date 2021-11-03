package tma.interns.roomsharing.service.file;

import org.springframework.stereotype.Service;
import tma.interns.roomsharing.dto.file.FileDto;
import tma.interns.roomsharing.entity.FileEntity;
import tma.interns.roomsharing.mapper.IFileMapper;
import tma.interns.roomsharing.repository.FileRepository;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class FileService implements IFileService {
    private final FileRepository fileRepo;
    private final IFileMapper fileMapper;
    public FileService(FileRepository fileRepo, IFileMapper fileMapper) {
        this.fileRepo = fileRepo;
        this.fileMapper = fileMapper;
    }

    /**
     * create file
     *
     * @author tt0411
     * @param file
     * @return file detail
     */
    public FileDto createFile (FileDto file){
        FileEntity fileEntity = fileMapper.fromFileDtoToFileEntity(file);
        FileEntity returnFile = fileRepo.save(fileEntity);
        return fileMapper.toFileDto(returnFile);
    }

    /**
     * update fiel
     *
     * @author tt0411
     * @param fileDto
     * @param fileId
     * @return new file
     */
    public FileDto updateFile (FileDto fileDto, UUID fileId){
        FileEntity fileEntity = fileMapper.fromFileDtoToFileEntity(fileDto);
        fileEntity.setFileId(fileId);
        FileEntity returnFile = fileRepo.save(fileEntity);
        return fileMapper.toFileDto(returnFile);
    }

    /**
     * delete file
     *
     * @author tt0411
     * @param fileId
     * @return status 200
     */
    public boolean delete(UUID fileId) {
        FileEntity fileEntity = fileRepo.findFirstByFileId(fileId);
        if(fileEntity != null){
           fileRepo.deleteById(fileId);
           return true;
        }
        return false;
    }

    /**
     * get file by fileId
     *
     * @author tt0411
     * @param fileId
     * @return file detail by fileId
     */
    public FileDto getById (UUID fileId){
        FileEntity fileEntity = fileRepo.findFirstByFileId(fileId);
        if(fileEntity != null){
            return fileMapper.toFileDto(fileEntity);
        }
        return  null;
    }

    /**
     * get file by parentType and parentId
     *
     * @author tt0411
     * @param parentType
     * @param parentId
     * @return file detail by parentType and parentId
     */
    @Override
    public List<FileDto> getByParentTypeAndParentId(int parentType, UUID parentId) {
        List<FileEntity> fileEntity2 = fileRepo.findByParentTypeAndParentId(parentType,parentId);
        if (fileEntity2 != null){
            return fileMapper.toFileDtos(fileEntity2);
        }
        return null;
    }

    @Override
    public void deleteByParentTypeAndParentId(int parentType, UUID parentId) {
        List<FileEntity> fileEntities = fileRepo.findByParentTypeAndParentId(parentType,parentId);
        for(FileEntity file : fileEntities) {
            delete(file.getFileId());
        }
    }

}
