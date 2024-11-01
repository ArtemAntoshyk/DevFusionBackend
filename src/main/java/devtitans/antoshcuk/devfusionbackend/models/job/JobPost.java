package devtitans.antoshcuk.devfusionbackend.models.job;

import devtitans.antoshcuk.devfusionbackend.models.user.Company;
import jakarta.persistence.*;
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
@Entity
@Table(name = "job_post")
public class JobPost {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne()
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;
    @ManyToOne()
    @JoinColumn(name = "job_type_id", referencedColumnName = "id")
    private JobType jobType;
    @ManyToOne()
    @JoinColumn(name = "job_gradation_id", referencedColumnName = "id")
    private JobGradation jobGradation;
    @Column(name = "title")
    private String title;
    @Column(name = "job_description")
    private String jobDescription;
    @Column(name = "job_location")
    private String jobLocation;
    @Column(name = "latitude")
    private double latitude;
    @Column(name = "longitude")
    private double longitude;
    @Column(name = "is_company_name_hidden")
    private boolean isCompanyNameHidden;
    @Column(name = "created_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "is_active")
    private boolean isActive;

    @OneToMany(mappedBy = "jobPost")
    private List<JobPostActivity> jobPostActivities;

    public JobPost(Company company, JobType jobType, JobGradation jobGradation, String title, String jobDescription, String jobLocation, double latitude, double longitude, boolean isCompanyNameHidden, Date createdAt, boolean isActive, List<JobPostActivity> jobPostActivities) {
        this.company = company;
        this.jobType = jobType;
        this.jobGradation = jobGradation;
        this.title = title;
        this.jobDescription = jobDescription;
        this.jobLocation = jobLocation;
        this.latitude = latitude;
        this.longitude = longitude;
        this.isCompanyNameHidden = isCompanyNameHidden;
        this.createdAt = createdAt;
        this.isActive = isActive;
        this.jobPostActivities = jobPostActivities;
    }
}
