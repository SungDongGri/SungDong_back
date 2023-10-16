package SungDongGri.SungDong_back.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProgramSurvey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title; //설문 제목

    @Column
    private LocalDate startDate; //시작일

    @Column
    private LocalDate endDate; //종료

    @Column
    private String content; //내용

    @JsonIgnore
    @OneToMany(mappedBy = "survey", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SurveyItem> items;
    //items.get(0) ... 으로 조회하면 됨

}
