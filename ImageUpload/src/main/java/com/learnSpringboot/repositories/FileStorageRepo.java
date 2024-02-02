package com.learnSpringboot.repositories;

import com.learnSpringboot.entities.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FileStorageRepo extends JpaRepository<ImageData, Long> {

//    Optional<ImageData> findByName(String fileName);
}
