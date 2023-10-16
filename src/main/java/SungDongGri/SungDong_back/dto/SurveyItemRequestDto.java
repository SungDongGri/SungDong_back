package SungDongGri.SungDong_back.dto;

import SungDongGri.SungDong_back.domain.SurveyItem;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SurveyItemRequestDto {
    private Long id;
    private String itemContent;
    public static SurveyItem toEntity(SurveyItemRequestDto dto) {
        return SurveyItem.builder()
                .id(dto.getId())
                .itemContent(dto.getItemContent())
                .build();
    }
}
