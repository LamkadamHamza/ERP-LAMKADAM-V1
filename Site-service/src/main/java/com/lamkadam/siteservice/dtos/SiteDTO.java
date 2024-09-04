package com.lamkadam.siteservice.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class SiteDTO {

    private Long id;


    private String name;


    private String address;


    private String phoneNumber;


    private String email;
}
