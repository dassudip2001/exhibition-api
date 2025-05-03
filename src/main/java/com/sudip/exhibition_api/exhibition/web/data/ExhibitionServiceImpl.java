package com.sudip.exhibition_api.exhibition.web.data;

import com.sudip.exhibition_api.exhibition.persistence.ExhibitionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ExhibitionServiceImpl implements ExhibitionService {
    private final ExhibitionRepository exhibitionRepository;
    private final ExhibitionMapper exhibitionMapper;


    @Override
    public List<ExhibitionResponse> findAll() {
        return exhibitionRepository.
                findAll()
                .stream()
                .map(exhibitionMapper::toExhibitionResponse)
                .toList();
    }

    @Override
    public ExhibitionResponse findById(String id) {
        return exhibitionRepository.findById(id)
                .map(exhibitionMapper::toExhibitionResponse)
                .orElseThrow(() -> new RuntimeException("Exhibition not found"));
    }

    @Override
    public String save(ExhibitionRequest exhibitionRequest) {
        return exhibitionRepository.save(exhibitionMapper.toExhibitionModel(exhibitionRequest)).getId();
    }

    @Override
    public String update(String id, ExhibitionRequest exhibitionRequest) {
        return  exhibitionRepository.findById(id)
                .map(exhibitionModel -> {
                    exhibitionModel.setTitle(exhibitionRequest.title());
                    exhibitionModel.setDescription(exhibitionRequest.description());
                    exhibitionModel.setStartDate(exhibitionRequest.startDate());
                    exhibitionModel.setEndDate(exhibitionRequest.endDate());
                    exhibitionModel.setStatus(exhibitionRequest.status());
                    exhibitionModel.setSlug(exhibitionRequest.slug());
                    exhibitionModel.setBannerImage(exhibitionRequest.bannerImage());
                    exhibitionModel.setThumbnailImage(exhibitionRequest.thumbnailImage());
                    exhibitionModel.setSections(exhibitionRequest.sections());
                    return exhibitionRepository.save(exhibitionModel).getId();
                })
                .orElseThrow(() -> new RuntimeException("Exhibition not found"));
    }

    @Override
    public void delete(String id) {
        if(exhibitionRepository.existsById(id)){
            exhibitionRepository.deleteById(id);
        }
        else{
            throw new RuntimeException("Exhibition not found");
        }
    }
}
