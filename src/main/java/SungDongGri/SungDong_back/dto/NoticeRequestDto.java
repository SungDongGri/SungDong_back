package SungDongGri.SungDong_back.dto;

import SungDongGri.SungDong_back.domain.Notice;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class NoticeRequestDto {
    private Long id;
    private String title;
    private String content;

    public Notice toEntity(){
        return Notice.builder()
                .id(this.id)
                .title(this.title)
                .content(this.content)
                .localDateTime(LocalDateTime.now())
                .build();
    }
}
