package j6l12hw.service;

import j6l12hw.dto.CustomerDto;

import java.util.List;

public interface CustomerService {

    List<CustomerDto> findAll();

    CustomerDto findById(int id);

}
