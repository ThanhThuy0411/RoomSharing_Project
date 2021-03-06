package tma.interns.roomsharing.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tma.interns.roomsharing.dto.file.FileDto;
import tma.interns.roomsharing.dto.file.FileSearchDto;
import tma.interns.roomsharing.service.file.IFileService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
public class FileController {
    private final IFileService fileService;

    public FileController(IFileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/file")
    public ResponseEntity<FileDto> create(@RequestBody FileDto newFile) {
        try {
            FileDto createdFile = fileService.createFile(newFile);
            return new ResponseEntity<>(createdFile, HttpStatus.OK);
        }
        catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/file/{fileId}")
    public  ResponseEntity<FileDto> update(@RequestBody FileDto file, @PathVariable UUID fileId){
        try {
            FileDto updatedFile = fileService.updateFile(file,fileId);
            return new ResponseEntity<>(updatedFile,HttpStatus.OK);
        }
        catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("file/{fileId}")
    public ResponseEntity<FileDto> get(@PathVariable UUID fileId){
        try {
            FileDto file = fileService.getById(fileId);
            return new ResponseEntity<>(file,HttpStatus.OK);
        }
        catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("file/byptypeandpid")
    public ResponseEntity<List<FileDto>> getByParentTypeParentId(@RequestBody FileSearchDto fileSearchDto){
        try {
            List<FileDto> file2 = fileService.getByParentTypeAndParentId(fileSearchDto.getParentType(), fileSearchDto.getParentId());
            return new ResponseEntity<>(file2, HttpStatus.OK);
        }catch (NoSuchElementException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/file/{fileId}")
    public ResponseEntity<HttpStatus> delete (@PathVariable UUID fileId){
        try {
                fileService.delete(fileId);
                return new ResponseEntity<>(HttpStatus.OK);
            } catch (Exception ex){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

    }
}
