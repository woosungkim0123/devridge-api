package io.devridge.api.domain.roadmap;

import io.devridge.api.dto.course.RoadmapStatusDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoadmapRepository extends JpaRepository<Roadmap, Long> {

    @Query("SELECT new io.devridge.api.dto.course.RoadmapStatusDto(r.matchingFlag, c, ur.studyStatus) FROM Roadmap r " +
            "JOIN r.course c " +
            "LEFT JOIN UserRoadmap ur ON ur.roadmap.id = r.id AND ur.user.id = :userId " +
            "WHERE r.companyInfo.id = :companyInfoId " +
            "ORDER BY c.order, CASE c.type WHEN 'SKILL' THEN 0 WHEN 'CS' THEN 1 ELSE 2 END")
    List<RoadmapStatusDto> getRoadmapsIncludingCoursesByCompanyInfoIdWithUserId(@Param("companyInfoId") Long companyInfoId, @Param("userId") Long userId);
}
