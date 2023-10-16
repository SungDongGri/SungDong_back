package SungDongGri.SungDong_back.service;

import SungDongGri.SungDong_back.base.PageResult;
import SungDongGri.SungDong_back.domain.Notice;
import SungDongGri.SungDong_back.dto.NoticeRequestDto;
import SungDongGri.SungDong_back.dto.NoticeResponseDto;
import SungDongGri.SungDong_back.exception.CustomException;
import SungDongGri.SungDong_back.exception.ErrorCode;
import SungDongGri.SungDong_back.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeService {
    private final NoticeRepository noticeRepository;

    @Transactional
    public NoticeResponseDto addNotice(NoticeRequestDto noticeRequestDto) {
        Notice notice = noticeRequestDto.toEntity();
        Notice savedNotice = noticeRepository.save(notice);
        return NoticeResponseDto.of(savedNotice);
    }
    @Transactional
    public List<Notice> getAllNotices(String keyword) {
        if(keyword == null || keyword.trim().isEmpty()) {
            return noticeRepository.findAll();
        }else{
            return noticeRepository.findAllByTitleContainingOrContentContaining(keyword,keyword);
        }
    }
    @Transactional
    public NoticeResponseDto detailNotice(Long noticeId){
        Notice notice = noticeRepository.findById(noticeId).orElseThrow(()->new CustomException(ErrorCode.NOT_FOUND));
        return NoticeResponseDto.of(notice);
    }

    @Transactional
    public Long updateNotice(Long noticeId, NoticeRequestDto noticeRequestDto){
        Notice notice = noticeRepository.findById(noticeId).orElseThrow(()->new CustomException(ErrorCode.NOT_FOUND));
        notice.setTitle(noticeRequestDto.getTitle());
        notice.setContent(noticeRequestDto.getContent());
        notice.setLocalDateTime(LocalDateTime.now());
        return noticeId;
    }

    @Transactional
    public void deleteNotice(Long noticeId){
        Notice notice = noticeRepository.findById(noticeId).orElseThrow(()->new CustomException(ErrorCode.NOT_FOUND));
        noticeRepository.deleteById(notice.getId());
    }


    public PageResult<NoticeResponseDto> getNoticeList(Long noticeId, Pageable pageable){
        return PageResult.ok(noticeRepository.findAllById(noticeId,pageable).map(NoticeResponseDto::of));
    }
}
