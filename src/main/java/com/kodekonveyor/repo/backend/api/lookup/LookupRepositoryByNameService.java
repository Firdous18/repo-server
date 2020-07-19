package com.kodekonveyor.repo.backend.api.lookup;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodekonveyor.exception.ValidationException;
import com.kodekonveyor.repo.api.LerpoiEntity;
import com.kodekonveyor.repo.api.LerpoiEntityRepository;
import com.kodekonveyor.repo.api.SumtiConstants;
import com.kodekonveyor.repo.api.SumtiDTO;
import com.kodekonveyor.repo.api.SumtiEntity;
import com.kodekonveyor.repo.api.SumtiEntityRepository;

@Service
public class LookupRepositoryByNameService {

  @Autowired
  private LerpoiEntityRepository lerpoiEntityRepository;

  @Autowired
  private SumtiEntityRepository sumtiEntityRepository;

  public SumtiDTO call(final String repoName) {
    final LerpoiEntity lerpoiEntity =
        lerpoiEntityRepository.findByText(repoName).get();

    final Optional<SumtiEntity> sumtiEnity =
        sumtiEntityRepository.findByLerpoi(lerpoiEntity);
    if (sumtiEnity.isEmpty())
      throw new ValidationException(SumtiConstants.NOT_FOUND_EXCEPTION);
    final SumtiDTO sumtiDTO = new SumtiDTO();
    sumtiDTO.setBridi(sumtiEnity.get().getBridi().getId());
    sumtiDTO.setLerpoi(sumtiEnity.get().getLerpoi().getId());
    sumtiDTO.setUuid(sumtiEnity.get().getUuid());
    return sumtiDTO;

  }
}
