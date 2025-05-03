package com.sudip.exhibition_api.exhibition.web.data;

import com.sudip.exhibition_api.exhibition.persistence.ExhibitionModel;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ExhibitionService {
    public List<ExhibitionResponse> findAll();

    public ExhibitionResponse findById(String id);

    @Transactional
    public String save(ExhibitionRequest exhibitionRequest);

    @Transactional
    public String update(String id, ExhibitionRequest exhibitionRequest);

    @Transactional
    public void delete(String id);
}
