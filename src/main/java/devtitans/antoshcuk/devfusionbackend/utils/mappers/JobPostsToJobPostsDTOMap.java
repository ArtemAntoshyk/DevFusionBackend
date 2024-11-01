package devtitans.antoshcuk.devfusionbackend.utils.mappers;

import devtitans.antoshcuk.devfusionbackend.dto.JobPostDTO;
import devtitans.antoshcuk.devfusionbackend.models.job.JobPost;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

public class JobPostsToJobPostsDTOMap extends PropertyMap<JobPost, JobPostDTO> {
    private ModelMapper modelMapper;

    public JobPostsToJobPostsDTOMap(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    protected void configure() {
        map(source.getJobType(), destination.getType());
        map(source.getJobGradation(), destination.getGradation());
    }
}
