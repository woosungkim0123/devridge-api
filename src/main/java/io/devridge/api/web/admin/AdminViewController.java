package io.devridge.api.web.admin;

import io.devridge.api.domain.companyinfo.*;
import io.devridge.api.domain.roadmap.Course;
import io.devridge.api.domain.roadmap.CourseDetailRepository;
import io.devridge.api.domain.roadmap.CourseRepository;
import io.devridge.api.domain.video.CourseVideo;
import io.devridge.api.domain.video.CourseVideoRepository;
import io.devridge.api.dto.admin.CompanyInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/admin")
@Controller
public class AdminViewController {

    private final JobRepository jobRepository;
    private final CourseDetailRepository courseDetailRepository;
    private final CourseRepository courseRepository;
    private final CompanyInfoRepository companyInfoRepository;
    private final CompanyRequiredAbilityRepository companyRequiredAbilityRepository;
    private final CourseVideoRepository courseVideoRepository;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/course")
    public String courseList(Model model) {
        List<Job> jobList = jobRepository.findAll();
        model.addAttribute("jobList", jobList);

        return "courseList";
    }

    @GetMapping("/companyInfo")
    public String companyInfo(Model model) {
        List<CompanyInfoDto> companyInfoList = companyInfoRepository.findByAllWithRoadmap();
        model.addAttribute("companyInfoList", companyInfoList);

        return "companyInfoList";
    }



//    @GetMapping("/video/{jobId}/{courseId}")
//    public String courseVideoCourse(@PathVariable Long jobId, @PathVariable Long courseId, Model model) {
//        List<CourseDetail> courseDetailList = courseDetailRepository.findByCourseId(courseId);
//        model.addAttribute("jobId", jobId);
//        model.addAttribute("courseDetailList", courseDetailList);
//        return "courseVideoCourseDetail";
//    }

    @GetMapping("/video/detail/{courseDetailId}")
    public String courseVideoCourse1(@PathVariable Long courseDetailId, Model model) {
        List<CourseVideo> courseVideoList = courseVideoRepository.findByCourseDetailId(courseDetailId);
        model.addAttribute("courseVideoList", courseVideoList);
        model.addAttribute("courseDetailId", courseDetailId);
        return "courseVideo";
    }

}
