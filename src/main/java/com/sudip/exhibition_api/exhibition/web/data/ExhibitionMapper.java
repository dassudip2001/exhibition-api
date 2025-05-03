package com.sudip.exhibition_api.exhibition.web.data;

import com.sudip.exhibition_api.exhibition.persistence.ExhibitionModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ExhibitionMapper {

    public ExhibitionModel toExhibitionModel(ExhibitionRequest exhibitionRequest) {
        if (exhibitionRequest == null) {
            return null;
        }
        return ExhibitionModel.builder()
                .title(exhibitionRequest.title())
                .description(exhibitionRequest.description())
                .startDate(exhibitionRequest.startDate())
                .endDate(exhibitionRequest.endDate())
                .status(exhibitionRequest.status())
                .slug(exhibitionRequest.slug())
                .bannerImage(exhibitionRequest.bannerImage())
                .thumbnailImage(exhibitionRequest.thumbnailImage())
                .sections(exhibitionRequest.sections())
                .build();
    }

    public ExhibitionResponse toExhibitionResponse(ExhibitionModel exhibitionModel) {
        if (exhibitionModel == null) {
            return null;
        }
        return ExhibitionResponse.builder()
                .id(exhibitionModel.getId())
                .title(exhibitionModel.getTitle())
                .description(exhibitionModel.getDescription())
                .startDate(exhibitionModel.getStartDate())
                .endDate(exhibitionModel.getEndDate())
                .status(exhibitionModel.getStatus())
                .slug(exhibitionModel.getSlug())
                .bannerImage(exhibitionModel.getBannerImage())
                .thumbnailImage(exhibitionModel.getThumbnailImage())
                .sections(exhibitionModel.getSections())
                .build();
    }

}
