package com.sudip.exhibition_api.exhibition.web.data;

import com.sudip.exhibition_api.exhibition.persistence.ExhibitionSection;
import com.sudip.exhibition_api.exhibition.persistence.ExhibitionStatus;

import java.util.Date;
import java.util.List;

public record ExhibitionRequest(
        String title,
        String description,
        String bannerImage,
        String thumbnailImage,
        ExhibitionStatus status,
        String slug,
        Date startDate,
        Date endDate,

        List<ExhibitionSection> sections
        ) {
}
