package com.sudip.exhibition_api.exhibition.persistence;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ExhibitionSection {
    private String id;
    private ExhibitionSectionType type;
    private String title;
    private String content;
    private int order;
}
