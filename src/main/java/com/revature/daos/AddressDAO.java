package com.revature.daos;

import com.revature.models.Address;

import java.util.List;

public interface AddressDAO {
    public List<Address> findAll();
    public Address findByAddress(Address address);
    public boolean addAddress(Address address);
    public boolean updateAddress(Address address);
}
