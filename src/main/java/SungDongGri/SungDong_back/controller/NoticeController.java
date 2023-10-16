package SungDongGri.SungDong_back.controller;


import SungDongGri.SungDong_back.base.BaseResponse;
import SungDongGri.SungDong_back.base.PageResult;
import SungDongGri.SungDong_back.domain.Notice;
import SungDongGri.SungDong_back.dto.NoticeRequestDto;
import SungDongGri.SungDong_back.dto.NoticeResponseDto;
import SungDongGri.SungDong_back.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    private final NoticeService noticeService;

    @PostMapping("")
    public BaseResponse<NoticeResponseDto> addNotice(@RequestBody NoticeRequestDto noticeRequestDto){
        return BaseResponse.ok(noticeService.addNotice(noticeRequestDto));
    }

    @PutMapping("/{noticeId}")
    public BaseResponse<Long> updateNotice(@PathVariable Long noticeId, @RequestBody NoticeRequestDto noticeRequestDto){
        return BaseResponse.ok(noticeService.updateNotice(noticeId, noticeRequestDto));
    }

    @DeleteMapping("/{noticeId}")
    public BaseResponse<Void> deleteNotice(@PathVariable Long noticeId){
        noticeService.deleteNotice(noticeId);
        return BaseResponse.ok();
    }

    @GetMapping("/all")
    public BaseResponse<List<Notice>> getAllNotice(@RequestParam(value = "keyword", required = false) String keyword) {
        return BaseResponse.ok(noticeService.getAllNotices(keyword));
    }

    @GetMapping("/{noticeId}")
    public BaseResponse<NoticeResponseDto> getDetailNotice(@PathVariable Long noticeId){
        return BaseResponse.ok(noticeService.detailNotice(noticeId));
    }

    @GetMapping("noticeList")
    public BaseResponse<PageResult<NoticeResponseDto>> getNoticeList(@RequestParam(required = false) Long noticeId,Pageable pageable){
        return BaseResponse.ok(noticeService.getNoticeList(noticeId,pageable));
    }
}
