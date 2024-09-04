package com.lamkadam.orderservice.dtos;

import com.lamkadam.orderservice.enumes.StatusOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data  @AllArgsConstructor @NoArgsConstructor
public class NewOrderDTO {

   private LocalDate dateLivrision;
   private StatusOrder status;
  private     Long IdCustomer;
   private String IdProduct;
   private Long IdSite;
}
