package com.vibecheck.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vibecheck.model.Submission;
@Repository
public interface SubmissionRepository extends JpaRepository<Submission,Long> {

}
