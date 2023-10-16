package SungDongGri.SungDong_back.repository;

import SungDongGri.SungDong_back.domain.ProgramSurvey;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import java.util.List;


@Repository
public interface ProgramSurveyRepository extends JpaRepository<ProgramSurvey,Long> {
    Page<ProgramSurvey> findAllById(Long surveyId, Pageable pageable);
    @Query("SELECT ps FROM ProgramSurvey ps JOIN FETCH ps.items")
    ProgramSurvey findProgramSurveyWithItemsById(Long id);




}
