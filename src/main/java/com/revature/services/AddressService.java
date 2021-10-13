package com.revature.services;

import com.revature.daos.AddressDAO;
import com.revature.daos.AddressDAOImpl;
import com.revature.models.Address;

public class AddressService {

    private AddressDAO addressDAO = new AddressDAOImpl();

    public Address findByAddress(Address address) {
        return addressDAO.findByAddress(address);
    }

    public Address findById(int id) {
        return addressDAO.findById(id);
    }

    public boolean newAddress(Address address) {
        return addressDAO.addAddress(address);
    }
}
