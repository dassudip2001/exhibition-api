package com.sudip.exhibition_api.exhibition.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExhibitionRepository  extends  MongoRepository<ExhibitionModel, String>{
}
