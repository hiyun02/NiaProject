package kopo.poly.repository;

import kopo.poly.repository.entity.ReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<ReportEntity, Long> {

    List<ReportEntity> findAllByLocationOrderByReportDT(String location);

    List<ReportEntity> findAllByReportDTBetween(String startTime, String endTime);

    @Query(value =
            "SELECT COALESCE(MAX(DENSITY), '없음') AS highest_density " +
                    "FROM REPORT " +
                    "WHERE LOCATION = :title " +
                    "AND DENSITY IN ('여유', '보통', '약간 붐빔', '붐빔') " +
                    "AND REPORT_DT BETWEEN :startTime AND :endTime",
            nativeQuery = true)
    String getReportMax(@Param("title") String title, @Param("startTime") String startTime, @Param("endTime") String endTime);

}
