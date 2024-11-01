package devtitans.antoshcuk.devfusionbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompanyWithPostsDTO {
    private int id;
    private String name;
    private String companyLogo;
    private List<JobPostDTO> jobPosts;
}