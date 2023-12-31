package SungDongGri.SungDong_back.service;

import SungDongGri.SungDong_back.base.PageResult;
import SungDongGri.SungDong_back.domain.ProgramSurvey;
import SungDongGri.SungDong_back.domain.SurveyItem;
import SungDongGri.SungDong_back.dto.ProgramSurveyRequestDto;
import SungDongGri.SungDong_back.dto.ProgramSurveyResponseDto;
import SungDongGri.SungDong_back.dto.SurveyItemRequestDto;
import SungDongGri.SungDong_back.exception.CustomException;
import SungDongGri.SungDong_back.exception.ErrorCode;
import SungDongGri.SungDong_back.repository.ProgramSurveyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProgramSurveyService {
    private final ProgramSurveyRepository programSurveyRepository;

    @Transactional
    public ProgramSurveyResponseDto addSurvey(ProgramSurveyRequestDto programSurveyRequestDto){
        ProgramSurvey programSurvey = programSurveyRequestDto.toEntity();
        return ProgramSurveyResponseDto.of(programSurveyRepository.save(programSurvey));
    }

    @Transactional
    public Long updateSurvey(Long surveyId, ProgramSurveyRequestDto programSurveyRequestDto){
        ProgramSurvey programSurvey = programSurveyRepository.findById(surveyId).orElseThrow(()->new CustomException(ErrorCode.NOT_FOUND));
        programSurvey.setTitle(programSurveyRequestDto.getTitle());
        programSurvey.setStartDate(programSurveyRequestDto.getStartDate());
        programSurvey.setEndDate(programSurveyRequestDto.getEndDate());
        programSurvey.setContent(programSurveyRequestDto.getContent());
        List<SurveyItemRequestDto> itemDtos = programSurveyRequestDto.getItems();

        List<SurveyItem> updatedItems = programSurvey.getItems();
        updatedItems.clear();

        for (SurveyItemRequestDto itemDto : itemDtos) {
            SurveyItem newItem = new SurveyItem();
            newItem.setItemContent(itemDto.getItemContent());
            updatedItems.add(newItem);
        }
        programSurvey.setItems(updatedItems);

        return programSurvey.getId();
    }

    @Transactional
    public void deleteSurvey(Long surveyId){
        ProgramSurvey programSurvey = programSurveyRepository.findById(surveyId).orElseThrow(()->new CustomException(ErrorCode.NOT_FOUND));
        programSurveyRepository.deleteById(programSurvey.getId());
    }

    @Transactional
    public PageResult<ProgramSurveyResponseDto> getSurveyList(Long surveyId, Pageable pageable){
        return PageResult.ok(programSurveyRepository.findAllById(surveyId,pageable).map(ProgramSurveyResponseDto::of));
    }

    @Transactional
    public List<ProgramSurvey> getAllSurvey(){
        return programSurveyRepository.findAll();
    }

    @Transactional
    public ProgramSurveyResponseDto detailSurvey(Long surveyId){
        ProgramSurvey programSurvey = programSurveyRepository.findProgramSurveyWithItemsById(surveyId);
        return ProgramSurveyResponseDto.of(programSurvey);
    }
}
