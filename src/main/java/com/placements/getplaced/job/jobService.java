package com.placements.getplaced.job;

import org.springframework.stereotype.Service;

import java.util.List;

public interface jobService {
    List<Job> findAll();
    void createJob(Job job);

    Job getJobById(Long id);

    boolean deleteJob(Long jobId);

    boolean updateJob(Long jobId, Job job);
}
