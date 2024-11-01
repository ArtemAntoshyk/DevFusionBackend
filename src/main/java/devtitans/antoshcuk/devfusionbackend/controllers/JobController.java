package devtitans.antoshcuk.devfusionbackend.controllers;

import devtitans.antoshcuk.devfusionbackend.dto.JobPostDTO;
import devtitans.antoshcuk.devfusionbackend.models.job.JobPost;
import devtitans.antoshcuk.devfusionbackend.services.JobPostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin(origins = "http://localhost:63343")
public class JobController {
    private final ModelMapper modelMapper;
    private final JobPostService jobPostService;

    @Autowired
    public JobController(@Qualifier("modelMapper") ModelMapper modelMapper, JobPostService jobPostService) {
        this.modelMapper = modelMapper;
        this.jobPostService = jobPostService;
    }

    @GetMapping("/all_job_posts")
    public List<JobPostDTO> getAllJobs() {
        System.out.println("Get Request");
        return jobPostService.getJobPosts().stream()
                .map(this::convertJobPostToJobPostDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/job_posts_by_company/{companyId}")
    public List<JobPostDTO> getJobsByCompany(@PathVariable("companyId") int companyId) {
        System.out.println("Get Request");
        return jobPostService.getJobPostsByCompanyId(companyId).stream()
                .map(this::convertJobPostToJobPostDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/job_by_id/{jobPostId}")
    @ResponseBody
    public JobPostDTO getJobById(@PathVariable("jobPostId") int jobPostId) {
        System.out.println("Get Request");
        return convertJobPostToJobPostDto(jobPostService.getJobPostById(jobPostId));
    }

    @GetMapping("/all_job_posts_pagination")
    public List<JobPostDTO> getAllJobs(@RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "10") int size) {
        Page<JobPost> jobPosts = jobPostService.getAllJobPosts(page, size);
        return jobPosts.stream()
                .map(this::convertJobPostToJobPostDto)
                .collect(Collectors.toList());
    }


    private JobPostDTO convertJobPostToJobPostDto(JobPost jobPost) {
        return modelMapper.map(jobPost, JobPostDTO.class);
    }

}
