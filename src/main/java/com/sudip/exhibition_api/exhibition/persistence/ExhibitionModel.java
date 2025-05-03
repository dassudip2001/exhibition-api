package com.sudip.exhibition_api.exhibition.persistence;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "exhibitions")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExhibitionModel {
    @Id
    private String id;


    private String title;

    private String description;

    private String bannerImage;

    private String thumbnailImage;

    private Date  startDate;
    private Date endDate;

    private ExhibitionStatus  status;
    private String slug;

    private List<ExhibitionSection> sections;



    private Date createdAt;
    private Date updatedAt;
}
