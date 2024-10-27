package devtitans.antoshcuk.devfusionbackend.dto;

import devtitans.antoshcuk.devfusionbackend.dto.CompanyDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JobPostDto {
    private int id;
    private CompanyDto company;
    private JobTypeDTO type;
    private JobGradationDTO gradation;
    private String jobType;
    private String jobGradation;
    private String title;
    private String jobDescription;
    private String jobLocation;
    private double latitude;
    private double longitude;
    private boolean isCompanyNameHidden;
    private Date createdAt;
    private boolean isActive;
}