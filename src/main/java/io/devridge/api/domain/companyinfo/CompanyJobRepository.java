package io.devridge.api.domain.companyinfo;

import io.devridge.api.dto.course.CompanyJobInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CompanyJobRepository extends JpaRepository<CompanyJob, Long> {
    Optional<CompanyJob> findByCompanyIdAndJobId(long companyId, long jobId);

    @Query("select new io.devridge.api.dto.course.CompanyJobInfo(c.name, j.name) from CompanyJob cj left join Company c on cj.company.id = c.id left join Job j on cj.job.id = j.id  where cj.company.id = :companyId and cj.job.id = :jobId")
    Optional<CompanyJobInfo> findCompanyJobInfo(long companyId, long jobId);
}
