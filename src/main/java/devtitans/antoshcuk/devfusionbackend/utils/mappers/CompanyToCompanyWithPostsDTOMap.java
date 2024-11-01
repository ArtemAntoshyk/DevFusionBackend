package devtitans.antoshcuk.devfusionbackend.utils.mappers;

import devtitans.antoshcuk.devfusionbackend.dto.CompanyWithPostsDTO;
import devtitans.antoshcuk.devfusionbackend.dto.JobPostDTO;
import devtitans.antoshcuk.devfusionbackend.models.job.JobPost;
import devtitans.antoshcuk.devfusionbackend.models.user.Company;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.util.List;
import java.util.stream.Collectors;

public class CompanyToCompanyWithPostsDTOMap extends PropertyMap<Company, CompanyWithPostsDTO> {
    private final ModelMapper modelMapper;
    public CompanyToCompanyWithPostsDTOMap(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    @Override
    protected void configure() {
        using(ctx -> {
            List<JobPost> jobPosts = (List<JobPost>) ctx.getSource();
            return jobPosts.stream()
                    .map(jobPost -> modelMapper.map(jobPost, JobPostDTO.class)) // используйте modelMapper здесь
                    .collect(Collectors.toList());
        }).map(source.getJobPosts()).setJobPosts(null);
    }
}
