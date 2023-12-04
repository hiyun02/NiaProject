package kopo.poly.repository.entity;


import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "AREA")
@DynamicInsert
@DynamicUpdate
@Entity
public class AreaEntity {

    @Id
    @Column(name = "LOCATION")
    private String location;

    @NonNull
    @Column(name = "LAT", nullable = false)
    private String lat;

    @NonNull
    @Column(name = "LNG", nullable = false)
    private String lng;




}
