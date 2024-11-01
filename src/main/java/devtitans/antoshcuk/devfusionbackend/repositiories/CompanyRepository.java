package devtitans.antoshcuk.devfusionbackend.repositiories;

import devtitans.antoshcuk.devfusionbackend.models.user.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
public interface CompanyRepository extends JpaRepository<Company, Integer> {
    public Company findById(int id);
}
