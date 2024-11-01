package devtitans.antoshcuk.devfusionbackend.repositiories;

import devtitans.antoshcuk.devfusionbackend.models.job.JobPost;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
public interface JobPostRepository extends JpaRepository<JobPost, Integer> {

    public List<JobPost> findJobPostsByCompanyId(int companyId);

    // Метод для получения всех постов с пагинацией
    Page<JobPost> findAll(Pageable pageable);


}
