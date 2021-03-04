package com.study.eatgo.application;

import com.study.eatgo.domain.Region;
import com.study.eatgo.domain.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RegionService {

    private RegionRepository regionRepository;

    @Autowired
    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public List<Region> getRegions() {
        List<Region> regions = regionRepository.findAll();

        return regions;
    }

    public Region addRegion(String name) {
        Region region = Region.builder().name(name).build();

        regionRepository.save(region);

        return region;
    }
}
