package SungDongGri.SungDong_back.controller;

import SungDongGri.SungDong_back.base.BaseResponse;
import SungDongGri.SungDong_back.base.PageResult;
import SungDongGri.SungDong_back.domain.ProgramSurvey;
import SungDongGri.SungDong_back.dto.ProgramSurveyRequestDto;
import SungDongGri.SungDong_back.dto.ProgramSurveyResponseDto;
import SungDongGri.SungDong_back.service.ProgramSurveyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


import java.util.List;

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

    @DeleteMapping("/{surveyId}")
    public BaseResponse<Void> deleteSurvey(@PathVariable Long surveyId){
        programSurveyService.deleteSurvey(surveyId);
        return BaseResponse.ok();
    }

    @GetMapping("/all")
    public BaseResponse<List<ProgramSurvey>> getAllSurvey(){
        return BaseResponse.ok(programSurveyService.getAllSurvey());
    }

    @GetMapping("/{surveyId}")
    public BaseResponse<ProgramSurveyResponseDto> getDetailSurvey(@PathVariable Long surveyId){
        return BaseResponse.ok(programSurveyService.detailSurvey(surveyId));
    }

    @GetMapping("surveyList")
    public BaseResponse<PageResult<ProgramSurveyResponseDto>> getSurveyList(@RequestParam(required = false) Long surveyId, Pageable pageable){
        return BaseResponse.ok(programSurveyService.getSurveyList(surveyId,pageable));
    }
}
