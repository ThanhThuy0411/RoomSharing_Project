package tma.interns.roomsharing.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import tma.interns.roomsharing.enumration.FileType;

import javax.persistence.*;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "file")
public class FileEntity {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name= "fileId", columnDefinition = "CHAR(36)")
    @Type(type="uuid-char")
    private UUID fileId;
    private String name;
    @Enumerated(EnumType.STRING)
    private FileType type;
    @Column(name="parent_type")
    private int parentType;
    @Column(name="parent_id")
    @Type(type="uuid-char")
    private UUID parentId;
    private String url;
}
