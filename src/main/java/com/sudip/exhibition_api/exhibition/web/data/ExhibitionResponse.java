package com.sudip.exhibition_api.exhibition.web.data;

import com.sudip.exhibition_api.exhibition.persistence.ExhibitionSection;
import com.sudip.exhibition_api.exhibition.persistence.ExhibitionStatus;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
@Builder
public class ExhibitionResponse {
    private String id;
    private String title;
    private String description;
    private String bannerImage;
    private String thumbnailImage;
    private ExhibitionStatus status;
    private String slug;
    private Date startDate;
    private Date endDate;
    private List<ExhibitionSection> sections;
    private String createdAt;
    private String updatedAt;

}
