package devtitans.antoshcuk.devfusionbackend;

import devtitans.antoshcuk.devfusionbackend.utils.mappers.CompanyToCompanyWithPostsDTOMap;
import devtitans.antoshcuk.devfusionbackend.utils.mappers.JobPostsToJobPostsDTOMap;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DevFusionBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevFusionBackendApplication.class, args);
    }

    //TODO add property mapper for auto convert inner dto
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.addMappings(new CompanyToCompanyWithPostsDTOMap(modelMapper));
        modelMapper.addMappings(new JobPostsToJobPostsDTOMap(modelMapper));
        return modelMapper;
    }
}
