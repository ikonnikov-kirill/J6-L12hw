package j6l12hw.service;

import j6l12hw.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import j6l12hw.dto.CustomerDto;
import j6l12hw.mapper.CustomerMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public List<CustomerDto> findAll() {
        return CustomerMapper.fromCustomers(
                customerRepository.findAll());
    }

    @Override
    public CustomerDto findById(int id) {
        return CustomerMapper.fromCustomer(
                customerRepository.findById(id)
        );
    }
}
