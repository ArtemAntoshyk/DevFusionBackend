package devtitans.antoshcuk.devfusionbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompanyDTO {
    private int id;
    private String name;
    private String businessStreamName;
    private String companyLogo;
    private String companyDescription;
    private Date establishmentDate;
    private String companyWebsiteUrl;
    private List<String> companyImages;

}