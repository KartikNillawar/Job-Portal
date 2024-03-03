package com.placements.getplaced.job.impl;

import com.placements.getplaced.job.Job;
import com.placements.getplaced.job.JobRepository;
import com.placements.getplaced.job.jobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class jobServiceImpl implements jobService {
    //    private List<Job> jobs = new ArrayList<>();
    JobRepository jobRepository;

    public jobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {

        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJob(Long jobId) {
        try {
            jobRepository.deleteById(jobId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateJob(Long jobId, Job updatedjob) {
        Optional<Job> jobOptional = jobRepository.findById(jobId);
        if (jobOptional.isPresent()) {
            Job job = jobOptional.get();
            job.setTitle(updatedjob.getTitle());
            job.setDescription(updatedjob.getDescription());
            job.setLocation(updatedjob.getLocation());
            job.setMinSalary(updatedjob.getMinSalary());
            job.setMaxSalary(job.getMaxSalary());
            jobRepository.save(job);
            return true;
        }
        return false;
    }
}
