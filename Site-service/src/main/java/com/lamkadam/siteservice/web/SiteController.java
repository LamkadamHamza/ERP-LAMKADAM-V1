package com.lamkadam.siteservice.web;


import com.lamkadam.siteservice.dtos.SiteDTO;
import com.lamkadam.siteservice.entities.Site;
import com.lamkadam.siteservice.exceptions.SiteAlreadyException;
import com.lamkadam.siteservice.exceptions.SiteNotfoundException;
import com.lamkadam.siteservice.mappers.SiteMapper;
import com.lamkadam.siteservice.service.SiteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
@AllArgsConstructor
public class SiteController {

    private SiteService siteService;
    private SiteMapper siteMapper;


    @GetMapping("sites")
    public List<Site> getAllSite (){
     List<SiteDTO> siteDTOList = siteService.getAllSite();
    List<Site> siteList = siteDTOList.stream().map(siteMapper ::from).collect(Collectors.toList());
    return  siteList;
    }


    @GetMapping("sites/{id}")
    public  Site getSiteById (@PathVariable Long id) throws SiteNotfoundException {
        SiteDTO siteDTO = siteService.getSiteById(id);
        Site site = siteMapper.from(siteDTO);
        return  site;
    }



    @PostMapping("/sites")
    public  Site savesite(@RequestBody Site site) throws SiteAlreadyException {
      SiteDTO siteDTO = siteMapper.from(site);
      SiteDTO sitesaved = siteService.SaveSite(siteDTO);
      Site site1 = siteMapper.from(sitesaved);
      return  site1;
    }


    @DeleteMapping("/sites/{id}")
    public void deletsite (@PathVariable long id) throws SiteNotfoundException {
       siteService.DeletSite(id);
    }


    @PutMapping("/sites")
    public Site UpdateSite(@RequestBody Site site) throws SiteAlreadyException, SiteNotfoundException{
     SiteDTO siteDTO =siteMapper.from(site);
     SiteDTO siteDTO1 = siteService.UpdateSite(siteDTO);
     Site site1 = siteMapper.from(siteDTO1);
     return  site1;
    }
}
