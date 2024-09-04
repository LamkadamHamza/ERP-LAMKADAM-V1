package com.lamkadam.siteservice.repository;

import com.lamkadam.siteservice.entities.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteRepository extends JpaRepository<Site, Long> {

    @Query("select case when count(s)>0 then true else false END from Site  s where s.id =?1")
    Boolean checkIfSiteIdExist(Long id);
}
