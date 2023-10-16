package SungDongGri.SungDong_back.controller;

import SungDongGri.SungDong_back.base.BaseResponse;
import SungDongGri.SungDong_back.dto.ProgramSurveyRequestDto;
import SungDongGri.SungDong_back.dto.ProgramSurveyResponseDto;
import SungDongGri.SungDong_back.service.ProgramSurveyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/survey")
public class ProgramSurveyController {
    @Autowired
    private final ProgramSurveyService programSurveyService;

    @PostMapping("")
    public BaseResponse<ProgramSurveyResponseDto> addSurvey(@RequestBody ProgramSurveyRequestDto programSurveyRequestDto){
        return BaseResponse.ok(programSurveyService.addSurvey(programSurveyRequestDto));
    }
    @PutMapping("/{surveyId}")
    public BaseResponse<Long> updateSurvey(@PathVariable Long surveyId, @RequestBody ProgramSurveyRequestDto programSurveyRequestDto){
        return BaseResponse.ok(programSurveyService.updateSurvey(surveyId, programSurveyRequestDto));
    }

}
