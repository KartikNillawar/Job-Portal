package com.placements.getplaced.job.impl;

import com.placements.getplaced.job.Job;
import com.placements.getplaced.job.jobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Service
public class jobServiceImpl implements jobService {
    private List<Job> jobs = new ArrayList<>();
    private Long jobId = Long.valueOf(1);
    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(jobId++);
        jobs.add(job);
    }

    @Override
    public Job getJobById(Long id) {
        for(Job job: jobs)
        {
            if(job.getId()==id)
                return job;
        }
        return null;
    }

    @Override
    public boolean deleteJob(Long jobId) {
        Iterator<Job> iterator = jobs.iterator();
        while (iterator.hasNext())
        {
            Job job = iterator.next();
            if(job.getId().equals(jobId))
            {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateJob(Long jobId, Job updatedjob) {
        for(Job job:jobs)
        {
            if(job.getId().equals(jobId))
            {
                job.setTitle(updatedjob.getTitle());
                job.setDescription(updatedjob.getDescription());
                job.setLocation(updatedjob.getLocation());
                job.setMinSalary(updatedjob.getMinSalary());
                job.setMaxSalary(job.getMaxSalary());
                return true;
            }
        }
        return false;
    }
}
