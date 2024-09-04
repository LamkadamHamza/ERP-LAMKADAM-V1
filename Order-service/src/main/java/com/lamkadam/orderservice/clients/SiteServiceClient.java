package com.lamkadam.orderservice.clients;


import com.lamkadam.orderservice.modul.Customer;
import com.lamkadam.orderservice.modul.Site;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "Site-service")
public interface SiteServiceClient {




    @GetMapping("/api/sites/{id}")
    Site findSiteById(@PathVariable Long id);

    @GetMapping("/api/sites")
    List<Site> allSites();
}
