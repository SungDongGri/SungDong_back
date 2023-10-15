package SungDongGri.SungDong_back.repository;

import SungDongGri.SungDong_back.domain.Notice;
import SungDongGri.SungDong_back.dto.NoticeRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {
    Page<Notice> findAllById(Long noticeId,Pageable pageable);

    List<Notice> findAllByTitleContainingOrContentContaining(String title, String content);

}
