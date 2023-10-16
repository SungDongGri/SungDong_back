package SungDongGri.SungDong_back.dto;

import SungDongGri.SungDong_back.domain.ProgramSurvey;
import SungDongGri.SungDong_back.domain.SurveyItem;
import lombok.Builder;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
public class ProgramSurveyResponseDto {
    private Long id;

    private String title;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    private String content;


    private List<SurveyItem> items;

    public static ProgramSurveyResponseDto of(ProgramSurvey programSurvey){
        return ProgramSurveyResponseDto.builder()
                .id(programSurvey.getId())
                .title(programSurvey.getTitle())
                .startDate(programSurvey.getStartDate())
                .endDate(programSurvey.getEndDate())
                .content(programSurvey.getContent())
                .items(programSurvey.getItems())
                .build();
    }
}
