package j6l12hw.mapper;

import j6l12hw.dto.CustomerDto;
import j6l12hw.model.Customer;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerMapper {
    public static Customer toCustomer(CustomerDto customerDto) {

        return Customer.builder()
                .id(customerDto.getId())
                .name(customerDto.getName())
                .build();
    }

    public static CustomerDto fromCustomer(Customer customer) {

        return CustomerDto.builder()
                .id(customer.getId())
                .name(customer.getName())
                .build();
    }

    public static List<Customer> toCustomers(List<CustomerDto> customerDtoList) {
        return customerDtoList.stream()
                .map(CustomerMapper::toCustomer)
                .sorted(Comparator.comparing(Customer::getName))
                .collect(Collectors.toList());
    }

    public static List<CustomerDto> fromCustomers(List<Customer> customerList) {
        return customerList.stream()
                .map(CustomerMapper::fromCustomer)
                .sorted(Comparator.comparing(CustomerDto::getName))
                .collect(Collectors.toList());
    }
}
