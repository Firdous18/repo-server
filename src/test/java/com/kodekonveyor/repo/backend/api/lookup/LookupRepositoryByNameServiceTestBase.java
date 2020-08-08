package com.kodekonveyor.repo.backend.api.lookup;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.kodekonveyor.repo.api.LerpoiEntityRepository;
import com.kodekonveyor.repo.api.SumtiEntityRepository;
import com.kodekonveyor.repo.api.SumtiEntityRepositoryStubs;
import com.kodekonveyor.repo.backend.api.LerpoiEntityRepositoryStubs;

public class LookupRepositoryByNameServiceTestBase {

  @Mock
  LerpoiEntityRepository lerpoiEntityRepository;
  @InjectMocks
  protected LookupRepositoryByNameService lookupRepoByNameService;
  @Mock
  SumtiEntityRepository sumtiEntityRepository;

  @BeforeEach
  public void setUp() {
    LerpoiEntityRepositoryStubs.behaviour(lerpoiEntityRepository);
    SumtiEntityRepositoryStubs.behaviour(sumtiEntityRepository);
  }
}
