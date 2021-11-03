package tma.interns.roomsharing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tma.interns.roomsharing.entity.UserEntity;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    UserEntity findFirstByUserId(UUID userId);
    UserEntity findFirstByUserNameAndPassword(String userName, String password);
    Optional<UserEntity> findByUserName(String userName);
    void deleteByUserId(UUID userId);

}
