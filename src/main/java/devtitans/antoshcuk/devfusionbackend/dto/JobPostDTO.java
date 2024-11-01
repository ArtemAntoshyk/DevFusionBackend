package devtitans.antoshcuk.devfusionbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JobPostDTO {
    private int id;
    private CompanyBaseDTO company;
    private JobTypeDTO type;
    private JobGradationDTO gradation;
//    private String jobType;
//    private String jobGradation;
    private String title;
    private String jobDescription;
    private String jobLocation;
    private double latitude;
    private double longitude;
    private boolean isCompanyNameHidden;
    private Date createdAt;
    private boolean isActive;
}