package kopo.poly.repository.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "REPORT")
@DynamicInsert
@DynamicUpdate
@Entity
public class ReportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REPORT_SEQ")
    private Long reportSeq;

    @NonNull
    @Column(name = "BELONG", nullable = false)
    private String belong;

    @NonNull
    @Column(name = "NAME", nullable = false)
    private String name;

    @NonNull
    @Column(name = "LOCATION", nullable = false)
    private String location;

    @NonNull
    @Column(name = "PHONE", nullable = false)
    private String phone;

    @NonNull
    @Column(name = "DENSITY", nullable = false)
    private String density;

    @Column(name = "FILE_PATH", nullable = true)
    private String filePath;

    @NonNull
    @Column(name = "REPORT_DT", nullable = false)
    private String reportDT;




}
