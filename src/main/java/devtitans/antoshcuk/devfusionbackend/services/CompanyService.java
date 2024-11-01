package devtitans.antoshcuk.devfusionbackend.services;

import devtitans.antoshcuk.devfusionbackend.models.user.Company;
import devtitans.antoshcuk.devfusionbackend.repositiories.CompanyRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    private CompanyRepository companyRepository;
    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }
    @Transactional
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }
    @Transactional
    public Company getCompanyById(int id) {
        return companyRepository.findById(id);
    }
}
