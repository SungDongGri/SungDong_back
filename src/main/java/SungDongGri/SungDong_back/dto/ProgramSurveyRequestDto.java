package SungDongGri.SungDong_back.dto;

import SungDongGri.SungDong_back.domain.ProgramSurvey;
import SungDongGri.SungDong_back.domain.SurveyItem;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
public class ProgramSurveyRequestDto {
    private Long id;

    private String title;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    private String content;

     private List<SurveyItemRequestDto> items;

    public ProgramSurvey toEntity() {
        ProgramSurvey programSurvey = ProgramSurvey.builder()
                .id(this.id)
                .title(this.title)
                .startDate(this.startDate)
                .endDate(this.endDate)
                .content(this.content)
                .build();

        if (this.items != null) {
            List<SurveyItem> surveyItems = new ArrayList<>();
            for (int i = 0; i < this.items.size(); i++) {
                SurveyItemRequestDto dto = this.items.get(i);
                SurveyItem surveyItem = SurveyItemRequestDto.toEntity(dto);
                surveyItem.setSurvey(programSurvey);
                surveyItems.add(surveyItem);
            }
            programSurvey.setItems(surveyItems);
        }




        return programSurvey;
    }

}
