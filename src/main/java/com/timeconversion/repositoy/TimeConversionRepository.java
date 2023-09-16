package com.timeconversion.repositoy;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.timeconversion.model.TimeConversionEntity;
@Repository
public interface TimeConversionRepository extends CrudRepository<TimeConversionEntity, Long> {
	 public Optional<TimeConversionEntity> findByInputTime(String inputTime);
}

