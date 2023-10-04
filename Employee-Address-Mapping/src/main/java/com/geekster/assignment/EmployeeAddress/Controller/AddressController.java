package com.geekster.assignment.EmployeeAddress.Controller;

import com.geekster.assignment.EmployeeAddress.Model.Address;
import com.geekster.assignment.EmployeeAddress.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping
    public List<Address> getAllAddresses() {
        return addressService.getAllAddresses();
    }

    @GetMapping("/{id}")
    public Address getAddressById(@PathVariable Long id) {
        return addressService.getAddressById(id);
    }

    @PostMapping("address")
    public String createAddress(@RequestBody Address address) {
        return addressService.createAddress(address);
    }

    @PostMapping("addresses")
    public String createListOfAddress(@RequestBody List<Address> addressList){
        return addressService.createListOfAddresses(addressList);
    }

    @PutMapping("/{id}")
    public String updateAddress(@PathVariable Long id, @RequestBody Address address) {
        return addressService.updateAddress(id, address);
    }

    @DeleteMapping("/{id}")
    public String deleteAddressById(@PathVariable Long id) {
      return   addressService.deleteAddressById(id);
    }
}

