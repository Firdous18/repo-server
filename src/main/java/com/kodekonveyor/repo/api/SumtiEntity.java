package com.kodekonveyor.repo.api;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class SumtiEntity {

  @OneToOne(fetch = FetchType.LAZY)
  private BridiEntity bridi;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(fetch = FetchType.LAZY)
  private LerpoiEntity lerpoi;

  private String uuid;

}
