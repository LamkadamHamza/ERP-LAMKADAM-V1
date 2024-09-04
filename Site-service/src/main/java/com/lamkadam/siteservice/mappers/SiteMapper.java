package com.lamkadam.siteservice.mappers;

import com.lamkadam.siteservice.dtos.SiteDTO;
import com.lamkadam.siteservice.entities.Site;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class SiteMapper {

    ModelMapper modelMapper = new ModelMapper();


    public SiteDTO from(Site site) { return modelMapper.map(site , SiteDTO.class);}

    public Site from (SiteDTO siteDTO ){ return  modelMapper.map(siteDTO , Site.class);}
}
