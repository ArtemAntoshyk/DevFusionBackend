package devtitans.antoshcuk.devfusionbackend.controllers;

import devtitans.antoshcuk.devfusionbackend.dto.CompanyDTO;
import devtitans.antoshcuk.devfusionbackend.dto.CompanyWithPostsDTO;
import devtitans.antoshcuk.devfusionbackend.dto.JobPostDTO;
import devtitans.antoshcuk.devfusionbackend.models.user.Company;
import devtitans.antoshcuk.devfusionbackend.services.CompanyService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {
    private CompanyService companyService;
    private ModelMapper modelMapper;

    @Autowired
    public CompanyController(CompanyService companyService, @Qualifier("modelMapper") ModelMapper modelMapper) {
        this.companyService = companyService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all_companies_with_posts")
    public List<CompanyWithPostsDTO> getAllCompaniesWithPosts() {
        companyService.getAllCompanies().stream()
                .forEach(company -> System.out.println(company.getId() + " " + company.getName() +
                        company.getJobPosts().stream().map(job -> job.getTitle()).collect(Collectors.joining(", "))));
        return companyService.getAllCompanies().stream()
                .map(this::convertCompanyToWithPostsDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/all_companies")
    public List<CompanyDTO> getAllCompanies() {
        return companyService.getAllCompanies().stream()
                .map(this::convertCompanyToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/company_by_id/{id}")
    public CompanyDTO getCompanyById(@PathVariable("id") int id) {
        return convertCompanyToDTO(companyService.getCompanyById(id));
    }

    @GetMapping("/company_with_posts_by_id/{id}")
    public CompanyWithPostsDTO getCompanyWithPostsById(@PathVariable("id") int id) {
        return convertCompanyToWithPostsDTO(companyService.getCompanyById(id));
    }

    private CompanyDTO convertCompanyToDTO(Company company) {
        return modelMapper.map(company, CompanyDTO.class);
    }

    private CompanyWithPostsDTO convertCompanyToWithPostsDTO(Company company) {

        return modelMapper.map(company, CompanyWithPostsDTO.class);
    }

    public Company convertCompanyDTOToCompany(CompanyDTO companyDTO) {
        return modelMapper.map(companyDTO, Company.class);
    }

    public Company convertCompanyWithPostsDTOToCompany(CompanyWithPostsDTO companyDTO) {
        return modelMapper.map(companyDTO, Company.class);
    }
}
