package com.lamkadam.siteservice.service;

import com.lamkadam.siteservice.dtos.SiteDTO;
import com.lamkadam.siteservice.entities.Site;
import com.lamkadam.siteservice.exceptions.SiteAlreadyException;
import com.lamkadam.siteservice.exceptions.SiteNotfoundException;
import com.lamkadam.siteservice.mappers.SiteMapper;
import com.lamkadam.siteservice.repository.SiteRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service @AllArgsConstructor
@Transactional @Slf4j
public class SiteServiceImpl implements  SiteService{


   private SiteRepository siteRepository;
   private SiteMapper siteMapper;


    @Override
    public List<SiteDTO> getAllSite() {
        List<SiteDTO> siteDTOS = siteRepository.findAll().stream().map(siteMapper ::from).collect(Collectors.toList());
        return siteDTOS;
    }

    @Override
    public SiteDTO SaveSite(SiteDTO siteDTO) throws SiteAlreadyException {
       if(siteRepository.checkIfSiteIdExist(siteDTO.getId())) throw new SiteAlreadyException(String.format("le site deje existe", siteDTO.getId()));
           Site site = siteMapper.from(siteDTO);
           Site siteSaved = siteRepository.save(site);
           SiteDTO siteDTO1 = siteMapper.from(siteSaved);
        return siteDTO1;
    }

    @Override
    public void DeletSite(Long id) throws SiteNotfoundException {
        Site site = siteRepository.findById(id).orElse(null);
        if(site == null) throw new  SiteNotfoundException (String.format("site n existe pas"));
        siteRepository.delete(site);

    }

    @Override
    public SiteDTO UpdateSite(SiteDTO siteDTO) throws SiteAlreadyException, SiteNotfoundException {
        if(siteRepository.checkIfSiteIdExist(siteDTO.getId())) throw new SiteAlreadyException(String.format("le site deje existe", siteDTO.getId()));
        Site site = siteRepository.findById(siteDTO.getId()).orElse(null);
        if(site == null) throw new  SiteNotfoundException (String.format("site n existe pas"));

        site.setAddress(siteDTO.getAddress());
        site.setName(siteDTO.getName());
       Site siteUpadete = siteRepository.save(site);

        return siteMapper.from(siteUpadete);
    }

    @Override
    public SiteDTO getSiteById(Long id) throws SiteNotfoundException {
        Site site = siteRepository.findById(id).orElse(null);
        if(site == null) throw new  SiteNotfoundException (String.format("site n existe pas"));
        SiteDTO siteDTO = siteMapper.from(site);
        return siteDTO;
    }
}
