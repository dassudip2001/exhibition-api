package com.sudip.exhibition_api.exhibition.web;

import com.sudip.exhibition_api.exhibition.web.data.ExhibitionRequest;
import com.sudip.exhibition_api.exhibition.web.data.ExhibitionResponse;
import com.sudip.exhibition_api.exhibition.web.data.ExhibitionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/api/v1/exhibitions")
@RequiredArgsConstructor
public class ExhibitionController {
    private final ExhibitionService exhibitionService;

    @GetMapping
    public ResponseEntity<List<ExhibitionResponse>> getAllExhibitions() {
        return ResponseEntity.ok(exhibitionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExhibitionResponse> getExhibitionById(
           @PathVariable String id) {
        return ResponseEntity.ok(exhibitionService.findById(id));
    }

    @PostMapping
    public ResponseEntity<String> createExhibition(
            @RequestBody @Valid ExhibitionRequest exhibitionModel) {
        return ResponseEntity.ok(exhibitionService.save(exhibitionModel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateExhibition(
            @PathVariable String id,
            @RequestBody @Valid ExhibitionRequest exhibitionModel) {
        return ResponseEntity.ok(exhibitionService.update(id, exhibitionModel));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExhibition(
            @PathVariable String id) {
        exhibitionService.delete(id);
        return ResponseEntity.ok("Exhibition deleted successfully");
    }

}
