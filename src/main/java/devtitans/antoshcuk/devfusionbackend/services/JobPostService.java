package devtitans.antoshcuk.devfusionbackend.services;

import devtitans.antoshcuk.devfusionbackend.models.job.JobPost;
import devtitans.antoshcuk.devfusionbackend.repositiories.JobPostRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPostService {
    private JobPostRepositories jobPostRepositories;

    @Autowired
    public JobPostService(JobPostRepositories jobPostRepositories) {
        this.jobPostRepositories = jobPostRepositories;
    }

    public List<JobPost> getJobPosts() {
        return jobPostRepositories.findAll();
    }

    public List<JobPost> getJobPostsByCompanyId(int companyId) {
        return jobPostRepositories.findJobPostsByCompanyId(companyId);
    }

    public JobPost getJobPostById(int id) {
        return jobPostRepositories.findById(id).orElse(null);
    }
    public Page<JobPost> getAllJobPosts(int page, int size) {
        return jobPostRepositories.findAll(PageRequest.of(page, size));
    }
}
