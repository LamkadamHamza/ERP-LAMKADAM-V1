package com.lamkadam.siteservice.service;

import com.lamkadam.siteservice.dtos.SiteDTO;
import com.lamkadam.siteservice.exceptions.SiteAlreadyException;
import com.lamkadam.siteservice.exceptions.SiteNotfoundException;

import java.util.List;

public interface SiteService {

    List<SiteDTO> getAllSite();

    SiteDTO SaveSite(SiteDTO siteDTO) throws SiteAlreadyException;

    void DeletSite (Long id) throws SiteNotfoundException;

    SiteDTO UpdateSite (SiteDTO siteDTO) throws SiteAlreadyException , SiteNotfoundException;


    SiteDTO getSiteById (Long id) throws SiteNotfoundException;

}
