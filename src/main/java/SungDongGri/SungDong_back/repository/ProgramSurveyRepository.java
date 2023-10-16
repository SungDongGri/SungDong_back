package SungDongGri.SungDong_back.repository;

import SungDongGri.SungDong_back.domain.ProgramSurvey;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

@Repository
public interface ProgramSurveyRepository extends JpaRepository<ProgramSurvey,Long> {
    Page<ProgramSurvey> findAllById(Long surveyId, Pageable pageable);
}
