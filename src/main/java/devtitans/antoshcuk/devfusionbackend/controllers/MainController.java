package devtitans.antoshcuk.devfusionbackend.controllers;

import devtitans.antoshcuk.devfusionbackend.dto.JobPostDto;
import devtitans.antoshcuk.devfusionbackend.models.job.JobPost;
import devtitans.antoshcuk.devfusionbackend.services.JobPostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@CrossOrigin(origins = "http://localhost:63343")
public class MainController {

    private final JobPostService jobPostService;

    @Autowired
    public MainController(JobPostService jobPostService) {
        this.jobPostService = jobPostService;
    }

    @GetMapping("/allJobPosts")
    @ResponseBody
    public List<JobPostDto> getAllJobs() {
        System.out.println("Get Request");
        return jobPostService.getJobPosts().stream()
                .map(this::convertJobPostToJobPostDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/jobPostsByCompany/{companyId}")
    @ResponseBody
    public List<JobPostDto> getJobsByCompany(@PathVariable("companyId") int companyId) {
        System.out.println("Get Request");
        return jobPostService.getJobPostsByCompanyId(companyId).stream()
                .map(this::convertJobPostToJobPostDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/jobById/{jobPostId}")
    @ResponseBody
    public JobPostDto getJobById(@PathVariable("jobPostId") int jobPostId) {
        System.out.println("Get Request");
        return convertJobPostToJobPostDto(jobPostService.getJobPostById(jobPostId));
    }

    @GetMapping("/allJobPostsPagination")
    @ResponseBody
    public List<JobPostDto> getAllJobs(@RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "10") int size) {
        Page<JobPost> jobPosts = jobPostService.getAllJobPosts(page, size);
        return jobPosts.stream()
                .map(this::convertJobPostToJobPostDto)
                .collect(Collectors.toList());
    }


    private JobPostDto convertJobPostToJobPostDto(JobPost jobPost) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(jobPost, JobPostDto.class);
    }

}
