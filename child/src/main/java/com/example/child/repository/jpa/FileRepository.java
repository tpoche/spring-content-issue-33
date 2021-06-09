package com.example.child.repository.jpa;

import com.example.child.repository.jpa.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {

}
